package com.leetcode.medium.hash;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    30/04/24,
 * Time:    10:11 pm
 * 1282. Group the People Given the Group Size They Belong To
 * https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/description/
 */
public class GroupThePeople {
  public static void main(String[] args) {
    GroupThePeople groupThePeople = new GroupThePeople();
    int[] groupSizes = {3, 3, 3, 3, 3, 1, 3};
    ListUtils.printLists(groupThePeople.groupThePeople(groupSizes));
  }

  public List<List<Integer>> groupThePeople(int[] groupSizes) {
    List<List<Integer>> res = new ArrayList();
    Map<Integer, List<Integer>> groups = new HashMap<>();
    for (int i = 0; i < groupSizes.length; ++i) {
      List<Integer> list = groups.computeIfAbsent(groupSizes[i], k -> new ArrayList());
      list.add(i);
      if (list.size() == groupSizes[i]) {
        res.add(list);
        groups.put(groupSizes[i], new ArrayList());
      }
    }
    return res;
  }
}