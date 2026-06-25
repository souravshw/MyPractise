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

def main():
    posts = parse_posts()
    posts_dir = r"docs\posts"
    
    missing_nav = []
    incorrect_prev = []
    incorrect_next = []
    
    for i, post in enumerate(posts):
        filename = post["filename"]
        file_path = os.path.join(posts_dir, filename)
        
        if not os.path.exists(file_path):
            print(f"Warning: File not found: {file_path}")
            continue
            
        with open(file_path, "r", encoding="utf-8") as f:
            html = f.read()
            
        if "class=\"post-navigation\"" not in html and 'class="post-navigation"' not in html:
            missing_nav.append(filename)
            continue
            
        prev_post = posts[i + 1] if i + 1 < len(posts) else None
        next_post = posts[i - 1] if i - 1 >= 0 else None
        
        # Check prev_post link
        if prev_post:
            expected_prev_href = f'href="../posts/{prev_post["filename"]}"'
            if expected_prev_href not in html:
                incorrect_prev.append((filename, prev_post["filename"]))
        else:
            # Should NOT contain a prev-card link
            if "prev-card" in html:
                incorrect_prev.append((filename, "should not have previous"))
                
        # Check next_post link
        if next_post:
            expected_next_href = f'href="../posts/{next_post["filename"]}"'
            if expected_next_href not in html:
                incorrect_next.append((filename, next_post["filename"]))
        else:
            # Should NOT contain a next-card link
            if "next-card" in html:
                incorrect_next.append((filename, "should not have next"))
                
    print(f"Verified {len(posts)} posts.")
    print(f"Missing navigation container: {len(missing_nav)}")
    for m in missing_nav:
        print(f"  - {m}")
        
    print(f"Incorrect/missing previous link: {len(incorrect_prev)}")
    for m, details in incorrect_prev:
        print(f"  - {m}: {details}")
        
    print(f"Incorrect/missing next link: {len(incorrect_next)}")
    for m, details in incorrect_next:
        print(f"  - {m}: {details}")

if __name__ == "__main__":
    main()
