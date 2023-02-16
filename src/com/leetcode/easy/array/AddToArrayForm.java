package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    15/02/23, Time:    4:37 pm
 * https://leetcode.com/problems/add-to-array-form-of-integer/
 */
public class AddToArrayForm {

  public static void main(String[] args) {
    AddToArrayForm addToArrayForm = new AddToArrayForm();
    int[] num = new int[]{2, 1, 5};
    int k = 806;
    //int[] num = new int[]{0};
    //int k = 23;
    //int[] num = new int[]{6};
    //int k = 809;
    List<Integer> ans = addToArrayForm.addToArrayForm(num, k);
  }

  private List<Integer> addToArrayForm(int[] num, int k) {
    List<Integer> ans = new ArrayList<>();
    int size = num.length;
    for (int i = size - 1; i >= 0; i--) {
      ans.add(0, (num[i] + k) % 10);
      k = (num[i] + k) / 10;
    }
    while (k > 0) {
      ans.add(0, k % 10);
      k = k / 10;
    }
    return ans;
  }
}