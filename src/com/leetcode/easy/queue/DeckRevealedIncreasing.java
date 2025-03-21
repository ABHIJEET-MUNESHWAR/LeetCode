package com.leetcode.easy.queue;

import com.leetcode.utils.ArrayUtils;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    10/04/24,
 * Time:    10:37 pm
 * https://leetcode.com/problems/reveal-cards-in-increasing-order/description/?envType=daily-question&envId=2024-04-10
 */
public class DeckRevealedIncreasing {
  public static void main(String[] args) {
    DeckRevealedIncreasing deckRevealedIncreasing = new DeckRevealedIncreasing();
    int[] deck = {17, 13, 11, 2, 3, 5, 7};
    ArrayUtils.printArray(deckRevealedIncreasing.deckRevealedIncreasing(deck));
  }

  private int[] deckRevealedIncreasing(int[] deck) {
    int size = deck.length;
    Arrays.sort(deck);
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < size; i++) {
      queue.add(i);
    }
    int[] answer = new int[size];
    for (int i = 0; i < size; i++) {
      answer[queue.poll()] = deck[i];
      queue.add(queue.poll());
    }
    return answer;
  }
}