class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        subsetsTakeOrNoTake(nums, 0, temp);
        return result;
    }

    private void subsetsTakeOrNoTake(int[] nums, int index, List<Integer> temp) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        subsetsTakeOrNoTake(nums, index + 1, temp);
        temp.remove(temp.size() - 1);
        subsetsTakeOrNoTake(nums, index + 1, temp);
    }
}