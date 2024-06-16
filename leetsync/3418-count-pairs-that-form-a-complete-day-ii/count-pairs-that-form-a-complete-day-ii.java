class Solution {
    public long countCompleteDayPairs(int[] hours) {

        // Initialize a frequency array to count occurrences of each remainder

        int[] remainderCounts = new int[24];

        long count = 0;

        for (int hour : hours) {

            int remainder = hour % 24;

            // The complement remainder needed to form a complete day

            int complement = (24 - remainder) % 24;

            // Add the count of numbers that can pair with this one

            count += remainderCounts[complement];

            // Increment the count for this remainder

            remainderCounts[remainder]++;

        }

        return count;
    }
}