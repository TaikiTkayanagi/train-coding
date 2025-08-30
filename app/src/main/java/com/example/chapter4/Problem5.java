package com.example.chapter4;

public class Problem5 {
    private static class Node {
        private int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(20);
        Node node2 = new Node(10);
        Node node3 = new Node(30);
        Node node4 = new Node(25);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;

        // TODO: 上記ノードがBTSかどうかの判定を行うようにする
    }

}
