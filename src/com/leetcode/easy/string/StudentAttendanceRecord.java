package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    25/11/22, Time:    7:46 pm
 * https://leetcode.com/problems/student-attendance-record-i/
 */
public class StudentAttendanceRecord {

  public static void main(String[] args) {
    StudentAttendanceRecord studentAttendanceRecord = new StudentAttendanceRecord();
    System.out.println(studentAttendanceRecord.checkRecord1("PPALLP"));
    System.out.println(studentAttendanceRecord.checkRecord1("PPALLL"));
    System.out.println(studentAttendanceRecord.checkRecord2("PPALLP"));
    System.out.println(studentAttendanceRecord.checkRecord2("PPALLL"));
  }

  private boolean checkRecord2(String s) {
    return (s.indexOf("A") == s.lastIndexOf("A")) && (s.indexOf("LLL") == -1);
  }

  private boolean checkRecord1(String s) {
    boolean wasNeverAbsent = false;
    boolean wasNeverLate = s.indexOf("LLL") == -1 ? true : false;
    int absentCount = 0;
    int len = s.length();
    for (int i = 0; i < len; i++) {
      if (s.charAt(i) == 'A') {
        absentCount++;
      }
    }
    if (absentCount < 2) {
      wasNeverAbsent = true;
    }
    return wasNeverAbsent && wasNeverLate;
  }
}