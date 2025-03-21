package com.leetcode.medium.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/10/23,
 * Time:    9:18am
 */
public class FindDuplicateContent {
  public static void main(String[] args) {
    FindDuplicateContent findDuplicateContent = new FindDuplicateContent();
    String[] paths =
        {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)",
            "root 4.txt(efgh)"};
    List<List<String>> duplicateContents = findDuplicateContent.findDuplicateContent(paths);
  }

  private List<List<String>> findDuplicateContent(String[] paths) {
    List<List<String>> duplicateContents = new ArrayList<>();
    Map<String, List<String>> contentToPathsMap = new HashMap<>();
    for (String path : paths) {
      String[] pathArray = path.split(" ");
      String directory = pathArray[0];
      int directorySize = pathArray.length;
      for (int i = 1; i < directorySize; i++) {
        String pathString = pathArray[i];
        String[] pathStringArray = pathString.split("\\(");
        String fileName = pathStringArray[0];
        String content = pathStringArray[1];
        content = content.substring(0, content.length() - 1);
        String completePath = directory + "/" + fileName;
        List<String> pathList = new ArrayList<>();
        if (contentToPathsMap.containsKey(content)) {
          pathList = contentToPathsMap.get(content);
        }
        pathList.add(completePath);
        contentToPathsMap.put(content, pathList);
      }
    }
    for (Map.Entry<String, List<String>> entry : contentToPathsMap.entrySet()) {
      String content = entry.getKey();
      List<String> pathList = entry.getValue();
      if (pathList.size() > 1) {
        duplicateContents.add(pathList);
      }
    }
    return duplicateContents;
  }
}