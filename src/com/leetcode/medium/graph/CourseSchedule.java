package com.leetcode.medium.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    08/06/24,
 * Time:    3:29 pm
 * 207. Course Schedule
 * https://leetcode.com/problems/course-schedule/description/
 */
public class CourseSchedule {
  public static void main(String[] args) {
    CourseSchedule courseSchedule = new CourseSchedule();
    int numCourses = 2;
    int[][] prerequisites = {{0, 1}, {1, 0}};
    System.out.println(courseSchedule.canFinishBFS(numCourses, prerequisites));
    System.out.println(courseSchedule.canFinishDFS(numCourses, prerequisites));
  }

  private boolean canFinishDFS(int numCourses, int[][] prerequisites) {
    ArrayList<Integer>[] graph = new ArrayList[numCourses];
    for (int i = 0; i < numCourses; i++) {
      graph[i] = new ArrayList<>();
    }
    for (int[] prerequisite : prerequisites) {
      graph[prerequisite[0]].add(prerequisite[1]);
    }
    boolean[] visited = new boolean[numCourses];
    boolean[] recursionStack = new boolean[numCourses];
    for (int i = 0; i < numCourses; i++) {
      if (!visited[i] && hasCycle(graph, visited, recursionStack, i)) {
        return false;
      }
    }
    return true;
  }

  private boolean hasCycle(ArrayList<Integer>[] graph, boolean[] visited, boolean[] recursionStack, int currentNode) {
    visited[currentNode] = true;
    recursionStack[currentNode] = true;
    for (int neighbor : graph[currentNode]) {
      if (!visited[neighbor] && hasCycle(graph, visited, recursionStack, neighbor)) {
        return true;
      } else if (recursionStack[neighbor]) {
        return true;
      }
    }
    recursionStack[currentNode] = false;
    return false;
  }

  private boolean canFinishBFS(int numCourses, int[][] prerequisites) {
    ArrayList<Integer>[] adjacencyList = (ArrayList<Integer>[]) new ArrayList[numCourses];
    int[] inDegree = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      adjacencyList[i] = new ArrayList<>();
    }
    for (int[] edge : prerequisites) {
      int u = edge[0];
      int v = edge[1];
      adjacencyList[v].add(u);
      inDegree[u]++;
    }
    return topologicalSortCheck(numCourses, adjacencyList, inDegree);
  }

  private boolean topologicalSortCheck(int numCourses, ArrayList<Integer>[] adjacencyList, int[] inDegree) {
    int count = 0;
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (inDegree[i] == 0) {
        count++;
        queue.add(i);
      }
    }
    while (!queue.isEmpty()) {
      int u = queue.poll();
      for (int v : adjacencyList[u]) {
        inDegree[v]--;
        if (inDegree[v] == 0) {
          queue.add(v);
          count++;
        }
      }
    }
    return count == numCourses;
  }
}