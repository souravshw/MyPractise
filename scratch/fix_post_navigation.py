import os
import re

def parse_posts():
    with open(r"docs\js\posts.js", "r", encoding="utf-8") as f:
        content = f.read()

    chunks = content.split("{")
    posts = []
    
    for chunk in chunks:
        title_match = re.search(r'title:\s*"(.*?)"', chunk)
        url_match = re.search(r'url:\s*"(.*?)"', chunk)
        
        if title_match and url_match:
            title = title_match.group(1)
            url = url_match.group(1)
            filename = os.path.basename(url)
            posts.append({
                "title": title,
                "filename": filename
            })
            
    return posts

def rebuild_navigation(html, new_nav_html):
    # Find start of post-navigation-related section
    start_tag = 'id="post-navigation-related">'
    idx = html.find(start_tag)
    if idx == -1:
        return None
        
    start_idx = idx + len(start_tag)
    
    # Find the beginning of the related-posts section
    end_tag = '<div class="related-posts">'
    end_idx = html.find(end_tag, start_idx)
    
    if end_idx != -1:
        # Rebuild between start_idx and end_idx
        # Preserve the indentation before <div class="related-posts">
        rebuilt = html[:start_idx] + "\n" + new_nav_html + "\n\n        " + html[end_idx:]
        return rebuilt
    else:
        # Fallback to matching up to the closing </section> tag
        end_tag = '</section>'
        end_idx = html.find(end_tag, start_idx)
        if end_idx != -1:
            rebuilt = html[:start_idx] + "\n" + new_nav_html + "\n\n      " + html[end_idx:]
            return rebuilt
            
    return None

def main():
    posts = parse_posts()
    print(f"Parsed {len(posts)} posts from posts.js")
    
    posts_dir = r"docs\posts"
    modified_count = 0
    
    for i, post in enumerate(posts):
        filename = post["filename"]
        file_path = os.path.join(posts_dir, filename)
        
        if not os.path.exists(file_path):
            print(f"Warning: File not found: {file_path}")
            continue
            
        with open(file_path, "r", encoding="utf-8") as f:
            html = f.read()
            
        prev_post = None
        next_post = None
        
        if i + 1 < len(posts):
            prev_post = posts[i + 1]
            
        if i - 1 >= 0:
            next_post = posts[i - 1]
            
        nav_html = '        <div class="post-navigation">\n'
        
        if prev_post:
            nav_html += f"""          <a href="../posts/{prev_post['filename']}" class="nav-card prev-card">
            <div class="nav-card-arrow prev-arrow">
              <svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><line x1="19" y1="12" x2="5" y2="12"></line><polyline points="12 19 5 12 12 5"></polyline></svg>
            </div>
            <div class="nav-card-content">
              <span class="nav-card-label">Previous Post</span>
              <span class="nav-card-title">{prev_post['title']}</span>
            </div>
          </a>\n"""
          
        if next_post:
            nav_html += f"""          <a href="../posts/{next_post['filename']}" class="nav-card next-card">
            <div class="nav-card-content" style="text-align: right;">
              <span class="nav-card-label">Next Post</span>
              <span class="nav-card-title">{next_post['title']}</span>
            </div>
            <div class="nav-card-arrow next-arrow">
              <svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><line x1="5" y1="12" x2="19" y2="12"></line><polyline points="12 5 19 12 12 19"></polyline></svg>
            </div>
          </a>\n"""
          
        nav_html += '        </div>'
        
        new_html = rebuild_navigation(html, nav_html)
        
        if new_html and new_html != html:
            with open(file_path, "w", encoding="utf-8", newline="\n") as f:
                f.write(new_html)
            modified_count += 1
        elif not new_html:
            print(f"Warning: Could not replace navigation block in {filename}")
            
    print(f"Successfully updated navigation blocks in {modified_count} files.")

if __name__ == "__main__":
    main()
