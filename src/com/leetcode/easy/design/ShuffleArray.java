package com.leetcode.easy.design;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    27/08/22, Time:    12:20 PM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/98/design/670/
 */
public class ShuffleArray {

  private int[] nums;

  public ShuffleArray(int[] nums) {
    this.nums = nums;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3};
    ShuffleArray shuffleArray = new ShuffleArray(nums);
    shuffleArray.printArray(nums);
    nums = shuffleArray.shuffle();
    shuffleArray.printArray(nums);
    shuffleArray.reset();
    shuffleArray.printArray(nums);
    nums = shuffleArray.shuffle();
    shuffleArray.printArray(nums);
  }

  public int[] reset() {
    return this.nums;
  }

  public int[] shuffle() {
    if (nums == null) {
      return null;
    }
    int len = nums.length;
    int[] rand = new int[len];
    for (int i = 0; i < len; i++) {
      int r = (int) (Math.random() * (i + 1));
      rand[i] = rand[r];
      rand[r] = nums[i];
    }
    return rand;
  }

  public void printArray(int[] nums) {
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      System.out.println(nums[i]);
    }
    System.out.println();
  }
}