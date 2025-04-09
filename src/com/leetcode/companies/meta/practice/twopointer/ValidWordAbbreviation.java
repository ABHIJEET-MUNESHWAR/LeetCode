package com.leetcode.companies.meta.practice.twopointer;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   09-04-2025
    Time:   04:26 pm
    https://www.educative.io/module/page/An5VrvSVNYGLGGM57/10370001/5333691084177408/4534419230162944
    Valid Word Abbreviation
*/

public class ValidWordAbbreviation {
    public static void main(String[] args) {
        ValidWordAbbreviation validWordAbbreviation = new ValidWordAbbreviation();
        String word = "internationalization";
        String abbr = "i12iz4n";
        System.out.println(validWordAbbreviation.validWordAbbreviation(word, abbr));
    }

    private boolean validWordAbbreviation(String word, String abbr) {
        int l1 = word.length();
        int l2 = abbr.length();
        int i = 0, j = 0;
        while (i < l1 && j < l2) {
            if (Character.isDigit(abbr.charAt(j))) {
                int num = 0;
                while (j < l2 && Character.isDigit(abbr.charAt(j))) {
                    num = num * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                i += num;
                if (i > l1) {
                    return false;
                }
            } else if (word.charAt(i) != abbr.charAt(j)) {
                return false;
            } else {
                i++;
                j++;
            }
        }
        return i == l1 && j == l2;
    }
}
