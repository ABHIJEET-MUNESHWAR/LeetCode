class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int N = n * n;
        Map<Integer, Integer> map = new HashMap<>();
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map.put(grid[i][j], map.getOrDefault(grid[i][j], 0) + 1);
            }
        }
        for (int i = 1; i <= N; i++) {
            if (!map.containsKey(i)) {
                b = i;
            } else if (map.get(i) == 2) {
                a = i;
            }
        }
        return new int[] { a, b };
    }
}