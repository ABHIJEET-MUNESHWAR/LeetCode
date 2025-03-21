package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    25/11/22, Time:    8:31 pm
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 */
public class ReverseWordsInString3 {

  public static void main(String[] args) {
    ReverseWordsInString3 reverseWordsInString3 = new ReverseWordsInString3();
    System.out.println(reverseWordsInString3.reverseWords1("God Ding"));
    System.out.println(reverseWordsInString3.reverseWords1("Let's take LeetCode contest"));
    System.out.println(reverseWordsInString3.reverseWords2("God Ding"));
    System.out.println(reverseWordsInString3.reverseWords2("Let's take LeetCode contest"));
  }

  private String reverseWords2(String s) {
    String[] words = s.split(" ");
    int wordCount = words.length;
    for (int i = 0; i < wordCount; i++) {
      words[i] = new StringBuilder(words[i]).reverse().toString();
    }
    return String.join(" ", words);
  }

  private String reverseWords1(String s) {
    int len = s.length();
    if (len == 1) {
      return s;
    }
    String[] words = s.split(" ");
    int wordCount = words.length;
    String answer = "";
    for (int i = 0; i < wordCount; i++) {
      String word = words[i];
      words[i] = reverse(word.toCharArray());
      answer = answer + words[i] + " ";
    }

    return answer.substring(0, answer.length() - 1);
  }

  private String reverse(char[] chars) {
    int l = 0, r = chars.length - 1;
    while (l < r) {
      char t = chars[l];
      chars[l] = chars[r];
      chars[r] = t;
      l++;
      r--;
    }
    return String.valueOf(chars);
  }
}