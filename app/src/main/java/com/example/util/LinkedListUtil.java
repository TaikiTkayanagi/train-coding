package com.example.util;

import java.util.LinkedList;
import java.util.Random;

public class LinkedListUtil {
    public static LinkedList<Integer> generateRandomIntegerList(int length) {
        var random = new Random();
        var result = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            result.add(random.nextInt(10));
        }
        return result;
    }

    public static void show(LinkedList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i + 1 != list.size()) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
