package com.example.chapter1;

import java.util.HashMap;

import com.example.util.StringUtil;

public class Problem2 {
    public static void main(String[] args) {
        final int LENGTH = 5;
        var array1 = StringUtil.generateRandomString(LENGTH);
        var array2 = StringUtil.maybeRemoveRandomChar(StringUtil.randomSort(array1));
        System.out.println("array1: " + array1 + " " + "array2: " + array2);

        var memo = new HashMap<Character, Integer>();
        for (var value : array1.toCharArray()) {
            if (memo.containsKey(value)) {
                int count = memo.get(value);
                memo.replace(value, ++count);
            } else {
                memo.put(value, 1);
            }
        }

        for (var value : array2.toCharArray()) {
            if (memo.containsKey(value)) {
                int count = memo.get(value);
                memo.replace(value, --count);
            }
        }

        for (var entrySet : memo.entrySet()) {
            if (entrySet.getValue() > 0) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
