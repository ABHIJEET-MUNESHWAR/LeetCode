package com.leetcode.medium.string;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    02/06/24,
 * Time:    7:33 pm
 * 443. String Compression
 * https://leetcode.com/problems/string-compression/description/
 */
public class StringCompression {
  public static void main(String[] args) {
    StringCompression s = new StringCompression();
    char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
    System.out.println(s.compress(chars));
  }

  private int compress(char[] chars) {
    int size = chars.length;
    int i = 0;
    int index = 0;
    while (i < size) {
      char currentChar = chars[i];
      int count = 0;
      while (i < size && currentChar == chars[i]) {
        count++;
        i++;
      }
      chars[index++] = currentChar;
      if (count > 1) {
        String countString = String.valueOf(count);
        for (char ch : countString.toCharArray()) {
          chars[index++] = ch;
        }
      }
    }
    return index;
  }
}