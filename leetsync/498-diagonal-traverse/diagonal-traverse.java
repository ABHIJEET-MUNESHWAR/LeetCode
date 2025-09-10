class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        // Use HashMap to store diagonals
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Fill the map with diagonals
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i + j;
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(mat[i][j]);
            }
        }

        List<Integer> resultList = new ArrayList<>();
        boolean flip = true;

        // Process diagonals in increasing order of keys
        for (int k = 0; k <= m + n - 2; k++) {
            List<Integer> diagonal = map.get(k);
            if (diagonal == null) {
                continue;
            }
            if (flip) {
                Collections.reverse(diagonal);
            }
            resultList.addAll(diagonal);
            flip = !flip;
        }

        // Convert result list to array
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}