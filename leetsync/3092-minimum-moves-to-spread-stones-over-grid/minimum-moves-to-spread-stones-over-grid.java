class Solution {
    private int solve(int[][] grid, List<Pair<Integer, Integer>> zeros, List<Pair<Integer, Integer>> extras,
            int currIndex) {
        if (currIndex == zeros.size()) {
            return 0;
        }

        int n = extras.size();
        int currZeroX = zeros.get(currIndex).getKey();
        int currZeroY = zeros.get(currIndex).getValue();
        int ans = 1000000;
        for (int i = 0; i < n; i++) {
            int currX = extras.get(i).getKey();
            int currY = extras.get(i).getValue();
            if (grid[currX][currY] > 1) {
                // do
                grid[currX][currY]--;
                grid[currZeroX][currZeroY] = 1;
                ans = Math.min(ans, Math.abs(currZeroX - currX) + Math.abs(currZeroY - currY)
                        + solve(grid, zeros, extras, currIndex + 1));

                // undo
                grid[currX][currY]++;
                grid[currZeroX][currZeroY] = 0;
            }
        }
        return ans;
    }

    public int minimumMoves(int[][] grid) {
        List<Pair<Integer, Integer>> zeros, extras;
        zeros = new ArrayList<>();
        extras = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 0) {
                    zeros.add(new Pair(i, j));
                } else if (grid[i][j] > 1) {
                    extras.add(new Pair(i, j));
                }
            }
        }

        return solve(grid, zeros, extras, 0);
    }
}