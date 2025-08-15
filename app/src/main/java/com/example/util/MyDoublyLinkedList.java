package com.example.util;

public class MyDoublyLinkedList<T> {
    private DoublyNode<T> first;
    private DoublyNode<T> last;

    public void add(DoublyNode<T> node) {
        if (first == null) {
            this.first = node;
            this.last = node;
            return;
        }
        var previousLast = last;
        previousLast.setNext(last);

        last = node;
        last.setPrevious(previousLast);
    }

    public void add(T[] array) {
        if (array.length == 0) {
            return;
        }
        if (first == null) {
            first = new DoublyNode<T>(array[0]);
            var iterator = first;
            for (int i = 1; i < array.length; i++) {
                var node = new DoublyNode<T>(array[i]);
                iterator.setNext(node);
                node.setPrevious(iterator);
                iterator = node;
            }
            last = iterator;
        }
    }

    public T getFromLast(int i) throws Exception {
        if (i < 0) {
            throw new Exception("ダメです");
        }
        if (first == null) {
            return null;
        }
        int count = 0;
        var iterator = last;
        while (count != i) {
            if (iterator.getPrevious() == null) {
                return null;
            }
            iterator = iterator.getPrevious();
            count++;
        }
        return iterator.getValue();
    }
}
