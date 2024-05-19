class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long minimumLoss = Integer.MAX_VALUE;
        long idealSum = 0;
        long count = 0;
        for (int num : nums) {
            if ((num ^ k) > num) {
                count++;
                idealSum += (num ^ k);
            } else {
                idealSum += num;
            }
            minimumLoss = Math.min(minimumLoss, Math.abs(num - ((num ^ k))));
        }
        if (count % 2 == 0) {
            return idealSum;
        }
        return idealSum - minimumLoss;
    }
}