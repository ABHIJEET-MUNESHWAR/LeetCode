class Solution {
    int minFairness = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        int[] distributedCookies = new int[k];
        backtrack(cookies, k, distributedCookies, 0);
        return minFairness;
    }

    public void backtrack(int[] cookies, int k, int[] distributedCookies, int index) {
        int n = cookies.length;
        if (index >= n) {
            int maxUnfairness = Integer.MIN_VALUE;
            for (int distributedCookie : distributedCookies) {
                maxUnfairness = Math.max(maxUnfairness, distributedCookie);
            }
            minFairness = Math.min(minFairness, maxUnfairness);
            return;
        }
        int cookie = cookies[index];
        for (int i = 0; i < k; i++) {
            distributedCookies[i] += cookie;
            backtrack(cookies, k, distributedCookies, index + 1);
            distributedCookies[i] -= cookie;
        }
    }
}