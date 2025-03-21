package com.leetcode.medium.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    20/07/24,
 * Time:    7:39 pm
 * 451. Sort Characters By Frequency
 * https://leetcode.com/problems/sort-characters-by-frequency/description/
 */
public class FrequencySort {
    public static void main(String[] args) {
        FrequencySort frequencySort = new FrequencySort();
        String s = "tree";
        System.out.println(frequencySort.frequencySort(s));
    }

    class Pair {
        int frequency;
        Character character;

        public Pair(int frequency, Character character) {
            this.frequency = frequency;
            this.character = character;
        }
    }

    private String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o2.frequency - o1.frequency);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(new Pair(entry.getValue(), entry.getKey()));
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int frequency = pair.frequency;
            Character character = pair.character;
            while (frequency-- > 0) {
                sb.append(character);
            }
        }
        return sb.toString();
    }
}