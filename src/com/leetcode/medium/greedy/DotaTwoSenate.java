package com.leetcode.medium.greedy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    14/07/24,
 * Time:    9:25 am
 */
public class DotaTwoSenate {
    public static void main(String[] args) {
        DotaTwoSenate dotaTwoSenate = new DotaTwoSenate();
        String senate = "RDD";
        System.out.println(dotaTwoSenate.predictPartyVictory(senate));
        System.out.println(dotaTwoSenate.predictPartyVictoryUsingQueue(senate));
    }

    private String predictPartyVictoryUsingQueue(String senate) {
        char[] senates = senate.toCharArray();
        int n = senates.length;
        Queue<Integer> radiantQueue = new LinkedList<>();
        Queue<Integer> direQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (senates[i] == 'R') {
                radiantQueue.add(i);
            } else {
                direQueue.add(i);
            }
        }
        while (!radiantQueue.isEmpty() && !direQueue.isEmpty()) {
            if (radiantQueue.peek() < direQueue.peek()) {
                radiantQueue.add(n++);
            } else {
                direQueue.add(n++);
            }
            direQueue.poll();
            radiantQueue.poll();
        }
        return radiantQueue.isEmpty() ? "Dire" : "Radiant";
    }

    private String predictPartyVictory(String senate) {
        char[] chars = senate.toCharArray();
        int r = 0, d = 0;
        int n = chars.length;
        for (char ch : chars) {
            if (ch == 'R') {
                r++;
            } else {
                d++;
            }
        }
        int startIndex = 0;
        while (r > 0 && d > 0) {
            while (chars[startIndex] == ' ') {
                startIndex = (startIndex + 1) % n;
            }
            char ban = 'R';
            if (chars[startIndex] == 'R') {
                ban = 'D';
                d--;
            } else {
                r--;
            }
            int nextIndex = (startIndex + 1) % n;
            while (chars[nextIndex] != ban) {
                nextIndex = (nextIndex + 1) % n;
            }
            chars[nextIndex] = ' ';
            startIndex = (startIndex + 1) % n;
        }
        return r > 0 ? "Radiant" : "Dire";
    }
}