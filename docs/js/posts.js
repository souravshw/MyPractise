// Blog Posts Data Source
const postsData = [
  {
    id: 62,
    title: "Understanding Java Inner Classes: Member, Local, and Anonymous",
    excerpt: "Learn the differences between Member, Local, and Anonymous inner classes in Java, explained simply with real-world analogies and code examples.",
    category: "Java Core & OOP",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/java-inner-classes-member-local-anonymous.html",
    image: "images/coffee_shop_kitchen.png"
  },
  {
    id: 61,
    title: "Understanding Java Static Nested Classes and Nested Interfaces",
    excerpt: "Learn how Java static nested classes and nested interfaces work, their access rules, and how to instantiate them. Explained simply.",
    category: "Java Core & OOP",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/java-static-nested-classes-interfaces.html",
    image: "images/string_identity_map.png"
  },
  {
    id: 60,
    title: "Class Initialization Sequences in Java Inheritance",
    excerpt: "Learn the initialization sequence rules of static blocks and instance blocks in a Java subclass-superclass inheritance layout simply.",
    category: "Java Core & OOP",
    date: "June 19, 2026",
    readTime: "3 min read",
    url: "posts/java-class-initialization-blocks-inheritance.html",
    image: "images/java_initialization_blocks.png"
  },
  {
    id: 59,
    title: "Mutating Map Keys and the HashSet Removal Gotcha",
    excerpt: "Learn how mutating mutable fields inside Map keys or HashSet elements breaks hash buckets and prevents removals in Java. Explained simply.",
    category: "Java Collections",
    date: "June 19, 2026",
    readTime: "5 min read",
    url: "posts/java-mutating-map-keys-set-removal.html",
    image: "images/hash_contract_broken.png"
  },
  {
    id: 58,
    title: "How Map Sorting Works with and without Java Streams",
    excerpt: "Learn how to sort a HashMap by values in Java, using both classic Collections.sort() and Java 8 Streams. Explained simply.",
    category: "Java Collections",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/java-map-sorting-values-stream.html",
    image: "images/comparator_chaining.png"
  },
  {
    id: 57,
    title: "Sorted Sets (TreeSet) and Custom Comparator Gotchas in Java",
    excerpt: "Learn how TreeSet uses compareTo to enforce uniqueness in Java, and discover the trap of returning 0 from custom Comparables. Explained simply.",
    category: "Java Collections",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/java-sorted-sets-treeset-comparator-gotchas.html",
    image: "images/custom_list.svg"
  },
  {
    id: 56,
    title: "LeetCode: Reversing a 32-bit Integer and Preventing Overflow",
    excerpt: "Learn how to reverse the digits of a 32-bit signed integer in Java and protect against numerical overflow simply.",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "3 min read",
    url: "posts/leetcode-reversing-integer-overflow.html",
    image: "images/stock_profit_checker.svg"
  },
  {
    id: 55,
    title: "Sorting Lists Based on Element Occurrences in Java",
    excerpt: "Learn how to sort a list of integers based on their maximum frequency/occurrences in Java using Streams groupingBy and custom sorting.",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/leetcode-sorting-list-by-max-occurrences.html",
    image: "images/top_k_elements.svg"
  },
  {
    id: 54,
    title: "Solving HackerRank's Min-Max Sum Challenge in Java",
    excerpt: "Learn how to solve the HackerRank Min-Max Sum challenge in Java, finding the minimum and maximum sums of exactly 4 out of 5 integers. Explained simply.",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/hackerrank-min-max-sum-challenge.html",
    image: "images/rotating_array_k_times.svg"
  },
  {
    id: 53,
    title: "Solving HackerRank's Plus-Minus Ratio Challenge in Java",
    excerpt: "Learn how to solve the HackerRank Plus-Minus ratio challenge in Java using Stream filtering to calculate numeric ratios. Explained simply.",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "3 min read",
    url: "posts/hackerrank-plus-minus-ratio-challenge.html",
    image: "images/stock_profit_checker.svg"
  },
  {
    id: 52,
    title: "Finding Target Sum Pairs Using Complements HashSet in Java",
    excerpt: "Learn how to solve the target sum pairs (Two Sum) challenge in Java using a complements HashSet for O(N) efficiency. Explained simply.",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "3 min read",
    url: "posts/hackerrank-find-target-sum-pairs.html",
    image: "images/summing_up_to_n.svg"
  },
  {
    id: 51,
    title: "Understanding Java Exception Propagation",
    excerpt: "Learn how checked and unchecked exceptions propagate up the call stack in Java, explained simply with a corporate escalation analogy.",
    category: "Java Exceptions",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/understanding-java-exception-propagation.html",
    image: "images/java_exception_propagation.png"
  },
  {
    id: 50,
    title: "How to Use throw, throws, and Custom Exceptions in Java",
    excerpt: "Learn the difference between throw and throws in Java and how to create custom exception classes simply with real-world analogies.",
    category: "Java Exceptions",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/java-throw-throws-custom-exceptions.html",
    image: "images/java_throw_throws_custom.png"
  },
  {
    id: 49,
    title: "Java Multiple Catch Blocks and the Finally Execution Trap",
    excerpt: "Learn how multiple catch blocks work in Java, their ordered execution, and the finally execution trap when calling System.exit(). Explained simply.",
    category: "Java Exceptions",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/java-multiple-catch-finally-execution.html",
    image: "images/java_catch_finally_execution.png"
  },
  {
    id: 48,
    title: "Java Exception Rules in Method Overriding",
    excerpt: "Learn Java's compilation rules for overridden methods declaring checked vs unchecked exceptions simply with comparison guidelines and parent-child examples.",
    category: "Java Exceptions",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/java-exception-rules-method-overriding.html",
    image: "images/java_exception_overriding.png"
  },
  {
    id: 47,
    title: "Reading and Writing Files in Java: The Classic IO Way",
    excerpt: "Learn how to read and write files in Java using classic classes like FileReader, BufferedReader, and PrintWriter. Explained simply with clear examples.",
    category: "Java IO & NIO",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/java-classic-io-read-write-files.html",
    image: "images/java_classic_io_read_write.png"
  },
  {
    id: 46,
    title: "Building a Custom Filter Reader: The Decorator Pattern in Java IO",
    excerpt: "Learn how to extend BufferedReader to create a custom filter class that capitalizes text as it reads, demonstrating the Decorator Pattern simply.",
    category: "Java IO & NIO",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/java-custom-bufferedReader-decorator.html",
    image: "images/java_custom_reader_decorator.png"
  },
  {
    id: 45,
    title: "Modern File Manipulation in Java: Introduction to NIO.2",
    excerpt: "Learn how to perform file manipulation in Java using NIO.2 (Files and Path). Create, delete, and move files simply with clear examples.",
    category: "Java IO & NIO",
    date: "June 19, 2026",
    readTime: "3 min read",
    url: "posts/java-nio-file-manipulation.html",
    image: "images/java_nio_file_manipulation.png"
  },
  {
    id: 44,
    title: "Java 8 Streams Recipes for Common Programming Tasks",
    excerpt: "Learn Java 8 Streams recipes for partitioning odd/even, finding string frequency, sorting, merging arrays, and reversing lists simply with code blocks.",
    category: "Java Streams & Functional",
    date: "June 19, 2026",
    readTime: "5 min read",
    url: "posts/java8-streams-common-tasks-recipes.html",
    image: "images/java8_streams_recipes.png"
  },
  {
    id: 43,
    title: "Deep Dive into Java 8 Method References",
    excerpt: "Learn Java 8 method reference syntax (static, instance, constructor) bound to Consumer, Supplier, and BiPredicate functional interfaces simply.",
    category: "Java Streams & Functional",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/java8-method-references-guide.html",
    image: "images/java8_method_references.png"
  },
  {
    id: 42,
    title: "Understanding Generic Classes and Methods in Java",
    excerpt: "Learn the basics of Java Generics by declaring generic classes and generic methods. Explained simply with type parameters and code examples.",
    category: "Java Generics",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/understanding-java-generic-classes-methods.html",
    image: "images/custom_list.svg"
  },
  {
    id: 41,
    title: "Demystifying Java Generics Wildcards and Bounded Types",
    excerpt: "Learn Java Generics wildcards, upper bounds (? extends T), and lower bounds (? super T) simply with hierarchies of Person, Student, and Teacher.",
    category: "Java Generics",
    date: "June 19, 2026",
    readTime: "5 min read",
    url: "posts/java-generics-wildcards-bounded-types.html",
    image: "images/comparator_chaining.png"
  },
  {
    id: 40,
    title: "Understanding Built-In Annotations in Java",
    excerpt: "Learn Java's built-in annotations (@Override, @Deprecated, and @SuppressWarnings) simply with practical code examples and clear layman analogies.",
    category: "Java Annotations",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/understanding-java-builtin-annotations.html",
    image: "images/java_builtin_annotations.png"
  },
  {
    id: 39,
    title: "How to Create and Read Custom Annotations in Java",
    excerpt: "Learn how to declare custom annotations in Java using @interface and read their parameters at runtime using Reflection. Explained simply.",
    category: "Java Annotations",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/creating-custom-annotations-java.html",
    image: "images/custom_annotations_java.png"
  },
  {
    id: 38,
    title: "Understanding the Basics of Java Enums",
    excerpt: "Learn the basics of Java Enums, including declaring enums inside or outside classes and using them inside switch statements simply.",
    category: "Java Enums",
    date: "June 19, 2026",
    readTime: "3 min read",
    url: "posts/understanding-java-enums-basics.html",
    image: "images/java_enums_basics.png"
  },
  {
    id: 37,
    title: "Mastering Advanced Java Enums: Fields and Constructors",
    excerpt: "Learn advanced Java Enums features, including adding instance fields, custom private constructors, and iterating values simply.",
    category: "Java Enums",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/understanding-advanced-java-enums.html",
    image: "images/advanced_java_enums.png"
  },
  {
    id: 36,
    title: "Understanding String Equality in Java",
    excerpt: "Learn the difference between == and .equals() for String comparison in Java, explained simply with a smartphone analogy and a step-by-step code trace.",
    category: "Java Core & OOP",
    date: "June 19, 2026",
    readTime: "3 min read",
    url: "posts/understanding-string-equality.html",
    image: "images/string_equality_java.png"
  },
  {
    id: 35,
    title: "Demystifying the equals() and hashCode() Contract in Java",
    excerpt: "Learn the equals and hashCode contract in Java using Book and Employee entities, and discover common pitfalls like misspelled overrides and unsafe casts.",
    category: "Java Core & OOP",
    date: "June 19, 2026",
    readTime: "5 min read",
    url: "posts/understanding-equals-hashcode-contract.html",
    image: "images/book_employee_equals.png"
  },
  {
    id: 34,
    title: "Understanding Java Class Initialization Order and Blocks",
    excerpt: "Learn Java initialization blocks (static and instance blocks) and constructor execution order using BaseballTeam, explained simply.",
    category: "Java Core & OOP",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/understanding-class-initialization-blocks.html",
    image: "images/java_initialization_blocks.png"
  },
  {
    id: 33,
    title: "Finding the Longest Consecutive Increasing Chain in Java",
    excerpt: "Searching for ordered sequences inside arrays is a classic algorithmic puzzle. Learn how to scan and calculate the longest incrementing card run in Java.",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "3 min read",
    url: "posts/consecutive-increasing-chains.html",
    image: "images/consecutive_increasing_chain.svg"
  },
  {
    id: 32,
    title: "Summing Up to a Target Sum in Java",
    excerpt: "Comparing elements across arrays of different sizes requires bounds checking. Learn how to safely search for index pairs summing to 10 in Java.",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "3 min read",
    url: "posts/summing-up-to-ten.html",
    image: "images/summing_up_to_n.svg"
  },
  {
    id: 31,
    title: "How ArrayList Works Under the Hood",
    excerpt: "Arrays are fixed-size in computer memory, but ArrayList expands dynamically. Learn how Java grows capacity behind the scenes using an expanding toy box analogy.",
    category: "Java Core & OOP",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/understanding-custom-arraylist.html",
    image: "images/custom_list.svg"
  },
  {
    id: 30,
    title: "Rotating Arrays in Java",
    excerpt: "Shifting elements inside memory arrays is common in computational math. Learn how to perform array rotations in place using the Triple-Reverse trick.",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "3 min read",
    url: "posts/rotating-arrays.html",
    image: "images/rotating_array_k_times.svg"
  },
  {
    id: 29,
    title: "Finding the Top K Elements",
    excerpt: "Filtering and displaying high scores requires sorting datasets dynamically. Learn how to maintain a top K leaderboard using a custom TreeSet in Java.",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/finding-top-k-elements.html",
    image: "images/top_k_elements.svg"
  },
  {
    id: 28,
    title: "Maximizing Stock Profits",
    excerpt: "Learn how to find the maximum possible stock profit in Java simply, using a rollercoaster climbing analogy and a line-by-line main method trace.",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/maximizing-stock-profits.html",
    image: "images/stock_profit_checker.svg"
  },
  {
    id: 27,
    title: "Detecting Loops in a Linked List",
    excerpt: "Infinite loops can freeze programs. Learn how to detect cycles in singly linked lists using a simple visited flag check and a sticky note analogy.",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "3 min read",
    url: "posts/detecting-linked-list-loops.html",
    image: "images/linked_list_loop_detector.svg"
  },
  {
    id: 26,
    title: "Reversing a Linked List",
    excerpt: "Manipulating memory pointers in place is a crucial coding skill. Learn how to flip linked list nodes one-by-one using a shoulder-holding line analogy.",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/reversing-linked-list.html",
    image: "images/reversing_linked_list.svg"
  },
  {
    id: 25,
    title: "Understanding Balanced Parentheses",
    excerpt: "Checking if brackets open and close in correct nesting order is a fundamental algorithmic challenge. Learn how Java solves it using a Stack and a Russian nesting dolls analogy.",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/understanding-balanced-parentheses.html",
    image: "images/parenthesis_checker.png"
  },
  {
    id: 24,
    title: "Flatmapping Min/Max & Diamond Inheritance",
    excerpt: "Learn how array flatmapping structures data in Streams and how Java resolves interface default method conflicts (the Diamond Problem).",
    category: "Java Streams & Functional",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/flatmapping-min-max-interfaces.html",
    image: "images/min_max_flatmap.png"
  },
  {
    id: 23,
    title: "Flattening 2D Arrays in Java",
    excerpt: "Processing nested arrays is simpler when you flatten them first. Learn how to transform 2D arrays in Java Streams using flatMapToInt and a dresser drawer analogy.",
    category: "Java Streams & Functional",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/flattening-two-dimensional-arrays.html",
    image: "images/flattening_2d_arrays.png"
  },
  {
    id: 22,
    title: "Sorting by Multiple Fields",
    excerpt: "Sorting collections often requires multiple criteria to break ties. Learn how to chain Comparators in Java Streams using a simple school lining-up analogy.",
    category: "Java Streams & Functional",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/sorting-multiple-fields-streams.html",
    image: "images/comparator_chaining.png"
  },
  {
    id: 21,
    title: "Understanding Anagram Grouping",
    excerpt: "Scrambled letters sharing the same alphabet footprint form Anagram families. Learn how to sort and group anagrams in Java using HashMap and Stream collector grouping.",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/understanding-anagram-grouping.html",
    image: "images/string_anagram_grouping.png"
  },
  {
    id: 20,
    title: "Understanding Strings as HashMap Keys",
    excerpt: "Java's String pool cache handles literals and heap allocations differently in memory. Learn how HashMap resolves them using a key-maker analogy.",
    category: "Java Core & OOP",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/understanding-string-map-keys.html",
    image: "images/string_identity_map.png"
  },
  {
    id: 19,
    title: "Demystifying Java's equals() and hashCode() Contract",
    excerpt: "HashMap depends heavily on the equals and hashCode methods to organize data. Learn how breaking this contract leads to duplicated keys using a broken sorting room analogy.",
    category: "Java Core & OOP",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/understanding-hashmap-equals-hashcode.html",
    image: "images/hash_contract_broken.png"
  },
  {
    id: 18,
    title: "Demystifying Java's Synchronized Keyword",
    excerpt: "Thread synchronization prevents data corruption in concurrent programs. Learn how Java locks object monitors using a simple telephone booth analogy.",
    category: "Java Concurrency",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/understanding-synchronized-keyword.html",
    image: "images/understanding_synchronized.png"
  },
  {
    id: 17,
    title: "Printing Odd & Even Numbers using Two Threads",
    excerpt: "Coordinating threads to print alternating numbers is a classic interview puzzle. Learn how to solve this using BlockingQueue with a simple relay race analogy.",
    category: "Java Concurrency",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/printing-odd-even-threads.html",
    image: "images/odd_even_threads.png"
  },
  {
    id: 16,
    title: "Understanding Java's Synchronized Deadlocks",
    excerpt: "Nesting synchronized blocks can easily freeze your threads if lock order is inconsistent. Learn how these deadlocks occur using a double bank transfer analogy.",
    category: "Java Concurrency",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/understanding-deadlock-synchronized.html",
    image: "images/deadlock_synchronized.png"
  },
  {
    id: 15,
    title: "Understanding Java Deadlocks",
    excerpt: "Thread deadlocks can freeze your program indefinitely. Learn how they happen using explicit ReentrantLocks and a simple coloring-contest analogy.",
    category: "Java Concurrency",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/understanding-deadlock-checker.html",
    image: "images/deadlock_checker.png"
  },
  {
    id: 14,
    title: "Demystifying Java's Builder Design Pattern",
    excerpt: "Constructing complex objects with many optional parameters doesn't have to be a headache. Learn how the Builder pattern solves this using a step-by-step robot helper analogy.",
    category: "Design Patterns",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/understanding-builder-design-pattern.html",
    image: "images/builder_pattern.png"
  },
  {
    id: 13,
    title: "Demystifying String Permutations",
    excerpt: "Finding all rearrangements of a string is a classic backtracking problem. Learn how to solve this using simple swapping cards analogies.",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/understanding-string-permutations.html",
    image: "images/string_permutations.png"
  },
  {
    id: 12,
    title: "Reversing Strings While Preserving Space Positions",
    excerpt: "Flipping a string while keeping space formatting intact is a common puzzle. Learn how to solve this using a bookmark-and-restore algorithm.",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/reversing-words-preserving-spaces.html",
    image: "images/reversing_words.png"
  },
  {
    id: 11,
    title: "Understanding Java's Wait and Notify",
    excerpt: "Coordinating threads without a BlockingQueue requires low-level synchronization. Learn how wait and notifyAll coordinate threads using a locked bakery shelf analogy.",
    category: "Java Concurrency",
    date: "June 19, 2026",
    readTime: "5 min read",
    url: "posts/understanding-producer-consumer-wait-notify.html",
    image: "images/bakery_wait_notify.png"
  },
  {
    id: 10,
    title: "Understanding Java's Producer-Consumer Pattern",
    excerpt: "Coordinating threads doesn't have to be complex. Learn how to implement the Producer-Consumer pattern using Java's BlockingQueue with a simple bakery shelf analogy.",
    category: "Java Concurrency",
    date: "June 19, 2026",
    readTime: "4 min read",
    url: "posts/understanding-producer-consumer.html",
    image: "images/bakery_producer_consumer.png"
  },
  {
    id: 9,
    title: "Demystifying Java's Thread Pool",
    excerpt: "Thread pools are crucial for optimizing performance in concurrent systems. In this guide, we explain custom thread pools and worker thread queues using a cozy coffee shop analogy.",
    category: "Java Concurrency",
    date: "June 19, 2026",
    readTime: "5 min read",
    url: "posts/understanding-thread-pool.html",
    image: "images/coffee_shop_kitchen.png"
  },
  {
    id: 8,
    title: "Demystifying the Bridge and Torch Problem",
    excerpt: "The Bridge and Torch problem is a classic optimization puzzle. In this guide, we break down the strategies for finding the minimum crossing time using simple analogies and Java code.",
    category: "Algorithms",
    date: "June 19, 2026",
    readTime: "5 min read",
    url: "posts/bridge-and-torch-problem.html",
    image: "images/bridge_crossing.png"
  },
  {
    id: 7,
    title: "Understanding Java's CompletableFuture",
    excerpt: "Concurrency and asynchronous tasks don't have to be complicated. In this guide, we break down Java's CompletableFuture and thenCombine using a dinner prep analogy so you can write cleaner non-blocking programs.",
    category: "Java Concurrency",
    date: "June 18, 2026",
    readTime: "4 min read",
    url: "posts/understanding-completablefuture.html",
    image: "images/completable_future.svg"
  },
  {
    id: 6,
    title: "Demystifying Java's ForkJoinPool",
    excerpt: "Parallel processing doesn't have to be intimidating. In this guide, we break down Java's ForkJoinPool and RecursiveTask using a sandwich-making analogy so you can write high-performance multithreaded programs easily.",
    category: "Java Parallelism",
    date: "June 18, 2026",
    readTime: "4 min read",
    url: "posts/understanding-forkjoin-pool.html",
    image: "images/fork_join_pool.svg"
  }
];

