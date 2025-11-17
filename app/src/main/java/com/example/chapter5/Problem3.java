package com.example.chapter5;

import java.util.Scanner;

public class Problem3 {
    private static int getBit(int a, int i) {
        return a & (1 << i);
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int a = Integer.valueOf(sc.nextLine());
        int length = Integer.toBinaryString(a).toString().length();

        int ans = 0;
        int previousCount = 0;
        int count = 0;
        for (int i = 0; i < length; i++) {
            var bit = getBit(a, i);
            count++;
            if (bit == 0) {
                count -= previousCount;
                previousCount = count;
            }
            ans = count > ans ? count : ans;
        }

        System.out.println(ans);
        sc.close();
    }
}
