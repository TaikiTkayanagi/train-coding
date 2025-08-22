package com.example.chapter2;

import com.example.util.MySinglyLinkedList;
import com.example.util.SinglyNode;

public class Program8 {
    public static void main(String[] args) {
        var list1 = new MySinglyLinkedList<Integer>();
        var list2 = new MySinglyLinkedList<Integer>();
        Integer[] array = { 1, 2, 3, 4 };
        var last = list1.add(array);
        list2.add(array);
        var iterator = last;
        for (int i = 5; i < 10; i++) {
            var node = new SinglyNode<>(i);
            iterator.setNext(node);
            iterator = node;
        }
        iterator.setNext(last);

        var ans = findCirculationStartNode(list1);
        var ans2 = findCirculationStartNode(list2);
        System.out.println(ans != null ? ans.getValue().toString() : "違う");
        System.out.println(ans2 != null ? ans2.getValue().toString() : "違う");
    }

    public static SinglyNode<Integer> findCirculationStartNode(MySinglyLinkedList<Integer> list) {
        var isCirculation = isCirculation(list);
        if (isCirculation == null) {
            return null;
        }
        var head = list.getFirst();
        while (head != isCirculation) {
            head = head.getNext();
            isCirculation = isCirculation.getNext();
        }
        return head;
    }

    public static SinglyNode<Integer> isCirculation(MySinglyLinkedList<Integer> list) {
        if (list.getFirst() == null) {
            return null;
        }

        var slow = list.getFirst();
        var fast = list.getFirst();
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                return fast;
            }

        }
        return null;
    }
}
