class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] countArray = getCountArray(n);
        int num = 1;
        for (int i = 0; i < 31; i++) {
            if (Arrays.equals(countArray, getCountArray(num))) {
                return true;
            } else {
                num = num << 1;
            }
        }
        return false;
    }

    private int[] getCountArray(int n) {
        int[] countArray = new int[10];
        while (n > 0) {
            countArray[n % 10]++;
            n = n / 10;
        }
        return countArray;
    }
}