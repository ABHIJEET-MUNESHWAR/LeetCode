class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int result = 0;
        int maxIValue = values[0];
        for (int j = 1; j < n; j++) {
            int jValue = values[j] - j;
            result = Math.max(result, maxIValue + jValue);
            maxIValue = Math.max(maxIValue, values[j] + j);
        }
        return result;
    }
}