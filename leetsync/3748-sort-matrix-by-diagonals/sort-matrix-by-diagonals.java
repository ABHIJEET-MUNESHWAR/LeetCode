class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Collect diagonal elements (i - j as the key)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int diagonal = i - j;
                map.computeIfAbsent(diagonal, k -> new ArrayList<>()).add(grid[i][j]);
            }
        }
        // Sort diagonals: non-decreasing for diag >= 0, non-increasing for diag < 0
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            if (entry.getKey() >= 0) {
                Collections.sort(list);
            } else {
                list.sort(Collections.reverseOrder());
            }
        }

        // Fill grid back using elements from the map
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int diagonal = i - j;
                List<Integer> list = map.get(diagonal);
                grid[i][j] = list.remove(list.size() - 1); // Take from raer of list to have O(1) time complexity
            }
        }
        return grid;
    }
}