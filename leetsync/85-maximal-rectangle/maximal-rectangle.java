public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        int largestArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int val = matrix[i][j] - '0';
                if (val == 0) {
                    heights[j] = 0;
                } else {
                    heights[j] += val;
                }
            }
            int maxArea = largestRectangleArea(heights);
            largestArea = Math.max(maxArea, largestArea);
        }
        return largestArea;
    }

    private int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        int size = heights.length;
        int[] stack = new int[size + 1];
        int index = -1;
        for (int i = 0; i <= size; i++) {
            int element = (i == size) ? 0 : heights[i];
            while ((index != -1) && ((heights[stack[index]]) > element)) {
                int h = heights[stack[index--]];
                int ps = (index == -1) ? -1 : stack[index];
                int w = i - ps - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack[++index] = i;
        }
        return maxArea == Integer.MIN_VALUE ? 0 : maxArea;
    }
}