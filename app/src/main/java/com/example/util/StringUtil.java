package com.example.util;

import java.util.HashSet;
import java.util.Random;

public class StringUtil {
    public static String generateRandomString(int length) {
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }

    public static String randomSort(String str) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(str.length());
        var memo = new HashSet<Integer>();
        for (int i = 0; i < str.length(); i++) {
            int index = random.nextInt(str.length());
            while (!memo.add(index)) {
                if (index + 1 >= str.length()) {
                    index = -1;
                }
                index++;
            }
            sb.append(str.charAt(index));
        }
        return sb.toString();
    }

    public static String maybeRemoveRandomChar(String str) {
        var random = new Random();
        var index = random.nextInt(str.length() * 2);
        if (index < str.length()) {
            return str.substring(0, index) + str.substring(index + 1);
        }
        return str;
    }
}
