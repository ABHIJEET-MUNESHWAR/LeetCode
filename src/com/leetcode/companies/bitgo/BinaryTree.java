package com.leetcode.companies.bitgo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    19/07/24,
 * Time:    7:57 pm
 */
public class BinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        //String[] strArr = new String[]{"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"};
        String[] strArr = new String[] {"(1,2)", "(3,2)", "(2,12)", "(5,2)"};
        System.out.println(binaryTree.binaryTree(strArr));
    }

    private String binaryTree(String[] strArr) {
        int n = strArr.length;
        Map<Integer, Integer> sourceToFrequencyMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> destinationToFrequencyMap = new HashMap<Integer, Integer>();
        for (String edge : strArr) {
            int source = getSource(edge);
            int destination = getDestination(edge);
            sourceToFrequencyMap.put(source, sourceToFrequencyMap.getOrDefault(source, 0) + 1);
            if (sourceToFrequencyMap.containsKey(source) && sourceToFrequencyMap.get(source) > 2) {
                return "false";
            }
            destinationToFrequencyMap.put(destination, destinationToFrequencyMap.getOrDefault(destination, 0) + 1);
            if (destinationToFrequencyMap.containsKey(destination) && destinationToFrequencyMap.get(destination) > 2) {
                return "false";
            }
        }
        strArr[0] = "true";
        return strArr[0];
    }

    private int getDestination(String destination) {
        char[] chars = destination.toCharArray();
        String value = "";
        int i = 1;
        while (chars[i] != ',') {
            i++;
        }
        i++;
        while (chars[i] != ')') {
            value += chars[i];
            i++;
        }
        return Integer.parseInt(value);
    }

    private int getSource(String source) {
        char[] chars = source.toCharArray();
        String value = "";
        int i = 1;
        while (chars[i] != ',') {
            value += chars[i];
            i++;
        }
        return Integer.parseInt(value);
    }
}