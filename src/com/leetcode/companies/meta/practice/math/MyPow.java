package com.leetcode.companies.meta.practice.math;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   16-04-2025
    Time:   05:42 pm
    50. Pow(x, n)
    https://leetcode.com/problems/powx-n/description/
*/

public class MyPow {
    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        double x = 2.00000;
        int n = 10;
        System.out.println(myPow.myPow(x, n)); // 1024.00000
    }

    public double solve(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return solve(1 / x, -n);
        }
        if (n % 2 == 0) {
            return solve(x * x, n / 2);
        }
        return x * solve(x * x, (n - 1) / 2);
    }

    public double myPow(double x, int n) {
        return solve(x, (long) n);
    }
}
