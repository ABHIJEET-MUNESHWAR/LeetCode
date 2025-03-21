package com.leetcode.medium.stack;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    11/05/24,
 * Time:    1:04 pm
 * 1441. Build an Array With Stack Operations
 * https://leetcode.com/problems/build-an-array-with-stack-operations/
 */
public class BuildArray {
  public static void main(String[] args) {
    BuildArray buildArray = new BuildArray();
    int[] target = {1, 2};
    int n = 4;
    ListUtils.printStringList(buildArray.buildArray(target, n));
  }

  private List<String> buildArray(int[] target, int n) {
    List<String> answer = new ArrayList<>();
    int incomingStream = 1;
    int mismatchCounter = 0;
    int i = 0;
    int size = target.length;
    while ((incomingStream <= n) && (i < size)) {
      if (target[i] == incomingStream) {
        while (mismatchCounter > 0) {
          answer.add("Pop");
          mismatchCounter--;
        }
        answer.add("Push");
        i++;
      } else {
        mismatchCounter++;
        answer.add("Push");
      }
      incomingStream++;
    }
    return answer;
  }
}