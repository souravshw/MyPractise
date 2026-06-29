package io.practise.map;

public class CustomHashMap<K, V> {
    
    // Internal node structure for collision handling using chaining
    static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    private Node<K, V>[] table;
    private int capacity;
    private final float loadFactor = 0.75f;
    private int size;

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        this.capacity = DEFAULT_INITIAL_CAPACITY;
        this.table = (Node<K, V>[]) new Node[capacity];
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    public CustomHashMap(int initialCapacity) {
        this.capacity = initialCapacity;
        this.table = (Node<K, V>[]) new Node[capacity];
        this.size = 0;
    }

    /**
     * Hash function that maps a key to a bucket index.
     * Null keys are always mapped to index 0.
     */
    private int hash(K key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode() % capacity);
    }

    /**
     * Inserts or updates a key-value pair.
     * Triggers dynamic resizing (rehashing) if load factor threshold is crossed.
     */
    public V put(K key, V value) {
        // Check load factor and resize if needed
        if ((float) (size + 1) / capacity > loadFactor) {
            System.out.println("\n[Resize Trigger] Size (" + (size + 1) + ") exceeds load factor threshold (" + (capacity * loadFactor) + "). Initiating resize...");
            resize();
        }

        int index = hash(key);
        Node<K, V> head = table[index];

        if (head == null) {
            // No collision, directly insert at the bucket index
            table[index] = new Node<>(key, value, null);
            size++;
            System.out.println("[Put] Added new key-value pair: " + key + "=" + value + " at bucket index [" + index + "]. No collision.");
            return null;
        }

        // Collision occurred, traverse the chained linked list at the bucket index
        Node<K, V> curr = head;
        while (curr != null) {
            if (isKeyEqual(curr.key, key)) {
                // Key matches, overwrite and return old value
                V oldValue = curr.value;
                curr.value = value;
                System.out.println("[Put] Key '" + key + "' already exists. Overwriting value at bucket index [" + index + "]: Old Value = " + oldValue + ", New Value = " + value);
                return oldValue;
            }
            if (curr.next == null) {
                break;
            }
            curr = curr.next;
        }

        // Key not found in the chain, append to the end of the chain (chaining)
        curr.next = new Node<>(key, value, null);
        size++;
        System.out.println("[Put] Collision detected at bucket index [" + index + "]! Chained new key-value pair: " + key + "=" + value + " after current chain.");
        return null;
    }

    /**
     * Retrieves the value associated with the specified key.
     */
    public V get(K key) {
        int index = hash(key);
        Node<K, V> curr = table[index];

        System.out.print("[Get] Searching for key '" + key + "' in bucket [" + index + "]: ");
        int depth = 0;
        while (curr != null) {
            depth++;
            if (isKeyEqual(curr.key, key)) {
                System.out.println("FOUND at chain depth " + depth + ". Value = " + curr.value);
                return curr.value;
            }
            curr = curr.next;
        }
        System.out.println("NOT FOUND.");
        return null;
    }

    /**
     * Removes the entry for a key if it is present in the map.
     */
    public V remove(K key) {
        int index = hash(key);
        Node<K, V> curr = table[index];
        Node<K, V> prev = null;

        System.out.print("[Remove] Attempting to remove key '" + key + "' from bucket [" + index + "]: ");
        while (curr != null) {
            if (isKeyEqual(curr.key, key)) {
                V value = curr.value;
                if (prev == null) {
                    // Removing head of the chain
                    table[index] = curr.next;
                } else {
                    // Unlinking current node from the chain
                    prev.next = curr.next;
                }
                size--;
                System.out.println("REMOVED successfully. Returned value = " + value);
                return value;
            }
            prev = curr;
            curr = curr.next;
        }
        System.out.println("NOT FOUND. Nothing to remove.");
        return null;
    }

    /**
     * Returns the number of key-value pairs stored in the map.
     */
    public int size() {
        return size;
    }

    /**
     * Doubles capacity of the table array and rehashes all elements.
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        int oldCapacity = capacity;
        Node<K, V>[] oldTable = table;

        capacity = oldCapacity * 2;
        table = (Node<K, V>[]) new Node[capacity];
        size = 0; // Reset size since put() will recalculate size for rehashed entries

        System.out.println("   --> Rehashing: Resizing bucket array capacity from " + oldCapacity + " to " + capacity);

        for (int i = 0; i < oldCapacity; i++) {
            Node<K, V> curr = oldTable[i];
            if (curr != null) {
                System.out.print("   --> Moving bucket index [" + i + "] chain: ");
                while (curr != null) {
                    System.out.print("(" + curr.key + "=" + curr.value + ") ");
                    // Re-insert into the new larger table
                    put(curr.key, curr.value);
                    curr = curr.next;
                }
                System.out.println();
            }
        }
        System.out.println("[Resize Complete] Rehashing done. New capacity is " + capacity + ", Current Size is " + size + "\n");
    }

    /**
     * Utility method to compare keys, accounting for null.
     */
    private boolean isKeyEqual(K k1, K k2) {
        if (k1 == null) {
            return k2 == null;
        }
        return k1.equals(k2);
    }

    /**
     * Displays the current map state (buckets and chains).
     */
    public void printMapState() {
        System.out.println("\n--- Current CustomHashMap State (Capacity: " + capacity + ", Size: " + size + ") ---");
        for (int i = 0; i < capacity; i++) {
            Node<K, V> curr = table[i];
            if (curr != null) {
                System.out.print("Bucket [" + i + "]: ");
                while (curr != null) {
                    System.out.print("[" + curr.key + " -> " + curr.value + "]");
                    if (curr.next != null) {
                        System.out.print(" -> ");
                    }
                    curr = curr.next;
                }
                System.out.println();
            }
        }
        System.out.println("------------------------------------------------------------------------\n");
    }
}
