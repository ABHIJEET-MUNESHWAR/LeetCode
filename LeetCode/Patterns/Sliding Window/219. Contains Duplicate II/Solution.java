
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        Set<Integer> set = new HashSet<>();
        while (right < n) {
            if ((right - left) > k) {
                set.remove(nums[left]);
                left++;
            }
            if (set.contains(nums[right])) {
                return true;
            }
            set.add(nums[right]);
            right++;
        }
        return false;
    }
}