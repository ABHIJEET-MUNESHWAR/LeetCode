package com.leetcode.companies.meta.practice.heap;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   13-04-2025
    Time:   09:39 am
    767. Reorganize String
    https://leetcode.com/problems/reorganize-string/description/
*/

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    public static void main(String[] args) {
        ReorganizeString reorganizeString = new ReorganizeString();
        String s = "aab";
        System.out.println(reorganizeString.reorganizeString(s)); // Output: "aba"
        System.out.println(reorganizeString.reorganizeStringTwo(s)); // Output: "aba"
    }

    private String reorganizeStringTwo(String s) {
        int n = s.length();
        char[] result = new char[n];
        int[] freq = new int[26];
        int maxOccFreq = 0;
        char maxOccChar = '$';
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
            if (freq[ch - 'a'] > ((n + 1) / 2)) {
                return "";
            }
            if (maxOccFreq < freq[ch - 'a']) {
                maxOccFreq = freq[ch - 'a'];
                maxOccChar = ch;
            }
        }
        int j = 0;
        while (maxOccFreq-- > 0) {
            result[j] = maxOccChar;
            j += 2;
            freq[maxOccChar - 'a']--;
        }
        for (char i = 'a'; i <= 'z'; i++) {
            while (freq[i - 'a'] > 0) {
                if (j > n - 1) {
                    j = 1;
                }
                result[j] = i;
                j += 2;
                freq[i - 'a']--;
            }
        }
        return new String(result);
    }

    public String reorganizeString(String s) {
        Map<Character, Integer> freqToCharMap = new HashMap<>();
        int n = s.length();
        for (char ch : s.toCharArray()) {
            int freq = freqToCharMap.getOrDefault(ch, 0) + 1;
            if (freq > ((n + 1) / 2)) {
                return "";
            }
            freqToCharMap.put(ch, freq);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (Map.Entry<Character, Integer> entry : freqToCharMap.entrySet()) {
            char ch = entry.getKey();
            int freq = entry.getValue();
            pq.add(new int[]{freq, ch});
        }
        StringBuilder sb = new StringBuilder();
        while (pq.size() >= 2) {
            int[] first = pq.poll();
            int[] second = pq.poll();
            sb.append((char) first[1]);
            sb.append((char) second[1]);
            first[0]--;
            second[0]--;
            if (first[0] > 0) {
                pq.add(first);
            }
            if (second[0] > 0) {
                pq.add(second);
            }
        }
        if (!pq.isEmpty()) {
            int[] first = pq.poll();
            sb.append((char) first[1]);
        }
        return sb.toString();
    }
}
