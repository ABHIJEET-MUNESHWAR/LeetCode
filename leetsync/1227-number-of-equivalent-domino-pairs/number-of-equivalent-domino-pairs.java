class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> numToFreqMap = new HashMap<>();
        int result = 0;
        for (int[] domino : dominoes) {
            int num = Math.min(domino[0], domino[1]) * 10 + Math.max(domino[0], domino[1]);
            numToFreqMap.put(num, numToFreqMap.getOrDefault(num, 0) + 1);
        }
        for (int value : numToFreqMap.values()) {
            result += (value) * (value - 1) / 2;
        }
        return result;
    }
}