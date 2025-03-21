package com.leetcode.medium.math;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    11/05/24,
 * Time:    6:20 pm
 * 40. Combination Sum II
 * https://leetcode.com/problems/combination-sum-ii/description/
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        ListUtils.printLists(combinationSum2.combinationSum2(candidates, target));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, target, result, current, 0);
        return result;
    }

    private void solve(int[] candidates, int target, List<List<Integer>> result, List<Integer> current, int index) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                // Ignore duplicate elements to avoid duplicate pairs
                continue;
            }
            current.add(candidates[i]);
            solve(candidates, target - candidates[i], result, current, i + 1);
            current.remove(current.size() - 1);
        }
    }
}