package com.example.chapter2;

import com.example.util.MySinglyLinkedList;
import com.example.util.SinglyNode;

public class Problem5 {
    public static void main(String[] args) {
        var list1 = new MySinglyLinkedList<Integer>();
        var list2 = new MySinglyLinkedList<Integer>();
        Integer[] array1 = { 7, 1, 6 };
        Integer[] array2 = { 5, 9, 2 };
        list1.add(array1);
        list2.add(array2);

        var actual = list1.calculate(list2);
        actual.show();

        var actual2 = recursiveCalculate(list1.getFirst(), list2.getFirst());
        actual2.show();
    }

    public static MySinglyLinkedList<Integer> recursiveCalculate(SinglyNode<Integer> node1, SinglyNode<Integer> node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        var afterSameLength = sameLength(node1, node2);
        var result = recursiveCalculteHelper(afterSameLength[0], afterSameLength[1]);
        if (result[0].getValue() != 0) {
            var before = new SinglyNode<>(result[0].getValue());
            before.setNext(result[1]);
            result[1] = before;
        }
        var list = new MySinglyLinkedList<Integer>();
        list.setFirst(result[1]);

        return list;
    }

    public static SinglyNode<Integer>[] recursiveCalculteHelper(SinglyNode<Integer> node1, SinglyNode<Integer> node2) {
        if (node1 == null && node2 == null) {
            var finish = new SinglyNode[2];
            finish[0] = new SinglyNode<Integer>(0);
            finish[1] = null;
            return finish;
        }

        var next1 = node1 == null ? null : node1.getNext();
        var next2 = node2 == null ? null : node2.getNext();

        var previousResult = recursiveCalculteHelper(next1, next2);
        int total = previousResult[0].getValue();
        SinglyNode<Integer> previousNode = previousResult[1];
        if (node1 != null) {
            total += node1.getValue();
        }
        if (node2 != null) {
            total += node2.getValue();
        }

        int carryUp = 0;
        if (previousNode == null) {
            carryUp = total / 10;
            total %= 10;
            previousNode = new SinglyNode<Integer>(total);
        } else {
            carryUp = total / 10;
            total %= 10;
            var before = new SinglyNode<Integer>(total);
            before.setNext(previousNode);
            previousNode = before;
        }
        var r = new SinglyNode[2];
        r[0] = new SinglyNode<>(carryUp);
        r[1] = previousNode;
        return r;
    }

    public static SinglyNode<Integer>[] sameLength(SinglyNode<Integer> node1, SinglyNode<Integer> node2) {
        int length1 = 0;
        int length2 = 0;

        var iterator = node1;
        while (iterator != null) {
            length1++;
            iterator = iterator.getNext();
        }

        iterator = node2;
        while (iterator != null) {
            length2++;
            iterator = iterator.getNext();
        }

        if (length1 > length2) {
            iterator = node1;
            for (int i = 0; i < length1 - length2; i++) {
                var before = new SinglyNode<>(0);
                before.setNext(iterator);
                iterator = before;
            }
            var result = new SinglyNode[2];
            result[0] = iterator;
            result[1] = node2;
            return result;
        } else if (length2 > length1) {
            iterator = node2;
            for (int i = 0; i < length2 - length1; i++) {
                var before = new SinglyNode<>(0);
                before.setNext(iterator);
                iterator = before;
            }
            var result = new SinglyNode[2];
            result[0] = node1;
            result[1] = iterator;
            return result;
        } else {
            var result = new SinglyNode[2];
            result[0] = node1;
            result[1] = node2;
            return result;
        }
    }
}
