package com.leetcode.hard.backtracking;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    24/05/24,
 * Time:    12:09 pm
 * 1255. Maximum Score Words Formed by Letters
 * https://leetcode.com/problems/maximum-score-words-formed-by-letters/description/?envType=daily-question&envId=2024-05-24
 */
public class MaximumScoreWordsFormedByLetters {
  public static void main(String[] args) {
    MaximumScoreWordsFormedByLetters maximumScoreWordsFormedByLetters = new MaximumScoreWordsFormedByLetters();
    String[] words = {"dog", "cat", "dad", "good"};
    char[] letters = {'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'};
    int[] score = {1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    System.out.println(maximumScoreWordsFormedByLetters.maxScoreWords(words, letters, score));
  }

  int maxScore = Integer.MIN_VALUE;

  private int maxScoreWords(String[] words, char[] letters, int[] score) {
    int[] frequencyMap = new int[26];
    for (char c : letters) {
      frequencyMap[c - 'a']++;
    }
    solve(words, 0, score, 0, frequencyMap);
    return maxScore;
  }

  private void solve(String[] words, int index, int[] score, int currentScore, int[] frequencyMap) {
    maxScore = Math.max(maxScore, currentScore);
    if (index >= words.length) {
      return;
    }
    // can we take word[index]
    int j = 0;
    int tempScore = 0;
    int[] tempFrequencyMap = new int[26];
    for (int i = 0; i < 26; i++) {
      tempFrequencyMap[i] = frequencyMap[i];
    }
    while (j < words[index].length()) {
      char c = words[index].charAt(j);
      tempFrequencyMap[c - 'a']--;
      tempScore += score[c - 'a'];
      if (tempFrequencyMap[c - 'a'] < 0) {
        break;
      }
      j++;
    }
    if (j == words[index].length()) {
      // we were able to form this word words[i]
      // Take option
      solve(words, index + 1, score, currentScore + tempScore, tempFrequencyMap);
    }
    // Skip
    solve(words, index + 1, score, currentScore, frequencyMap);
  }
}