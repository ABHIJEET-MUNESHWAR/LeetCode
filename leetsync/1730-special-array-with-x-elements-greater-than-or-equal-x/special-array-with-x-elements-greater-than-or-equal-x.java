class Solution {
    public int specialArray(int[] nums) {
        int size = nums.length;
        // Frequency array
        int[] frequencyMap = new int[size + 1];

        // Populate the frequency array
        for (int i = 0; i < size; i++) {
            if (nums[i] > size) {
                frequencyMap[size]++;
            } else {
                frequencyMap[nums[i]]++;
            }
        }

        // Calculate prefix sum from the end
        int cumulativeSum = 0;
        for (int i = size; i >= 0; i--) {
            cumulativeSum += frequencyMap[i];
            if (i == cumulativeSum) {
                return i;
            }
        }
        return -1;

    }
}