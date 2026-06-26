package io.practise.dsa;

import java.util.Stack;

public class EvaluateRPN {

    // Stack - O(n)
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+-*/".contains(token) && token.length() == 1) {
                int b = stack.pop(), a = stack.pop();
                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateRPN solver = new EvaluateRPN();
        String[] tokens = {"2", "1", "+", "3", "*"}; // (2+1)*3 = 9

        System.out.println("--- Evaluate Reverse Polish Notation Demonstration ---");
        System.out.println("Result: " + solver.evalRPN(tokens));
    }
}
