class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(nums, result, current, 0);
        return result;
    }

    public void backtrack(int[] nums, List<List<Integer>> result, List<Integer> current, int index) {
        if (current.size() > 1) {
            result.add(new ArrayList(current));
        }
        Set<Integer> isUsed = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (isUsed.contains(nums[i])) {
                continue;
            }
            if (current.isEmpty() || nums[i] >= current.get(current.size() - 1)) {
                current.add(nums[i]); // Do
                backtrack(nums, result, current, i + 1); // Explore
                current.remove(current.size() - 1);// Undo
                isUsed.add(nums[i]);
            }
        }
    }
}