package io.practise.accolite;

public class PermutationOfString {

    /**
     * Prints all permutations of a given string.
     *
     * @param str the string to permute
     */
    public static void printPermutations(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        permute(str.toCharArray(), 0);
    }

    /**
     * A recursive helper function to generate and print permutations.
     *
     * @param chars The character array representing the string.
     * @param currentIndex The current index to start swapping from.
     */
    private static void permute(char[] chars, int currentIndex) {
        // Base case: If we've reached the end of the string, we have a complete permutation.
        if (currentIndex == chars.length - 1) {
            System.out.println(new String(chars));
            return;
        }

        // Recursive step:
        // For each character from the current index to the end...
        for (int i = currentIndex; i < chars.length; i++) {
            // 1. Swap the character at the current index with the character at index 'i'.
            swap(chars, currentIndex, i);

            // 2. Recurse for the rest of the string (from the next index).
            permute(chars, currentIndex + 1);

            // 3. Backtrack: Swap the characters back to their original positions.
            // This is crucial to explore all other possibilities correctly.
            swap(chars, currentIndex, i);
        }
    }

    /**
     * Swaps two characters in a character array.
     *
     * @param chars The character array.
     * @param i The index of the first character.
     * @param j The index of the second character.
     */
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        String input = "ABC";
        System.out.println("Permutations for \"" + input + "\":");
        printPermutations(input);

        System.out.println("\nPermutations for \"GOD\":");
        printPermutations("GOD");
    }
}
