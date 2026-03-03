class Solution {
    public char findKthBit(int n, int k) {
        // Base case: if n is 1, the sequence is just "0"
        if (n == 1) {
            return '0';
        }
        // Length of the sequence at level n: 2^n - 1
        int length = (1 << n) - 1;

        // If k is in the first half, recurse on the first half
        if (k < Math.ceil(length / 2.0)) {
            return findKthBit(n - 1, k);
        }

        // If k is the middle bit, return '1'
        if (k == Math.ceil(length / 2.0)) {
            return '1';
        }

        // Otherwise, recurse on the mirrored second half
        else {
            char ch = findKthBit(n - 1, length - (k - 1)); // handle reversed
            return ch == '1' ? '0' : '1'; // handle flipped bit
        }
    }
}