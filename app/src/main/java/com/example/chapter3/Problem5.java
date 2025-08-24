package com.example.chapter3;

import java.util.Stack;

public class Problem5 {
    private static class CustomStack {
        private Stack<Integer> stack;

        public CustomStack() {
            this.stack = new Stack<>();
        }

        public void push(int value) {
            stack.push(value);
        }

        public Integer pop() {
            return stack.pop();
        }

        public void sort() {
            var result = new Stack<Integer>();
            while (!stack.isEmpty()) {
                var pop = stack.pop();

                while (!result.isEmpty()) {
                    if (pop > result.peek()) {
                        stack.push(result.pop());
                    } else {
                        break;
                    }
                }
                result.push(pop);
            }
            stack = result;
        }
    }

    public static void main(String[] args) {
        var stack = new CustomStack();

        stack.push(2);
        stack.push(10);
        stack.push(1);
        stack.push(3);
        stack.push(5);

        stack.sort();

        System.out.println("stack is pop " + stack.pop());
        System.out.println("stack is pop " + stack.pop());
        System.out.println("stack is pop " + stack.pop());
        System.out.println("stack is pop " + stack.pop());
        System.out.println("stack is pop " + stack.pop());
    }
}
