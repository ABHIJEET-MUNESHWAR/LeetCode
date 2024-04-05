package com.leetcode.medium.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    05/04/24,
 * Time:    7:54 am
 * https://leetcode.com/problems/task-scheduler/?envType=daily-question&envId=2024-03-19
 */
public class LeastInterval {
  class Task implements Comparable<Task> {
    int frequency;
    int executionTime;

    public Task(int frequency, int executionTime) {
      this.frequency = frequency;
      this.executionTime = executionTime;
    }

    @Override
    public int compareTo(Task that) {
      return that.frequency - this.frequency;
    }
  }

  public static void main(String[] args) {
    LeastInterval leastInterval = new LeastInterval();
    char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
    int n = 2;
    System.out.println(leastInterval.leastInterval(tasks, n));
  }

  private int leastInterval(char[] tasks, int n) {
    Map<Character, Integer> frequencyMap = new HashMap<>();
    for (char ch : tasks) {
      frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
    }
    PriorityQueue<Task> maxheap = new PriorityQueue<>();
    for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
      maxheap.add(new Task(entry.getValue(), 0));
    }
    Queue<Task> taskQueue = new LinkedList<>();
    int time = 0;
    while (!taskQueue.isEmpty() || !maxheap.isEmpty()) {
      time++;
      // Check if there's task in maxHeap & process it.
      if (!maxheap.isEmpty()) {
        Task task = maxheap.poll();
        task.frequency--;
        if (task.frequency > 0) {
          // update execution time
          task.executionTime = time + n;
          taskQueue.add(task);
        }
      }
      // shift active process to maxHeap
      if (!taskQueue.isEmpty() && taskQueue.peek().executionTime == time) {
        maxheap.add(taskQueue.poll());
      }
    }
    return time;
  }
}