package com.example.chapter4;

import java.util.ArrayList;

public class Problem1 {
    private static class Node {
        private int value;
        private ArrayList<Node> go;
        private boolean isVisited;

        public Node(int value) {
            this.value = value;
            this.go = new ArrayList<>();
            this.isVisited = false;
        }

        public void connect(Node node) {
            go.add(node);
        }

        public boolean canGoTo(Node node) {
            return canGoToHelper(this, node);
        }

        private boolean canGoToHelper(Node current, Node compare) {
            if (current.isVisited) {
                return false;
            }
            current.isVisited = true;
            for (var next : current.go) {
                var result = canGoToHelper(next, compare);
                if (result) {
                    return result;
                }
            }
            return current == compare;
        }
    }

    public static void main(String[] args) {
        var node1 = new Node(1);
        var node2 = new Node(2);
        var node3 = new Node(3);
        var node4 = new Node(4);
        var node5 = new Node(5);
        var node6 = new Node(6);

        node1.connect(node2);
        node2.connect(node3);
        node2.connect(node4);
        node4.connect(node1);
        node3.connect(node5);

        System.out.println("Node1 to Node5 is " + node1.canGoTo(node5));
        System.out.println("Node1 to Node6 is " + node1.canGoTo(node6));
    }
}
