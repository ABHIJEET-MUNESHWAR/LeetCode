class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int r = grid.length;
        int c = grid[0].length;
        int n = r * c;
        k = k % n;
        List<List<Integer>> result = new ArrayList<>();
        if (k != 0) {
            reverse(grid, 0, n - 1, c);
            reverse(grid, 0, k - 1, c);
            reverse(grid, k, n - 1, c);
        }

        for (int i = 0; i < r; i++) {
            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < c; j++) {
                rowList.add(grid[i][j]);
            }
            result.add(rowList);
        }
        return result;
    }

    public void reverse(int[][] grid, int i, int j, int col) {
        while (i < j) {
            int t = grid[i / col][i % col];
            grid[i / col][i % col] = grid[j / col][j % col];
            grid[j / col][j % col] = t;
            i++;
            j--;
        }
    }
}