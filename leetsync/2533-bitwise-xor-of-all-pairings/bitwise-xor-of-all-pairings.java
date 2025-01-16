class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + n);
        }
        for (int num : nums2) {
            map.put(num, map.getOrDefault(num, 0) + m);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value % 2 == 1) {
                result ^= key;
            }
        }
        return result;
    }
}