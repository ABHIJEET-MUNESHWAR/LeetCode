class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> numToFrequencyMap = new HashMap<>();
        for(int num: arr){
            numToFrequencyMap.put(num, numToFrequencyMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> frequencyList = new ArrayList<>();
        frequencyList.addAll(numToFrequencyMap.values());
        Collections.sort(frequencyList);
        int size = frequencyList.size();
        for (int i = 0; i < size; i++) {
            k -= frequencyList.get(i);
            if (k < 0) {
                return size - i;
            }
        }
        return 0; // All were removed
    }
}