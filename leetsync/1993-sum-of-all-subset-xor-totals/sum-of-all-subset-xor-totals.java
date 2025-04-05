class Solution {
    List<List<Integer>> subSets = new ArrayList<>();

    public void solve(int[] nums, int index, List<Integer> temp) {
        if (index >= nums.length) {
            subSets.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        solve(nums, index + 1, temp);
        temp.remove(temp.size() - 1);
        solve(nums, index + 1, temp);
    }

    public int subsetXORSum(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        int result = 0;
        solve(nums, 0, temp);
        for (List<Integer> subSet : subSets) {
            int xor = 0;
            for (int set : subSet) {
                xor ^= set;
            }
            result += xor;
        }
        return result;
    }
}