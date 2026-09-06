class Solution {
    public void combinationSum4(int[] nums, int target, int n, List<Integer> currentList,
            List<List<Integer>> resultList) {
        if (target == 0) {
            resultList.add(new ArrayList<>(currentList));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            currentList.add(nums[i]);
            combinationSum4(nums, target - nums[i], n, currentList, resultList);
            currentList.remove(currentList.size() - 1);
        }
    }

    public int combinationSum4(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        int n = nums.length;
        combinationSum4(nums, target, n, currentList, resultList);
        return resultList.size();
    }
}