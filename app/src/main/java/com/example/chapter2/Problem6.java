package com.example.chapter2;

import java.util.Stack;

import com.example.util.MySinglyLinkedList;
import com.example.util.SinglyNode;

public class Problem6 {
    private static class Inner {
        private Boolean isPalidrome;
        private SinglyNode<String> middlePoint;

        public void setIsPalidrome(boolean isPalidrome) {
            this.isPalidrome = isPalidrome;
        }

        public Boolean isPalidrome() {
            return isPalidrome;
        }

        public void setMiddlePoint(SinglyNode<String> middlePoint) {
            this.middlePoint = middlePoint;
        }

        public SinglyNode<String> getMiddlePoint() {
            return this.middlePoint;
        }
    }

    public static void main(String[] args) {
        var list = new MySinglyLinkedList<String>();
        String[] array = { "a", "c", "b", "c", "a" };
        list.add(array);
        checkPalindromeByReverse(list);
        checkPalidromeByStack(list);
        checkPalidromeByRecursive(list);
    }

    private static void checkPalidromeByRecursive(MySinglyLinkedList<String> list) {
        var r = isPalidrome(list.getFirst(), list.getFirst());

        System.out.println(r.isPalidrome ? "YES" : "NO");
    }

    private static Inner isPalidrome(SinglyNode<String> slow, SinglyNode<String> fast) {
        if (fast == null || fast.getNext() == null) {
            var inner = new Inner();
            if (fast == null) {
                inner.setMiddlePoint(slow);
            } else {
                inner.setMiddlePoint(slow.getNext());
            }
            return inner;
        }

        var result = isPalidrome(slow.getNext(), fast.getNext().getNext());
        if (result.isPalidrome() != null && !result.isPalidrome()) {
            return result;
        }
        result.setIsPalidrome(result.getMiddlePoint().getValue().equals(slow.getValue()));
        result.setMiddlePoint(result.getMiddlePoint().getNext());
        return result;
    }

    private static void checkPalidromeByStack(MySinglyLinkedList<String> list) {
        var stack = new Stack<String>();

        var iterator = list.getFirst();
        while (iterator != null) {
            stack.add(iterator.getValue());
            iterator = iterator.getNext();
        }

        iterator = list.getFirst();
        while (!stack.isEmpty() && iterator != null) {
            if (stack.pop() != iterator.getValue()) {
                System.out.println("NO");
                return;
            }
            iterator = iterator.getNext();
        }
        System.out.println("YES");
    }

    private static void checkPalindromeByReverse(MySinglyLinkedList<String> list) {
        var reverse = reverse(list);

        var iterator1 = list.getFirst();
        var iterator2 = reverse.getFirst();
        while (iterator1 != null && iterator2 != null) {
            if (iterator1.getValue() != iterator2.getValue()) {
                System.out.println("回文ではない");
                return;
            }
            iterator1 = iterator1.getNext();
            iterator2 = iterator2.getNext();
        }
        System.out.println("回文です");
    }

    private static MySinglyLinkedList<String> reverse(MySinglyLinkedList<String> list) {
        var reverseList = new MySinglyLinkedList<String>();
        SinglyNode<String> iterator = list.getFirst();
        SinglyNode<String> before = null;

        while (iterator != null) {
            if (before == null) {
                before = new SinglyNode<String>(iterator.getValue());
            } else {
                var tmp = new SinglyNode<>(iterator.getValue());
                tmp.setNext(before);
                before = tmp;
            }
            iterator = iterator.getNext();
        }

        reverseList.setFirst(before);
        return reverseList;
    }
}
