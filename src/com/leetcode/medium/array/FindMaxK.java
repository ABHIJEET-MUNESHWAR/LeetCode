package com.leetcode.medium.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    02/05/24,
 * Time:    8:32 am
 * 2441. Largest Positive Integer That Exists With Its Negative
 * https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/description/?envType=daily-question&envId=2024-05-02
 */
public class FindMaxK {
  public static void main(String[] args) {
    FindMaxK findMaxK = new FindMaxK();
    int[] nums = {-1, 10, 6, 7, -7, 1};
    System.out.println(findMaxK.findMaxK(nums));
  }

  private int findMaxK(int[] nums) {
    int[] frequencyMap = new int[1001];
    int size = nums.length;
    int answer = -1;
    for (int i = 0; i < size; i++) {
      int num = nums[i];
      int absNum = Math.abs(num);
      if (frequencyMap[absNum] == (-num) && answer < Math.abs(frequencyMap[absNum])) {
        answer = Math.abs(frequencyMap[absNum]);
      }
      frequencyMap[absNum] = num;
    }
    return answer;
  }
}