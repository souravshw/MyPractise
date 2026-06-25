import os
import re

def main():
    posts_dir = r"docs\posts"
    all_posts = [f for f in os.listdir(posts_dir) if f.endswith(".html")]
    
    missing_section = []
    empty_section = []
    has_section = 0
    
    for post in all_posts:
        file_path = os.path.join(posts_dir, post)
        with open(file_path, "r", encoding="utf-8") as f:
            content = f.read()
            
        if "related-posts" not in content:
            missing_section.append(post)
        else:
            # Check if there are related cards inside
            cards = re.findall(r'class="related-card"', content)
            if len(cards) == 0:
                empty_section.append(post)
            else:
                has_section += 1
                
    print(f"Total blog posts checked: {len(all_posts)}")
    print(f"Posts with populated Related Articles: {has_section}")
    print(f"Posts missing 'related-posts' section altogether: {len(missing_section)}")
    for p in missing_section:
        print(f"  - {p}")
    print(f"Posts with 'related-posts' section but zero related cards: {len(empty_section)}")
    for p in empty_section:
        print(f"  - {p}")

if __name__ == "__main__":
    main()
