package com.example.chapter1;

import java.util.HashSet;

import com.example.util.StringUtil;

public class Problem1 {
    private static void otherAnswer(String input) {
        long flage = 0;
        for (var character : input.toCharArray()) {
            if (character >= 'a' && character <= 'z') {
                int shift = character - 'a';
                if ((flage & (1L << shift)) > 0) {
                    System.out.println("重複発見: " + character);
                    break;
                }
                flage |= (1L << shift);
            } else if (character >= 'A' && character <= 'Z') {
                int shift = (character - 'A') + 26;
                if ((flage & (1L << shift)) > 0) {
                    System.out.println("重複発見: " + character);
                    break;
                }
                flage |= (1L << shift);
            }
        }
    }

    public static void main(String[] args) {
        final int LENGTH = 10;
        var str = StringUtil.generateRandomString(LENGTH);
        System.out.println("str: " + str);

        var memo = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            var character = str.charAt(i);
            if (!memo.add(character)) {
                System.out.println("重複発見: " + character);
            }
        }

        otherAnswer(str);
    }
}
