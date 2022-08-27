package com.leetcode.easy.design;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    27/08/22, Time:    12:31 PM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/98/design/562/
 */

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj = new MinStack();
 * obj.push(val); obj.pop(); int param_3 = obj.top(); int param_4 = obj.getMin();
 */
public class MinStack {

  Stack<Integer> stack;
  Queue<Integer> queue;

  public MinStack() {
    stack = new Stack<>();
    queue = new PriorityQueue<>();
  }

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    int min1 = minStack.getMin();
    System.out.println(min1);
    minStack.pop();
    int top1 = minStack.top();
    System.out.println(top1);
    int min2 = minStack.getMin();
    System.out.println(min2);
  }

  public void push(int val) {
    stack.push(val);
    queue.add(val);
  }

  public void pop() {
    int element = stack.pop();
    queue.remove(element);
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return queue.peek();
  }
}