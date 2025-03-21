class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                int element = matrix[i][j];
                if (rowSet.contains(element)) {
                    return false;
                } else {
                    rowSet.add(element);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                int element = matrix[j][i];
                if (colSet.contains(element)) {
                    return false;
                } else {
                    colSet.add(element);
                }
            }
        }
        return true;
    }
}