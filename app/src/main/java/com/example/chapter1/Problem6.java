package com.example.chapter1;

public class Problem6 {
    public static void main(String[] args) {
        String input = "aabcccccaaa";
        // String input = "ab";
        System.out.println("input: " + input);

        var sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int iterator = i + 1;
            var character = input.charAt(i);
            if (iterator >= input.length()) {
                sb.append(character + "1");
                break;
            }
            var nextCharacter = input.charAt(iterator);
            while (character == nextCharacter && iterator < input.length()) {
                iterator++;
                if (iterator >= input.length()) {
                    break;
                }
                nextCharacter = input.charAt(iterator);
            }
            sb.append(character);
            sb.append(iterator - i);
            i = iterator - 1;
        }

        var compress = sb.toString();
        System.out.println("compress: " + compress);
        System.out.println(compress.length() > input.length() ? compress : input);
    }
}
