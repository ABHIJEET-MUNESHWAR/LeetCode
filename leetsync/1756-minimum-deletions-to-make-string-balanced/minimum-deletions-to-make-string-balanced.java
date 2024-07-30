class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] rightA = new int[n];
        int leftBCount = 0;
        int rightACount = 0;
        int result = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            rightA[i] = rightACount;
            if (c == 'a') {
                rightACount++;
            }
        }
        for (int i = 0; i < n; i++) {
            result = Math.min(result, leftBCount + rightA[i]);
            if (s.charAt(i) == 'b') {
                leftBCount++;
            }
        }
        return result;
    }
}