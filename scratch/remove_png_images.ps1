# 1. Clean posts.js: remove png image references
$postsPath = "docs/js/posts.js"
$postsContent = Get-Content -Path $postsPath -Raw

# Replace: image: "images/something.png", with nothing
# We also handle optional trailing commas and spaces
$newPostsContent = $postsContent -replace 'image:\s*"images/[^"]+\.png",?\s*\r?\n', ""
Set-Content -Path $postsPath -Value $newPostsContent -Encoding utf8
Write-Host "Updated docs/js/posts.js (removed PNG image references)"

# 2. Clean all blog post HTML files
$postFiles = Get-ChildItem -Path "docs/posts" -Filter "*.html"
$mainImageRemovedCount = 0
$relatedImageRemovedCount = 0

foreach ($file in $postFiles) {
    $content = Get-Content -Path $file.FullName -Raw
    $originalContent = $content

    # Pattern A: Main post illustration div containing a PNG image
    # Matches <div style="text-align: center; margin-bottom: 2rem;"> ... <img src="../images/....png" ...> ... </div>
    $mainImagePattern = '(?s)<!-- Post Illustration Image -->\s*<div style="text-align: center; margin-bottom: 2rem;">\s*<img src="\.\./images/[^"]+\.png"[^>]*>\s*</div>'
    if ($content -match $mainImagePattern) {
        $content = $content -replace $mainImagePattern, ""
        $mainImageRemovedCount++
    } else {
        # Fallback regex in case comment is missing or styling is slightly different
        $mainImagePattern2 = '(?s)<div style="text-align: center; margin-bottom: 2rem;">\s*<img src="\.\./images/[^"]+\.png"[^>]*>\s*</div>'
        if ($content -match $mainImagePattern2) {
            $content = $content -replace $mainImagePattern2, ""
            $mainImageRemovedCount++
        }
    }

    # Pattern B: Related card images
    # Matches <a href="..." class="related-card-img">\s*<img src="../images/....png" ...>\s*</a>
    $relatedImagePattern = '(?s)<a href="[^"]+" class="related-card-img">\s*<img src="\.\./images/[^"]+\.png"[^>]*>\s*</a>'
    if ($content -match $relatedImagePattern) {
        $content = [regex]::Replace($content, $relatedImagePattern, "")
        $relatedImageRemovedCount++
    }

    # Pattern C: Any other standalone img tag pointing to PNG under ../images/
    # (except sourav_profile.png, just in case)
    # Matches <img src="../images/(?!sourav_profile)[^"]+\.png"[^>]*>
    # We will just replace it with an empty string if it exists
    $otherImagePattern = '(?s)<img src="\.\./images/(?!sourav_profile)[^"]+\.png"[^>]*>'
    if ($content -match $otherImagePattern) {
        $content = [regex]::Replace($content, $otherImagePattern, "")
    }

    if ($content -ne $originalContent) {
        Set-Content -Path $file.FullName -Value $content -Encoding utf8
    }
}

Write-Host "Processed $($postFiles.Count) blog post HTML files."
Write-Host "Removed $mainImageRemovedCount main illustration PNG blocks."
Write-Host "Removed $relatedImageRemovedCount related card PNG image blocks."
