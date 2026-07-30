class Solution {
    int[][] directions = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacificBoolean = new boolean[m][n];
        boolean[][] atlanticBoolean = new boolean[m][n];
        boolean[][] pacificVisited = new boolean[m][n];
        boolean[][] atlanticVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            pacificBoolean[i][0] = true;
            atlanticBoolean[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            pacificBoolean[0][j] = true;
            atlanticBoolean[m - 1][j] = true;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificBoolean[i][j]) {
                    pacificAtlanticDFS(heights, pacificBoolean, pacificVisited, i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (atlanticBoolean[i][j]) {
                    pacificAtlanticDFS(heights, atlanticBoolean, atlanticVisited, i, j);
                }
            }
        }
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificBoolean[i][j] && atlanticBoolean[i][j]) {
                    resultList.add(Arrays.asList(i, j));
                }
            }
        }
        return resultList;
    }

    public void pacificAtlanticDFS(int[][] heights, boolean[][] oceanBoolean, boolean[][] visited, int i, int j) {
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        int m = heights.length;
        int n = heights[0].length;
        for (int[] direction : directions) {
            int i_ = i + direction[0];
            int j_ = j + direction[1];
            if (i_ >= 0 && i_ < m && j_ >= 0 && j_ < n && !oceanBoolean[i_][j_] && heights[i_][j_] >= heights[i][j]) {
                oceanBoolean[i_][j_] = true;
                pacificAtlanticDFS(heights, oceanBoolean, visited, i_, j_);
            }
        }
    }
}