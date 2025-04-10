package com.leetcode.hard.stack;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    13/07/24,
 * Time:    1:34 pm
 * 2751. Robot Collisions
 * https://leetcode.com/problems/robot-collisions/description/?envType=daily-question&envId=2024-07-13
 */
public class RobotCollisions {
    public static void main(String[] args) {
        RobotCollisions robotCollisions = new RobotCollisions();
        int[] positions = {5, 4, 3, 2, 1};
        int[] healths = {2, 17, 9, 15, 10};
        String directions = "RRRRR";
        ListUtils.printList(robotCollisions.robotCollisions(positions, healths, directions));
    }

    private List<Integer> robotCollisions(int[] positions, int[] healths, String directions) {
        List<Integer> result = new ArrayList<>();
        int n = positions.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(indices, (i, j) -> Integer.compare(positions[i], positions[j]));
        for (int currentIndex : indices) {
            if (directions.charAt(currentIndex) == 'R') {
                stack.push(currentIndex);
            } else {
                while (!stack.isEmpty() && healths[currentIndex] > 0) {
                    int topIndex = stack.pop();
                    if (healths[topIndex] > healths[currentIndex]) {
                        healths[topIndex]--;
                        healths[currentIndex] = 0;
                        stack.push(topIndex);
                    } else if (healths[topIndex] < healths[currentIndex]) {
                        healths[currentIndex]--;
                        healths[topIndex] = 0;
                    } else {
                        healths[currentIndex] = 0;
                        healths[topIndex] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                result.add(healths[i]);
            }
        }
        return result;
    }
}