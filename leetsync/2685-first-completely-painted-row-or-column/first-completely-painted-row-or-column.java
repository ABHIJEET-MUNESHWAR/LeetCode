class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int size = arr.length;
        int m = mat.length;
        int n = mat[0].length;
        int result = Integer.MAX_VALUE;
        Map<Integer, Integer> numToPositionMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            numToPositionMap.put(arr[i], i);
        }
        for (int i = 0; i < m; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                max = Math.max(max, numToPositionMap.get(mat[i][j]));
            }
            result = Math.min(result, max);
        }
        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                max = Math.max(max, numToPositionMap.get(mat[j][i]));
            }
            result = Math.min(result, max);
        }
        return result;
    }
}