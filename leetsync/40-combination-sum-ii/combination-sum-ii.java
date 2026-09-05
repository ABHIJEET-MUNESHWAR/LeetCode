class Solution {
    public void combinationSum2BackTrack(int[] nums, int target, int n, int index, List<Integer> currentList,
            List<List<Integer>> resultList) {
        if (target == 0) {
            resultList.add(new ArrayList<>(currentList));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < n; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            currentList.add(nums[i]);
            combinationSum2BackTrack(nums, target - nums[i], n, i + 1, currentList, resultList);
            currentList.remove(currentList.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        int n = candidates.length;
        Arrays.sort(candidates);
        combinationSum2BackTrack(candidates, target, n, 0, currentList, resultList);
        return resultList;
    }
}