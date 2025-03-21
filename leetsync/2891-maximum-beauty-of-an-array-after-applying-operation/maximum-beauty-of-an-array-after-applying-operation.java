class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int maxBeauty = 0;
        Arrays.sort(nums);
        int n = nums.length;
        int i=0, j=0;
        // Sliding Window
        while(i<n){
            while(j<n && nums[j]-nums[i]<=2*k){
                j++;
            }
            maxBeauty = Math.max(maxBeauty, j-i);
            i++;
        }
        return maxBeauty;
    }
}