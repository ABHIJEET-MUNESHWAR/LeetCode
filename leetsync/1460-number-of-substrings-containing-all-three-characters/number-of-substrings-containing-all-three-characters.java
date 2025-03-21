class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] charToFreqMap = new int[3];
        int left = 0, right = 0, count = 0;
        while (right < n) {
            char ch = s.charAt(right);
            charToFreqMap[ch - 'a']++;
            while (charToFreqMap[0] > 0 && charToFreqMap[1] > 0 && charToFreqMap[2] > 0) {
                count += (n - right);
                charToFreqMap[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return count;
    }
}