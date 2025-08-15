package com.example.util;

public class MySinglyLinkedList<T> {
    private SinglyNode<T> first;

    public void add(T[] array) {
        if (array.length == 0) {
            return;
        }
        if (first == null) {
            first = new SinglyNode<T>(array[0]);
        }
        var iterator = first;
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
        }
        for (int i = 1; i < array.length; i++) {
            var node = new SinglyNode<T>(array[i]);
            iterator.setNext(node);
            iterator = node;
        }
    }

    public T getFromLast(int index) {
        if (index < 0 || first == null) {
            return null;
        }
        int length = 0;
        var iterator = first;
        while (iterator != null) {
            length++;
            iterator = iterator.getNext();
        }
        if (length < index) {
            return null;
        }
        var target = length - index;
        int count = 0;
        iterator = first;
        while (count != target) {
            count++;
            iterator = iterator.getNext();
        }
        return iterator.getValue();
    }
}
