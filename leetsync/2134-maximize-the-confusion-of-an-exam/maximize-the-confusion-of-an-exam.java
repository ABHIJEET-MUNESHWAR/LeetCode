class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int result = 0;
        Map<Character, Integer> charToFrequencyMap = new HashMap<>();
        int n = answerKey.length();
        int left = 0;
        int right = 0;
        while (right < n) {
            Character rightChar = answerKey.charAt(right);
            charToFrequencyMap.put(rightChar, charToFrequencyMap.getOrDefault(rightChar, 0) + 1);
            while (Math.min(charToFrequencyMap.getOrDefault('T', 0), charToFrequencyMap.getOrDefault('F', 0)) > k) {
                Character leftChar = answerKey.charAt(left);
                charToFrequencyMap.put(leftChar, charToFrequencyMap.getOrDefault(leftChar, 0) - 1);
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}