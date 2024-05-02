class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int len = nums.length;
        Map<Integer, Integer> locationMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
          int diff = target - nums[i];
          if (locationMap.containsKey(diff)) {
            ans[1] = i;
            ans[0] = locationMap.get(diff);
          }
          locationMap.put(nums[i], i);
        }
        return ans;   
    }
}