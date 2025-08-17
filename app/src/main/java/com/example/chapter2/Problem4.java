package com.example.chapter2;

import com.example.util.MySinglyLinkedList;

public class Problem4 {
    public static void main(String[] args) {
        Integer[] array = { 3, 5, 8, 5, 10, 2, 1 };
        var list = new MySinglyLinkedList<Integer>();
        list.add(array);

        list.sortBy(5);

        list.show();
    }
}
