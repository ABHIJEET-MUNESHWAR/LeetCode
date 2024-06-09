class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderVsIndexMap = new HashMap<>();
        remainderVsIndexMap.put(0, -1);
        int size = nums.length;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += nums[i];
            int reminder = sum % k;
            if (remainderVsIndexMap.containsKey(reminder)) {
                if ((i - remainderVsIndexMap.get(reminder)) >= 2) {
                    return true;
                }
            } else {
                remainderVsIndexMap.put(reminder, i);
            }
        }
        return false;
    }
}