package com.leetcode.medium.greedy;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    13/07/24,
 * Time:    1:25 pm
 * 991. Broken Calculator
 * https://leetcode.com/problems/broken-calculator/description/
 */
public class BrokenCalculator {
    public static void main(String[] args) {
        BrokenCalculator brokenCalculator = new BrokenCalculator();
        int startValue = 2, target = 3;
        System.out.println(brokenCalculator.brokenCalc(startValue, target));
    }

    private int brokenCalc(int startValue, int target) {
        if (startValue == target) {
            return 0;
        }
        if (startValue > target) {
            return startValue - target;
        }
        if (target % 2 == 0) {
            return 1 + brokenCalc(startValue, target / 2);
        }
        return 1 + brokenCalc(startValue, target + 1);
    }
}