class Solution {
    int[] dp = new int[101];

    public int rob(int[] nums) {
        int size = nums.length;
        int prevPrev = 0;
        int prev = 0;
        int temp = 0;

        if (size == 1) {
            return nums[0];
        }
        for (int i = 1; i <= size - 1; i++) {
            int steal = nums[i - 1] + prevPrev;
            int skip = prev;
            temp = Math.max(steal, skip);
            prevPrev = prev;
            prev = temp;
        }
        int result1 = prev;

        prevPrev = 0;
        prev = 0;
        temp = 0;
        dp = new int[size + 1];
        for (int i = 2; i <= size; i++) {
            int steal = nums[i - 1] + prevPrev;
            int skip = prev;
            temp = Math.max(steal, skip);
            prevPrev = prev;
            prev = temp;
        }
        int result2 = prev;
        return Math.max(result1, result2);
    }

}