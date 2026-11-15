class Solution {
    int MOD = (int) 1e9 + 7;

    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int answer = 0;
        int oddCount = 0, evenCount = 1;
        int prefixSum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            if (prefixSum % 2 == 0) {
                // Odd + Even = Odd
                answer = (oddCount + answer) % MOD;
                evenCount++;
            } else {
                // Even + Odd = Odd
                answer = (evenCount + answer) % MOD;
                oddCount++;
            }
        }
        return answer;
    }
}