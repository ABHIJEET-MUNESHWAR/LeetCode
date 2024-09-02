package com.leetcode.medium.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    02/09/24,
 * Time:    9:57 pm
 * 1894. Find the Student that Will Replace the Chalk
 * https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk/description/
 */
public class CalkReplacer {
    public static void main(String[] args) {
        CalkReplacer calkReplacer = new CalkReplacer();
        int[] chalk = {5, 1, 5};
        int k = 22;
        System.out.println(calkReplacer.calkReplacer(chalk, k));
    }

    private int calkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long totalChalkSum = 0;
        // Calculate the total sum of chalk required in one iteration
        for (int i = 0; i < n; i++) {
            totalChalkSum += chalk[i];
        }
        // Calculate the remaining chalk after full iterations
        int remainChalk = (int) (k % totalChalkSum);
        // Find the first student who cannot complete their required chalk usage
        for (int i = 0; i < n; i++) {
            if (remainChalk < chalk[i]) {
                return i;
            }
            remainChalk -= chalk[i];
        }
        return -1;// In theory, this line should never be reached
    }
}