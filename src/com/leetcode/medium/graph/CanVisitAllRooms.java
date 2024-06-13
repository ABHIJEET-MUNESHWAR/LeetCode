package com.leetcode.medium.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    13/06/24,
 * Time:    11:25 am
 * 841. Keys and Rooms
 * https://leetcode.com/problems/keys-and-rooms/description/
 */
public class CanVisitAllRooms {
  public static void main(String[] args) {
    CanVisitAllRooms canVisitAllRooms = new CanVisitAllRooms();
    List<List<Integer>> rooms = new ArrayList<>();
    List<Integer> room1 = new ArrayList<>();
    room1.add(1);
    room1.add(3);
    rooms.add(room1);
    List<Integer> room2 = new ArrayList<>();
    room2.add(3);
    room2.add(0);
    room2.add(1);
    rooms.add(room2);
    List<Integer> room3 = new ArrayList<>();
    room3.add(2);
    rooms.add(room3);
    List<Integer> room4 = new ArrayList<>();
    room4.add(0);
    rooms.add(room4);
    System.out.println(canVisitAllRooms.canVisitAllRooms(rooms));
  }

  private boolean canVisitAllRooms(List<List<Integer>> rooms) {
    int totalRooms = rooms.size();
    boolean[] visited = new boolean[totalRooms];
    //dfs(rooms, 0, visited);
    bfs(rooms, 0, visited);
    for (int i = 1; i < totalRooms; i++) {
      if (!visited[i]) {
        return false;
      }
    }
    return true;
  }

  private void bfs(List<List<Integer>> rooms, int source, boolean[] visited) {
    visited[source] = true;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(source);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int cur = queue.poll();
        for (int next : rooms.get(cur)) {
          if (!visited[next]) {
            queue.add(next);
            visited[next] = true;
          }
        }
      }
    }
  }

  private void dfs(List<List<Integer>> rooms, int source, boolean[] visited) {
    visited[source] = true;
    for (int next : rooms.get(source)) {
      if (!visited[next]) {
        dfs(rooms, next, visited);
      }
    }
  }
}