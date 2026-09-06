class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        backTracking(nums, resultList, currentList, 0);
        return resultList;
    }

    public void backTracking(int[] nums, List<List<Integer>> resultList, List<Integer> currentList, int index) {
        if (currentList.size() > 1) {
            resultList.add(new ArrayList(currentList));
        }
        int n = nums.length;
        Set<Integer> isUsed = new HashSet<>();
        for (int i = index; i < n; i++) {
            if (currentList.size() == 0 || (nums[i] >= currentList.get(currentList.size() - 1))) {
                if (isUsed.contains(nums[i])) {
                    continue;
                }
                currentList.add(nums[i]);
                backTracking(nums, resultList, currentList, i + 1);
                currentList.remove(currentList.size() - 1);
                isUsed.add(nums[i]);
            }
        }
    }
}