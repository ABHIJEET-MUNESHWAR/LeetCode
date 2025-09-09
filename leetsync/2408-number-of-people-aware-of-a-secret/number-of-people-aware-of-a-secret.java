// Approach-2 - Bottom Up
// T.C : O(n * (forgt - delay))
// S.C : O(n)
class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = (int)1e9 + 7;
        int[] t = new int[n + 1]; // t[day] = number of people who learn the secret on "day"

        t[1] = 1;

        for (int day = 2; day <= n; day++) {
            long count = 0;
            for (int prev = day - forget + 1; prev <= day - delay; prev++) {
                if (prev > 0) {
                    count = (count + t[prev]) % MOD;
                }
            }
            t[day] = (int)count;
        }

        int result = 0;
        for (int day = n - forget + 1; day <= n; day++) {
            if (day > 0) {
                result = (result + t[day]) % MOD;
            }
        }

        return result;
    }
}