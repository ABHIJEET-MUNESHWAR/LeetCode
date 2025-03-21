class Solution {
    public int[] getAverages(int[] nums, int k) {
        int size = nums.length;
        long windowSize = 2 * k + 1;
        int[] result = new int[size];
        Arrays.fill(result, -1);
        if (windowSize > size) {            
            return result;
        }
        int left = 0;
        int right = 0;
        long currentSum = 0;
        while (right < size) {
            currentSum += nums[right];
            if ((right - left + 1) == (windowSize)) {
                result[left + k] = (int) (currentSum / windowSize);
                currentSum -= nums[left];
                left++;
            }
            right++;
        }
        return result;
    }
}