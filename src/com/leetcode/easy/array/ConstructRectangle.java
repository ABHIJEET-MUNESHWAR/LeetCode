package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    26/09/22, Time:    6:24 AM
 * https://leetcode.com/problems/construct-the-rectangle/
 */
public class ConstructRectangle {

  public static void main(String[] args) {
    ConstructRectangle constructRectangle = new ConstructRectangle();
    int[] dimension = constructRectangle.constructRectangle(122122);
    System.out.println(dimension);
  }

  private int[] constructRectangle(int area) {
    int w = (int) Math.sqrt(area);
    while (area % w != 0) {
      w--;
    }
    return new int[]{area / w, w};
  }
}