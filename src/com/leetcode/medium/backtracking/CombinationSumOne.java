package com.leetcode.medium.backtracking;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   06-08-2026
    Time:   09:39 pm
    https://leetcode.com/problems/combination-sum/description/
*/

import com.leetcode.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumOne {
    public static void main(String[] args) {
        CombinationSumOne   combinationSumOne = new CombinationSumOne();
        int[]               candidates        = {2, 3, 6, 7};
        int                 target            = 7;
        List<List<Integer>> resultList        = combinationSumOne.combinationSum(candidates, target);
        ListUtils.printLists(resultList);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultList  = new ArrayList<>();
        List<Integer>       currentList = new ArrayList<>();
        combinationSumBackTrack(candidates, target, candidates.length, 0, currentList, resultList);
        return resultList;
    }

    public void combinationSumBackTrack(int[] candidates, int remainingTarget, int length, int index, List<Integer> currentList, List<List<Integer>> resultList) {
        if (remainingTarget == 0) {
            resultList.add(new ArrayList<>(currentList));
            return;
        }
        if (index >= length || remainingTarget < 0) {
            return;
        }
        for (int i = index; i < length; i++) {
            currentList.add(candidates[i]);
            combinationSumBackTrack(candidates, remainingTarget - candidates[i], length, i, currentList, resultList);
            currentList.remove(currentList.size() - 1);
        }
    }
}
