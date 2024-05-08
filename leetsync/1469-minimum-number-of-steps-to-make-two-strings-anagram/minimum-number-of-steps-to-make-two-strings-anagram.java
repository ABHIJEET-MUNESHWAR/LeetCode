class Solution {
    public int minSteps(String s, String t) {

        int diffCount = 0;
        int[] countMap = new int[26];
        for (char c : s.toCharArray()) {
            countMap[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            countMap[c - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (countMap[i] != 0) {
                diffCount += Math.abs(countMap[i]);
            }
        }
        return diffCount / 2;
    }
}