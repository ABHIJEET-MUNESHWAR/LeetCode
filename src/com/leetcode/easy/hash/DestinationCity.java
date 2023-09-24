package com.leetcode.easy.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    23/09/23,
 * Time:    11:35 am
 * https://leetcode.com/problems/destination-city/description/
 */
public class DestinationCity {
  public static void main(String[] args) {
    DestinationCity destinationCity = new DestinationCity();
    List<List<String>> paths = new ArrayList<>();
    List<String> path1 = new ArrayList<>();
    path1.add("London");
    path1.add("New York");
    paths.add(path1);
    List<String> path2 = new ArrayList<>();
    path2.add("New York");
    path2.add("Lima");
    paths.add(path2);
    List<String> path3 = new ArrayList<>();
    path3.add("Lima");
    path3.add("Sao Paulo");
    paths.add(path3);
    System.out.println(destinationCity.destinationCity(paths));
  }

  private String destinationCity(List<List<String>> paths) {
    String destination = "";
    Map<String, String> map = new HashMap<>();
    paths.forEach(path -> {
      map.put(path.get(0), path.get(1));
    });
    ListIterator<List<String>> iterator = paths.listIterator();
    while (iterator.hasNext()) {
      List<String> path = iterator.next();
      String source = path.get(0);
      while (map.containsKey(source)) {
        source = map.get(source);
      }
      return source;
    }
    return destination;
  }
}