class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        int[] dp = new int[size];
        int[] previousIndexArray = new int[size];
        for (int i = 0; i < size; i++) {
            previousIndexArray[i] = -1;
            dp[i] = 1;
        }
        int lastChosenIndex = 0;
        int maxLength = 1;
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        previousIndexArray[i] = j;
                    }
                    if (maxLength < dp[i]) {
                        maxLength = dp[i];
                        lastChosenIndex = i;
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while (lastChosenIndex != -1) {
            result.add(nums[lastChosenIndex]);
            lastChosenIndex = previousIndexArray[lastChosenIndex];
        }
        return result;
    }
}