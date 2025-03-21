class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {

        int[] frequencyMap = new int[n];
        boolean[][] frequencyMatrix = new boolean[n][n];
        for (int[] road : roads) {
            frequencyMap[road[0]]++;
            frequencyMap[road[1]]++;
            frequencyMatrix[road[0]][road[1]] = true;
            frequencyMatrix[road[1]][road[0]] = true;
        }
        int maxRank = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int totalRank = frequencyMap[i] + frequencyMap[j];
                if (frequencyMatrix[i][j]) {
                    totalRank--;
                }
                maxRank = Math.max(maxRank, totalRank);
            }
        }
        return maxRank;
    }
}