package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    24/09/23,
 * Time:    4:13 pm
 * https://leetcode.com/problems/number-of-senior-citizens/
 */
public class CountSeniors {
  public static void main(String[] args) {
    CountSeniors countSeniors = new CountSeniors();
    String[] details = {"7868190130M7522", "5303914400F9211", "9273338290F4010"};
    System.out.println(countSeniors.countSeniors(details));
  }

  private int countSeniors(String[] details) {
    int elder = 0;
    for (String detail : details) {
      int age = (detail.charAt(11) - '0') * 10 + detail.charAt(12) - '0';
      if (age > 60) {
        elder++;
      }
    }
    return elder;
  }
}