class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        double logValue = Math.log10(n) / Math.log10(3);
        // Check if logValue is an integer
        return logValue == (int) logValue;
    }
}