package com.leetcode.medium.backtracking;

import com.leetcode.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    11/05/24,
 * Time:    4:43 pm
 * 46. Permutations
 * https://leetcode.com/problems/permutations/description/
 */
public class Permutations {
    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[]        nums         = {1, 2, 3};
        ListUtils.printLists(permutations.permute(nums));
    }

    private List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, ArrayList<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) {
                    continue;
                }
                tempList.add(nums[i]);
                backtrack(result, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}