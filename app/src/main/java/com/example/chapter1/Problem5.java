package com.example.chapter1;

import java.util.HashMap;

public class Problem5 {
    public static void main(String args[]) {
        String[][] input = { { "pale", "ple" }, { "pales", "pale" }, { "pale", "bale" }, { "pale", "bake" } };

        for (var array : input) {
            String from = array[0];
            String to = array[1];
            if (to.length() + 1 == from.length()) {
                var memo = createMemo(to);
                var result = replaceMemo(memo, from);
                showResult(result);
            } else if (to.length() == from.length() + 1) {
                var memo = createMemo(from);
                var result = replaceMemo(memo, to);
                showResult(result);
            } else if (to.length() == from.length()) {
                var memo = createMemo(from);
                var result = replaceMemo(memo, to);
                var count = 0;
                for (var value : result.values()) {
                    count += value;
                }
                if (count == 1) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static HashMap<Character, Integer> createMemo(String s) {
        var memo = new HashMap<Character, Integer>();
        for (var c : s.toCharArray()) {
            if (memo.containsKey(c)) {
                memo.replace(c, memo.get(c) + 1);
            } else {
                memo.put(c, 1);
            }
        }

        return memo;
    }

    private static HashMap<Character, Integer> replaceMemo(HashMap<Character, Integer> memo, String s) {
        for (var c : s.toCharArray()) {
            if (memo.containsKey(c)) {
                memo.replace(c, memo.get(c) - 1);
            }
        }
        return memo;
    }

    private static void showResult(HashMap<Character, Integer> result) {
        for (var value : result.values()) {
            if (value != 0) {
                System.out.println("NO");
            }
        }
        System.out.println("YES");
    }
}
