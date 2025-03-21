package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    25/11/22, Time:    7:07 AM
 */
public class DetectCapital {

  public static void main(String[] args) {
    DetectCapital detectCapital = new DetectCapital();
    System.out.println(detectCapital.detectCapitalUse1("USA"));
    System.out.println(detectCapital.detectCapitalUse2("USA"));
  }

  private boolean detectCapitalUse1(String word) {
    return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
  }


  private boolean detectCapitalUse2(String word) {
    if (word.length() < 2) {
      return true;
    }
    if (word.toUpperCase().equals(word)) {
      return true;
    }
    if (word.substring(1).toLowerCase().equals(word.substring(1))) {
      return true;
    }
    return false;
  }

}