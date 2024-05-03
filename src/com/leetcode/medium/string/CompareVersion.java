package com.leetcode.medium.string;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    03/05/24,
 * Time:    7:31 am
 * 165. Compare Version Numbers
 * https://leetcode.com/problems/compare-version-numbers/description/?envType=daily-question&envId=2024-05-03
 */
public class CompareVersion {
  public static void main(String[] args) {
    CompareVersion compareVersion = new CompareVersion();
    String version1 = "1.0", version2 = "1.0.0";
    System.out.println(compareVersion.compareVersion(version1, version2));
  }

  private int compareVersion(String version1, String version2) {
    String[] levels1 = version1.split("\\.");
    String[] levels2 = version2.split("\\.");
    int length = Math.max(levels1.length, levels2.length);
    for (int i = 0; i < length; i++) {
      Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
      Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
      int compare = v1.compareTo(v2);
      if (compare != 0) {
        return compare;
      }
    }
    return 0;
  }
}