package com.example.chapter2;

import com.example.util.MySinglyLinkedList;

public class problem2 {
    public static void main(String[] args) throws Exception {
        var list = new MySinglyLinkedList<Integer>();
        Integer[] array = { 1, 2, 3, 4 };
        list.add(array);

        // TODO: 再帰を使った解放とポインターを2つ使った解放を試す
        System.out.println(list.getFromLast(1));
    }
}
