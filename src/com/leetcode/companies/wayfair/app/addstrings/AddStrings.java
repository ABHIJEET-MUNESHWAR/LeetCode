package com.leetcode.companies.wayfair.app.addstrings;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   21-03-2025
    Time:   08:04 pm
    https://leetcode.com/problems/add-strings/description/
    415. Add Strings
*/

public class AddStrings {
    public static void main(String[] args) {
        AddStrings addStrings = new AddStrings();
        String num1 = "456";
        String num2 = "77";
        System.out.println(addStrings.addStrings(num1, num2));
        num1 = "1,234";
        num2 = "2,345";
        System.out.println(addStrings.addStringsWithComma(num1, num2));
        System.out.println(addStrings.fibonacci(20));
    }

    private String fibonacci(int n) {
        if (n == 0) {
            return "0";
        }
        if (n == 1) {
            return "1";
        }
        String a = "0";
        String b = "1";
        for (int i = 2; i <= n; i++) {
            String c = addStringsWithComma(a, b);
            a = b;
            b = c;
        }
        return b;
    }

    private String addStringsWithComma(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = m - 1, j = n - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
            // ✅ Ignore commas while processing digits
            if (i >= 0 && num1.charAt(i) == ',') {
                i--;
            }
            if (j >= 0 && num2.charAt(j) == ',') {
                j--;
            }
            // Validation
            if (i >= 0 && !Character.isDigit(num1.charAt(i))) {
                throw new IllegalArgumentException("Invalid character in input: " + num1.charAt(i));
            }
            if (j >= 0 && !Character.isDigit(num2.charAt(j))) {
                throw new IllegalArgumentException("Invalid character in input: " + num2.charAt(j));
            }
            int a = i < 0 ? 0 : num1.charAt(i) - '0';
            int b = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = a + b + carry;
            sb.append(sum % 10);
            carry = sum / 10;

            if (sb.length() % 3 == 0 && (i >= 0 || j >= 0 || carry > 0)) {
                sb.append(",");
            }
        }
        return sb.reverse().toString();
    }

    private String addStrings(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = m - 1, j = n - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
            int a = i < 0 ? 0 : num1.charAt(i) - '0';
            int b = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = a + b + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }
}
