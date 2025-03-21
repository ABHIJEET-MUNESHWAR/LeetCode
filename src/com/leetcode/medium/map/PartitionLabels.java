package com.leetcode.medium.map;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    10/05/24,
 * Time:    5:17 pm
 * 763. Partition Labels
 * https://leetcode.com/problems/partition-labels/description/
 */
public class PartitionLabels {
  public static void main(String[] args) {
    PartitionLabels partitionLabels = new PartitionLabels();
    String s = "ababcbacadefegdehijhklij";
    ListUtils.printList(partitionLabels.partitionLabels(s));
  }

  private List<Integer> partitionLabels(String s) {
    int size = s.length();
    List<Integer> answer = new ArrayList<>();
    Map<Character, Integer> occuranceMap = new HashMap<>();
    for (int i = 0; i < size; i++) {
      char c = s.charAt(i);
      occuranceMap.put(c, i);
    }
    int currentPartitionSize = 0;
    int currentEnd = 0;
    int end = 0;
    for (int i = 0; i < size; i++) {
      currentPartitionSize++;
      char c = s.charAt(i);
      currentEnd = occuranceMap.get(c);
      end = Math.max(end, currentEnd);
      if (i == end) {
        answer.add(currentPartitionSize);
        currentPartitionSize = 0;
      }
    }
    return answer;
  }
}