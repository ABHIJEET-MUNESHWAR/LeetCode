class Solution {
    public int[] sortByBits(int[] arr) {
        List<Integer> answerList = new ArrayList<>();
        TreeMap<Integer, List<Integer>> binaryToFreqTreeMap = new TreeMap<>();
        for (int num : arr) {
            int bitCount = getBitCount(num);
            List<Integer> freqList = new ArrayList<>();
            if (binaryToFreqTreeMap.containsKey(bitCount)) {
                freqList = binaryToFreqTreeMap.get(bitCount);
            }
            freqList.add(num);
            Collections.sort(freqList);
            binaryToFreqTreeMap.put(bitCount, freqList);
        }
        for (Map.Entry<Integer, List<Integer>> entry : binaryToFreqTreeMap.entrySet()) {
            List<Integer> nums = entry.getValue();
            answerList.addAll(nums);
        }
        return answerList.stream().mapToInt(i -> i).toArray();
    }

    private int getBitCount(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }
}