package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;
import java.util.Stack;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    24/09/23,
 * Time:    8:42 am
 * https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/
 */
public class FinalPrices {
  public static void main(String[] args) {
    FinalPrices finalPrices = new FinalPrices();
    int[] prices = {8, 4, 6, 2, 3};
    int[] prices2 = {8, 4, 6, 2, 3};
    ArrayUtils.printArray(finalPrices.finalPrices(prices));
    ArrayUtils.printArray(finalPrices.finalPrices2(prices2));
  }

  private int[] finalPrices2(int[] prices) {
    Stack<Integer> stack = new Stack<>();
    int size = prices.length;
    for (int i = 0; i < size; i++) {
      while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
        prices[stack.pop()] -= prices[i];
      }
      stack.push(i);
    }
    return prices;
  }

  private int[] finalPrices(int[] prices) {
    int size = prices.length;
    for (int i = 0; i < size; i++) {
      int n = prices[i];
      for (int j = i + 1; j < size; j++) {
        if (n >= prices[j]) {
          n = n - prices[j];
          break;
        }
      }
      prices[i] = n;
    }
    return prices;
  }
}