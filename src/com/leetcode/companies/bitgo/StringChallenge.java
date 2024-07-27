package com.leetcode.companies.bitgo;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    19/07/24,
 * Time:    8:34 pm
 */
public class StringChallenge {
    public static void main(String[] args) {
        StringChallenge stringChallenge = new StringChallenge();
        //String str = "aabbcde";
        String str = "wwwbbbw";
        System.out.println(stringChallenge.stringChallenge(str));
    }

    private String stringChallenge(String str) {
        String result = "";
        int n = str.length();
        char[] chars = str.toCharArray();
        int i = 0;
        int count = 1;
        while (i < n - 1) {
            while ((chars[i] == chars[i + 1]) && (i < n - 1)) {
                count++;
                i++;
            }
            result += count + "" + chars[i];
            i++;
            count = 1;
        }
        result += count + "" + chars[n - 1];
        str =  merge(result, "v74z21ahrdb");
        return str;
    }

    private String merge(String first, String second) {
        int n = first.length();
        int m = second.length();
        int i = 0, j = 0;
        String result = "";
        while (i < n && j < m) {
            result += first.charAt(i) + "" + second.charAt(j);
            i++;
            j++;
        }
        while (i < n) {
            result += first.charAt(i) + "";
            i++;
        }
        while (j < m) {
            result += second.charAt(j) + "";
            j++;
        }
        return result;
    }
}