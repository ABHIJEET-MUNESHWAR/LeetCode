class Solution {
    public int[] reverse(int[] nums, int i, int j) {
        while (i < j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }
        return nums;
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (k > n) {
            k = k % n;
        }
        nums = reverse(nums, 0, n - 1);
        nums = reverse(nums, 0, k - 1);
        nums = reverse(nums, k, n - 1);
    }
}