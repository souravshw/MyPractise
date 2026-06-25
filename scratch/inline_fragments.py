import os
import re

def main():
    # Paths
    base_dir = r"docs"
    header_path = os.path.join(base_dir, "fragments", "header.html")
    footer_path = os.path.join(base_dir, "fragments", "footer.html")

    # Read master fragments
    with open(header_path, "r", encoding="utf-8") as f:
        header_template = f.read()
    
    with open(footer_path, "r", encoding="utf-8") as f:
        footer_template = f.read()

    # Regex patterns to match <header> and <footer> tags with any content inside
    # (enables idempotency / rerunning)
    header_regex = re.compile(
        r'(<header\s+[^>]*class="main-header"[^>]*data-path-prefix="([^"]*)"[^>]*data-active-nav="([^"]*)"[^>]*>)(.*?)(</header>)',
        re.DOTALL
    )
    footer_regex = re.compile(
        r'(<footer\s+[^>]*class="main-footer"[^>]*data-path-prefix="([^"]*)"[^>]*>)(.*?)(</footer>)',
        re.DOTALL
    )

    # Walk through directory
    modified_count = 0
    for root, dirs, files in os.walk(base_dir):
        # Skip the fragments directory itself
        if "fragments" in root:
            continue
        
        for file in files:
            if not file.endswith(".html"):
                continue
            
            file_path = os.path.join(root, file)
            with open(file_path, "r", encoding="utf-8") as f:
                content = f.read()
            
            original_content = content
            
            # 1. Process Header
            header_match = header_regex.search(content)
            if header_match:
                full_open_tag = header_match.group(1)
                prefix = header_match.group(2)
                active_nav = header_match.group(3)
                
                # Build header HTML
                header_html = header_template.replace("{prefix}", prefix)
                if active_nav:
                    # Inject active class to the link matching active_nav ID
                    target_id = f'id="nav-{active_nav}"'
                    header_html = header_html.replace(target_id, f'{target_id} class="active"')
                
                # Replace content inside <header>...</header>
                replacement = f"{full_open_tag}\n{header_html}\n</header>"
                content = header_regex.sub(replacement, content, count=1)

            # 2. Process Footer
            footer_match = footer_regex.search(content)
            if footer_match:
                full_open_tag = footer_match.group(1)
                prefix = footer_match.group(2)
                
                # Build footer HTML
                footer_html = footer_template.replace("{prefix}", prefix)
                
                # Replace content inside <footer>...</footer>
                replacement = f"{full_open_tag}\n{footer_html}\n</footer>"
                content = footer_regex.sub(replacement, content, count=1)
            
            # Save if changed
            if content != original_content:
                with open(file_path, "w", encoding="utf-8") as f:
                    f.write(content)
                modified_count += 1
                print(f"Inlined fragments in: {file_path}")

    print(f"Successfully processed. Inlined {modified_count} files.")

if __name__ == "__main__":
    main()
