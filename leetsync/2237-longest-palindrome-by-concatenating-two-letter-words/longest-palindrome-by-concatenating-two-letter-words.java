class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> wordToFreqMap = new HashMap<>();
        int result = 0;
        for (String word : words) {
            String reverseWord = new StringBuilder(word).reverse().toString();
            if (wordToFreqMap.getOrDefault(reverseWord, 0) > 0) {
                result += 4;
                wordToFreqMap.put(reverseWord, wordToFreqMap.get(reverseWord) - 1);
            } else {
                wordToFreqMap.put(word, wordToFreqMap.getOrDefault(word, 0) + 1);
            }
        }
        // Check for a word with both characters same to use in the center
        for (Map.Entry<String, Integer> entry : wordToFreqMap.entrySet()) {
            String word = entry.getKey();
            int freq = entry.getValue();
            if (word.charAt(0) == word.charAt(1) && freq > 0) {
                result += 2;
                break;
            }
        }
        return result;
    }
}