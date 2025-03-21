package com.leetcode.medium.trie;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    05/06/24,
 * Time:    9:07 am
 * 421. Maximum XOR of Two Numbers in an Array
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/description/
 */
public class FindMaximumXOR {
  public static void main(String[] args) {
    FindMaximumXOR findMaximumXOR = new FindMaximumXOR();
    int[] nums = {3, 10, 5, 25, 2, 8};
    System.out.println(findMaximumXOR.findMaximumXORBruteForce(nums));
    System.out.println(findMaximumXOR.findMaximumXORTrie(nums));
  }

  private int findMaximumXORBruteForce(int[] nums) {
    int size = nums.length;
    int maxXor = 0;
    for (int i = 0; i < size; i++) {
      for (int j = i + 1; j < size; j++) {
        maxXor = Math.max(maxXor, nums[i] ^ nums[j]);
      }
    }
    return maxXor;
  }

  class TrieNode {
    TrieNode left;
    TrieNode right;
  }

  public void insert(TrieNode root, int data) {
    TrieNode crawl = root;
    for (int i = 31; i >= 0; i--) {
      int bit = (data >> i) & 1;
      if (bit == 0) {
        if (crawl.left == null) {
          crawl.left = new TrieNode();
        }
        crawl = crawl.left;
      } else {
        if (crawl.right == null) {
          crawl.right = new TrieNode();
        }
        crawl = crawl.right;
      }
    }
  }

  private int findMaximumXORTrie(int[] nums) {
    int maxXor = 0;
    TrieNode root = new TrieNode();
    for (int num : nums) {
      insert(root, num);
    }
    for (int num : nums) {
      maxXor = Math.max(maxXor, maxXor(root, num));
    }
    return maxXor;
  }

  private int maxXor(TrieNode root, int num) {
    int maxXor = 0;
    TrieNode crawl = root;
    for (int i = 31; i >= 0; i--) {
      int ithBit = (num >> i) & 1;
      if (ithBit == 1) {
        if (crawl.left != null) {
          maxXor += Math.pow(2, i);
          crawl = crawl.left;
        } else {
          crawl = crawl.right;
        }
      } else {
        if (crawl.right != null) {
          maxXor += Math.pow(2, i);
          crawl = crawl.right;
        } else {
          crawl = crawl.left;
        }
      }
    }
    return maxXor;
  }
}