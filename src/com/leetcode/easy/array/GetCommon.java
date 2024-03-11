package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    09/03/24,
 * Time:    8:30 am
 * https://leetcode.com/problems/minimum-common-value/?envType=daily-question&envId=2024-03-09
 */
public class GetCommon {
  public static void main(String[] args) {
    GetCommon getCommon = new GetCommon();
    int[] num1 = {1, 2, 3, 6};
    int[] num2 = {2, 3, 4, 5};
    System.out.println(getCommon.getCommon(num1, num2));
  }

  private int getCommon(int[] num1, int[] num2) {
    int size1 = num1.length;
    int size2 = num2.length;
    int i = 0, j = 0;
    while (i < size1 && j < size2) {
      if (num1[i] < num2[j]) {
        i++;
      } else if (num1[i] > num2[j]) {
        j++;
      } else {
        return num1[i];
      }
    }
    return -1;
  }
}