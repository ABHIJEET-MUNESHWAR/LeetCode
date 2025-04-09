class Solution {
    public int minOperations(int[] nums, int k) {
        BitSet bs = new BitSet(100001);
        for (int num : nums) {
            if (num < k) {
                return -1;
            } else if (num > k) {
                bs.set(num);
            }
        }
        return bs.cardinality();
    }
}