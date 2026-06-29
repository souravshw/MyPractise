import os
import re
import xml.etree.ElementTree as ET
from datetime import datetime

def main():
    sitemap_path = r"docs\sitemap-blog-post.xml"
    posts_dir = r"docs\posts"
    
    # 1. Read existing sitemap and parse URLs
    with open(sitemap_path, "r", encoding="utf-8") as f:
        sitemap_content = f.read()

    # Find all loc entries in sitemap
    locs = re.findall(r"<loc>(https://www.enggnotes.com/posts/([^<]+))</loc>", sitemap_content)
    existing_filenames = {loc[1] for loc in locs}
    
    # 2. Scan posts directory for html files
    all_posts = [f for f in os.listdir(posts_dir) if f.endswith(".html")]
    
    missing_posts = []
    for post in all_posts:
        if post not in existing_filenames:
            missing_posts.append(post)
            
    print(f"Total HTML posts in directory: {len(all_posts)}")
    print(f"Existing posts in sitemap: {len(existing_filenames)}")
    print(f"Missing posts to add: {len(missing_posts)}")
    
    if not missing_posts:
        print("No missing posts. Sitemap is up to date!")
        return
        
    # 3. Add missing posts to the sitemap content
    # Find the insertion point: right after <!-- Blog Posts --> comment or right before the first blog post url block
    # Let's locate "<!-- Blog Posts -->" and insert them right after it.
    insert_marker = "<!-- Blog Posts -->"
    if insert_marker not in sitemap_content:
        print("Error: Could not find <!-- Blog Posts --> marker in sitemap.")
        return
        
    today_str = datetime.today().strftime('%Y-%m-%d')
    new_urls_block = ""
    for post in sorted(missing_posts):
        new_urls_block += f"""    <url>
        <loc>https://www.enggnotes.com/posts/{post}</loc>
        <lastmod>{today_str}</lastmod>
        <changefreq>monthly</changefreq>
        <priority>0.8</priority>
    </url>\n"""

    split_idx = sitemap_content.find(insert_marker) + len(insert_marker)
    updated_content = (
        sitemap_content[:split_idx] + "\n" +
        new_urls_block +
        sitemap_content[split_idx:]
    )
    
    with open(sitemap_path, "w", encoding="utf-8", newline="\n") as f:
        f.write(updated_content)
        
    print(f"Successfully added {len(missing_posts)} missing posts to sitemap: {missing_posts}")

if __name__ == "__main__":
    main()
