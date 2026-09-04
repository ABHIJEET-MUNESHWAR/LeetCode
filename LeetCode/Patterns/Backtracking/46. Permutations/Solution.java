class Solution {
    public void permuteBackTrack(int[] nums, int n, Set<Integer> isUsedSet, List<Integer> currentList,
            List<List<Integer>> resultList) {
        if (currentList.size() == n) {
            resultList.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isUsedSet.contains(nums[i])) {
                continue;
            }
            isUsedSet.add(nums[i]);
            currentList.add(nums[i]);
            permuteBackTrack(nums, n, isUsedSet, currentList, resultList);
            isUsedSet.remove(nums[i]);
            currentList.remove(currentList.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        int n = nums.length;
        Set<Integer> isUsedSet = new HashSet<>();
        permuteBackTrack(nums, n, isUsedSet, currentList, resultList);
        return resultList;
    }
}