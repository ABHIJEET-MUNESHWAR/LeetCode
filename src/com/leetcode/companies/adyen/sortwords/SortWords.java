package com.leetcode.companies.adyen.sortwords;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    30/07/24,
 * Time:    11:10 am
 * // Sort words based on word length preserving the sequence of words
 */
public class SortWords {
    public static void main(String[] args) {
        SortWords sortWords = new SortWords();
        String str = "This is repeated string of length some value.";
        System.out.println(sortWords.sortWords(str));
    }

    private String sortWords(String str) {
        int n = str.length();
        str = str.substring(0, n - 1);
        String[] words = str.split(" ");
        n = words.length;
        for (int i = 1; i < n; i++) {
            String temp = words[i];
            // Insert s[j] at its correct position
            int j = i - 1;
            while (j >= 0 && temp.length() < words[j].length()) {
                words[j + 1] = words[j];
                j--;
            }
            words[j + 1] = temp;
        }
        String output = String.join(" ", words);
        output = output.toLowerCase();
        StringBuilder sb = new StringBuilder(output);
        sb.setCharAt(0, Character.toUpperCase(output.charAt(0)));
        output = sb.toString();
        output = output + ".";
        return output;
    }
}