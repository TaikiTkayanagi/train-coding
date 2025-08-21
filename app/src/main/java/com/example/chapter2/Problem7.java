package com.example.chapter2;

import java.util.Stack;

import com.example.util.MySinglyLinkedList;
import com.example.util.SinglyNode;

public class Problem7 {
    private static class RecursiveResult {
        public Boolean isEqual;
        public Stack<SinglyNode<Integer>> stack = new Stack<>();
    }

    public static void main(String[] args) {
        Integer[] array1 = { 1, 2, 3, 4, 5 };
        Integer[] array2 = { 1, 2, 3, 4, 5, 6, 7 };
        var list1 = new MySinglyLinkedList<Integer>();
        var last1 = list1.add(array1);
        var list2 = new MySinglyLinkedList<Integer>();
        var last2 = list2.add(array2);

        for (int i = 6; i < 10; i++) {
            var node = new SinglyNode<Integer>(i);
            last1.setNext(node);
            last2.setNext(node);
            last1 = node;
            last2 = node;
        }

        int list1Length = length(list1);
        int list2Length = length(list2);

        if (list1Length > list2Length) {
            padLeft(list1Length - list2Length, list2);
        } else if (list2Length > list1Length) {
            padLeft(list2Length - list1Length, list1);
        }
        var r = recursiveCompare(list1.getFirst(), list2.getFirst());
        while (!r.stack.isEmpty()) {
            System.out.println(r.stack.pop().getValue() + " ");
        }
    }

    private static RecursiveResult recursiveCompare(SinglyNode<Integer> node1, SinglyNode<Integer> node2) {
        if (node1 == null && node2 == null) {
            return new RecursiveResult();
        }

        var result = recursiveCompare(node1.getNext(), node2.getNext());

        if (result.isEqual != null && !result.isEqual) {
            return result;
        }
        result.isEqual = node1.equals(node2);
        if (result.isEqual) {
            result.stack.add(node1);
        }
        return result;
    }

    private static int length(MySinglyLinkedList<Integer> list) {
        var iterator = list.getFirst();
        int count = 0;
        while (iterator != null) {
            iterator = iterator.getNext();
            count++;
        }
        return count;
    }

    private static void padLeft(int count, MySinglyLinkedList<Integer> list) {
        var first = list.getFirst();
        while (count > 0) {
            var node = new SinglyNode<Integer>(0);
            node.setNext(first);
            first = node;
            count--;
        }
        list.setFirst(first);
    }
}
