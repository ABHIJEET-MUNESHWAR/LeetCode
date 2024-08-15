package com.leetcode.easy.greedy;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    15/08/24,
 * Time:    12:34 pm
 * 860. Lemonade Change
 * https://leetcode.com/problems/lemonade-change/description/
 */
public class LemonadeChange {
    public static void main(String[] args) {
        LemonadeChange lemonadeChange = new LemonadeChange();
        //int[] bills = {5, 5, 5, 10, 20};
        //int[] bills = {5, 5, 10, 10, 20};
        //int[] bills = {5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5};
        int[] bills = {5, 5, 5, 5, 20, 20, 5, 5, 20, 5};
        System.out.println(lemonadeChange.lemonadeChange(bills));
    }

    private boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int five = 0, ten = 0;
        for (int i = 0; i < n; i++) {
            int bill = bills[i];
            switch (bill) {
                case 5:
                    five++;
                    break;
                case 10:
                    if (five > 0) {
                        ten++;
                        five--;
                    } else {
                        return false;
                    }
                    break;
                case 20:
                    if (five > 0 && ten > 0) {
                        five--;
                        ten--;
                    } else if (five >= 3) {
                        five -= 3;
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}