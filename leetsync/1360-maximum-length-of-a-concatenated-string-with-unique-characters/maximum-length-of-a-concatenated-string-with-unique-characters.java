class Solution {
    public int maxLength(List<String> arr) {
        return solveRecursion(arr, "", 0);
    }

    private int solveRecursion(List<String> arr, String temp, int index) {
        if (index >= arr.size()) {
            return temp.length();
        }
        int includeLength = 0;
        int excludeLength = 0;
        if (isUnique(arr.get(index), temp)) {
            // Either Include OR Exclude
            // Include
            String originalTemp = temp;
            temp += arr.get(index);
            includeLength += solveRecursion(arr, temp, index + 1);
            temp = originalTemp;
        }
        // Exclude
        excludeLength += solveRecursion(arr, temp, index + 1);
        int result = Math.max(includeLength, excludeLength);
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