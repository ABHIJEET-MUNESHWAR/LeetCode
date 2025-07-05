class Solution {
    public int findLucky(int[] arr) {
        int n = arr.length;
        int luckyInt = -1;
        Map<Integer, Integer> numToFreqMap = new HashMap<>();
        for (int num : arr) {
            numToFreqMap.put(num, numToFreqMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : numToFreqMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (key == value) {
                luckyInt = Math.max(luckyInt, key);
            }
        }
        return luckyInt;
    }
}