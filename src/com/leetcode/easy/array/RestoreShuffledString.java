package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    11/02/23, Time:    8:45 am
 * https://leetcode.com/problems/shuffle-string/
 */
public class RestoreShuffledString {

  public static void main(String[] args) {
    RestoreShuffledString restoreShuffledString = new RestoreShuffledString();
    String s = "codeleet";
    int[] indices = new int[]{4,5,6,7,0,2,1,3};
    System.out.println(restoreShuffledString.restoreString(s, indices));
  }

  private String restoreString(String s, int[] indices) {
    char[] chars = new char[s.length()];
    for (int i = 0; i < indices.length; i++) {
      chars[indices[i]] = s.charAt(i);
    }
    return new String(chars);
  }
}