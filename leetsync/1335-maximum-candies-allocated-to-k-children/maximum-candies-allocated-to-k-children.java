class Solution {
    public boolean canDistribute(int[] candies, long k, int mid) {
        int n = candies.length;
        for (int i = 0; i < n; i++) {
            k -= (candies[i] / mid);
            if (k <= 0) {
                // all children got mid candies
                return true;
            }
        }
        return k <= 0;// all children got mid candies
    }

    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        int maxCandy = Integer.MIN_VALUE;
        long total = 0;
        for (int candy : candies) {
            total += candy;
            if (maxCandy < candy) {
                maxCandy = candy;
            }
        }
        if (total < k) {
            return 0;
        }
        int left = 1, right = maxCandy, result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(candies, k, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}