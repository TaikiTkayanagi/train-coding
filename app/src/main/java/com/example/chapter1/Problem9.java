package com.example.chapter1;

import java.util.ArrayList;

public class Problem9 {
    private static boolean isSubstring(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0 || s1.length() < s2.length()) {
            return false;
        }
        var firstCharacter = s2.charAt(0);
        ArrayList<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            var index = s1.indexOf(firstCharacter, i);
            if (index == -1) {
                break;
            }
            indexList.add(index);
            i = index;
        }
        for (int i = 0; i < indexList.size(); i++) {
            boolean isRoll = false;
            boolean isSubstring = true;
            int s1Index = indexList.get(i);
            for (int j = 0; j < s2.length(); j++) {
                if (s1Index >= s1.length()) {
                    isRoll = true;
                    s1Index = 0;
                }
                if (s1.charAt(s1Index) != s2.charAt(j)) {
                    isSubstring = false;
                    break;
                }
                s1Index++;
            }
            if (isRoll && isSubstring) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "ewaterbottl";
        // String s2 = "erbottlewat";
        System.out.println(isSubstring(s1, s2));
    }
}
