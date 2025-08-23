package com.example.chapter3;

import com.example.util.SinglyNode;

public class Problem2 {
    private static class Stack {
        private SinglyNode<Integer> head;
        private SinglyNode<Integer> minHead;

        public void push(int value) {
            if (head == null) {
                head = new SinglyNode<Integer>(value);
                minHead = new SinglyNode<Integer>(value);
                return;
            }

            var tmp = head;
            head = new SinglyNode<Integer>(value);
            head.setNext(tmp);

            if (minHead.getValue() >= value) {
                tmp = minHead;
                minHead = new SinglyNode<Integer>(value);
                minHead.setNext(tmp);
            }
        }

        public Integer pop() {
            if (head == null) {
                return null;
            }
            var result = head;
            head = head.getNext();
            if (minHead.getValue() == result.getValue()) {
                minHead = minHead.getNext();
            }
            return result.getValue();
        }

        public Integer peek() {
            if (head == null) {
                return null;
            }
            return head.getValue();
        }

        public Integer min() {
            if (minHead == null) {
                return null;
            }

            return minHead.getValue();
        }
    }

    public static void main(String[] args) {
        var stack = new Stack();
        stack.push(10);
        stack.push(3);
        stack.push(2);
        stack.push(2);
        stack.push(7);

        System.out.println("min " + stack.min());
        stack.pop();
        stack.pop();
        System.out.println("min " + stack.min());
        stack.pop();
        System.out.println("min " + stack.min());
    }
}
