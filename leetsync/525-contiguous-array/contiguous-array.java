class Solution {
    public int findMaxLength(int[] nums) {

        int maxLength = 0;
        int size = nums.length;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            int length = 0;
            if (sum == 0) {
                length = i + 1;
            } else if (map.containsKey(sum)) {
                length = i - map.get(sum);
            } else {
                map.put(sum, i);
            }
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}