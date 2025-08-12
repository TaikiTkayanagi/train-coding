package com.example.chapter1;

public class Problem3 {
    public static void main(String[] args) {
        String input = "Mr Jhon Smith";
        int length = input.length();
        System.out.println("input: " + input);
        System.out.println("length: " + length);

        for (int i = 0; i < length; i++) {
            if (input.charAt(i) == ' ') {
                input = input.substring(0, i) + "%20" + input.substring(i + 1);
            }
        }
        System.out.println(input);
    }
}
