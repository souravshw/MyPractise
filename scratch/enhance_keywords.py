import os
import re

def clean_keyword(kw):
    return kw.strip().lower()

def main():
    base_dir = r"docs\posts"
    
    # Common stop words to exclude when parsing title
    stop_words = {"in", "and", "a", "or", "to", "the", "how", "why", "of", "for", "with", "on", "at", "by", "an", "is", "are", "from"}

    # Keyword pools for high relevance
    kafka_base = ["apache kafka", "event streaming", "message broker", "distributed systems", "real-time data pipelines", "kafka tutorial", "event-driven architecture", "backend engineering", "system design", "software architecture"]
    java_base = ["java programming", "java tutorial", "backend development", "clean code java", "java developer", "software engineering", "coding tutorial"]
    algo_base = ["algorithm design", "data structures", "coding interview preparation", "leetcode solution", "hackerrank challenge", "java algorithms", "problem solving", "programming puzzle", "time complexity optimization"]

    modified_count = 0

    for file in os.listdir(base_dir):
        if not file.endswith(".html"):
            continue
        
        file_path = os.path.join(base_dir, file)
        
        with open(file_path, "r", encoding="utf-8") as f:
            content = f.read()

        # Find existing keywords
        kw_regex = re.compile(r'<meta\s+name="keywords"\s+content="([^"]*)"\s*/?>', re.IGNORECASE)
        kw_match = kw_regex.search(content)
        
        if not kw_match:
            # If no keywords tag is found, skip or we could inject one, but all posts have them.
            continue
            
        existing_kw_str = kw_match.group(1)
        existing_kws = [clean_keyword(k) for k in existing_kw_str.split(",") if k.strip()]
        
        # Determine category and load relevant pool
        fn_lower = file.lower()
        content_lower = content.lower()
        
        relevant_pool = []
        
        # 1. Identify Topic Area
        is_kafka = "kafka" in fn_lower or "kafka" in content_lower
        is_java = "java" in fn_lower or "class" in content_lower or "interface" in content_lower or "thread" in content_lower
        is_algo = "leetcode" in fn_lower or "hackerrank" in fn_lower or "algorithm" in fn_lower or "sort" in fn_lower or "search" in fn_lower or "array" in fn_lower or "list" in fn_lower

        if is_kafka:
            relevant_pool.extend(kafka_base)
            # Context-specific Kafka additions
            if "acks" in fn_lower or "producer" in fn_lower:
                relevant_pool.extend(["kafka producer", "message delivery guarantees", "idempotent producer", "acks settings"])
            if "consumer" in fn_lower or "group" in fn_lower or "rebalanc" in fn_lower:
                relevant_pool.extend(["kafka consumer", "consumer group", "partition rebalancing", "kafka consumer lag", "offset management"])
            if "stream" in fn_lower:
                relevant_pool.extend(["kafka streams", "state store", "kstream ktable", "stream processing"])
            if "connect" in fn_lower:
                relevant_pool.extend(["kafka connect", "source connector", "sink connector", "data ingestion"])
            if "kraft" in fn_lower or "zookeeper" in fn_lower:
                relevant_pool.extend(["kafka kraft mode", "zookeeper replacement", "metadata replication"])
            if "schema" in fn_lower or "registry" in fn_lower:
                relevant_pool.extend(["schema registry", "avro serialization", "schema evolution"])
            if "dlq" in fn_lower or "dead-letter" in fn_lower:
                relevant_pool.extend(["dead letter queue", "kafka dlq pattern", "error handling kafka"])
            if "zero-loss" in fn_lower or "durability" in fn_lower:
                relevant_pool.extend(["zero data loss", "kafka durability", "min insync replicas"])
        elif is_java:
            relevant_pool.extend(java_base)
            # Context-specific Java additions
            if "completablefuture" in fn_lower or "thread" in fn_lower or "concurrency" in fn_lower or "forkjoin" in fn_lower or "executor" in fn_lower or "synchronized" in fn_lower:
                relevant_pool.extend(["java concurrency", "multithreading java", "asynchronous programming", "thread pool java", "java parallel processing"])
            if "enum" in fn_lower:
                relevant_pool.extend(["java enums", "advanced java enums", "oop design patterns"])
            if "generics" in fn_lower or "wildcard" in fn_lower:
                relevant_pool.extend(["java generics", "bounded types java", "type safety java"])
            if "annotation" in fn_lower:
                relevant_pool.extend(["custom annotations java", "java reflection", "meta-programming"])
            if "nio" in fn_lower or "file" in fn_lower or "io" in fn_lower:
                relevant_pool.extend(["java nio", "file manipulation java", "java io streams", "java 8 streams"])
            if "exception" in fn_lower or "catch" in fn_lower or "throw" in fn_lower:
                relevant_pool.extend(["java exceptions", "exception handling java", "method overriding exceptions"])
        elif is_algo:
            relevant_pool.extend(algo_base)
            # Context-specific Algorithm additions
            if "list" in fn_lower or "linkedlist" in fn_lower:
                relevant_pool.extend(["linked list java", "linked list loop detection", "reversing linked list"])
            if "sort" in fn_lower:
                relevant_pool.extend(["sorting algorithms java", "java streams sorting", "array sorting java"])
            if "array" in fn_lower or "matrix" in fn_lower or "flat" in fn_lower:
                relevant_pool.extend(["array manipulation java", "matrix flattening", "subarray algorithms"])
            if "thread" in fn_lower:
                relevant_pool.extend(["multithreading algorithms", "producer consumer pattern java", "thread coordination"])

        # Extract title words for title-based high-relevance search phrases
        title_regex = re.compile(r'<title>(.*?)</title>', re.IGNORECASE)
        title_match = title_regex.search(content)
        title_phrases = []
        if title_match:
            title_text = title_match.group(1).split("|")[0].strip() # get the main title part
            words = [re.sub(r'[^a-zA-Z0-9]', '', w).lower() for w in title_text.split() if w.strip()]
            words = [w for w in words if w and w not in stop_words]
            
            # Generate short phrases combining title keywords
            if len(words) >= 2:
                title_phrases.append(f"{words[0]} {words[1]}")
            if len(words) >= 3:
                title_phrases.append(f"{words[1]} {words[2]}")
            for w in words[:4]:
                if is_java:
                    title_phrases.append(f"{w} java")
                elif is_kafka:
                    title_phrases.append(f"{w} kafka")
                else:
                    title_phrases.append(f"{w} algorithm")

        # Build list of candidates
        candidates = existing_kws.copy()
        
        # Add title phrases first (very high relevance)
        for tp in title_phrases:
            cleaned = clean_keyword(tp)
            if cleaned not in candidates:
                candidates.append(cleaned)
                
        # Add topic-specific pool candidates
        for rp in relevant_pool:
            cleaned = clean_keyword(rp)
            if cleaned not in candidates:
                candidates.append(cleaned)

        # Fallback general terms if still under 12
        general_fallbacks = ["software engineering notes", "developer tutorial", "programming concepts", "backend developer guide", "coding logic", "web developer learning"]
        for gf in general_fallbacks:
            if len(candidates) >= 12:
                break
            cleaned = clean_keyword(gf)
            if cleaned not in candidates:
                candidates.append(cleaned)

        # Slice to minimum of 12 or keep all if it grew larger
        final_kws = candidates
        
        # Ensure we meet the 12 keyword minimum
        if len(final_kws) < 12:
            print(f"Warning: {file} has only {len(final_kws)} keywords after processing.")
        
        new_kw_str = ", ".join(final_kws)
        
        # Replace the keywords tag in file
        new_tag = f'<meta name="keywords" content="{new_kw_str}">'
        new_content = kw_regex.sub(new_tag, content, count=1)
        
        if new_content != content:
            with open(file_path, "w", encoding="utf-8") as f:
                f.write(new_content)
            modified_count += 1
            print(f"Updated keywords ({len(final_kws)}) in: {file}")
            
    print(f"\nDone. Updated keywords in {modified_count} files.")

if __name__ == "__main__":
    main()
