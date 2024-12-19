class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int chunksCount = 0;
        int cumSum = 0, normalSum = 0;
        for (int i = 0; i < n; i++) {
            cumSum += arr[i];
            normalSum += i;
            if (cumSum == normalSum) {
                chunksCount++;
            }
        }
        return chunksCount;
    }
}