package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    27/07/23,
 * Time:    9:22 am
 * https://leetcode.com/problems/reverse-prefix-of-word/
 */
public class ReversePrefix {
    public static void main(String[] args) {
        ReversePrefix reversePrefix = new ReversePrefix();
        String word = "abcdefd";
        char ch = 'd';
        System.out.println(reversePrefix.reversePrefix(word, ch));
    }

    private String reversePrefix(String word, char ch) {
        int length = word.length();
        char[] letters = word.toCharArray();
        for (int i = 0; i < length; i++) {
            if (letters[i] == ch) {
                for (int j = 0; j < (i + 1) / 2; j++) {
                    char temp = letters[i - j];
                    letters[i - j] = letters[j];
                    letters[j] = temp;
                }
                break;
            }
        }
        return new String(letters);
    }
}