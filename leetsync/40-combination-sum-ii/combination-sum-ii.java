class Solution {
    public void combinationSum2BackTrack(int[] nums, int n, int index, int target, List<Integer> currentList,
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
            combinationSum2BackTrack(nums, n, i + 1, target - nums[i], currentList, resultList);
            currentList.remove(currentList.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        Arrays.sort(nums);
        combinationSum2BackTrack(nums, n, 0, target, currentList, resultList);
        return resultList;
    }
}