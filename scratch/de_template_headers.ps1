# Arrays of randomized headers to choose from
$introHeaders = @(
    "<h2>The Challenge</h2>",
    "<h2>What We're Solving</h2>",
    "<h2>Problem Breakdown</h2>",
    "<h2>Understanding the Problem</h2>",
    "<h2>Understanding the Challenge</h2>"
)

$walkthroughHeaders = @(
    "<h2>How It Works</h2>",
    "<h2>Step-by-Step Execution</h2>",
    "<h2>Tracing the Logic</h2>",
    "<h2>The Inner Workings</h2>",
    "<h2>Walking Through the Logic</h2>"
)

$approachHeaders = @(
    "<h2>The Strategy</h2>",
    "<h2>Solving the Problem</h2>",
    "<h2>The Logic Behind It</h2>",
    "<h2>Core Algorithm</h2>",
    "<h2>The Approach</h2>"
)

$snippetHeaders = @(
    "<h2>Code Breakdown</h2>",
    "<h2>Key Explanations</h2>",
    "<h2>How the Code Works</h2>",
    "<h2>Code Walkthrough</h2>"
)

$javaHeaders = @(
    "<h2>The Java Code</h2>",
    "<h2>Implementation in Java</h2>",
    "<h2>Full Code Solution</h2>",
    "<h2>Java Solution</h2>"
)

$conclusionHeaders = @(
    "<h2>Final Thoughts</h2>",
    "<h2>Wrapping Up</h2>",
    "<h2>Summary</h2>",
    "<h2>Takeaways</h2>"
)

$analogyPrefixes = @(
    "A Simple Metaphor: ",
    "Think of it like: ",
    "A Simple Analogy: ",
    "An Analogy: ",
    "An Everyday Metaphor: "
)

$postFiles = Get-ChildItem -Path "docs/posts" -Filter "*.html"
$updatedCount = 0

foreach ($file in $postFiles) {
    $content = Get-Content -Path $file.FullName -Raw
    $originalContent = $content

    # 1. Replace Intro headers
    $introRand = Get-Random -InputObject $introHeaders
    $content = $content -replace '<h2>Introduction & Problem Explanation</h2>', $introRand

    # 2. Replace Walkthrough headers
    $walkRand = Get-Random -InputObject $walkthroughHeaders
    $content = $content -replace '<h2>Step-by-Step Execution Walkthrough</h2>', $walkRand
    $content = $content -replace '<h2>Step-by-Step Logic Trace</h2>', $walkRand

    # 3. Replace Algorithmic Approach headers
    $approachRand = Get-Random -InputObject $approachHeaders
    $content = $content -replace '<h2>The Algorithmic Approach</h2>', $approachRand
    $content = $content -replace '<h2>How the Algorithm Finds the Fastest Way</h2>', $approachRand

    # 4. Replace Snippet headers
    $snippetRand = Get-Random -InputObject $snippetHeaders
    $content = $content -replace '<h2>Key Code Snippets & Explanations</h2>', $snippetRand

    # 5. Replace Java Code headers
    $javaRand = Get-Random -InputObject $javaHeaders
    $content = $content -replace '<h2>Java Implementation Code</h2>', $javaRand
    $content = $content -replace '<h2>Java Implementation</h2>', $javaRand

    # 6. Replace Conclusion headers
    $conclusionRand = Get-Random -InputObject $conclusionHeaders
    $content = $content -replace '<h2>Conclusion</h2>', $conclusionRand

    # 7. Modify Analogy Box titles to remove "Real-World Analogy" phrase
    # Matches the SVG and "Real-World Analogy: [Title]" inside analogy-box-title
    $analogyPattern = '(?s)(<div class="analogy-box-title">[\s\S]*?)Real-World Analogy:\s*(.*?)(</div>)'
    if ($content -match $analogyPattern) {
        $prefixRand = Get-Random -InputObject $analogyPrefixes
        $content = [regex]::Replace($content, $analogyPattern, "${1}${prefixRand}${2}${3}")
    }

    if ($content -ne $originalContent) {
        Set-Content -Path $file.FullName -Value $content -Encoding utf8
        $updatedCount++
    }
}

Write-Host "Processed $($postFiles.Count) blog posts. Restructured and randomized headers in $updatedCount files."
