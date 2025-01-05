package com.leetcode.medium.prefixsum;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   05-01-2025
    Time:   09:28 am
    848. Shifting Letters
    https://leetcode.com/problems/shifting-letters/description/
*/

public class ShiftingLetters {
    public static void main(String[] args) {
        ShiftingLetters shiftingLetters = new ShiftingLetters();
        String s = "xasy";
        int[] shifts = new int[]{622939912, 116899933, 983296461, 536563513};
        System.out.println(shiftingLetters.shiftingLetters(s, shifts));  // kdod
    }

    private String shiftingLetters(String s, int[] shifts) {
        long shift = 0;
        StringBuilder result = new StringBuilder(s);
        int n = shifts.length;
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            int charIntToBeShifted = ch - 'a';
            charIntToBeShifted += (shift + shifts[i]) % 26;
            charIntToBeShifted %= 26;
            ch = (char) (charIntToBeShifted + 'a');
            result.setCharAt(i, ch);
            shift += shifts[i];
        }
        return result.toString();
    }

}
