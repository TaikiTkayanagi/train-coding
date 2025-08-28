package com.example.chapter4;

import java.util.ArrayDeque;

public class Problem2 {
    private static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public void show() {
            var queue1 = new ArrayDeque<Node>();
            var queue2 = new ArrayDeque<Node>();
            queue1.add(this);
            while (!queue1.isEmpty() || !queue2.isEmpty()) {
                var sb = new StringBuilder();
                if (!queue1.isEmpty()) {
                    while (!queue1.isEmpty()) {
                        var node = queue1.poll();
                        sb.append(node.value);
                        sb.append(" ");
                        if (node.left != null) {
                            queue2.add(node.left);
                        }
                        if (node.right != null) {
                            queue2.add(node.right);
                        }
                    }
                } else {
                    while (!queue2.isEmpty()) {
                        var node = queue2.poll();
                        sb.append(node.value);
                        sb.append(" ");
                        if (node.left != null) {
                            queue1.add(node.left);
                        }
                        if (node.right != null) {
                            queue1.add(node.right);
                        }
                    }
                }
                System.out.println(sb.toString());
            }
        }
    }

    public static void main(String[] args) {
        int[] sortedArray = { 1, 3, 5, 7, 9, 10, 24, 34 };

        var node = createBinarySearchTree(0, sortedArray.length - 1, sortedArray);
        node.show();
    }

    private static Node createBinarySearchTree(int left, int right, int[] sortedArray) {
        if (left > right) {
            return null;
        }

        int mid = (int) Math.ceil((left + right) / 2.0);
        var node = new Node(sortedArray[mid]);
        var leftNode = createBinarySearchTree(left, mid - 1, sortedArray);
        var rightNode = createBinarySearchTree(mid + 1, right, sortedArray);

        if (leftNode != null) {
            node.left = leftNode;
        }
        if (rightNode != null) {
            node.right = rightNode;
        }
        return node;
    }
}
