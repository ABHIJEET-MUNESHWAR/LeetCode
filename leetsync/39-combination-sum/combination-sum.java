class Solution {
    public void combinationSumBackTrack(int[] nums, int target, int n, int index, List<Integer> currentList,
            List<List<Integer>> resultList) {
        if (target == 0) {
            resultList.add(new ArrayList<>(currentList));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < n; i++) {
            currentList.add(nums[i]);
            combinationSumBackTrack(nums, target - nums[i], n, i, currentList, resultList);
            currentList.remove(currentList.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        int n = candidates.length;
        combinationSumBackTrack(candidates, target, n, 0, currentList, resultList);
        return resultList;
    }
}