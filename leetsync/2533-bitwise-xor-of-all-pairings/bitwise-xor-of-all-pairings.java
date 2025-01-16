class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int result = 0;
        if (m % 2 == 1) {
            for (int j = 0; j < n; j++) {
                result = result ^ (nums2[j]);
            }
        }
        if (n % 2 == 1) {
            for (int j = 0; j < m; j++) {
                result = result ^ (nums1[j]);
            }
        }
        return result;
    }
}