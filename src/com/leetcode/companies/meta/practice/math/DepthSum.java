package com.leetcode.companies.meta.practice.math;


import java.util.List;

/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   16-04-2025
    Time:   06:04 pm
    339. Nested List Weight Sum
    https://leetcode.com/problems/nested-list-weight-sum/description/
*/
// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {
    // Constructor initializes an empty nested list.
    //public NestedInteger();

    // Constructor initializes a single integer.
    // public NestedInteger(int value);

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class DepthSum {
    public static void main(String[] args) {
        DepthSum depthSum = new DepthSum();
    }

    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }

    public int depthSum(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                sum += nestedInteger.getInteger() * depth;
            } else {
                sum += depthSum(nestedInteger.getList(), depth + 1);
            }
        }
        return sum;
    }
}
