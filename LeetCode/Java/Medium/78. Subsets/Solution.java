class Solution {
    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<Integer> currentList = new ArrayList<>();
        backTrack(nums, n, 0, currentList);
        return resultList;
    }

    public void backTrack(int[] nums, int n, int index, List<Integer> currentList) {
        if (index >= n) {
            resultList.add(new ArrayList<>(currentList));
            return;
        }
        currentList.add(nums[index]);
        backTrack(nums, n, index + 1, currentList);
        currentList.remove(currentList.size() - 1);
        backTrack(nums, n, index + 1, currentList);
    }
}