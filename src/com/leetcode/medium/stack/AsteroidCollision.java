package com.leetcode.medium.stack;

import com.leetcode.utils.ArrayUtils;
import java.util.Stack;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    14/04/24,
 * Time:    8:33 am
 * https://leetcode.com/problems/asteroid-collision/
 */
public class AsteroidCollision {
  public static void main(String[] args) {
    AsteroidCollision asteroidCollision = new AsteroidCollision();
//    int[] asteroids = {10, 2, -5};
//    int[] asteroids = {-2, -10, 5};
//    int[] asteroids = {5, 10, -5};
    int[] asteroids = {-2, -2, 1, -2};
    ArrayUtils.printArray(asteroidCollision.asteroidCollision(asteroids));
  }

  private int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();
    for (int asteroid : asteroids) {
      if (asteroid > 0) {
        // asteroid is positive
        stack.push(asteroid);
      } else {
        // asteroid is negative
        while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
          stack.pop();
        }
        if (stack.isEmpty() || stack.peek() < 0) {
          stack.push(asteroid);
        } else if ((stack.peek() + asteroid) == 0) {
          stack.pop();
        }
      }
    }
    int[] answer = new int[stack.size()];
    for (int i = answer.length - 1; i >= 0; i--) {
      answer[i] = stack.pop();
    }
    return answer;
  }
}