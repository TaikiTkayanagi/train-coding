package com.example.chapter1;

import java.util.HashMap;

public class Problem4 {
    public static void main(String[] args) {
        String input = "Tact Coa".toLowerCase();
        String expected = "taco cat".toLowerCase();

        var memo = new HashMap<Character, Integer>();
        for (int i = 0; i < input.length(); i++) {
            var currentChar = input.charAt(i);
            if (memo.containsKey(currentChar)) {
                memo.replace(currentChar, memo.get(currentChar) + 1);
            } else {
                memo.put(currentChar, 1);
            }
        }

        for (var character : expected.toCharArray()) {
            memo.replace(character, memo.get(character) - 1);
        }

        for (var entrySet : memo.entrySet()) {
            if (entrySet.getValue() != 0) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
