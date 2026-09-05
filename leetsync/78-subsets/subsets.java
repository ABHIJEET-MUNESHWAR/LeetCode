class Solution {
    public void subSetBackTrack(int[] nums, int n, int index, List<Integer> currentList,
            List<List<Integer>> resultList) {
        if (index == n) {
            resultList.add(new ArrayList<>(currentList));
            return;
        }
        currentList.add(nums[index]);
        subSetBackTrack(nums, n, index + 1, currentList, resultList);
        currentList.remove(currentList.size() - 1);
        subSetBackTrack(nums, n, index + 1, currentList, resultList);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        int n = nums.length;
        subSetBackTrack(nums, n, 0, currentList, resultList);
        return resultList;
    }
}