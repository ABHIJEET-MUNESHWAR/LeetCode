package com.leetcode.medium.simulation;

import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    04/09/24,
 * Time:    8:59 pm
 * 874. Walking Robot Simulation
 * https://leetcode.com/problems/walking-robot-simulation/description/
 */
public class RobotSimulation {
    public static void main(String[] args) {
        RobotSimulation robotSimulation = new RobotSimulation();
        int[] commands = {4, -1, 3};
        int[][] obstacles = new int[][] {};
        System.out.println(robotSimulation.robotSim(commands, obstacles));
    }

    private int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            String key = obs[0] + "_" + obs[1];
            obstacleSet.add(key);
        }
        int x = 0, y = 0;
        int maxDistance = 0;
        // Pointing to north
        int[] dir = new int[] {0, 1}; // North
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -2) {
                // Turn left by 90 degree
                dir = new int[] {-dir[1], dir[0]};
            } else if (commands[i] == -1) {
                // Turn right by 90 degree
                dir = new int[] {dir[1], -dir[0]};
            } else {
                // move forward step by step
                for (int step = 0; step < commands[i]; step++) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    String nextKey = newX + "_" + newY;
                    // If there's an obstacle, stop moving in this direction
                    if (obstacleSet.contains(nextKey)) {
                        break;
                    }
                    // Move to the new position
                    x = newX;
                    y = newY;
                }
            }
            // Update the maximum distance from the origin
            maxDistance = Math.max(maxDistance, x * x + y * y);
        }
        return maxDistance;
    }
}