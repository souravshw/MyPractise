// Blog Posts Data Source
const postsData = [
  {
    id: 36,
    title: "Sorting Maps by Value in Java Streams: A Simple Guide",
    excerpt: "Sorting entries in a Map by their values rather than keys is a common challenge. Learn how to sort Map values using Java Streams and a simple leaderboard analogy.",
    category: "Java",
    date: "June 22, 2026",
    readTime: "4 min read",
    url: "posts/sorting-maps-streams-simply.html",
    image: "images/stream_map_sorting.svg"
  },
  {
    id: 35,
    title: "Understanding Polymorphism and Method Overriding: A Simple Guide",
    excerpt: "Polymorphism lets objects behave in their own unique way. Learn how JVM resolves method overriding in class hierarchies using a simple theater actor analogy.",
    category: "Java",
    date: "June 22, 2026",
    readTime: "4 min read",
    url: "posts/understanding-polymorphism-inheritance-simply.html",
    image: "images/inheritance_checker.svg"
  },
  {
    id: 34,
    title: "Building a Web Link Spam Analyzer in Java: A Simple Guide",
    excerpt: "Learn how to crawl web pages in Java and filter spam links using a simple postal inspector analogy and line-by-line main method trace.",
    category: "Java",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/spam-link-analyzer-simply.html",
    image: "images/link_analyzer.svg"
  },
  {
    id: 33,
    title: "Finding the Longest Consecutive Increasing Chain in Java: A Simple Guide",
    excerpt: "Searching for ordered sequences inside arrays is a classic algorithmic puzzle. Learn how to scan and calculate the longest incrementing card run in Java.",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "3 min read",
    url: "posts/consecutive-increasing-chains-simply.html",
    image: "images/consecutive_increasing_chain.svg"
  },
  {
    id: 32,
    title: "Summing Up to a Target Sum in Java: A Simple Guide",
    excerpt: "Comparing elements across arrays of different sizes requires bounds checking. Learn how to safely search for index pairs summing to 10 in Java.",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "3 min read",
    url: "posts/summing-up-to-ten-simply.html",
    image: "images/summing_up_to_n.svg"
  },
  {
    id: 31,
    title: "How ArrayList Works Under the Hood: A Simple Guide",
    excerpt: "Arrays are fixed-size in computer memory, but ArrayList expands dynamically. Learn how Java grows capacity behind the scenes using an expanding toy box analogy.",
    category: "Java",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/understanding-custom-arraylist-simply.html",
    image: "images/custom_list.svg"
  },
  {
    id: 30,
    title: "Rotating Arrays in Java: A Simple Guide",
    excerpt: "Shifting elements inside memory arrays is common in computational math. Learn how to perform array rotations in place using the Triple-Reverse trick.",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "3 min read",
    url: "posts/rotating-arrays-simply.html",
    image: "images/rotating_array_k_times.svg"
  },
  {
    id: 29,
    title: "Finding the Top K Elements: A Simple Guide",
    excerpt: "Filtering and displaying high scores requires sorting datasets dynamically. Learn how to maintain a top K leaderboard using a custom TreeSet in Java.",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/finding-top-k-elements-simply.html",
    image: "images/top_k_elements.svg"
  },
  {
    id: 28,
    title: "Maximizing Stock Profits: A Simple Guide",
    excerpt: "Learn how to find the maximum possible stock profit in Java simply, using a rollercoaster climbing analogy and a line-by-line main method trace.",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/maximizing-stock-profits-simply.html",
    image: "images/stock_profit_checker.svg"
  },
  {
    id: 27,
    title: "Detecting Loops in a Linked List: A Simple Guide",
    excerpt: "Infinite loops can freeze programs. Learn how to detect cycles in singly linked lists using a simple visited flag check and a sticky note analogy.",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "3 min read",
    url: "posts/detecting-linked-list-loops-simply.html",
    image: "images/linked_list_loop_detector.svg"
  },
  {
    id: 26,
    title: "Reversing a Linked List: A Simple Guide",
    excerpt: "Manipulating memory pointers in place is a crucial coding skill. Learn how to flip linked list nodes one-by-one using a shoulder-holding line analogy.",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/reversing-linked-list-simply.html",
    image: "images/reversing_linked_list.svg"
  },
  {
    id: 25,
    title: "Understanding Balanced Parentheses: A Simple Guide",
    excerpt: "Checking if brackets open and close in correct nesting order is a fundamental algorithmic challenge. Learn how Java solves it using a Stack and a Russian nesting dolls analogy.",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/understanding-balanced-parentheses-simply.html",
    image: "images/parenthesis_checker.png"
  },
  {
    id: 24,
    title: "Flatmapping Min/Max & Diamond Inheritance: A Simple Guide",
    excerpt: "Learn how array flatmapping structures data in Streams and how Java resolves interface default method conflicts (the Diamond Problem).",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/flatmapping-min-max-interfaces-simply.html",
    image: "images/min_max_flatmap.png"
  },
  {
    id: 23,
    title: "Flattening 2D Arrays in Java: A Simple Guide",
    excerpt: "Processing nested arrays is simpler when you flatten them first. Learn how to transform 2D arrays in Java Streams using flatMapToInt and a dresser drawer analogy.",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/flattening-two-dimensional-arrays-simply.html",
    image: "images/flattening_2d_arrays.png"
  },
  {
    id: 22,
    title: "Sorting by Multiple Fields: A Simple Guide",
    excerpt: "Sorting collections often requires multiple criteria to break ties. Learn how to chain Comparators in Java Streams using a simple school lining-up analogy.",
    category: "Java",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/sorting-multiple-fields-streams-simply.html",
    image: "images/comparator_chaining.png"
  },
  {
    id: 21,
    title: "Understanding Anagram Grouping: A Simple Guide",
    excerpt: "Scrambled letters sharing the same alphabet footprint form Anagram families. Learn how to sort and group anagrams in Java using HashMap and Stream collector grouping.",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/understanding-anagram-grouping-simply.html",
    image: "images/string_anagram_grouping.png"
  },
  {
    id: 20,
    title: "Understanding Strings as HashMap Keys: A Simple Guide",
    excerpt: "Java's String pool cache handles literals and heap allocations differently in memory. Learn how HashMap resolves them using a key-maker analogy.",
    category: "Java",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/understanding-string-map-keys-simply.html",
    image: "images/string_identity_map.png"
  },
  {
    id: 19,
    title: "Demystifying Java's equals() and hashCode() Contract: A Simple Guide",
    excerpt: "HashMap depends heavily on the equals and hashCode methods to organize data. Learn how breaking this contract leads to duplicated keys using a broken sorting room analogy.",
    category: "Java",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/understanding-hashmap-equals-hashcode-simply.html",
    image: "images/hash_contract_broken.png"
  },
  {
    id: 18,
    title: "Demystifying Java's Synchronized Keyword: A Simple Guide",
    excerpt: "Thread synchronization prevents data corruption in concurrent programs. Learn how Java locks object monitors using a simple telephone booth analogy.",
    category: "Java Concurrency",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/understanding-synchronized-keyword-simply.html",
    image: "images/understanding_synchronized.png"
  },
  {
    id: 17,
    title: "Printing Odd & Even Numbers using Two Threads: A Simple Guide",
    excerpt: "Coordinating threads to print alternating numbers is a classic interview puzzle. Learn how to solve this using BlockingQueue with a simple relay race analogy.",
    category: "Java Concurrency",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/printing-odd-even-threads-simply.html",
    image: "images/odd_even_threads.png"
  },
  {
    id: 16,
    title: "Understanding Java's Synchronized Deadlocks: A Simple Guide",
    excerpt: "Nesting synchronized blocks can easily freeze your threads if lock order is inconsistent. Learn how these deadlocks occur using a double bank transfer analogy.",
    category: "Java Concurrency",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/understanding-deadlock-synchronized-simply.html",
    image: "images/deadlock_synchronized.png"
  },
  {
    id: 15,
    title: "Understanding Java Deadlocks: A Simple Guide",
    excerpt: "Thread deadlocks can freeze your program indefinitely. Learn how they happen using explicit ReentrantLocks and a simple coloring-contest analogy.",
    category: "Java Concurrency",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/understanding-deadlock-checker-simply.html",
    image: "images/deadlock_checker.png"
  },
  {
    id: 14,
    title: "Demystifying Java's Builder Design Pattern: A Simple Guide",
    excerpt: "Constructing complex objects with many optional parameters doesn't have to be a headache. Learn how the Builder pattern solves this using a step-by-step robot helper analogy.",
    category: "Design Patterns",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/understanding-builder-design-pattern-simply.html",
    image: "images/builder_pattern.png"
  },
  {
    id: 13,
    title: "Demystifying String Permutations: A Simple Guide",
    excerpt: "Finding all rearrangements of a string is a classic backtracking problem. Learn how to solve this using simple swapping cards analogies.",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/understanding-string-permutations-simply.html",
    image: "images/string_permutations.png"
  },
  {
    id: 12,
    title: "Reversing Strings While Preserving Space Positions",
    excerpt: "Flipping a string while keeping space formatting intact is a common puzzle. Learn how to solve this using a bookmark-and-restore algorithm.",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/reversing-words-preserving-spaces-simply.html",
    image: "images/reversing_words.png"
  },
  {
    id: 11,
    title: "Understanding Java's Wait and Notify: A Simple Guide",
    excerpt: "Coordinating threads without a BlockingQueue requires low-level synchronization. Learn how wait and notifyAll coordinate threads using a locked bakery shelf analogy.",
    category: "Java Concurrency",
    date: "June 19, 2026",
    readTime: "5 min read",
    url: "posts/understanding-producer-consumer-wait-notify-simply.html",
    image: "images/bakery_wait_notify.png"
  },
  {
    id: 10,
    title: "Understanding Java's Producer-Consumer Pattern: A Simple Guide",
    excerpt: "Coordinating threads doesn't have to be complex. Learn how to implement the Producer-Consumer pattern using Java's BlockingQueue with a simple bakery shelf analogy.",
    category: "Java Concurrency",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/understanding-producer-consumer-simply.html",
    image: "images/bakery_producer_consumer.png"
  },
  {
    id: 9,
    title: "Demystifying Java's Thread Pool: A Simple Guide",
    excerpt: "Thread pools are crucial for optimizing performance in concurrent systems. In this guide, we explain custom thread pools and worker thread queues using a cozy coffee shop analogy.",
    category: "Java Concurrency",
    date: "June 19, 2026",
    readTime: "5 min read",
    url: "posts/understanding-thread-pool-simply.html",
    image: "images/coffee_shop_kitchen.png"
  },
  {
    id: 8,
    title: "Demystifying the Bridge and Torch Problem: A Simple Guide",
    excerpt: "The Bridge and Torch problem is a classic optimization puzzle. In this guide, we break down the strategies for finding the minimum crossing time using simple analogies and Java code.",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "5 min read",
    url: "posts/bridge-and-torch-problem-simply.html",
    image: "images/bridge_crossing.png"
  },
  {
    id: 7,
    title: "Understanding Java's CompletableFuture: A Simple Walkthrough",
    excerpt: "Concurrency and asynchronous tasks don't have to be complicated. In this guide, we break down Java's CompletableFuture and thenCombine using a dinner prep analogy so you can write cleaner non-blocking programs.",
    category: "Java Concurrency",
    date: "June 18, 2026",
    readTime: "4 min read",
    url: "posts/understanding-completablefuture-simply.html",
    image: ""
  },
  {
    id: 6,
    title: "Demystifying Java's ForkJoinPool: A Simple Guide",
    excerpt: "Parallel processing doesn't have to be intimidating. In this guide, we break down Java's ForkJoinPool and RecursiveTask using a sandwich-making analogy so you can write high-performance multithreaded programs easily.",
    category: "Java Parallelism",
    date: "June 18, 2026",
    readTime: "4 min read",
    url: "posts/understanding-forkjoin-pool-simply.html",
    image: ""
  }
];
