class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int size = nums.length;
        int result = 0;
        Map<Integer, Integer> reminderVsCountMap = new HashMap<>();
        reminderVsCountMap.put(0, 1);
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += nums[i];
            int reminder = sum % k;
            if (reminder < 0) {
                reminder += k;
            }
            if (reminderVsCountMap.containsKey(reminder)) {
                result += reminderVsCountMap.get(reminder);
                reminderVsCountMap.put(reminder, reminderVsCountMap.get(reminder) + 1);
            } else {
                reminderVsCountMap.put(reminder, 1);
            }
        }
        return result;
    }
}