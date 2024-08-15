class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        int[] temp = new int[max + 1];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int d = Math.abs(nums[i] - nums[j]);
                temp[d]++;
            }
        }
        for (int distance = 0; distance < max; distance++) {
            k -= temp[distance];
            if (k <= 0) {
                return distance; // Returning kth smallest distance
            }
        }
        return -1;
    }
}