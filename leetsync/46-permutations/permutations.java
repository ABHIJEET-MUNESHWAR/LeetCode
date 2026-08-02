class Solution {
    List<List<Integer>> resultList = new ArrayList<>();
    Set<Integer> isUsed = new HashSet<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> currentList = new ArrayList<>();
        backtrack(nums, currentList);
        return resultList;
    }

    public void backtrack(int[] nums, List<Integer> currentList) {
        int n = nums.length;
        if (currentList.size() == n) {
            resultList.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isUsed.contains(nums[i])) {
                continue;
            }
            isUsed.add(nums[i]);
            currentList.add(nums[i]);
            backtrack(nums, currentList);

            isUsed.remove(nums[i]);
            currentList.remove(currentList.size() - 1);
        }
    }
}