class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> numToFreqMap = new HashMap<>();
        int n = answers.length;
        for (int answer : answers) {
            numToFreqMap.put(answer, numToFreqMap.getOrDefault(answer, 0) + 1);
        }
        int total = 0;
        for (Map.Entry<Integer, Integer> entry : numToFreqMap.entrySet()) {
            int x = entry.getKey();
            int count = entry.getValue();

            int groupSize = x + 1;
            int groups = (int) Math.ceil((double) count / groupSize);

            total += groups * groupSize;
        }
        return total;
    }
}