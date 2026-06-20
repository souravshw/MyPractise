// Blog Posts Data Source
const postsData = [
  {
    id: 92,
    title: "Common Kafka Architecture and Design Patterns",
    excerpt: "Explore common Kafka architectural design patterns. Learn how Event Sourcing, CQRS, Transactional Outbox, and Dead Letter Queues (DLQ) work simply.",
    category: "Kafka & Distributed Systems",
    date: "June 20, 2026",
    readTime: "5 min read",
    url: "posts/kafka-architecture-design-patterns.html",
    image: "images/kafka-design-patterns.svg"
  },
  {
    id: 91,
    title: "Important Kafka Metrics to Monitor in Production",
    excerpt: "A production guide to Kafka monitoring. Learn the critical metrics including under-replicated partitions, consumer lag, and ISR shrink rates.",
    category: "Kafka & Distributed Systems",
    date: "June 20, 2026",
    readTime: "4 min read",
    url: "posts/kafka-monitoring-critical-metrics.html",
    image: "images/kafka-monitoring.svg"
  },
  {
    id: 90,
    title: "Introduction to Apache Kafka Security: Authentication & Authorization",
    excerpt: "A simple guide to Apache Kafka security. Learn about TLS encryption, SASL/SCRAM authentication, and ACLs authorization simply.",
    category: "Kafka & Distributed Systems",
    date: "June 20, 2026",
    readTime: "4 min read",
    url: "posts/kafka-security-mechanisms.html",
    image: "images/kafka-security.svg"
  },
  {
    id: 89,
    title: "Handling Schema Evolution in Kafka with Schema Registry",
    excerpt: "How do you handle schema evolution in Kafka? Learn how Confluent Schema Registry works, Avro serialization compatibility rules, and best practices simply.",
    category: "Kafka & Distributed Systems",
    date: "June 20, 2026",
    readTime: "4 min read",
    url: "posts/kafka-schema-evolution-registry.html",
    image: "images/kafka-schema-registry.svg"
  },
  {
    id: 88,
    title: "Kafka Delivery Semantics: At-Most-Once, At-Least-Once, Exactly-Once",
    excerpt: "A guide to Kafka delivery semantics. Learn how to configure At-Most-Once, At-Least-Once, and Exactly-Once (EOS) processing pipelines simply.",
    category: "Kafka & Distributed Systems",
    date: "June 20, 2026",
    readTime: "4 min read",
    url: "posts/kafka-delivery-semantics-guarantees.html",
    image: "images/kafka-delivery-guarantees.svg"
  },
  {
    id: 87,
    title: "Why Kafka is Moving to KRaft (Raft Metadata Mode) from ZooKeeper",
    excerpt: "Why is Apache ZooKeeper being replaced by KRaft mode? Learn about operational complexity, partition scaling bottlenecks, and metadata quorums.",
    category: "Kafka & Distributed Systems",
    date: "June 20, 2026",
    readTime: "4 min read",
    url: "posts/kafka-kraft-mode-vs-zookeeper.html",
    image: "images/kafka-kraft.svg"
  },
  {
    id: 86,
    title: "Understanding Log Compaction in Apache Kafka",
    excerpt: "What is Kafka Log Compaction? Learn how the clean vs. dirty log sections work, how disk space is reclaimed, and how tombstone records delete keys.",
    category: "Kafka & Distributed Systems",
    date: "June 20, 2026",
    readTime: "4 min read",
    url: "posts/kafka-log-compaction.html",
    image: "images/kafka-log-compaction.svg"
  },
  {
    id: 85,
    title: "What is Kafka Connect? Source vs. Sink Connectors",
    excerpt: "What is Kafka Connect? Learn how Source and Sink connectors simplify data ingestion from databases and exports to search engines without writing code.",
    category: "Kafka & Distributed Systems",
    date: "June 20, 2026",
    readTime: "4 min read",
    url: "posts/kafka-connect-source-sink.html",
    image: "images/kafka-connect.svg"
  },
  {
    id: 84,
    title: "What is a State Store in Kafka Streams?",
    excerpt: "What is a State Store in Kafka Streams? Learn how RocksDB is used for local state, and how changelog topics provide fault-tolerant recovery.",
    category: "Kafka & Distributed Systems",
    date: "June 20, 2026",
    readTime: "4 min read",
    url: "posts/kafka-streams-state-store.html",
    image: "images/kafka-state-store.svg"
  },
  {
    id: 83,
    title: "Kafka Streams: KStream vs. KTable Explained Simply",
    excerpt: "What is the difference between KStream and KTable in Kafka Streams? Learn their append vs. upsert semantics and windowing behavior simply.",
    category: "Kafka & Distributed Systems",
    date: "June 20, 2026",
    readTime: "4 min read",
    url: "posts/kafka-kstream-vs-ktable.html",
    image: "images/kafka-kstream-ktable.svg"
  },
  {
    id: 82,
    title: "Kafka Streams vs. Kafka Consumer: Which Should You Use?",
    excerpt: "Compare Kafka Streams library with classic Kafka Consumers. Learn when to use stateful processing, KStreams, KTables, and RocksDB state stores simply.",
    category: "Kafka & Distributed Systems",
    date: "June 20, 2026",
    readTime: "5 min read",
    url: "posts/kafka-streams-vs-consumer.html",
    image: "images/kafka-streams-intro.svg"
  },
  {
    id: 81,
    title: "How Kafka Achieves High Throughput (Zero-Copy & Sequential I/O)",
    excerpt: "Why is Apache Kafka so fast? Learn the internal design patterns including sequential disk IO, OS page cache utilization, batching, and zero-copy transfer.",
    category: "Kafka & Distributed Systems",
    date: "June 20, 2026",
    readTime: "4 min read",
    url: "posts/kafka-why-is-kafka-so-fast.html",
    image: "images/kafka-zero-copy.svg"
  },
  {
    id: 80,
    title: "Key Consumer Configurations for High Throughput in Kafka",
    excerpt: "Optimize your Kafka Consumer for high throughput. Learn how to configure fetch.min.bytes, max.poll.records, and fetch.max.wait.ms for speed.",
    category: "Kafka & Distributed Systems",
    date: "June 20, 2026",
    readTime: "4 min read",
    url: "posts/kafka-consumer-high-throughput.html",
    image: "images/kafka-consumer-throughput.svg"
  },
  {
    id: 79,
    title: "Key Producer Configurations for High Throughput in Kafka",
    excerpt: "Optimize your Kafka Producer for maximum throughput. Learn how tuning batch.size, linger.ms, compression.type, and buffer.memory improves speed.",
    category: "Kafka & Distributed Systems",
    date: "June 20, 2026",
    readTime: "4 min read",
    url: "posts/kafka-producer-high-throughput.html",
    image: "images/kafka_producer_throughput.png"
  },
  {
    id: 78,
    title: "What Happens When a Kafka Broker Goes Down?",
    excerpt: "What happens when a Kafka broker crashes? Learn how heartbeats detect failures, how partition leaders failover, and how clients automatically reconnect.",
    category: "Kafka & Distributed Systems",
    date: "June 20, 2026",
    readTime: "4 min read",
    url: "posts/kafka-broker-failure-scenario.html",
    image: "images/kafka_broker_down.png"
  },
  {
    id: 77,
    title: "Why min.insync.replicas is Crucial for Kafka Durability",
    excerpt: "Discover how min.insync.replicas protects Kafka data when combined with acks=all. Learn the failure scenarios and production recommendations.",
    category: "Kafka & Distributed Systems",
    date: "June 20, 2026",
    readTime: "4 min read",
    url: "posts/kafka-min-insync-replicas.html",
    image: "images/kafka_min_isr.png"
  },
  {
    id: 76,
    title: "How Apache Kafka Replication and Leader Election Work",
    excerpt: "Understand Kafka partition replication. Learn what Leader, Followers, In-Sync Replicas (ISR), and unclean leader elections do simply.",
    category: "Kafka & Distributed Systems",
    date: "June 20, 2026",
    readTime: "4 min read",
    url: "posts/kafka-replication-mechanics.html",
    image: "images/kafka_replication.png"
  },
  {
    id: 75,
    title: "Kafka Consumer Commits: commitSync vs. commitAsync",
    excerpt: "Compare commitSync and commitAsync methods in Kafka Consumer client. Learn which one to use in your loop vs. shutdown hooks for optimal latency.",
    category: "Kafka & Distributed Systems",
    date: "June 20, 2026",
    readTime: "4 min read",
    url: "posts/kafka-commitsync-vs-commitasync.html",
    image: "images/kafka_commit_sync_async.png"
  },
  {
    id: 74,
    title: "Kafka auto.offset.reset: Earliest vs. Latest Explained Simply",
    excerpt: "What is the difference between auto.offset.reset=earliest and latest in Apache Kafka? Learn how offset positioning works for new consumer groups simply.",
    category: "Kafka & Distributed Systems",
    date: "June 20, 2026",
    readTime: "3 min read",
    url: "posts/kafka-auto-offset-reset.html",
    image: "images/kafka_offset_reset.png"
  },
  {
    id: 73,
    title: "Understanding Kafka Consumer Rebalancing and How to Minimize It",
    excerpt: "Learn what consumer rebalancing is in Apache Kafka, what triggers it, why it causes stop-the-world pauses, and how to configure static membership to reduce it.",
    category: "Kafka & Distributed Systems",
    date: "June 20, 2026",
    readTime: "4 min read",
    url: "posts/kafka-consumer-rebalancing.html",
    image: "images/kafka_rebalancing.png"
  },
  {
    id: 72,
    title: "What is Apache Kafka and Why is it Used?",
    excerpt: "Learn what Apache Kafka is, how it works, and why companies use it for high-throughput, real-time event streaming simply.",
    category: "Kafka & Distributed Systems",
    date: "June 20, 2026",
    readTime: "4 min read",
    url: "posts/kafka-what-is-kafka.html",
    image: "images/kafka_intro.png"
  },
  {
    id: 71,
    title: "The Core Components of Apache Kafka Explained",
    excerpt: "A simple guide to the key components of Apache Kafka. Learn what Brokers, Topics, Partitions, Offsets, Producers, Consumers, and KRaft do.",
    category: "Kafka & Distributed Systems",
    date: "June 20, 2026",
    readTime: "4 min read",
    url: "posts/kafka-core-components.html",
    image: "images/kafka_components.png"
  },
  {
    id: 70,
    title: "Apache Kafka vs. RabbitMQ: Understanding the Differences",
    excerpt: "A simple, layman-friendly comparison of Apache Kafka vs. RabbitMQ. Learn when to use a distributed commit log vs. a traditional message queue.",
    category: "Kafka & Distributed Systems",
    date: "June 20, 2026",
    readTime: "4 min read",
    url: "posts/kafka-vs-rabbitmq-message-queues.html",
    image: "images/kafka_vs_mq.png"
  },
  {
    id: 69,
    title: "Understanding Kafka Topics and Partitioning Mechanics",
    excerpt: "Learn how Apache Kafka organizes messages using Topics and Partitions. Discover how message key routing and ordering work inside partitions simply.",
    category: "Kafka & Distributed Systems",
    date: "June 20, 2026",
    readTime: "4 min read",
    url: "posts/kafka-topics-partitions-explained.html",
    image: "images/kafka_partitions.png"
  },
  {
    id: 68,
    title: "What is an Offset in Kafka and How is it Managed?",
    excerpt: "Learn what Kafka offsets are and how to manage them. Discover auto-commit vs. manual commitSync and commitAsync methods simply.",
    category: "Kafka & Distributed Systems",
    date: "June 20, 2026",
    readTime: "4 min read",
    url: "posts/kafka-offsets-management.html",
    image: "images/kafka_offsets.png"
  },
  {
    id: 67,
    title: "How to Choose the Right Number of Partitions in Kafka",
    excerpt: "Struggling to decide how many partitions to assign to a Kafka Topic? Learn the formulas, sizing trade-offs, and scaling rules simply.",
    category: "Kafka & Distributed Systems",
    date: "June 20, 2026",
    readTime: "4 min read",
    url: "posts/kafka-choosing-partition-count.html",
    image: "images/kafka_partition_scaling.png"
  },
  {
    id: 66,
    title: "Inside the Kafka Producer: Architecture and Internal Flow",
    excerpt: "Explore the internal workings of the Kafka Producer. Learn how serialization, partitioning, batching, and record accumulators function simply.",
    category: "Kafka & Distributed Systems",
    date: "June 20, 2026",
    readTime: "5 min read",
    url: "posts/kafka-producer-internal-architecture.html",
    image: "images/kafka_producer_flow.png"
  },
  {
    id: 65,
    title: "Understanding Kafka Producer ACKs Settings and Trade-offs",
    excerpt: "A guide to Kafka acks configuration (0, 1, all). Learn the trade-offs between durability and throughput, and how to avoid data loss.",
    category: "Kafka & Distributed Systems",
    date: "June 20, 2026",
    readTime: "4 min read",
    url: "posts/kafka-producer-acks-settings.html",
    image: "images/kafka_acks.png"
  },
  {
    id: 64,
    title: "What is an Idempotent Producer in Kafka?",
    excerpt: "Learn how the Kafka Idempotent Producer prevents message duplication during retries. Discover how to configure Exactly-Once Semantics (EOS).",
    category: "Kafka & Distributed Systems",
    date: "June 20, 2026",
    readTime: "4 min read",
    url: "posts/kafka-idempotent-producer-exactly-once.html",
    image: "images/kafka_exactly_once.png"
  },
  {
    id: 63,
    title: "How Kafka Consumers and Consumer Groups Work",
    excerpt: "A beginner-friendly guide to Kafka Consumers and Consumer Groups. Learn how Kafka balances partitions among consumers and scale reading throughput.",
    category: "Kafka & Distributed Systems",
    date: "June 20, 2026",
    readTime: "4 min read",
    url: "posts/kafka-consumer-groups-basics.html",
    image: "images/kafka_consumer_groups.png"
  },
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

