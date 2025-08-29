package com.example.chapter4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

public class Problem3 {
    private static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

    }

    public static void main(String[] args) {
        var node = new Node(4);
        node.left = new Node(2);
        node.left.left = new Node(1);
        node.left.right = new Node(3);
        node.right = new Node(6);
        node.right.left = new Node(5);
        node.right.right = new Node(7);

        var queue1 = new ArrayDeque<Node>();
        var queue2 = new ArrayDeque<Node>();
        queue1.add(node);

        var result = new ArrayList<LinkedList<Node>>();
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            var linkedList = new LinkedList<Node>();
            if (!queue1.isEmpty()) {
                while (!queue1.isEmpty()) {
                    var peek = queue1.poll();
                    linkedList.add(peek);
                    if (peek.left != null) {
                        queue2.addLast(peek.left);
                    }
                    if (peek.right != null) {
                        queue2.addLast(peek.right);
                    }
                }
            } else {
                while (!queue2.isEmpty()) {
                    var peek = queue2.poll();
                    if (peek == null) {
                        continue;
                    }
                    linkedList.add(peek);
                    if (peek.left != null) {
                        queue1.addLast(peek.left);
                    }
                    if (peek.right != null) {
                        queue1.addLast(peek.right);
                    }
                }
            }
            result.add(linkedList);
        }

        for (int i = 0; i < result.size(); i++) {
            var linkedList = result.get(i);
            for (Node value : linkedList) {
                System.out.print(value.value);
            }
            System.out.println();
        }
    }
}
