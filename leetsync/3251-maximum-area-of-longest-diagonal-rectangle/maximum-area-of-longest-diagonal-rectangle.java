class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int n = dimensions.length;
        int maxDiagonal = 0, maxArea = 0;
        for (int i = 0; i < n; i++) {
            int length = dimensions[i][0];
            int width = dimensions[i][1];
            int diagonal = length * length + width * width;
            int area = length * width;
            if (maxDiagonal < diagonal) {
                maxDiagonal = diagonal;
                maxArea = area;
            } else if (maxDiagonal == diagonal) {
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}