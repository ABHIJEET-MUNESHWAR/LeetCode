package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    09/10/23,
 * Time:    4:55 pm
 * https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/
 * 2570. Merge Two 2D Arrays by Summing Values
 */
public class MergeArrays {
    public static void main(String[] args) {
        MergeArrays mergeArrays = new MergeArrays();
        int[][] nums1 = {{1, 2}, {2, 3}, {4, 5}};
        int[][] nums2 = {{1, 4}, {3, 2}, {4, 1}};
        ArrayUtils.printMatrix(mergeArrays.mergeArrays(nums1, nums2));
        ArrayUtils.printMatrix(mergeArrays.mergeArrays2(nums1, nums2));
    }

    public int[][] mergeArrays2(int[][] nums1, int[][] nums2) {
        List<int[]> resultList = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            int id1 = nums1[i][0];
            int id2 = nums2[j][0];
            if (id1 == id2) {
                resultList.add(new int[]{id1, nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            } else if (id1 < id2) {
                resultList.add(new int[]{id1, nums1[i][1]});
                i++;
            } else {
                resultList.add(new int[]{id2, nums2[j][1]});
                j++;
            }
        }
        while (i < len1) {
            resultList.add(new int[]{nums1[i][0], nums1[i][1]});
            i++;
        }
        while (j < len2) {
            resultList.add(new int[]{nums2[j][0], nums2[j][1]});
            j++;
        }
        int len = resultList.size();
        int[][] result = new int[len][2];
        for (i = 0; i < len; i++) {
            result[i][0] = resultList.get(i)[0];
            result[i][1] = resultList.get(i)[1];
        }
        return result;
    }

    private int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int num1Size = nums1.length;
        int num2Size = nums2.length;
        List<List<Integer>> answersList = new ArrayList<>();
        int i = 0, j = 0;
        while (i < num1Size && j < num2Size) {
            if (nums1[i][0] == nums2[j][0]) {
                List<Integer> answerList = new ArrayList<>();
                answerList.add(nums1[i][0]);
                answerList.add(nums1[i][1] + nums2[j][1]);
                answersList.add(answerList);
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                List<Integer> answerList = new ArrayList<>();
                answerList.add(nums1[i][0]);
                answerList.add(nums1[i][1]);
                answersList.add(answerList);
                i++;
            } else {
                List<Integer> answerList = new ArrayList<>();
                answerList.add(nums2[j][0]);
                answerList.add(nums2[j][1]);
                answersList.add(answerList);
                j++;
            }
        }
        while (i < num1Size) {
            List<Integer> answerList = new ArrayList<>();
            answerList.add(nums1[i][0]);
            answerList.add(nums1[i][1]);
            answersList.add(answerList);
            i++;
        }
        while (j < num2Size) {
            List<Integer> answerList = new ArrayList<>();
            answerList.add(nums2[j][0]);
            answerList.add(nums2[j][1]);
            answersList.add(answerList);
            j++;
        }
        int[][] answer = new int[answersList.size()][2];
        int k = 0;
        for (List<Integer> answerList : answersList) {
            answer[k][0] = answerList.get(0);
            answer[k][1] = answerList.get(1);
            k++;
        }
        return answer;
    }
}