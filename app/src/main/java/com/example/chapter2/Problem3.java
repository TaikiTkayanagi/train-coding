package com.example.chapter2;

import com.example.util.MySinglyLinkedList;

public class Problem3 {
    public static void main(String[] args) {
        var list = new MySinglyLinkedList<Integer>();
        Integer[] array = { 1, 2, 3, 4, 5 };
        list.add(array);
        list.show();
        var node = list.getFromLast(2);
        if (node != null && node.getNext() != null) {
            var next = node.getNext();
            node.setValue(next.getValue());
            node.setNext(next.getNext());
        }
        list.show();
    }
}
