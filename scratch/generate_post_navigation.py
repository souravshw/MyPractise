import os
import re

def parse_posts_js(file_path):
    with open(file_path, "r", encoding="utf-8") as f:
        content = f.read()
    
    # Find the array content
    array_match = re.search(r'const postsData = \[(.*?)\];', content, re.DOTALL)
    if not array_match:
        return []
    
    array_content = array_match.group(1)
    
    # Split by individual object blocks starting with { and ending with } followed by comma or whitespace
    object_strings = re.findall(r'\{\s*(.*?)\s*\}(?=,|\s*$)', array_content, re.DOTALL)
    
    posts = []
    for obj_str in object_strings:
        post = {}
        # Parse fields: key: "value" or key: value
        fields = re.findall(r'(\w+):\s*(?:"([^"]*)"|\'([^\']*)\'|(\d+))', obj_str)
        for key, val_double, val_single, val_num in fields:
            val = val_double or val_single
            if val:
                post[key] = val
            elif val_num:
                post[key] = int(val_num)
        if post:
            posts.append(post)
    return posts

def extract_keywords_from_html(file_path):
    if not os.path.exists(file_path):
        return []
    with open(file_path, "r", encoding="utf-8") as f:
        content = f.read()
    kw_match = re.search(r'<meta\s+name="keywords"\s+content="([^"]*)"\s*/?>', content, re.IGNORECASE)
    if kw_match:
        return [k.strip().lower() for k in kw_match.group(1).split(",") if k.strip()]
    return []

def get_fallback_svg(category):
    cat_lower = category.lower()
    if "kafka" in cat_lower or "distributed" in cat_lower:
        # Cyan streaming data nodes SVG
        return """<svg viewBox="0 0 24 24" fill="none" stroke="#06b6d4" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round">
          <circle cx="12" cy="5" r="3" fill="rgba(6, 182, 212, 0.1)" />
          <circle cx="5" cy="19" r="3" fill="rgba(6, 182, 212, 0.1)" />
          <circle cx="19" cy="19" r="3" fill="rgba(6, 182, 212, 0.1)" />
          <path d="M9 17l6-10M12 8l5 8" />
        </svg>"""
    elif "algo" in cat_lower or "problem" in cat_lower:
        # Emerald logic/binary tree SVG
        return """<svg viewBox="0 0 24 24" fill="none" stroke="#10b981" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round">
          <path d="M12 2v8" />
          <path d="M17 10a5 5 0 0 0-10 0" />
          <path d="M12 10v4" />
          <circle cx="12" cy="17" r="3" fill="rgba(16, 185, 129, 0.1)" />
          <circle cx="5" cy="10" r="3" fill="rgba(16, 185, 129, 0.1)" />
          <circle cx="19" cy="10" r="3" fill="rgba(16, 185, 129, 0.1)" />
        </svg>"""
    else:
        # Orange/Red Java cup SVG as default
        return """<svg viewBox="0 0 24 24" fill="none" stroke="#f97316" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round">
          <path d="M18 8h1a4 4 0 0 1 0 8h-1" />
          <path d="M2 8h16v9a4 4 0 0 1-4 4H6a4 4 0 0 1-4-4V8z" fill="rgba(249, 115, 22, 0.05)" />
          <line x1="6" y1="1" x2="6" y2="4" />
          <line x1="10" y1="1" x2="10" y2="4" />
          <line x1="14" y1="1" x2="14" y2="4" />
        </svg>"""

def main():
    base_dir = r"docs"
    posts_js_path = os.path.join(base_dir, "js", "posts.js")
    
    # Parse postsData from posts.js
    posts = parse_posts_js(posts_js_path)
    if not posts:
        print("Error: Could not parse postsData from posts.js")
        return
        
    print(f"Loaded {len(posts)} posts from posts.js")

    # Extract keywords for each post from its HTML file
    for p in posts:
        html_file = os.path.basename(p["url"])
        file_path = os.path.join(base_dir, "posts", html_file)
        p["keywords"] = extract_keywords_from_html(file_path)

    # Walk through the list of posts (newest to oldest)
    # Note: Index 0 is the newest post, last index is the oldest post.
    # Therefore, Next (newer) post is index - 1, Previous (older) post is index + 1.
    for idx, current_post in enumerate(posts):
        html_file = os.path.basename(current_post["url"])
        file_path = os.path.join(base_dir, "posts", html_file)
        
        if not os.path.exists(file_path):
            print(f"Warning: HTML file not found: {file_path}")
            continue

        # 1. Identify Next and Previous Posts
        next_post = posts[idx - 1] if idx > 0 else None
        prev_post = posts[idx + 1] if idx < len(posts) - 1 else None

        # 2. Calculate Related Posts
        related_candidates = []
        for other_idx, other_post in enumerate(posts):
            if other_idx == idx:
                continue
            
            score = 0
            # Same category bonus
            if other_post.get("category") == current_post.get("category"):
                score += 5
                
            # Matching keywords bonus
            p_kws = current_post.get("keywords", [])
            o_kws = other_post.get("keywords", [])
            matching_kws = set(p_kws).intersection(set(o_kws))
            score += len(matching_kws)
            
            related_candidates.append((score, other_post))
            
        # Sort by score descending, then by post id descending
        related_candidates.sort(key=lambda x: (x[0], x[1].get("id", 0)), reverse=True)
        top_related = [item[1] for item in related_candidates[:3]]

        # 3. Build Navigation HTML
        prev_btn_html = ""
        if prev_post:
            prev_url = "../" + prev_post["url"]
            prev_btn_html = f"""
          <a href="{prev_url}" class="nav-card prev-card">
            <div class="nav-card-arrow prev-arrow">
              <svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><line x1="19" y1="12" x2="5" y2="12"></line><polyline points="12 19 5 12 12 5"></polyline></svg>
            </div>
            <div class="nav-card-content">
              <span class="nav-card-label">Previous Post</span>
              <span class="nav-card-title">{prev_post["title"]}</span>
            </div>
          </a>"""
          
        next_btn_html = ""
        if next_post:
            next_url = "../" + next_post["url"]
            next_btn_html = f"""
          <a href="{next_url}" class="nav-card next-card">
            <div class="nav-card-arrow next-arrow">
              <svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><line x1="5" y1="12" x2="19" y2="12"></line><polyline points="12 5 19 12 12 19"></polyline></svg>
            </div>
            <div class="nav-card-content">
              <span class="nav-card-label">Next Post</span>
              <span class="nav-card-title">{next_post["title"]}</span>
            </div>
          </a>"""

        # 4. Build Related Posts HTML
        related_cards_html = ""
        for rp in top_related:
            rp_url = "../" + rp["url"]
            
            # Thumbnail image content or fallback SVG
            if rp.get("image"):
                img_path = "../" + rp["image"]
                media_html = f'<img src="{img_path}" alt="{rp["title"]}">'
            else:
                media_html = get_fallback_svg(rp.get("category", ""))
                
            related_cards_html += f"""
          <div class="related-card">
            <a href="{rp_url}" class="related-card-img">
              {media_html}
            </a>
            <div class="related-card-content">
              <div class="post-meta">
                <span class="post-category">{rp.get("category")}</span>
              </div>
              <h4 class="related-card-title"><a href="{rp_url}">{rp["title"]}</a></h4>
            </div>
          </div>"""

        # Complete widget container HTML
        widget_html = f"""
      <!-- Navigation & Related Articles -->
      <section class="post-navigation-related" id="post-navigation-related">
        <div class="post-navigation">
          {prev_btn_html}
          {next_btn_html}
        </div>
        
        <div class="related-posts">
          <h3 class="related-posts-title">Related Articles</h3>
          <div class="related-posts-grid">
            {related_cards_html}
          </div>
        </div>
      </section>"""

        # 5. Read current HTML content
        with open(file_path, "r", encoding="utf-8") as f:
            content = f.read()

        original_content = content

        # Replace existing widget if present, otherwise insert before </article>
        existing_section_regex = re.compile(
            r'(\s*<!-- Navigation & Related Articles -->\s*<section\s+class="post-navigation-related"\s+id="post-navigation-related">.*?</section>)|(\s*<section\s+class="post-navigation-related"\s+id="post-navigation-related">.*?</section>)',
            re.DOTALL
        )
        
        if existing_section_regex.search(content):
            content = existing_section_regex.sub(widget_html, content)
        else:
            # Insert right before </article>
            content = content.replace("</article>", f"{widget_html}\n    </article>")

        if content != original_content:
            with open(file_path, "w", encoding="utf-8") as f:
                f.write(content)
            print(f"Injected navigation & related posts widget into: {html_file}")

if __name__ == "__main__":
    main()
