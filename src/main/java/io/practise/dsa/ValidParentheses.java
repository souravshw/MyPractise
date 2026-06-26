package io.practise.dsa;

import java.util.Stack;

public class ValidParentheses {

    // Stack - O(n)
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses solver = new ValidParentheses();
        String paren = "()[]{}";

        System.out.println("--- Valid Parentheses Demonstration ---");
        System.out.printf("Input: %s, Is Valid: %b\n", paren, solver.isValid(paren));
    }
}
