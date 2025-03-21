class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int chunksCount = 0, maxTillNow = 0;
        for (int i = 0; i < n; i++) {
            maxTillNow = Math.max(arr[i], maxTillNow);
            if (maxTillNow == i) {
                chunksCount++;
            }
        }
        return chunksCount;
    }
}