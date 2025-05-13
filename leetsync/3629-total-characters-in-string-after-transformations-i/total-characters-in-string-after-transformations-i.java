class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int mod = 1_000_000_007;
        int[] map = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map[ch - 'a']++;
        }
        for (int c = 0; c < t; c++) {
            int[] temp = new int[26];
            for (int i = 0; i < 26; i++) {
                char ch = (char) (i + 'a');
                int freq = map[i];
                if (ch != 'z') {
                    temp[(ch + 1) - 'a'] = (temp[(ch + 1) - 'a'] + freq) % mod;
                } else {
                    temp['a' - 'a'] = (temp['a' - 'a'] + freq) % mod;
                    temp['b' - 'a'] = (temp['b' - 'a'] + freq) % mod;
                }
            }
            map = temp;
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            result = (result + map[i]) % mod;
        }
        return result;
    }
}