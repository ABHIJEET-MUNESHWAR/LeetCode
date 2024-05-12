class Solution {
    public int[][] largestLocal(int[][] grid) {
        int[][] ans = new int[grid.length - 2][grid.length - 2];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans.length; j++) {
                int max = Integer.MIN_VALUE;
                for (int a = i; a < i + 3; a++) {
                    for (int b = j; b < j + 3; b++) {
                        if (max < grid[a][b]) {
                            max = grid[a][b];
                        }
                    }
                }
                ans[i][j] = max;
            }
        }
        return ans;

    }
}