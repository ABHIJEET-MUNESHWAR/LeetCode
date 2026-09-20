class Solution {
    public void combinationSumBackTrack(int[] nums, int n, int target, int index, List<Integer> currentList,
            List<List<Integer>> resultList) {
        if (target == 0) {
            resultList.add(new ArrayList<>(currentList));
            return;
        }
        if (target < 0) {
            return;
        }
        if (index >= n) {
            return;
        }
        for (int i = index; i < n; i++) {
            currentList.add(nums[i]);
            combinationSumBackTrack(nums, n, target - nums[i], i, currentList, resultList);
            currentList.remove(currentList.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        int n = nums.length;
        combinationSumBackTrack(nums, n, target, 0, currentList, resultList);
        return resultList;
    }
}