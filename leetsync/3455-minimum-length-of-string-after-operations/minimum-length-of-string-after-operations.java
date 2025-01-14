class Solution {
    public int minimumLength(String s) {
        int[] freq = new int[26];
        int n = s.length();
        int deletedChars = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int chInt = ch - 'a';
            freq[chInt]++;
            if (freq[chInt] == 3) {
                freq[chInt] = 1;
                deletedChars += 2;
            }
        }
        return n - deletedChars;
    }
}