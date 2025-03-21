package com.leetcode.contest.weekly.four.zero.six;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    14/07/24,
 * Time:    9:16 am
 */
public class GetSmallestString {
    public static void main(String[] args) {
        GetSmallestString getSmallestString = new GetSmallestString();
        String s = "131";
        System.out.println(getSmallestString.getSmallestString(s));
    }

    private String getSmallestString(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 1; i < n; i++) {
            int first = chars[i - 1] - '0';
            int second = chars[i] - '0';
            if (isSameParity(first, second)) {
                char temp = chars[i];
                chars[i] = chars[i - 1];
                chars[i - 1] = temp;
                break;
            }
        }
        return new String(chars);
    }

    private boolean isSameParity(int first, int second) {
        return (first % 2 == 0 && second % 2 == 0 && first > second) || (first % 2 == 1 && second % 2 == 1 && first > second);
    }
}