class Solution {
    public int[] evenOddBit(int n) {

        int even = 0, odd = 0;
        boolean flip = true;
        while (n > 0) {
            if (flip) {
                if ((n & 1) == 1) {
                    even++;
                }
            } else {
                if ((n & 1) == 1) {
                    odd++;
                }
            }
            flip = !flip;
            n = n / 2;
        }
        int[] answer = { even, odd };
        return answer;
    }
}