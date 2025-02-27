class Solution {
    public int solve(int[] arr, Map<Integer, Integer> numToIndexMap, int j, int k) {
        int target = arr[k] - arr[j];
        if (numToIndexMap.containsKey(target) && numToIndexMap.get(target) < j) {
            int i = numToIndexMap.get(target);
            return solve(arr, numToIndexMap, i, j) + 1;
        }
        return 2;
    }

    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> numToIndexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            numToIndexMap.put(arr[i], i);
        }
        int maxLength = 0;
        for (int j = 1; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                int length = solve(arr, numToIndexMap, j, k);
                if (length >= 3) {
                    maxLength = Math.max(maxLength, length);
                }
            }
        }
        return maxLength >= 3 ? maxLength : 0;
    }
}