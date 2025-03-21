package com.leetcode.medium.array;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    14/05/24,
 * Time:    8:32 pm
 * 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams/description/
 */
public class GroupAnagrams {
  public static void main(String[] args) {
    GroupAnagrams groupAnagrams = new GroupAnagrams();
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    ListUtils.printStringLists(groupAnagrams.groupAnagrams(strs));
  }

  private List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String sortedWord = new String(chars);
      if (!map.containsKey(sortedWord)) {
        map.put(sortedWord, new ArrayList<>());
      }
      map.get(sortedWord).add(str);
    }
    return new ArrayList<>(map.values());
  }
}