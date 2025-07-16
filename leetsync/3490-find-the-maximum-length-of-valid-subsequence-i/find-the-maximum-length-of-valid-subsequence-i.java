class Solution {
    public int maximumLength(int[] nums) {
        int evenLength = 0, oddLength = 0;
        int n = nums.length;
        for (int num : nums) {
            if (num % 2 == 0) {
                evenLength++;
            } else {
                oddLength++;
            }
        }
        int altLength = 1; // At least 1 length
        int prevParity = nums[0] % 2;
        for (int i = 1; i < n; i++) {
            int currParity = nums[i] % 2;
            if (currParity != prevParity) {
                altLength++;
                prevParity = currParity;
            }
        }
        return Math.max(altLength, Math.max(evenLength, oddLength));
    }
}