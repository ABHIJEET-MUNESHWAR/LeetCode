//Approach - Straight Forward Difference Array Technique
//T.C : O(Q + n)
//S.C : O(Q + n)
class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int q = queries.length;
        int n = nums.length;
        int[] diff = new int[n];
        // Step 1: Make difference array using queries
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            int x = 1;
            diff[start] += x;
            if (end + 1 < n) {
                diff[end + 1] -= x;
            }
        }
        // Step 2: Compute cumulative effect on each index
        int[] result = new int[n];
        int cumSum = 0;
        for (int i = 0; i < n; i++) {
            cumSum += diff[i];
            result[i] = cumSum;
        }
        // Step 3: Check if each value can reach 0
        for (int i = 0; i < n; i++) {
            if (result[i] < nums[i]) {
                return false;// nums[i] won't become 0
            }
        }
        return true;
    }
}