class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        int[] rowMin = new int[rows];
        Arrays.fill(rowMin, Integer.MAX_VALUE);
        int[] colMax = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int element = matrix[i][j];
                rowMin[i] = Math.min(rowMin[i], element);
                colMax[j] = Math.max(colMax[j], element);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int element = matrix[i][j];
                if (element == rowMin[i] && element == colMax[j]) {
                    list.add(element);
                }
            }
        }
        return list;
    }
}