class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        char[] result = new char[n];
        int[] freq = new int[26];
        int maxOccFreq = 0;
        char maxOccChar = '$';
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
            if (freq[ch - 'a'] > ((n + 1) / 2)) {
                return "";
            }
            if (maxOccFreq < freq[ch - 'a']) {
                maxOccFreq = freq[ch - 'a'];
                maxOccChar = ch;
            }
        }
        int j = 0;
        while (maxOccFreq-- > 0) {
            result[j] = maxOccChar;
            j += 2;
            freq[maxOccChar - 'a']--;
        }
        for (char i = 'a'; i <= 'z'; i++) {
            while (freq[i - 'a'] > 0) {
                if (j > n - 1) {
                    j = 1;
                }
                result[j] = i;
                j += 2;
                freq[i - 'a']--;
            }
        }
        return new String(result);
    }
}