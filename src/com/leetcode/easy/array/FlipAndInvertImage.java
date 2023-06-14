package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    14/06/23,
 * Time:    8:52 pm
 * https://leetcode.com/problems/flipping-an-image/
 */
public class FlipAndInvertImage {
  public static void main(String[] args) {
    FlipAndInvertImage flipAndInvertImage = new FlipAndInvertImage();
    int[][] image = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
    image = flipAndInvertImage.flipAndInvertImage(image);
    ArrayUtils.printMatrix(image);
  }

  private int[][] flipAndInvertImage(int[][] image) {
    int size = image[0].length;
    for (int i = 0; i < size; i++) {
      for (int j = 0, k = size - 1; j < size / 2; j++, k--) {
        int t = image[i][j];
        image[i][j] = image[i][k];
        image[i][k] = t;
      }
    }
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (image[i][j] == 1) {
          image[i][j] = 0;
        } else {
          image[i][j] = 1;
        }
      }
    }
    return image;
  }
}