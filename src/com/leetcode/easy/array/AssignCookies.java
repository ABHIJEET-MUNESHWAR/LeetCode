package com.leetcode.easy.array;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    24/09/22, Time:    10:36 AM
 * https://leetcode.com/problems/assign-cookies/
 */
public class AssignCookies {

  public static void main(String[] args) {
    AssignCookies assignCookies = new AssignCookies();
    int[] childGreedArray = new int[]{10, 9, 8, 7};
    int[] cookieSizeArray = new int[]{5, 6, 7, 8};
    System.out.println(assignCookies.findContentChildren(childGreedArray, cookieSizeArray));
  }

  private int findContentChildren(int[] childGreedArray, int[] cookieSizeArray) {
    int contentChildrenCount = 0;
    int greedSize = childGreedArray.length;
    int cookieSize = cookieSizeArray.length;
    if (cookieSize == 0) {
      return contentChildrenCount;
    }
    int i = 0, j = 0;
    Arrays.sort(childGreedArray);
    Arrays.sort(cookieSizeArray);
    while (i < greedSize && j < cookieSize) {
      if (childGreedArray[i] <= cookieSizeArray[j]) {
        contentChildrenCount++;
        i++;
        j++;
      } else {
        j++;
      }
    }
    return contentChildrenCount;
  }
}