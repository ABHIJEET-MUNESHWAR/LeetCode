class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);
        Set<Integer> intersectionSet = new HashSet<>();
        for (int num : nums1) {
            if (binarySearch(nums2, num)) {
                intersectionSet.add(num);
            }
        }
        int[] answer = new int[intersectionSet.size()];
        int i = 0;
        for (int num : intersectionSet) {
            answer[i++] = num;
        }
        return answer;
    }

    private boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}