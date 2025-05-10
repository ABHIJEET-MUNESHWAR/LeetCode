package com.leetcode.medium.backtracking;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   09-05-2025
    Time:   11:13 am
    🟠 3343. Count Number of Balanced Permutations
    https://leetcode.com/problems/count-number-of-balanced-permutations/description/?envType=daily-question&envId=2025-05-09
*/

import java.util.ArrayList;
import java.util.List;

public class CountBalancedPermutations {
    public static void main(String[] args) {
        CountBalancedPermutations countBalancedPermutations = new CountBalancedPermutations();
        String                    num                       = "123";
        System.out.println(countBalancedPermutations.countBalancedPermutations(num));
    }

    public int countBalancedPermutations(String num) {
        List<String> permutations = permute(num);
        int          count        = 0;
        for (String permutation : permutations) {
            if (isBalanced(permutation)) {
                count++;
            }
        }
        return count;
    }

    private List<String> permute(String num) {
        List<String> result = new ArrayList<>();
        backtrack(num, "", result);
        return result;
    }

    private void backtrack(String num, String temp, List<String> result) {
        if (temp.length() == num.length()) {
            result.add(temp);
        } else {
            for (int i = 0; i < num.length(); i++) {
                if (temp.contains(String.valueOf(num.charAt(i)))) {
                    continue;
                }
                backtrack(num, temp + num.charAt(i), result);
            }
        }
    }

    private boolean isBalanced(String permutation) {
        int n         = permutation.length();
        int evenCount = 0;
        int oddCount  = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                evenCount += Character.getNumericValue(permutation.charAt(i));
            } else {
                oddCount += Character.getNumericValue(permutation.charAt(i));
            }
        }
        return evenCount == oddCount;
    }
}
