class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[401];
        Arrays.fill(dp, -1);
        return solveTopDown(nums, n, 0, dp);
    }

    public int solveTopDown(int[] nums, int n, int index, int[] dp) {
        if (index >= n) {
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int take = nums[index] + solveTopDown(nums, n, index + 2, dp);
        int skip = solveTopDown(nums, n, index+1, dp);
        return dp[index]=Math.max(take, skip);
    }
}