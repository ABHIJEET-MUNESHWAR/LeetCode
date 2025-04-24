package com.leetcode.companies.meta.practice.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    20/03/23, Time:    7:03 pm
 * https://leetcode.com/problems/can-place-flowers/
 * 605. Can Place Flowers
 */
public class CanPlaceFlowers {

    public static void main(String[] args) {
        CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();
        int[] flowerbed = new int[]{0, 0, 1, 0, 0};
        int n = 2;
        System.out.println(canPlaceFlowers.canPlaceFlowers(flowerbed, n));
    }

    private boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        if (n == 0) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 0) {
                boolean isLeftEmpty = (i == 0) || (flowerbed[i - 1] == 0);
                boolean isRightEmpty = (i == length - 1) || (flowerbed[i + 1] == 0);
                if (isLeftEmpty && isRightEmpty) {
                    flowerbed[i] = 1;
                    n--;
                    if (n == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}