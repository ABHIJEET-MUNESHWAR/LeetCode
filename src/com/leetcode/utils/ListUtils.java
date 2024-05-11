package com.leetcode.utils;

import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    13/03/24,
 * Time:    9:02 am
 */
public class ListUtils {
  public static void printList(List<Integer> list) {
    for (Integer item : list) {
      System.out.println(item);
    }
  }

  public static void printBooleanList(List<Boolean> list) {
    for (Boolean item : list) {
      System.out.println(item);
    }
  }

  public static void printStringList(List<String> list) {
    for (String item : list) {
      System.out.println(item);
    }
  }

  public static void printLists(List<List<Integer>> listOfList) {
    for (List<Integer> list : listOfList) {
      for (Integer item : list) {
        System.out.println(item);
      }
    }
  }
}