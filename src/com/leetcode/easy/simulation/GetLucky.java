package com.leetcode.easy.simulation;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    03/09/24,
 * Time:    7:12 pm
 * 1945. Sum of Digits of String After Convert
 * https://leetcode.com/problems/sum-of-digits-of-string-after-convert/description
 */
public class GetLucky {
    public static void main(String[] args) {
        GetLucky getLucky = new GetLucky();
        String s = "iiii";
        int k = 1;
        System.out.println(getLucky.getLucky(s, k));
    }

    private int getLucky(String s, int k) {
        StringBuilder number = new StringBuilder();
        int n = s.length();
        for (char ch : s.toCharArray()) {
            number.append(ch - 'a' + 1);
        }
        int sum = 0;
        while (k-- > 0) {
            sum = 0;
            for (char ch : number.toString().toCharArray()) {
                sum += ch - '0';
            }
            number = new StringBuilder(Integer.toString(sum));
        }
        return Integer.parseInt(number.toString());
    }
}