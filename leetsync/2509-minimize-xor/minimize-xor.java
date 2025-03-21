class Solution {
    public boolean isSet(int x, int bit) {
        return (x & (1 << bit)) != 0;
    }

    public int setBit(int x, int bit) {
        return x | (1 << bit);
    }

    public int unSetBit(int x, int bit) {
        return x & ~(1 << bit);
    }

    public boolean isUnSet(int x, int bit) {
        return (x & (1 << bit)) == 0;
    }

    public int minimizeXor(int num1, int num2) {
        int x = 0;
        int requiredSetBitCount = Integer.bitCount(num2);
        for (int bit = 31; bit >= 0 && requiredSetBitCount > 0; bit--) {
            if (isSet(num1, bit)) {
                x |= (1 << bit);
                requiredSetBitCount--;
            }
        }
        for (int bit = 0; bit < 32 && requiredSetBitCount > 0; bit++) {
            if (isUnSet(num1, bit)) {
                x |= (1 << bit);
                requiredSetBitCount--;
            }
        }
        return x;
    }
}