class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }
        int oddMax = Integer.MIN_VALUE, evenMin = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) {
                continue;
            }
            if (freq[i] % 2 == 0) {
                evenMin = Math.min(evenMin, freq[i]);
            } else {
                oddMax = Math.max(oddMax, freq[i]);
            }
        }
        return oddMax - evenMin;
    }
}