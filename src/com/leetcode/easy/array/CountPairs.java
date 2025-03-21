package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    27/07/23,
 * Time:    8:22 am
 * https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array/
 */
public class CountPairs {
    public static void main(String[] args) {
        CountPairs countPairs = new CountPairs();
        int[] nums = {3, 1, 2, 2, 2, 1, 3};
        int k = 2;
        System.out.println(countPairs.countPairs(nums, k));
    }

    private int countPairs(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int count = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> list = map.get(nums[i]);
                for (Integer num : list) {
                    int mul = num * i;
                    if ((mul) % k == 0) {
                        count++;
                    }
                }
                list.add(i);
                map.put(nums[i], list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        return count;
    }
}