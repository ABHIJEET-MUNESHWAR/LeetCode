class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        boolean isEven = nums[0] % 2 == 0;
        for (int i = 1; i < n; i++) {
            isEven = !isEven;
            boolean currentParity = nums[i] % 2 == 0;
            if (currentParity != isEven) {
                return false;
            }
        }
        return true;
    }
}