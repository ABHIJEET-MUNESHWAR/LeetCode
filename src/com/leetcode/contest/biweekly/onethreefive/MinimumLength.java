package com.leetcode.contest.biweekly.onethreefive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    20/07/24,
 * Time:    8:15 pm
 * 100330. Minimum Length of String After Operations
 * https://leetcode.com/problems/minimum-length-of-string-after-operations/description/
 */
public class MinimumLength {
    public static void main(String[] args) {
        MinimumLength minimumLength = new MinimumLength();
        //String s = "abaacbcbb";
        //String s = "aa";
        String s = "aaaaabbb";
        System.out.println(minimumLength.minimumLength(s));
    }

    private int minimumLength(String s) {
        int n = s.length();
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            List<Integer> list = map.getOrDefault(c, new ArrayList<>());
            list.add(i);
            map.put(c, list);
        }
        int finalLength = 0;
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            Character character = entry.getKey();
            List<Integer> list = entry.getValue();
            int size = list.size();
            if (size > 2) {
                if(size%2==0){
                    finalLength += 2;
                } else {
                    finalLength += 1;
                }
            } else {
                finalLength += size;
            }
        }
        return finalLength;
    }
}