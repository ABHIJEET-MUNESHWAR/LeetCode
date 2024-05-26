package com.leetcode.medium.backtracking;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    26/05/24,
 * Time:    11:49 pm
 * 552. Student Attendance Record II
 * https://leetcode.com/problems/student-attendance-record-ii/description/?envType=daily-question&envId=2024-05-26
 */
public class StudentAttendanceRecordTwo {
  public static void main(String[] args) {
    StudentAttendanceRecordTwo studentAttendanceRecordTwo = new StudentAttendanceRecordTwo();
    System.out.println(studentAttendanceRecordTwo.checkRecord(2));
    System.out.println(studentAttendanceRecordTwo.checkRecordBottomUp(2));
  }

  private int checkRecordBottomUp(int n) {
    int M = 1000000007;
    int[][][] t = new int[100001][2][3];

    // Base Case - 0 number of days. So, t[0][A][L], we return 1
    for (int A = 0; A <= 1; ++A) {
      for (int L = 0; L <= 2; ++L) {
        t[0][A][L] = 1;
      }
    }

    for (int i = 1; i <= n; i++) {
      for (int A = 0; A <= 1; A++) {
        for (int L = 0; L <= 2; L++) {

          long result = t[i - 1][A][0];            // P ---> solve(n-1, absent, 0) % M;
          result += (L < 2 ? t[i - 1][A][L + 1] : 0);  // L ---> solve(n-1, absent, consecutive_late+1) % M;
          result += (A == 0 ? t[i - 1][A + 1][0] : 0);  // A ---> solve(n-1, absent+1, 0) % M;

          t[i][A][L] = (int) (result % M);
        }
      }
    }

    return t[n][0][0];
  }

  private int checkRecord(int n) {
    for (int i = 0; i < 100001; i++) {
      for (int j = 0; j < 2; j++) {
        Arrays.fill(dp[i][j], -1);
      }
    }
    return solve(n, 0, 0);
  }

  int mod = 1000000007;
  int[][][] dp = new int[100001][2][3];

  private int solve(int n, int absent, int consecutiveLate) {
    // Pruning i.e. ignoring meaningless cases
    if (absent > 1 || consecutiveLate > 2) {
      return 0;
    }
    if (n == 0) {
      return 1;
    }
    if (dp[n][absent][consecutiveLate] != -1) {
      return dp[n][absent][consecutiveLate];
    }
    int absentCount = solve(n - 1, absent + 1, 0) % mod;
    int lateCount = solve(n - 1, absent, consecutiveLate + 1) % mod;
    int presentCount = solve(n - 1, absent, 0) % mod;
    return dp[n][absent][consecutiveLate] = ((absentCount + lateCount) % mod + presentCount) % mod;
  }
}