class Solution {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i] > arr.get(arr.size() - 1)) {
                arr.add(nums[i]);
            } else {
                int l = 0, r = arr.size() - 1, ans = 0;
                while (l <= r) {
                    int mid = (l + r) / 2;

                    if (nums[i] <= arr.get(mid)) {
                        ans = mid;
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                arr.set(ans, nums[i]);
            }
        }
        return arr.size();
    }
}