package com.example.chapter4;

import java.util.Objects;

public class Problem6 {
    private static class Node {
        private int value;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.left = node2;
        node2.parent = node1;
        node2.left = node3;
        node3.parent = node2;
        node1.right = node4;
        node4.parent = node1;
        node4.right = node5;
        node5.parent = node4;
        node2.right = node6;
        node6.parent = node2;

        var r = getNextNode(node1);
        System.out.println("getNextNode is " + (Objects.isNull(r) ? "Null" : r.value));
        r = getNextNode(node2);
        System.out.println("getNextNode is " + (Objects.isNull(r) ? "Null" : r.value));
        r = getNextNode(node3);
        System.out.println("getNextNode is " + (Objects.isNull(r) ? "Null" : r.value));
        r = getNextNode(node4);
        System.out.println("getNextNode is " + (Objects.isNull(r) ? "Null" : r.value));
        r = getNextNode(node5);
        System.out.println("getNextNode is " + (Objects.isNull(r) ? "Null" : r.value));
        r = getNextNode(node6);
        System.out.println("getNextNode is " + (Objects.isNull(r) ? "Null" : r.value));

    }

    public static Node getNextNode(Node node) {
        if (node.right != null) {
            var iterator = node.right;
            while (iterator.left != null) {
                iterator = iterator.left;
            }
            return iterator;
        } else {
            var iterator = node;
            while (iterator.parent != null) {
                if (iterator == iterator.parent.left) {
                    iterator = iterator.parent;
                    return iterator;
                }
                iterator = iterator.parent;
            }
            return null;
        }

    }
}
