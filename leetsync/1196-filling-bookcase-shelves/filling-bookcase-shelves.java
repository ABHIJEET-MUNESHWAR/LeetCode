class Solution {

    int totalShelfWidth;
    int[][] dp;

    public int minHeightShelves(int[][] books, int shelfWidth) {
        int index = 0;
        int maxHeight = 0;
        totalShelfWidth = shelfWidth;
        dp = new int[1001][1001];
        for (int i = 0; i < 1001; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solveMemoization(books, shelfWidth, index, maxHeight);
    }

    private int solveMemoization(int[][] books, int remainingWidth, int index, int maxHeight) {
        if (index >= books.length) {
            return maxHeight;
        }

        if (dp[index][remainingWidth] != -1) {
            return dp[index][remainingWidth];
        }

        int width = books[index][0];
        int height = books[index][1];

        int keep = Integer.MAX_VALUE;
        int skip = Integer.MAX_VALUE;

        // keep
        if (width <= remainingWidth) {
            keep = solveMemoization(books, remainingWidth - width, index + 1, Math.max(maxHeight, height));
        }

        // skip and put in next shelf
        skip = maxHeight + solveMemoization(books, totalShelfWidth - width, index + 1, height);
        return dp[index][remainingWidth] = Math.min(keep, skip);
    }
}