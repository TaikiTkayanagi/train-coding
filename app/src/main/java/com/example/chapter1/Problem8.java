package com.example.chapter1;

import java.util.HashMap;
import java.util.HashSet;

public class Problem8 {
    public static void main(String[] args) {
        int[][] input = { { 1, 2, 3 }, { 4, 0, 6 }, { 7, 8, 9 }, { 1, 2, 0 } };
        for (var array : input) {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
                if (i + 1 != array.length) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();

        var memo = new HashMap<Integer, Integer>();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] == 0) {
                    memo.put(i, j);
                }
            }
        }

        var rowMemo = new HashSet<Integer>();
        var colMemo = new HashSet<Integer>();
        for (var entrySet : memo.entrySet()) {
            int row = entrySet.getKey();
            int col = entrySet.getValue();
            if (rowMemo.add(row)) {
                for (int i = 0; i < input.length; i++) {
                    input[i][col] = 0;
                }
            }
            if (colMemo.add(col)) {
                for (int j = 0; j < input[row].length; j++) {
                    input[row][j] = 0;
                }
            }

        }

        for (var array : input) {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
                if (i + 1 != array.length) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}
