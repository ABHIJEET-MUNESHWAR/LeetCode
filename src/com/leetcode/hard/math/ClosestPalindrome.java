package com.leetcode.hard.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    25/08/24,
 * Time:    10:53 am
 * 564. Find the Closest Palindrome
 * https://leetcode.com/problems/find-the-closest-palindrome/description/
 */
public class ClosestPalindrome {
    public static void main(String[] args) {
        ClosestPalindrome closestPalindrome = new ClosestPalindrome();
        String n = "123";
        System.out.println(closestPalindrome.nearestPalindromic(n));
    }

    private String nearestPalindromic(String n) {
        int size = n.length();
        int mid = size / 2;
        int firstHalfLength = size % 2 == 0 ? mid : mid + 1;
        long firstHalf = Long.parseLong(n.substring(0, firstHalfLength));
        /*
            Generate possible palindromic candidates:
            1. Palindrome by mirroring the first half.
            2. Palindrome by mirroring the first half + 1.
            3. Palindrome by mirroring the first half - 1.
            4. Handle edge cases by considering palindromes of the form 999...
               and 100...001

            I was not able to catch the 3rd and 4th edge case :-( . But it's ok , I got to learn something.
        */
        // Generate possible palindromic candidates
        List<Long> possibleResults = new ArrayList<>();
        possibleResults.add(halfToPalindrome(firstHalf, size % 2 == 0));
        possibleResults.add(halfToPalindrome(firstHalf + 1, size % 2 == 0));
        possibleResults.add(halfToPalindrome(firstHalf - 1, size % 2 == 0));
        possibleResults.add((long) Math.pow(10, size - 1) - 1); // Edge case like 999...
        possibleResults.add((long) Math.pow(10, size) + 1);     // Edge case like 100...001
        long diff = Long.MAX_VALUE;
        long result = Long.MAX_VALUE;
        long originalNumber = Long.parseLong(n);
        for (long num : possibleResults) {
            if (num == originalNumber) {
                continue;
            }
            long absDiff = Math.abs(num - originalNumber);
            if (diff > absDiff) {
                diff = absDiff;
                result = num;
            } else if (diff == absDiff) {
                result = Math.min(result, num);
            }
        }
        return String.valueOf(result);
    }

    // Helper function to create a palindrome by mirroring the first half
    private Long halfToPalindrome(long left, boolean isEven) {
        long resultNumber = left;
        if (!isEven) {
            left = left / 10;
        }
        // Mirroring the first half to form a palindrome
        while (left > 0) {
            int digit = (int) (left % 10);
            resultNumber = resultNumber * 10 + digit;
            left = left / 10;
        }
        return resultNumber;
    }
}