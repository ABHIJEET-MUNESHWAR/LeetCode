class Solution {

    int result = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        int[] children = new int[k];
        solve(cookies, children, k, 0);
        return result;
    }

    private void solve(int[] cookies, int[] children, int k, int start) {
        if (start >= cookies.length) {
            int unfairness = Integer.MIN_VALUE;
            for (int i = 0; i < k; i++) {
                unfairness = Math.max(unfairness, children[i]);
            }
            result = Math.min(unfairness, result);
            return;
        }
        int cookie = cookies[start];
        for (int i = 0; i < k; i++) {
            children[i] += cookie;
            solve(cookies, children, k, start + 1);
            children[i] -= cookie;
        }
    }
}