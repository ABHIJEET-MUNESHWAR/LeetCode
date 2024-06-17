class Solution {
    public boolean judgeSquareSum(int c) {
        long low = 0;
        long high = (long) Math.sqrt(c);
        while (low <= high) {
            long sumOfSquares = low * low + high * high;
            if (sumOfSquares < c) {
                low++;
            } else if (sumOfSquares > c) {
                high--;
            } else {
                return true;
            }
        }
        return false;
    }
}