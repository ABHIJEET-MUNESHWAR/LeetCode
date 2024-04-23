package com.leetcode.hard.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    23/04/24,
 * Time:    1:58 pm
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/description/?envType=daily-question&envId=2024-04-12
 */
public class TrappingRainWater {
  public static void main(String[] args) {
    TrappingRainWater trappingRainWater = new TrappingRainWater();
    int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println(trappingRainWater.trap(height));
  }

  private int trap(int[] height) {
    int totalWater = 0;
    int leftMax = 0;
    int rightMax = 0;
    int size = height.length;
    int l = 0;
    int r = size - 1;
    while (l < r) {
      if (leftMax < height[l]) {
        leftMax = height[l];
      }
      if (rightMax < height[r]) {
        rightMax = height[r];
      }
      if (leftMax < rightMax) {
        totalWater += leftMax - height[l];
        l++;
      } else {
        totalWater += rightMax - height[r];
        r--;
      }
    }
    return totalWater;
  }
}