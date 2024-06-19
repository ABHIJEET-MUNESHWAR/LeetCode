class Solution {
    public int maxLength(List<String> arr) {
        return solveRecursionMemoization(arr, "", 0, new HashMap<String, Integer>());
    }

    private int solveRecursionMemoization(List<String> arr, String temp, int index, HashMap<String, Integer> map) {
        if (index >= arr.size()) {
            return temp.length();
        }
        if (map.containsKey(temp)) {
            return map.get(temp);
        }
        int includeLength = 0;
        int excludeLength = 0;
        if (isUnique(arr.get(index), temp)) {
            // Either Include OR Exclude
            // Include
            String originalTemp = temp;
            temp += arr.get(index);
            includeLength += solveRecursionMemoization(arr, temp, index + 1, map);
            temp = originalTemp;
        }
        // Exclude
        excludeLength += solveRecursionMemoization(arr, temp, index + 1, map);
        int result = Math.max(includeLength, excludeLength);
        map.put(temp, result);
        return result;
    }

    private boolean isUnique(String string1, String string2) {
        int[] frequencyMap = new int[26];
        for (char c : string1.toCharArray()) {
            int ch = c - 'a';
            if (frequencyMap[ch] > 0) {
                return false;
            }
            frequencyMap[ch]++;
        }
        for (char c : string2.toCharArray()) {
            if (frequencyMap[c - 'a'] > 0) {
                return false;
            }
        }
        return true;
    }
}