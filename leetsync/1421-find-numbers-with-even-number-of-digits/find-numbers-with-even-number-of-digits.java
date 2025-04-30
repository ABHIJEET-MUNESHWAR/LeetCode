class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num >= 10 && num <= 99) {
                count++;
            } else if (num >= 1000 && num <= 9999) {
                count++;
            } else if (num == 100000) {
                count++;
            }
        }
        return count;
    }
}