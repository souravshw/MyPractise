package io.practise.accolite;

import java.util.Stack;

public class ParenthesisChecker {

    public static void main(String[] args) {

        String paranthesisPattern = "[()()]{}(){}";

        Stack<Character> stack = new Stack<>();

        char arr[] = paranthesisPattern.toCharArray();

        for (int i = 0; i < arr.length; ++i) {
            char ch = arr[i];

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')') {

                Character tempCh = stack.peek();

                if (tempCh != '(') {
                    break;
                } else {
                    stack.pop();
                }
            } else if (ch == '}') {

                Character tempCh = stack.peek();

                if (tempCh != '{') {
                    break;
                } else {
                    stack.pop();
                }
            } else if (ch == ']') {
                Character tempCh = stack.peek();

                if (tempCh != '[') {
                    break;
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.size() == 0) {
            System.out.println("Well formed paranthesis");
        } else {
            int output = arr.length - stack.size();
            System.out.println("parenthesis not correct it's correct for upto these characters: " + output);
        }

    }
}
