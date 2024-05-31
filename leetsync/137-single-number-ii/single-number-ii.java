class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int k = 0; k < 32; k++) {
            int countZero = 0, countOne = 0;
            int temp = 1 << k;
            for (int num : nums) {
                if ((num & temp) == 0) {
                    countZero++;
                } else {
                    countOne++;
                }
            }
            if (countOne % 3 == 1) {
                result |= temp;
            }
        }
        return result;
    }
}