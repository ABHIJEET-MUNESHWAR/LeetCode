package com.leetcode.medium.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    11/07/24,
 * Time:    9:59 pm
 * 2024. Maximize the Confusion of an Exam
 * https://leetcode.com/problems/maximize-the-confusion-of-an-exam/description/
 */
public class MaxConsecutiveAnswers {
    public static void main(String[] args) {
        MaxConsecutiveAnswers maxConsecutiveAnswers = new MaxConsecutiveAnswers();
        String answerKey = "TTFTTFTT";
        int k = 1;
        System.out.println(maxConsecutiveAnswers.maxConsecutiveAnswers(answerKey, k));
        System.out.println(maxConsecutiveAnswers.maxConsecutiveAnswersSlidingWindow(answerKey, k));
    }

    private int maxConsecutiveAnswersSlidingWindow(String answerKey, int k) {
        int result = 0;
        Map<Character, Integer> charToFrequencyMap = new HashMap<>();
        int n = answerKey.length();
        int left = 0;
        int right = 0;
        while (right < n) {
            Character rightChar = answerKey.charAt(right);
            charToFrequencyMap.put(rightChar, charToFrequencyMap.getOrDefault(rightChar, 0) + 1);
            while (Math.min(charToFrequencyMap.getOrDefault('T', 0), charToFrequencyMap.getOrDefault('F', 0)) > k) {
                Character leftChar = answerKey.charAt(left);
                charToFrequencyMap.put(leftChar, charToFrequencyMap.getOrDefault(leftChar, 0) - 1);
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }

    private int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int result = 0;
        int left = 0;
        int right = 0;
        int countF = 0;
        while (right < n) {
            if (answerKey.charAt(right) == 'F') {
                countF++;
            }
            while (countF > k) {
                if (answerKey.charAt(left) == 'F') {
                    countF--;
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        left = 0;
        right = 0;
        int countT = 0;
        while (right < n) {
            if (answerKey.charAt(right) == 'T') {
                countT++;
            }
            while (countT > k) {
                if (answerKey.charAt(left) == 'T') {
                    countT--;
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}