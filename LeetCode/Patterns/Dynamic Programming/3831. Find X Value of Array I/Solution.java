class Solution {
    static public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        int n = nums.length;
        for (int i = 0; i < n; i++)
            nums[i] %= k;
        Long[][] dp;
        for (int req = 0; req < k; req++) {
            dp = new Long[n][k + 1];
            ans[req] = solve(0, req, -1, k, nums, dp);
        }
        return ans;
    }

    static long solve(int i, int req, int pro, int k, int[] arr, Long[][] dp) {
        if (i == arr.length)
            return 0;
        if (dp[i][pro + 1] != null)
            return dp[i][pro + 1];

        long take = 0, notTake = 0, count = 0;
        if (pro == -1) {
            if (arr[i] == req)
                count = 1;
            take = count + solve(i + 1, req, arr[i], k, arr, dp);
            notTake = solve(i + 1, req, -1, k, arr, dp);
        } else {
            int newPro = (pro * arr[i]) % k;
            if (newPro == req)
                count = 1;
            take = count + solve(i + 1, req, newPro, k, arr, dp);
        }

        return dp[i][pro + 1] = take + notTake;
    }
}