class Solution {
    public void subsetsWithDupBackTrack(int[] nums, int n, int index, List<Integer> currentList,
            List<List<Integer>> resultList) {
        if (index == n) {
            resultList.add(new ArrayList<>(currentList));
            return;
        }
        currentList.add(nums[index]);
        subsetsWithDupBackTrack(nums, n, index + 1, currentList, resultList);
        currentList.remove(currentList.size() - 1);
        while ((index + 1) < n && nums[index] == nums[index + 1]) {
            index++;
        }
        subsetsWithDupBackTrack(nums, n, index + 1, currentList, resultList);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        subsetsWithDupBackTrack(nums, n, 0, currentList, resultList);
        return resultList;
    }
}