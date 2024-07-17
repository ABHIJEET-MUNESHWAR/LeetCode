class Solution {
    public long largestPerimeter(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return -1;
        }
        Arrays.sort(nums);
        long maxPerimeter = -1;
        long currentPerimeter = nums[0] + nums[1];
        for (int i = 2; i < n; i++) {
            if (currentPerimeter > nums[i]) {
                currentPerimeter += nums[i];
                maxPerimeter = Math.max(maxPerimeter, currentPerimeter);
            } else {
                currentPerimeter += nums[i];
            }
        }
        return maxPerimeter;
    }
}