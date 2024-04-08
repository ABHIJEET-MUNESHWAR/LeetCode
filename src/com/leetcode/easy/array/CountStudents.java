package com.leetcode.easy.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    08/04/24,
 * Time:    7:26 am
 * https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/?envType=daily-question&envId=2024-04-08
 */
public class CountStudents {
  public static void main(String[] args) {
    CountStudents countStudents = new CountStudents();
    int[] students = {1, 1, 1, 0, 0, 1};
    int[] sandwiches = {1, 0, 0, 0, 1, 1};
    System.out.println(countStudents.countStudentsSimulation(students, sandwiches));
    System.out.println(countStudents.countStudentsOptimised(students, sandwiches));
  }

  private int countStudentsOptimised(int[] students, int[] sandwiches) {
    int zeros = 0;
    int once = 0;
    for (int student : students) {
      if (student == 0) {
        zeros++;
      } else {
        once++;
      }
    }
    for (int sandwich : sandwiches) {
      if (sandwich == 0) {
        if (zeros == 0) {
          return once;
        }
        zeros--;
      } else {
        if (once == 0) {
          return zeros;
        }
        once--;
      }
    }
    return 0;
  }

  private int countStudentsSimulation(int[] students, int[] sandwiches) {
    Queue<Integer> queue = new LinkedList<>();
    int top = 0, count = 0;
    for (int i = 0; i < students.length; i++) {
      queue.add(students[i]);
    }
    while (!queue.isEmpty() && count != queue.size()) {
      if (sandwiches[top] == queue.peek()) {
        count = 0;
        queue.poll();
        top++;
      } else {
        count++;
        queue.add(queue.poll());
      }
    }
    return queue.size();
  }
}