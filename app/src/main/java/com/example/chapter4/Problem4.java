package com.example.chapter4;

public class Problem4 {
    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class Result {
        private int count;
        private Boolean isBalanceTree;

    }

    public static void main(String[] args) {
        var node1 = new Node(1);
        var node2 = new Node(2);
        var node3 = new Node(3);
        var node4 = new Node(4);
        var node5 = new Node(5);
        var node6 = new Node(6);
        node1.left = node2;
        node1.right = node3;
        node3.right = node4;
        node4.left = node5;
        node4.right = node6;

        var r = isResult(node1, 0);
        System.out.println("isBalanceTree: " + r.isBalanceTree);
    }

    private static Result isResult(Node node, int count) {
        if (node == null) {
            var r = new Result();
            r.count = count - 1;
            r.isBalanceTree = null;
            return r;
        }

        var leftResult = isResult(node.left, count + 1);
        var rightResult = isResult(node.right, count + 1);

        if (leftResult.isBalanceTree != null && !leftResult.isBalanceTree) {
            return leftResult;
        }
        if (rightResult.isBalanceTree != null && !rightResult.isBalanceTree) {
            return rightResult;
        }

        if (leftResult.count >= rightResult.count && leftResult.count - rightResult.count <= 1) {
            leftResult.isBalanceTree = true;
            return leftResult;
        } else if (rightResult.count > leftResult.count && rightResult.count - leftResult.count <= 1) {
            rightResult.isBalanceTree = true;
            return rightResult;
        } else {
            leftResult.isBalanceTree = false;
            return leftResult;
        }
    }
}
