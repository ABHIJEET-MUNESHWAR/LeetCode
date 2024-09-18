package com.leetcode.medium.simulation;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    23/08/24,
 * Time:    9:18 am
 * 592. Fraction Addition and Subtraction
 * https://leetcode.com/problems/fraction-addition-and-subtraction/description/
 */
public class FractionAdditionSubtraction {
    public static void main(String[] args) {
        FractionAdditionSubtraction fractionAdditionSubtraction = new FractionAdditionSubtraction();
        String expression = "-1/2+1/2";
        System.out.println(fractionAdditionSubtraction.fractionAddition(expression));
    }

    private String fractionAddition(String expression) {
        int numerator = 0;
        int denominator = 1;
        int n = expression.length();
        int i = 0;
        while (i < n) {
            int currentNumerator = 0;
            int currentDenominator = 0;
            boolean isNegative = (expression.charAt(i) == '-');
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+') {
                i++;
            }
            // Build current numerator
            while (i < n && Character.isDigit(expression.charAt(i))) {
                int value = expression.charAt(i) - '0';
                currentNumerator = (currentNumerator * 10) + value;
                i++;
            }
            i++; // Skip divisor character
            if (isNegative) {
                currentNumerator = currentNumerator * -1;
            }
            // Build current denominator
            while (i < n && Character.isDigit(expression.charAt(i))) {
                int value = expression.charAt(i) - '0';
                currentDenominator = (currentDenominator * 10) + value;
                i++;
            }
            numerator = numerator * currentDenominator + denominator * currentNumerator;
            denominator = denominator * currentDenominator;
        }
        int gcd = findGCD(Math.abs(numerator), denominator);
        numerator /= gcd;
        denominator /= gcd;
        return numerator + "/" + denominator;
    }

    private int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }
}