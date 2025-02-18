class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        subSets(nums, result, current, 0);
        return result;
    }

    public void subSets(int[] nums, List<List<Integer>> result, List<Integer> current, int index) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        subSets(nums, result, current, index + 1);
        current.remove(current.size() - 1);
        subSets(nums, result, current, index + 1);
    }
}