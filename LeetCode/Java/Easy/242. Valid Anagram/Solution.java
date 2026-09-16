class Solution {
    public boolean isAnagram(String s, String t) {
        boolean isValidAnagram = true;
        int len1 = s.length();
        int len2 = t.length();
        if (len1 != len2) {
            return false;
        }
        int[] alphabet = new int[26];
        for (int i = 0; i < len1; i++) {
            Character ch = s.charAt(i);
            alphabet[ch - 'a']++;
        }
        for (int i = 0; i < len1; i++) {
            Character ch = t.charAt(i);
            alphabet[ch - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] != 0) {
                return false;
            }
        }
        return isValidAnagram;
    }
}