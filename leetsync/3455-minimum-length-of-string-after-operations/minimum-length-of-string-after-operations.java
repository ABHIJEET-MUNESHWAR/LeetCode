class Solution {
    public int minimumLength(String s) {
        int[] freq = new int[26];
        int n = s.length();
        int deletedChars = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int chInt = ch - 'a';
            freq[chInt]++;
        }
        int length = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) {
                continue;
            }
            if (freq[i] % 2 == 1) {
                length += 1;
            } else {
                length += 2;
            }
        }
        return length;
    }
}