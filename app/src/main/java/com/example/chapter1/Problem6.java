package com.example.chapter1;

public class Problem6 {
    public static void main(String[] args) {
        String input = "aabcccccaaa";
        // String input = "ab";
        System.out.println("input: " + input);
        int compressCount = compressCount(input);
        if (compressCount > input.length()) {
            System.out.println(input);
            return;
        }
        var result = compress(input, new StringBuilder(compressCount));
        System.out.println(result);
    }

    private static int compressCount(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            var c = input.charAt(i);
            if (i + 1 >= input.length() || c != input.charAt(i + 1)) {
                count += 2;
            }
        }
        return count;
    }

    private static String compress(String input, StringBuilder sb) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            count++;
            var c = input.charAt(i);
            if (i + 1 >= input.length() || c != input.charAt(i + 1)) {
                sb.append(c);
                sb.append(count);
                count = 0;
            }
        }

        return sb.toString();
    }

}
