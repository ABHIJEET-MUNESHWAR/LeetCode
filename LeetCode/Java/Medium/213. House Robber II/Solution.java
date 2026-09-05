class Solution {
    int[] dp = new int[101];

    public int rob(int[] nums) {
        int size = nums.length;
        if (size == 1) {
            return nums[0];
        }
        if (size == 2) {
            return Math.max(nums[0], nums[1]);
        }
        Arrays.fill(dp, -1);
        int take0thIndexHouse = solve(nums, 0, size - 2);
        Arrays.fill(dp, -1);
        int take1stIndexHouse = solve(nums, 1, size - 1);
        return Math.max(take0thIndexHouse, take1stIndexHouse);
    }

    private int solve(int[] nums, int index, int size) {
        if (index > size) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int steal = nums[index] + solve(nums, index + 2, size);
        int skip = solve(nums, index + 1, size);
        return Math.max(steal, skip);
    }
}