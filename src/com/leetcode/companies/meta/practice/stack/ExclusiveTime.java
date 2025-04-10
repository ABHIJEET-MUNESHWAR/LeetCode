package com.leetcode.companies.meta.practice.stack;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   10-04-2025
    Time:   10:38 am
    636. Exclusive Time of Functions
    https://leetcode.com/problems/exclusive-time-of-functions/description/
*/

import com.leetcode.utils.ArrayUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTime {
    public static void main(String[] args) {
        ExclusiveTime exclusiveTime = new ExclusiveTime();
        int n = 2;
        List<String> logs = Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6");
        ArrayUtils.printArray(exclusiveTime.exclusiveTime(n, logs));
    }

    private int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int lastLogTimeStamp = 0;
        int[] result = new int[n];
        for (String log : logs) {
            String[] str = log.split(":");
            int functionId = Integer.parseInt(str[0]);
            boolean isStart = str[1].equals("start");
            int timestamp = Integer.parseInt(str[2]);
            if (!isStart) {
                timestamp++;
            }
            if (!stack.isEmpty()) {
                int funcId = stack.peek();
                result[funcId] += timestamp - lastLogTimeStamp;
            }
            if (isStart) {
                stack.push(functionId);
            } else {
                stack.pop();
            }
            lastLogTimeStamp = timestamp;
        }
        return result;
    }
}
