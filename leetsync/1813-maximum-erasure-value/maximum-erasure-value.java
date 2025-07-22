class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int maxValue = 0;
        int left = 0, right = 0, sum = 0;
        Set<Integer> set = new HashSet<>();
        while (right < n) {
            if (!set.contains(nums[right])) {
                sum += nums[right];
                maxValue = Math.max(maxValue, sum);
                set.add(nums[right++]);
            } else {
                sum -= nums[left];
                set.remove(nums[left++]);
            }
        }
        return maxValue;
    }
}