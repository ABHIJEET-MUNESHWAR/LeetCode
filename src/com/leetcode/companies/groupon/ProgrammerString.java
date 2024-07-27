package com.leetcode.companies.groupon;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    23/07/24,
 * Time:    7:01 pm
 */
public class ProgrammerString {
    public static void main(String[] args) {
        ProgrammerString programmerString = new ProgrammerString();
        //String str = "programmerprogrammer";
        String str = "xprogxrmaxemrppprmmograeiruu";
        //String str = "progxrammerrxproxgrammer";
        System.out.println(programmerString.programmerString(str));
    }

    private int programmerString(String str) {
        String programmer = "programmer";

        String head = programmer;
        int i = 0;
        // programmer
        for (; i < str.length(); i++) {
            char ch = str.charAt(i);
            int pIndex = head.indexOf(ch);
            if (pIndex != -1) {
                head = head.substring(0, pIndex).concat(head.substring(pIndex + 1));
            }

            if (head.length() == 0) {
                i++;
                break;
            }
        }

        String tail = programmer;

        int j = str.length() - 1;
        // programmer
        for (; j >= 0; j--) {
            char ch = str.charAt(j);
            int pIndex = tail.indexOf(ch);
            if (pIndex != -1) {
                tail = tail.substring(0, pIndex).concat(tail.substring(pIndex + 1));
            }

            if (tail.length() == 0) {
                j--;
                break;
            }
        }
        return j - i + 1;
    }
}