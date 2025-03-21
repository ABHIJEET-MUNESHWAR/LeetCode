package com.leetcode.medium.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    15/05/24,
 * Time:    8:53 pm
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/description/
 */
public class ContainerWithMostWater {
  public static void main(String[] args) {
    ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
    int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    System.out.println(containerWithMostWater.containerWithMostWater(height));
  }

  private int containerWithMostWater(int[] height) {
    int maxArea = Integer.MIN_VALUE;
    int left = 0;
    int right = height.length - 1;
    while (left < right) {
      int area = (right - left) * Math.min(height[left], height[right]);
      maxArea = Math.max(maxArea, area);
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return maxArea;
  }
}