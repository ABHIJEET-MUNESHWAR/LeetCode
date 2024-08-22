package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    22/08/24,
 * Time:    9:21 pm
 * 476. Number Complement
 * https://leetcode.com/problems/number-complement/description/
 */
public class NumberComplement {
    public static void main(String[] args) {
        NumberComplement numberComplement = new NumberComplement();
        int num = 5;
        System.out.println(numberComplement.numberComplementUsingXORInLoop(num));
        System.out.println(numberComplement.numberComplementUsingXOR(num));
    }

    private int numberComplementUsingXOR(int num) {
        int noOfBits = (int) (Math.log(num) / Math.log(2)) + 1;
        int mask = (1 << noOfBits) - 1;
        return (num ^ mask);
    }

    private int numberComplementUsingXORInLoop(int num) {
        int noOfBits = (int) (Math.log(num) / Math.log(2)) + 1;
        for (int i = 0; i < noOfBits; i++) {
            num = num ^ (1 << i);
        }
        return num;
    }
}