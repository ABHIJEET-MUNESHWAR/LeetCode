package com.leetcode.hard.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    14/07/24,
 * Time:    3:38 pm
 * 726. Number of Atoms
 * https://leetcode.com/problems/number-of-atoms/description/?envType=daily-question&envId=2024-07-14
 */
public class NumberOfAtoms {
    public static void main(String[] args) {
        NumberOfAtoms numberOfAtoms = new NumberOfAtoms();
        String formula = "K4(ON(SO3)2)2";
        System.out.println(numberOfAtoms.countOfAtoms(formula));
    }

    private String countOfAtoms(String formula) {
        int n = formula.length();
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());
        int i = 0;
        while (i < n) {
            if (formula.charAt(i) == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (formula.charAt(i) == ')') {
                Map<String, Integer> top = stack.pop();
                i++;
                StringBuilder sb = new StringBuilder();
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    sb.append(formula.charAt(i));
                    i++;
                }
                int multiplier = sb.length() > 0 ? Integer.parseInt(sb.toString()) : 1;
                for (Map.Entry<String, Integer> entry : top.entrySet()) {
                    String key = entry.getKey();
                    Integer value = entry.getValue();
                    top.put(key, value * multiplier);
                }
                for (Map.Entry<String, Integer> entry : top.entrySet()) {
                    String key = entry.getKey();
                    Integer value = entry.getValue();
                    stack.peek().put(key, stack.peek().getOrDefault(key, 0) + value);
                }
            } else {
                StringBuilder element = new StringBuilder();
                element.append(formula.charAt(i++));
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    element.append(formula.charAt(i++));
                }
                StringBuilder sb = new StringBuilder();
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    sb.append(formula.charAt(i++));
                }
                int count = sb.length() > 0 ? Integer.parseInt(sb.toString()) : 1;
                stack.peek().put(element.toString(), stack.peek().getOrDefault(element.toString(), 0) + count);
            }
        }
        TreeMap<String, Integer> treeMap = new TreeMap<>(stack.peek());
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            result.append(key);
            if (value > 1) {
                result.append(value);
            }
        }
        return result.toString();
    }
}