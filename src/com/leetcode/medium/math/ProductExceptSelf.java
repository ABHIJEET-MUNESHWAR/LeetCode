package com.leetcode.medium.math;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    15/03/24,
 * Time:    7:44 am
 * https://leetcode.com/problems/product-of-array-except-self/?envType=daily-question&envId=2024-03-15
 */
public class ProductExceptSelf {
  public static void main(String[] args) {
    ProductExceptSelf productExceptSelf = new ProductExceptSelf();
    int[] nums = {1, 2, 3, 4};
    ArrayUtils.printArray(productExceptSelf.productExceptSelf(nums));
  }

  private int[] productExceptSelf(int[] nums) {
    int size = nums.length;
    int[] answer = new int[size];
    int prefixProduct = 1, postfixProduct = 1;
    for (int i = 0; i < size; i++) {
      prefixProduct = prefixProduct * nums[i];
      answer[i] = prefixProduct;
    }
    for (int i = size - 1; i > 0; i--) {
      answer[i] = answer[i - 1] * postfixProduct;
      postfixProduct = postfixProduct * nums[i];
    }
    answer[0] = postfixProduct;
    return answer;
  }
}