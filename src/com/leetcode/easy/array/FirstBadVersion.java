package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    11/08/22, Time:    4:27 PM
 */
public class FirstBadVersion extends VersionControl {

  public static void main(String[] args) {
    FirstBadVersion firstBadVersion = new FirstBadVersion();
    System.out.println("First bad version is: " + firstBadVersion.firstBadVersion(7));
  }

  private int firstBadVersion(int n) {
    int start = 0, end = n;
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (isBadVersion(mid)) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }
    return start;
  }
}