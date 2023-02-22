package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    22/02/23, Time:    10:14 am
 * https://leetcode.com/problems/count-items-matching-a-rule/
 */
public class CountItemsMatchingRule {

  public static void main(String[] args) {
    CountItemsMatchingRule countItemsMatchingRule = new CountItemsMatchingRule();
    List<List<String>> items = new ArrayList<>();
    List<String> list1 = new ArrayList<>();
    list1.add("phone");
    list1.add("blue");
    list1.add("pixel");
    items.add(list1);
    List<String> list2 = new ArrayList<>();
    list2.add("computer");
    list2.add("silver");
    list2.add("lenovo");
    items.add(list2);
    List<String> list3 = new ArrayList<>();
    list3.add("phone");
    list3.add("gold");
    list3.add("iphone");
    items.add(list3);
    System.out.println(countItemsMatchingRule.countMatches(items, "color", "silver"));
  }

  private int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
    int result = 0;
    for (List<String> list : items) {
      if (ruleKey.equals("type") && list.get(0).equals(ruleValue)) {
        result++;
      }
      if (ruleKey.equals("color") && list.get(1).equals(ruleValue)) {
        result++;
      }
      if (ruleKey.equals("name") && list.get(2).equals(ruleValue)) {
        result++;
      }
    }
    return result;
  }
}