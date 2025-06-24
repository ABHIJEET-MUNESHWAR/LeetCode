class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (nums[j] == key) {
                int start = Math.max(j - k, 0);
                int end = Math.min(j + k, n - 1);
                // Avoid adding duplicates
                if (!result.isEmpty() && result.get(result.size() - 1) >= start) {
                    start = result.get(result.size() - 1) + 1;
                }
                for (int i = start; i <= end; i++) {
                    result.add(i);
                }
            }
        }
        return result;
    }
}