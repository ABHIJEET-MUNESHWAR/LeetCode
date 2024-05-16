class Solution {
    public int characterReplacement(String s, int k) {

        int maxWindowLength = 0;
        int left = 0;
        int right = 0;
        int size = s.length();
        int maxFrequency = 0;
        int[] counts = new int[26];
        while (right < size) {
            counts[s.charAt(right) - 'A']++;
            maxFrequency = Math.max(maxFrequency, counts[s.charAt(right) - 'A']);
            if (((right - left + 1) - maxFrequency) > k) {
                counts[s.charAt(left) - 'A']--;
                left++;
            } else {
                maxWindowLength = Math.max(maxWindowLength, right - left + 1);
            }
            right++;
        }
        return maxWindowLength;
    }
}