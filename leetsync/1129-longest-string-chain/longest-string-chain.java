class Solution {

    int[][] dp;

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        dp = new int[1001][1001];
        for (int i = 0; i < 1001; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solveRecursionMemoization(words, -1, 0);
    }

    private int solveRecursionMemoization(String[] words, int previousIndex, int currentIndex) {
        if (currentIndex >= words.length) {
            return 0;
        }
        if (previousIndex != -1 && dp[previousIndex][currentIndex] != -1) {
            return dp[previousIndex][currentIndex];
        }
        int take = 0;
        if (previousIndex == -1 || isPredecessor(words[previousIndex], words[currentIndex])) {
            take = 1 + solveRecursionMemoization(words, currentIndex, currentIndex + 1);
        }
        int skip = solveRecursionMemoization(words, previousIndex, currentIndex + 1);
        if (previousIndex != -1) {
            dp[previousIndex][currentIndex] = Math.max(take, skip);
        }
        return Math.max(take, skip);
    }

    private boolean isPredecessor(String word1, String word2) {
        int size1 = word1.length();
        int size2 = word2.length();
        if ((size1 >= size2) || ((size2 - size1) > 1)) {
            return false;
        }
        int i = 0, j = 0;
        while (i < size1 && j < size2) {
            if (word1.charAt(i) == word2.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == size1;
    }
}