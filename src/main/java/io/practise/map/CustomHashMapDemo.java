package io.practise.map;

public class CustomHashMapDemo {
    public static void main(String[] args) {
        // Instantiate CustomHashMap with initial capacity of 4 to trigger collisions and resizing quickly
        System.out.println("=== Initializing CustomHashMap (Capacity: 4, Load Factor: 0.75) ===");
        CustomHashMap<String, Integer> myMap = new CustomHashMap<>(4);

        // 1. Basic put operations and null key mapping
        System.out.println("\n--- Step 1: Adding basic elements and Null Key ---");
        myMap.put("A", 100); // hash('A') = 65 % 4 = 1
        myMap.put(null, 500); // hash(null) = 0
        myMap.printMapState();

        // 2. Demonstrate Collision Chaining
        // Let's add keys that will end up in the same bucket.
        // 'A' (hashCode 65 -> index 1)
        // 'E' (hashCode 69 -> index 1) -> Collision!
        // 'I' (hashCode 73 -> index 1) -> Collision!
        System.out.println("\n--- Step 2: Triggering Collision Chaining (Keys: A, E, I all hash to index 1) ---");
        myMap.put("E", 200); 
        myMap.put("I", 300); 
        myMap.printMapState();

        // 3. Retrieve values (Get) demonstrating chain traversal
        System.out.println("\n--- Step 3: Getting values (traverse chains) ---");
        myMap.get("A");
        myMap.get("I");
        myMap.get(null);
        myMap.get("Z"); // Not existing

        // 4. Overwriting keys
        System.out.println("\n--- Step 4: Overwriting existing keys ---");
        myMap.put("E", 250); // Updates "E" from 200 to 250
        myMap.printMapState();

        // 5. Dynamic Resizing and Rehashing
        // Current size: 5 (A, E, I, B, null)
        // Load threshold: 4 * 0.75 = 3
        // Adding the 4th non-null element or exceeding the threshold will trigger resizing.
        // Let's put a new key "B" (hashCode 66 -> index 2) to trigger resize.
        System.out.println("\n--- Step 5: Adding 'B' to trigger Resize/Rehash (size exceeds threshold) ---");
        myMap.put("B", 400); 
        myMap.printMapState();

        // Verify retrieval works after rehashing
        System.out.println("\n--- Step 6: Verify retrieval after rehashing ---");
        myMap.get("A");
        myMap.get("E");
        myMap.get("I");
        myMap.get("B");
        myMap.get(null);

        // 6. Delete entries (Remove) from chain
        System.out.println("\n--- Step 7: Removing entries (head, middle, non-existing) ---");
        myMap.remove("E"); // Remove middle of chain (if colliding in index 1 under new capacity)
        myMap.remove(null); // Remove index 0
        myMap.remove("NonExistent");
        myMap.printMapState();
    }
}
