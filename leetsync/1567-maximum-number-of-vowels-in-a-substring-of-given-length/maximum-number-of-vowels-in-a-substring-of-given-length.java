class Solution {
    public int maxVowels(String s, int k) {

        int size = s.length();
        int left = 0, right = 0;
        int maxVowelsLength = 0;
        int currentVowels = 0;
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        while (right < size) {
            if (vowelSet.contains(s.charAt(right))) {
                currentVowels++;
            }
            if ((right - left + 1) == k) {
                maxVowelsLength = Math.max(maxVowelsLength, currentVowels);
                if (vowelSet.contains(s.charAt(left))) {
                    currentVowels--;
                }
                left++;
            }
            right++;
        }
        return maxVowelsLength;
    }
}