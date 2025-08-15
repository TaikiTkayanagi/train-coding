package com.example.chapter2;

import java.util.HashSet;
import java.util.LinkedList;

import com.example.util.LinkedListUtil;

public class Problem1 {
    private static LinkedList<Integer> checkByMap(LinkedList<Integer> list) {
        var memo = new HashSet<Integer>();
        int index = 0;
        while (index < list.size()) {
            if (!memo.add(list.get(index))) {
                list.remove(index);
                index--;
            }
            index++;
        }
        return list;
    }

    private static LinkedList<Integer> checkByPointer(LinkedList<Integer> list) {
        int left = 0;
        int right = 1;
        while (left < list.size() - 1) {
            var l = list.get(left);
            var r = list.get(right);
            if (l.equals(r)) {
                list.remove(right);
                right--;
            }
            right++;
            if (right >= list.size()) {
                left++;
                right = left + 1;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = LinkedListUtil.generateRandomIntegerList(10);
        LinkedListUtil.show(list);
        LinkedListUtil.show(checkByMap((LinkedList<Integer>) list.clone()));
        LinkedListUtil.show(checkByPointer((LinkedList<Integer>) list.clone()));
    }
}
