package com.leetcode.medium.bit;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    28/06/24,
 * Time:    7:16 pm
 * 779. K-th Symbol in Grammar
 * https://leetcode.com/problems/k-th-symbol-in-grammar/description/
 */
public class KthSymbolInGrammar {
  public static void main(String[] args) {
    KthSymbolInGrammar kthSymbolInGrammar = new KthSymbolInGrammar();
    int n = 1, k = 1;
    System.out.println(kthSymbolInGrammar.kthGrammar(n, k));
  }

  private int kthGrammar(int n, int k) {
    if (n == 1 && k == 1) {
      return 0;
    }
    int mid = (int) Math.pow(2, n - 1) / 2;
    if (k <= mid) {
      return kthGrammar(n - 1, k);
    } else {
      return 1 - kthGrammar(n - 1, k - mid);
    }
  }
}