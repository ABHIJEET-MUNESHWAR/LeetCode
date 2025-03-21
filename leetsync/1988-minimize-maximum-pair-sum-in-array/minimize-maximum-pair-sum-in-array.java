class Solution {
    public int minPairSum(int[] nums) {

        int size = nums.length;
        int max = Integer.MIN_VALUE;
        Arrays.sort(nums);
        int i = 0, j = size - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (max < sum) {
                max = sum;
            }
            i++;
            j--;
        }
        return max;
    }
}