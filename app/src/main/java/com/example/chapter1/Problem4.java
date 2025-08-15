package com.example.chapter1;

public class Problem4 {
    public static void main(String[] args) {
        String input = "TactCoa".toLowerCase();

        int memo = 0;
        for (char c : input.toCharArray()) {
            int shift = c - 'a';
            int bit = 1 << shift;
            if ((memo & bit) == 0) {
                memo |= bit;
            } else {
                memo &= ~bit;
            }
        }
        if (((memo - 1) & memo) > 0) {
            System.out.println(false);
        } else {
            System.out.println(true);
        }
    }
}
