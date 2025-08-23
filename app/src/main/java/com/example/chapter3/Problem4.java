package com.example.chapter3;

import java.util.Stack;

public class Problem4 {
    private static class MyQueue {
        private Stack<Integer> newStack;
        private Stack<Integer> oldStack;

        public MyQueue() {
            this.newStack = new Stack<>();
            this.oldStack = new Stack<>();
        }

        public void add(int value) {
            newStack.push(value);
        }

        public Integer remove() {
            if (newStack.isEmpty() && oldStack.isEmpty()) {
                return null;
            }
            if (!oldStack.isEmpty()) {
                return oldStack.pop();
            }
            while (!newStack.isEmpty()) {
                oldStack.push(newStack.pop());
            }
            return oldStack.pop();
        }

        public Integer peek() {
            if (newStack.isEmpty() && oldStack.isEmpty()) {
                return null;
            }
            if (!oldStack.isEmpty()) {
                return oldStack.peek();
            }
            while (!newStack.isEmpty()) {
                oldStack.push(newStack.pop());
            }
            return oldStack.peek();
        }
    }

    public static void main(String[] args) {
        var queue = new MyQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println("queue is remove: " + queue.remove());
        System.out.println("queue is peek: " + queue.peek());

        System.out.println("queue is remove: " + queue.remove());
        System.out.println("queue is peek: " + queue.peek());

        System.out.println("queue is remove: " + queue.remove());
        System.out.println("queue is peek: " + queue.peek());

        System.out.println("queue is remove: " + queue.remove());
        System.out.println("queue is peek: " + queue.peek());
    }
}
