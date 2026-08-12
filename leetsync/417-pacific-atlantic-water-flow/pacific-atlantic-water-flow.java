class Solution {
    int[][] directions = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> resultList = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacificHeight = new boolean[m][n];
        boolean[][] atlanticHeight = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            dfs(heights, pacificHeight, m, n, 0, i);
            dfs(heights, atlanticHeight, m, n, m - 1, i);
        }
        for (int j = 0; j < m; j++) {
            dfs(heights, pacificHeight, m, n, j, 0);
            dfs(heights, atlanticHeight, m, n, j, n - 1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificHeight[i][j] && atlanticHeight[i][j]) {
                    resultList.add(Arrays.asList(i, j));
                }
            }
        }
        return resultList;
    }

    public void dfs(int[][] heights, boolean[][] oceanHeight, int m, int n, int i, int j) {
        if (oceanHeight[i][j]) {
            return;
        }
        oceanHeight[i][j] = true;
        for (int[] direction : directions) {
            int i_ = i + direction[0];
            int j_ = j + direction[1];
            if (i_ >= 0 && j_ >= 0 && i_ < m && j_ < n && heights[i][j] <= heights[i_][j_]) {
                dfs(heights, oceanHeight, m, n, i_, j_);
            }
        }
    }
}