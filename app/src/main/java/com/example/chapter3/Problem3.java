package com.example.chapter3;

import java.util.Stack;

public class Problem3 {
    private static class SetOfStack {
        private int currentIndex;
        private int capacity;
        private Stack<Integer>[] list;

        public SetOfStack(int capacity) {
            if (capacity <= 0) {
                capacity = 1;
            }
            this.currentIndex = 0;
            this.capacity = capacity;
            list = new Stack[10];
        }

        public void push(int value) {
            if (list[currentIndex] == null) {
                list[currentIndex] = new Stack<>();
            }
            if (list[currentIndex].size() >= capacity) {
                currentIndex++;
                if (currentIndex >= list.length) {
                    extend();
                }
                list[currentIndex] = new Stack<>();
            }
            list[currentIndex].push(value);
        }

        public Integer peek() {
            if (list[currentIndex] == null) {
                return null;
            }
            return list[currentIndex].peek();
        }

        public Integer pop() {
            if (list[currentIndex] == null) {
                return null;
            }
            if (list[currentIndex].size() == 0 && currentIndex == 0) {
                return null;
            }
            if (list[currentIndex].size() == 0) {
                currentIndex--;
            }
            return list[currentIndex].pop();
        }

        public Integer popAt(int index) {
            if (index < list.length && list[index] == null) {
                return null;
            }
            if (list[index].empty()) {
                return null;
            }
            var result = list[index].pop();
            while (index + 1 < list.length && list[index + 1] != null) {
                index++;
                var stack = list[index];
                if (stack.isEmpty()) {
                    break;
                }
                var last = stack.getFirst();
                stack.remove(0);
                list[index - 1].push(last);
            }
            return result;
        }

        private void extend() {
            var result = new Stack[list.length + list.length];
            for (int i = 0; i < list.length; i++) {
                result[i] = list[i];
            }
            list = result;
        }
    }

    public static void main(String[] args) {
        var stack1 = new SetOfStack(3);
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        stack1.push(6);

        System.out.println("stack1 is pop " + stack1.pop());
        System.out.println("stack1 is pop " + stack1.pop());
        System.out.println("stack1 is peek " + stack1.peek());

        stack1.push(5);
        stack1.push(6);

        System.out.println("stack1 is pop " + stack1.popAt(0));
        System.out.println("stack1 is pop " + stack1.pop());
        System.out.println("stack1 is pop " + stack1.pop());
        System.out.println("stack1 is pop " + stack1.pop());
        System.out.println("stack1 is pop " + stack1.popAt(1));
        System.out.println("stack1 is pop " + stack1.pop());
        System.out.println("stack1 is pop " + stack1.pop());
        System.out.println("stack1 is pop " + stack1.pop());
        System.out.println("stack1 is pop " + stack1.pop());
        System.out.println("stack1 is pop " + stack1.pop());
    }
}
