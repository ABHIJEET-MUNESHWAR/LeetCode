class Solution {
    public long maximumImportance(int n, int[][] roads) {

        int[] degree = new int[n];
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }
        Arrays.sort(degree);
        long sum = 0;
        long value = 1;
        for (int i = 0; i < n; i++) {
            sum += (degree[i] * value);
            value++;
        }
        return sum;
    }
}