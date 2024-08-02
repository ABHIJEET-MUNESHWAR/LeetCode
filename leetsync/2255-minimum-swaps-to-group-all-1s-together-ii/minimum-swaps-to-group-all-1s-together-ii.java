class Solution {
    public int minSwaps(int[] nums) {
        int ones = Arrays.stream(nums).sum(), n = nums.length, res = nums.length;
    for (int i = 0, j = 0, cnt = 0; i < n; ++i) {
        while (j - i < ones)
            cnt += nums[j++ % n];
        res = Math.min(res, ones - cnt);
        cnt -= nums[i];
    }
    return res;
    }
}