class Solution {
    public int minOperations(int[] nums, int k) {
        for (int a : nums)
            k ^= a;
        return Integer.bitCount(k);
    }
}