package com.example.util;

public class MySinglyLinkedList<T extends Comparable<? super T>> {
    private SinglyNode<T> first;

    public SinglyNode<T> getFirst() {
        return first;
    }

    public void setFirst(SinglyNode<T> node) {
        this.first = node;
    }

    public SinglyNode<T> add(T[] array) {
        if (array.length == 0) {
            return null;
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
        return iterator;
    }

    public MySinglyLinkedList<Integer> calculate(MySinglyLinkedList<Integer> other) {
        var result = new MySinglyLinkedList<Integer>();
        SinglyNode<Integer> resultIterator = null;
        var iterator = first;
        var otherNode = other.first;
        int carryUp = 0;
        while (iterator != null || otherNode != null || carryUp != 0) {
            int x = 0;
            int y = 0;
            if (iterator != null) {
                x = (int) iterator.getValue();
                iterator = iterator.getNext();
            }
            if (otherNode != null) {
                y = otherNode.getValue();
                otherNode = otherNode.getNext();
            }
            int total = x + y + carryUp;
            if (total >= 10) {
                carryUp = total / 10;
                total %= 10;
            } else {
                carryUp = 0;
            }
            if (resultIterator == null) {
                resultIterator = new SinglyNode<Integer>(total);
            } else {
                var before = new SinglyNode<Integer>(total);
                before.setNext(resultIterator);
                resultIterator = before;
            }
        }
        result.first = resultIterator;
        return result;
    }

    public void sortBy(T pivot) {
        var itgerator = first;
        while (itgerator != null) {
            if (itgerator.getValue().compareTo(pivot) < 0) {
                itgerator = itgerator.getNext();
                continue;
            }
            var next = itgerator.getNext();
            while (next != null) {
                if (next.getValue().compareTo(pivot) >= 0) {
                    next = next.getNext();
                    continue;
                }
                var tmp = itgerator.getValue();
                itgerator.setValue(next.getValue());
                next.setValue(tmp);
                break;
            }
            if (next == null) {
                break;
            }
            itgerator = itgerator.getNext();
        }
    }

    public SinglyNode<T> getFromLast(int index) {
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
        return iterator;
    }

    public void show() {
        var iterator = first;
        while (iterator != null && iterator.getValue() != null) {
            System.out.print(iterator.getValue() + "→");
            iterator = iterator.getNext();
        }
        System.out.println();
    }
}
