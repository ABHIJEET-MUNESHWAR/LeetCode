package com.leetcode.companies.microsoft;

import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    16/07/24,
 * Time:    7:17 am
 */
public class Concatenate {
    public static void main(String[] args) {
        Concatenate concatenate = new Concatenate();
        String[] A = {"co", "dil", "ity"};
        System.out.println(concatenate.concatenate(A));
    }

    private int concatenate(String[] a) {
        int n = a.length;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String s = a[i];
            int m = s.length();
            boolean areUniqueChars = areUniqueChars(s);
            boolean isFound = false;
            if (areUniqueChars) {
                for (int j = 0; j < m; j++) {
                    char c = s.charAt(j);
                    if (set.contains(c)) {
                        isFound = true;
                        break;
                    }
                }
                if (!isFound) {
                    for (int j = 0; j < m; j++) {
                        char c = s.charAt(j);
                        set.add(c);
                    }
                }
            }
        }
        return set.size();
    }

    private boolean areUniqueChars(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }
}