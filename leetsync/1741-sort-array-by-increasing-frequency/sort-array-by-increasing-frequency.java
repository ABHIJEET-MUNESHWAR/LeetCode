class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> noToFreqMap = new HashMap<>();
        for (int num : nums) {
            noToFreqMap.put(num, noToFreqMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> keys = new ArrayList<>(noToFreqMap.keySet());
        Collections.sort(keys, (a, b) -> {
            return (noToFreqMap.get(a) == noToFreqMap.get(b)) ? b - a : noToFreqMap.get(a) - noToFreqMap.get(b);
        });
        int[] result = new int[n];
        int i = 0;
        for (int num : keys) {
            for (int j = 0; j < noToFreqMap.get(num); j++) {
                result[i++] = num;
            }
        }
        return result;
    }
}