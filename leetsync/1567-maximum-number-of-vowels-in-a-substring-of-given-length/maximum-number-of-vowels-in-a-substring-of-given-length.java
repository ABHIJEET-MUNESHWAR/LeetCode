class Solution {
    public int maxVowels(String s, int k) {
        int size = s.length();
        int left = 0, right = 0;
        int maxVowelsLength = 0;
        int currentVowels = 0;
        while (right < size) {
            if (isVowel(s.charAt(right))) {
                currentVowels++;
            }
            if ((right - left + 1) == k) {
                maxVowelsLength = Math.max(maxVowelsLength, currentVowels);
                if (isVowel(s.charAt(left))) {
                    currentVowels--;
                }
                left++;
            }
            right++;
        }
        return maxVowelsLength;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}