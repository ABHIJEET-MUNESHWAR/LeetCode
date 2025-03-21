package com.leetcode.medium.string;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    05/03/24,
 * Time:    9:05 am
 * <a href="https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/?envType=daily-question&envId=2024-03-05">.Minimum Length of String After Deleting Similar Ends.</a>
 */
public class MinimumLengthStrAfterDeletingSimilarEnds {
  public static void main(String[] args) {
    MinimumLengthStrAfterDeletingSimilarEnds minimumLengthStrAfterDeletingSimilarEnds =
        new MinimumLengthStrAfterDeletingSimilarEnds();
    String s = "aabccabba";
    System.out.println(minimumLengthStrAfterDeletingSimilarEnds.minimumLength(s));
  }

  private int minimumLength(String s) {
    int size = s.length();
    int left = 0, right = size - 1;
    while (left < right && s.charAt(left) == s.charAt(right)) {
      char ch = s.charAt(left);
      while (left <= right && s.charAt(left) == ch) {
        left++;
      }
      while (right >= left && s.charAt(right) == ch) {
        right--;
      }
    }
    return right - left + 1;
  }
}