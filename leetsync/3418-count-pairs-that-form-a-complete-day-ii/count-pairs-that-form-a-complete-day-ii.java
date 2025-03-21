class Solution {
    public long countCompleteDayPairs(int[] hours) {
        int size = hours.length;
        long[] frequencyMap = new long[24];
        long totalPairs = 0;
        for (int i = 0; i < size; i++) {
            int remainder = hours[i] % 24;
            if (remainder == 0) {
                totalPairs += frequencyMap[remainder];
            } else {
                totalPairs += frequencyMap[24 - remainder];
            }
            frequencyMap[remainder]++;
        }
        return totalPairs;
    }
}