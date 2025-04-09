class Solution {
    Random random;
    int[] prefixSum;

    public Solution(int[] w) {
        random = new Random();
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
        this.prefixSum = w;
    }

    public int pickIndex() {
        int n = prefixSum.length;
        int index = random.nextInt(prefixSum[n - 1]) + 1;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (index == prefixSum[mid]) {
                return mid;
            } else if (index > prefixSum[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */