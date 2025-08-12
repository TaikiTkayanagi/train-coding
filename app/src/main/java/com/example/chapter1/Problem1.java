package com.example.chapter1;

import java.util.HashSet;

import com.example.util.StringUtil;

public class Problem1 {
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
    }
}
