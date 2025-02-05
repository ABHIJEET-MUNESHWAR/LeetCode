class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        int diffCount = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
            }
            if (diffCount > 2) {
                return false;
            }
        }
        int[] first = new int[26];
        int[] second = new int[26];
        for (int i = 0; i < n; i++) {
            first[s1.charAt(i) - 'a']++;
            second[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (first[i] != second[i]) {
                return false;
            }
        }
        return true;
    }
}