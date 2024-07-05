class Solution {
    public int findKthPositive(int[] arr, int k) {
        int size = arr.length;
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((arr[mid] - (mid + 1)) < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left + k;
    }
}