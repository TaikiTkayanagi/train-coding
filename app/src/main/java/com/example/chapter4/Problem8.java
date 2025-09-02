package com.example.chapter4;

import java.util.ArrayDeque;
import java.util.HashMap;

public class Problem8 {
    private static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        var node1 = new Node(1);
        var node2 = new Node(2);
        var node3 = new Node(3);
        var node4 = new Node(4);
        var node5 = new Node(5);
        var node6 = new Node(6);
        var node7 = new Node(7);
        var node8 = new Node(8);
        var node9 = new Node(9);
        var node10 = new Node(10);
        var node11 = new Node(11);
        var node12 = new Node(12);
        var node13 = new Node(13);
        var node14 = new Node(14);
        var node15 = new Node(15);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node6.left = node9;
        node6.right = node10;
        node7.left = node11;
        node7.right = node12;
        node8.left = node13;
        node10.right = node14;
        node14.right = node15;

        var nodeAndParent = new HashMap<Node, Node>();
        nodeAndParent.put(node1, new Node(Integer.MAX_VALUE));
        var queue = new ArrayDeque<Node>();
        queue.addLast(node1);
        while (!queue.isEmpty()) {
            var pop = queue.poll();
            if (pop.left != null) {
                nodeAndParent.put(pop.left, pop);
                queue.addLast(pop.left);
            }
            if (pop.right != null) {
                nodeAndParent.put(pop.right, pop);
                queue.addLast(pop.right);
            }
        }

        var ans = findAncestor(node15, node9, nodeAndParent);
        System.out.println("ans: " + ans.value);
    }

    private static Node findAncestor(Node node1, Node node2, HashMap<Node, Node> nodeAndParent) {
        var memo = new HashMap<Node, Boolean>();
        var iterator = nodeAndParent.get(node1);
        while (nodeAndParent.containsKey(iterator)) {
            memo.put(iterator, true);
            iterator = nodeAndParent.get(iterator);
        }

        iterator = nodeAndParent.get(node2);
        while (nodeAndParent.containsKey(iterator)) {
            if (memo.containsKey(iterator)) {
                return iterator;
            }
            iterator = nodeAndParent.get(iterator);
        }
        return null;
    }
}
