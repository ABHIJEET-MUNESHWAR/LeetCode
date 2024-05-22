class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        return canPartition(nums, target);
    }

    private boolean canPartition(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            Set<Integer> tempSet = new HashSet<>();
            for (int setItem : set) {
                tempSet.add(setItem + nums[i]);
                tempSet.add(setItem);
            }
            set = tempSet;
        }
        return set.contains(target);
    }
}