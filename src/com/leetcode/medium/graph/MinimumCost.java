package com.leetcode.medium.graph;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    27/07/24,
 * Time:    10:51 am
 * 2976. Minimum Cost to Convert String I
 * https://leetcode.com/problems/minimum-cost-to-convert-string-i/description/?envType=daily-question&envId=2024-07-27
 */
public class MinimumCost {
    public static void main(String[] args) {
        MinimumCost minimumCost = new MinimumCost();
        String source = "abcd", target = "acbe";
        char[] original = {'a', 'b', 'c', 'c', 'e', 'd'};
        char[] changed = {'b', 'c', 'b', 'e', 'b', 'e'};
        int[] cost = new int[] {2, 5, 5, 1, 2, 20};
        System.out.println(minimumCost.minimumCost(source, target, original, changed, cost));
    }

    private long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] distances = new long[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }
        floydWarshall(original, changed, distances, cost);
        Long result = 0L;
        int n = source.length();
        for (int i = 0; i < n; i++) {
            int sourceNode = source.charAt(i) - 'a';
            int targetNode = target.charAt(i) - 'a';
            if (sourceNode == targetNode) {
                continue;
            }
            if (distances[sourceNode][targetNode] == Integer.MAX_VALUE) {
                return -1;
            }
            result += distances[sourceNode][targetNode];
        }
        return result;
    }

    private void floydWarshall(char[] original, char[] changed, long[][] distances, int[] cost) {
        int n = cost.length;
        for (int i = 0; i < n; i++) {
            int source = original[i] - 'a';
            int destination = changed[i] - 'a';
            distances[source][destination] = Math.min((long)cost[i], distances[source][destination]);
        }
        for (int via = 0; via < 26; via++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    distances[i][j] = Math.min(distances[i][j], distances[i][via] + distances[via][j]);
                }
            }
        }
    }
}