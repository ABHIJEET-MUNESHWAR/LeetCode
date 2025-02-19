package com.leetcode.medium.backtracking;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   19-02-2025
    Time:   05:27 pm
    https://www.geeksforgeeks.org/print-subsequences-string/
    Print all subsequences of a string
*/

public class PrintAllSubsequence {
    public static void main(String[] args) {
        PrintAllSubsequence printAllSubsequence = new PrintAllSubsequence();
        String str = "abc";
        printAllSubsequence.printAllSubsequence(str);
    }

    private void printAllSubsequence(String str) {
        printAllSubsequence(str, "", 0);
    }

    private void printAllSubsequence(String str, String current, int index) {
        if (index > str.length()) {
            return;
        }
        if (current != null && !current.trim().isEmpty()) {
            System.out.println(current);
        }
        for (int i = index; i < str.length(); i++) {
            current += str.charAt(i); // Do
            printAllSubsequence(str, current, i + 1); // Explore
            current = current.substring(0, current.length() - 1); // Undo
        }
    }
}
