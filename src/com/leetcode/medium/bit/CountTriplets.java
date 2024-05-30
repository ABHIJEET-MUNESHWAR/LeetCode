package com.leetcode.medium.bit;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    30/05/24,
 * Time:    2:52 pm
 */
public class CountTriplets {
  public static void main(String[] args) {
    CountTriplets countTriplets = new CountTriplets();
    int[] arr = {2, 3, 1, 6, 7};
    System.out.println(countTriplets.countTriplets(arr));
    System.out.println(countTriplets.countTripletsOptimised(arr));
  }

  private int countTripletsOptimised(int[] arr) {
    int size = arr.length;
    int[] prefixXor = new int[size + 1];

    // Initializing the first element to 0
    prefixXor[0] = 0;

    // Compute prefix XOR
    for (int i = 1; i <= size; i++) {
      prefixXor[i] = prefixXor[i - 1] ^ arr[i - 1];
    }
    int triplets = 0;
    for (int i = 0; i < prefixXor.length; i++) {
      for (int k = i + 1; k < prefixXor.length; k++) {
        if (prefixXor[i] == prefixXor[k]) {
          triplets += k - i - 1;
        }
      }
    }
    return triplets;
  }

  private int countTriplets(int[] arr) {
    int count = 0;
    int size = arr.length;
    for (int i = 0; i < size - 1; i++) {
      int temp1 = 0;
      for (int j = i + 1; j < size; j++) {
        temp1 ^= arr[j - 1];
        int temp2 = 0;
        for (int k = j; k < size; k++) {
          temp2 ^= arr[k];
          if (temp1 == temp2) {
            count++;
          }
        }
      }
    }
    return count;
  }
}