package com.example.chapter5;

import java.util.Scanner;

public class Problem1 {
    private static int clear(int i, int v) {
        return v & (~(1 << i));
    }

    private static int get(int i, int v) {
        return v & (1 << i);
    }

    private static int update(int i, int v, boolean isZero) {
        int u = isZero ? 0 : 1;
        return v | (u << i);
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var n = Integer.valueOf(sc.nextLine(), 2);
        var m = Integer.valueOf(sc.nextLine(), 2);
        var i = Integer.valueOf(sc.nextLine());
        var j = Integer.valueOf(sc.nextLine());

        int mIndex = 0;
        for (int k = i; k <= j; k++) {
            n = clear(k, n);
            int u = get(mIndex, m);
            mIndex++;
            n = update(k, n, u == 0);
            // System.out.println(Integer.toBinaryString(n));
        }

        System.out.println(Integer.toBinaryString(n));

        sc.close();
    }
}
