package com.leetcode.companies.wayfair;

import com.leetcode.utils.ArrayUtils;
import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    22/07/24,
 * Time:    8:13 pm
 */
public class FindPositions {
    public static void main(String[] args) {
        FindPositions findPositions = new FindPositions();
        int[] containers = {2, 7, 3, 4, 9};
        int[] chairIDs = {1, 25, 11};
        ArrayUtils.printArray(findPositions.findPositions(containers, chairIDs));
    }

    private int[] findPositions(int[] containers, int[] chairIDs) {
        int containerLength = containers.length;
        int chairLength = chairIDs.length;
        int[] result = new int[chairLength];
        int[] prefixSum = new int[containerLength];
        prefixSum[0] = containers[0];
        for (int i = 1; i < chairLength; i++) {
            prefixSum[i] = prefixSum[i - 1] + containers[i];
        }
        for (int i = 0; i < chairLength; i++) {
            int position = Arrays.binarySearch(prefixSum, chairIDs[i]);
            result[i] = 1 + (position >= 0 ? position : -1 * position - 1);
        }
        return result;
    }
}