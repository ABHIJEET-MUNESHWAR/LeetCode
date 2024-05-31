package com.leetcode.medium.stack;

import java.util.Stack;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    01/06/24,
 * Time:    1:48 am
 * 71. Simplify Path
 * https://leetcode.com/problems/simplify-path/description/
 */
public class SimplifyPath {
  public static void main(String[] args) {
    SimplifyPath simplifyPath = new SimplifyPath();
    String path = "/.../a/../b/c/../d/./";
    System.out.println(simplifyPath.simplifyPath(path));
    System.out.println(simplifyPath.simplifyPathStringBuilder(path));
  }

  private String simplifyPathStringBuilder(String path) {
    String[] split = path.split("/");
    int size = split.length;
    String[] stack = new String[size];
    int pointer = 0;
    for (int i = 0; i < size; i++) {
      if (split[i].equals(".") || split[i].equals("")) {
        continue;
      }
      if (split[i].equals("..")) {
        if (pointer > 0) {
          pointer--;
        }
      } else {
        stack[pointer] = split[i];
        pointer++;
      }
    }
    String result = "";
    for (int i = 0; i < pointer; i++) {
      result += "/" + stack[i];
    }
    return result.length() == 0 ? "/" : result;
  }

  private String simplifyPath(String path) {
    String[] split = path.split("/");
    int size = split.length;
    Stack<String> stack = new Stack<>();
    for (int i = 0; i < size; i++) {
      if (split[i].equals(".") || split[i].equals("")) {
        continue;
      }
      if (split[i].equals("..")) {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else {
        stack.push(split[i]);
      }
    }
    if (stack.isEmpty()) {
      return "/";
    }
    String result = "";
    while (!stack.isEmpty()) {
      result = "/" + stack.peek() + result;
      stack.pop();
    }
    return result;
  }
}