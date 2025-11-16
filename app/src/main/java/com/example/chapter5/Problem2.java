package com.example.chapter5;

import java.util.Scanner;

public class Problem2 {
    private static int update(int v, int i) {
        return v | 1 << i;
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var n = Double.valueOf(sc.nextLine());

        if (n == 1) {
            System.out.println(1);
        } else if (n == 0) {
            System.out.println(0);
        }

        var ans = 0;
        for (int i = 1; i <= 32; i++) {
            n *= 2;
            if (n >= 1) {
                ans = update(ans, 32 - i);
                if (n == 1) {
                    break;
                }
                n -= 1;
            }
        }

        if (ans == 0) {
            System.out.println("Error");
        } else {
            System.out.println("0." + String.format("%32s", Integer.toBinaryString(ans).toString()).replace(' ', '0'));
        }

        sc.close();
    }
}
