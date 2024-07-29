package com.leetcode.medium.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    29/07/24,
 * Time:    7:32 pm
 * 1395. Count Number of Teams
 * https://leetcode.com/problems/count-number-of-teams/description/?envType=daily-question&envId=2024-07-29
 */
public class NumTeams {
    public static void main(String[] args) {
        NumTeams numTeams = new NumTeams();
        int[] rating = {2, 5, 3, 4, 1};
        System.out.println(numTeams.numTeams(rating));
    }

    private int numTeams(int[] rating) {
        int count = 0;
        int n = rating.length;
        // count for ascending sequence
        for (int j = 0; j < n; j++) {
            int smallerNumbers = 0;
            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) {
                    smallerNumbers++;
                }
            }
            int largerNumbers = 0;
            for (int k = j + 1; k < n; k++) {
                if (rating[k] > rating[j]) {
                    largerNumbers++;
                }
            }
            count += smallerNumbers * largerNumbers;
        }

        // count for descending sequence
        for (int j = n - 1; j >= 0; j--) {
            int largerNumbers = 0;
            for (int i = 0; i < j; i++) {
                if (rating[i] > rating[j]) {
                    largerNumbers++;
                }
            }
            int smallerNumbers = 0;
            for (int k = j + 1; k < n; k++) {
                if (rating[k] < rating[j]) {
                    smallerNumbers++;
                }
            }
            count += smallerNumbers * largerNumbers;
        }
        return count;
    }
}