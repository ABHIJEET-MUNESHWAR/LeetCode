package com.leetcode.easy.stack;

import java.util.Stack;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    10/07/24,
 * Time:    7:09 am
 * 1598. Crawler Log Folder
 * https://leetcode.com/problems/crawler-log-folder/description/?envType=daily-question&envId=2024-07-10
 */
public class CrawlerLogFolder {
  public static void main(String[] args) {
    CrawlerLogFolder crawlerLogFolder = new CrawlerLogFolder();
    String[] logs = {"d1/", "d2/", "../", "d21/", "./"};
    System.out.println(crawlerLogFolder.minOperationsUsingStack(logs));
    System.out.println(crawlerLogFolder.minOperationsOptimised(logs));
  }

  private int minOperationsOptimised(String[] logs) {
    int depth = 0;
    for (String log : logs) {
      if (log.equals("../")) {
        depth = Math.max(0, depth - 1);
      } else if (!log.equals("./")) {
        depth++;
      }
    }
    return depth;
  }

  private int minOperationsUsingStack(String[] logs) {
    Stack<String> stack = new Stack<>();
    for (String log : logs) {
      switch (log) {
        case "../":
          if (!stack.isEmpty()) {
            stack.pop();
          }
          break;
        case "./":
          break;
        default:
          stack.push(log);
      }
    }
    return stack.size();
  }
}