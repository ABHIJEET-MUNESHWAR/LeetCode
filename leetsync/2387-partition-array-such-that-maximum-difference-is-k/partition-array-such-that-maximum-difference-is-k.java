class Solution {
    public int partitionArray(int[] nums, int k) {
        int n = nums.length;
        int count = 1;
        Arrays.sort(nums);
        int min = nums[0];
        for (int i = 0; i < n; i++) {
            if ((nums[i] - min) > k) {
                min = nums[i];
                count++;
            }
        }
        return count;
    }
}