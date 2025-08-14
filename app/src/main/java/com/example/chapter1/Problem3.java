package com.example.chapter1;

public class Problem3 {
    public static void main(String[] args) {
        char[] input = "Mr Jhon Smith    ".toCharArray();
        int length = 13;
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (input[i] == ' ')
                spaceCount++;
        }

        int newLength = length + spaceCount * 2;
        for (int i = length - 1; i >= 0; i--) {
            if (input[i] == ' ') {
                input[newLength - 1] = '0';
                input[newLength - 2] = '2';
                input[newLength - 3] = '%';
                newLength -= 3;
            } else {
                input[newLength - 1] = input[i];
                newLength--;
            }
        }

        for (var v : input) {
            System.out.print(v);
        }
    }
}
