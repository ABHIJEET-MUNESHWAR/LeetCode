package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    09/06/23,
 * Time:    8:14 am
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 */
public class NextGreatestLetter {
  public static void main(String[] args) {
    NextGreatestLetter nextGreatestLetter = new NextGreatestLetter();
    char[] letters = {'c', 'f', 'j'};
    char target = 'a';
    System.out.println(nextGreatestLetter.nextGreatestLetter(letters, target));
  }

  private char nextGreatestLetter(char[] letters, char target) {
    int size = letters.length;
    int start = 0;
    int end = size;
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (letters[mid] > target) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }
    return letters[start % size];
  }
}