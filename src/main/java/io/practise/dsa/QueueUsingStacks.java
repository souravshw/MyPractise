package io.practise.dsa;

import java.util.Stack;

public class QueueUsingStacks {

    public static class MyQueue {
        private Stack<Integer> in = new Stack<>();
        private Stack<Integer> out = new Stack<>();

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            peek();
            return out.pop();
        }

        public int peek() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.peek();
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        System.out.println("--- Implement Queue using Stacks Demonstration ---");
        queue.push(1);
        queue.push(2);
        System.out.println("Peek: " + queue.peek()); // 1
        System.out.println("Pop: " + queue.pop());   // 1
        System.out.println("Empty: " + queue.empty()); // false
    }
}
