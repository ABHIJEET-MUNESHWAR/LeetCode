class Solution {
    int[][] direction = { { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }, { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 } };

    Map<String, Double> dpMap = new HashMap<>();

    public double knightProbability(int n, int k, int row, int column) {
        return solveRecursionMemoization(n, k, row, column);
    }

    private double solveRecursionMemoization(int n, int k, int row, int column) {
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        String key = "row_" + row + "_column_" + column + "_key_" + k;
        if (dpMap.containsKey(key)) {
            return dpMap.get(key);
        }
        double result = 0;
        for (int[] direction : direction) {
            result += (double) solveRecursionMemoization(n, k - 1, row + direction[0], column + direction[1]);
        }
        dpMap.put(key, (double) result / 8.0);
        return (double) result / 8.0;
    }
}