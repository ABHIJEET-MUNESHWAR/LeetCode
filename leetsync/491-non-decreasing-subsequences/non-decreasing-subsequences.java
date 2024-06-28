class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backTrack(nums, current, result, 0);
        return result;
    }

    private void backTrack(int[] nums, List<Integer> current, List<List<Integer>> result, int index) {
        if (current.size() > 1) {
            result.add(new ArrayList<>(current));
        }
        Set<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (used.contains(nums[i])) {
                continue;
            }
            if (current.isEmpty() || nums[i] >= current.get(current.size() - 1)) {
                current.add(nums[i]);
                used.add(nums[i]);
                backTrack(nums, current, result, i + 1);
                current.remove(current.size() - 1);
            }
        }
    }
}