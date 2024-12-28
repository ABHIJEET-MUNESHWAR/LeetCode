class Solution {
    private int[][] dp = new int[20001][4];

    private int helper(int[] sums, int k, int index, int rem) {
        if (rem == 0) {
            return 0;
        }
        if (index >= sums.length) {
            return Integer.MIN_VALUE;
        }
        if (dp[index][rem] != -1) {
            return dp[index][rem];
        }
        int take = sums[index] + helper(sums, k, index + k, rem - 1);
        int skip = helper(sums, k, index + 1, rem);
        return dp[index][rem] = Math.max(take, skip);
    }

    private void solve(int[] sums, int k, int index, int rem, List<Integer> indices) {
        if (rem == 0 || index >= sums.length) {
            return;
        }
        int take = sums[index] + helper(sums, k, index + k, rem - 1);
        int skip = helper(sums, k, index + 1, rem);
        if (take >= skip) {
            indices.add(index);
            solve(sums, k, index + k, rem - 1, indices);
        } else {
            solve(sums, k, index + 1, rem, indices);
        }
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // Initialize the memoization array with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int n = nums.length - k + 1;
        int[] sums = new int[n];
        int windowSum = 0;
        int i = 0, j = 0;
        // Calculate window sums
        while (j < nums.length) {
            windowSum += nums[j];
            if (j - i + 1 == k) {
                sums[i] = windowSum;
                windowSum -= nums[i];
                i++;
            }
            j++;
        }
        List<Integer> indices = new ArrayList<>();
        solve(sums, k, 0, 3, indices);

        return indices.stream().mapToInt(Integer::intValue).toArray();
    }
}