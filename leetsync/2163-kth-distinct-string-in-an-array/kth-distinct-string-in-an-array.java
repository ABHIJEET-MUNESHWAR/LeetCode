class Solution {
    public String kthDistinct(String[] arr, int k) {

        Map<String, Integer> charToFreqMap = new HashMap<>();
        for (String str : arr) {
            charToFreqMap.put(str, charToFreqMap.getOrDefault(str, 0) + 1);
        }
        int i = 1;
        for (int j = 0; j < arr.length; j++) {
            if (charToFreqMap.get(arr[j]) == 1) {
                if (i == k) {
                    return arr[j];
                }
                i++;
            }
        }
        return "";
    }
}