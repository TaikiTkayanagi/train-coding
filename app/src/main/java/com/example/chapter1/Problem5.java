package com.example.chapter1;

import java.util.HashMap;

public class Problem5 {
    public static void main(String args[]) {
        String[][] input = { { "ab", "b" }, { "pales", "pale" }, { "pale", "bale" }, { "pale", "bake" } };

        for (var array : input) {
            String from = array[0];
            String to = array[1];
            if (to.length() + 1 == from.length()) {
                var memo = createMemo(from);
                var result = replaceMemo(memo, from);
                showResult(result);
            } else if (to.length() == from.length() + 1) {
                var memo = createMemo(to);
                var result = replaceMemo(memo, to);
                showResult(result);
            } else if (to.length() == from.length()) {
                var isDiffOne = false;
                var isOutput = false;
                for (int i = 0; i < to.length(); i++) {
                    if (to.charAt(i) != from.charAt(i)) {
                        if (isDiffOne) {
                            System.out.println("NO");
                            isOutput = true;
                            break;
                        }
                        isDiffOne = true;
                    }
                }
                if (!isOutput) {
                    System.out.println("YES");
                }
            }
        }
    }

    private static HashMap<Character, Integer> createMemo(String s) {
        var memo = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            if (memo.containsKey(c)) {
                memo.replace(c, memo.get(c) + (i + 1));
            } else {
                memo.put(c, i + 1);
            }
        }

        return memo;
    }

    private static HashMap<Character, Integer> replaceMemo(HashMap<Character, Integer> memo, String s) {
        for (int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            memo.replace(c, memo.get(c) - (i + 1));
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
