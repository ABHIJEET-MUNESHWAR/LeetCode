//Approach -1 (Binary Search + DFS) Time : O(n^2 * log(n))
//NOTE - In the paths, we have to find the maximum from the minimum path (Minimize the Maximum hints towards Binary Search)
//T.C : O(n^2 * log(n^2)) = O(n^2 log n)
//S.C : O(n^2) for visited

class Solution {
    int n;
    int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    boolean[][] visited;

    public int swimInWater(int[][] grid) {
        n = grid.length;
        int l = grid[0][0], r = n * n - 1;
        int result = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            visited = new boolean[n][n];
            if (isReachable(grid, 0, 0, mid)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }

    public boolean isReachable(int[][] grid, int i, int j, int mid) {
        if (i < 0 || j < 0 || i >= n || j >= n || visited[i][j] || grid[i][j] > mid) {
            return false;
        }
        visited[i][j] = true;
        if (i == n - 1 && j == n - 1) {
            return true;
        }
        for (int[] dir : directions) {
            int i_ = i + dir[0];
            int j_ = j + dir[1];
            if (isReachable(grid, i_, j_, mid)) {
                return true;
            }
        }
        return false;
    }
}