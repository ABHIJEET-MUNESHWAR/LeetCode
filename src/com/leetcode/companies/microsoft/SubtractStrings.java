package com.leetcode.companies.microsoft;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    16/07/24,
 * Time:    7:54 am
 */
public class SubtractStrings {

    public static String subtract(String num1, String num2) {
        // Ensure num1 is greater than or equal to num2
        if (num1.length() < num2.length() || (num1.length() == num2.length() && num1.compareTo(num2) < 0)) {
            return "-" + subtract(num2, num1);
        }

        StringBuilder result = new StringBuilder();
        int borrow = 0;

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0) {
            int digit1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j) - '0' : 0;

            int diff = digit1 - digit2 - borrow;

            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            result.append(diff);
            i--;
            j--;
        }

        // Remove leading zeros
        while (result.length() > 1 && result.charAt(result.length() - 1) == '0') {
            result.deleteCharAt(result.length() - 1);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String num2 = "1234";
        String num1 = "987";

        String difference = subtract(num1, num2);
        System.out.println("Difference: " + difference);
    }
}