class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int curr = ch - 'a';
            if (first[curr] == -1) {
                first[curr] = i;
            }
            last[curr] = i;
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) {
                continue;
            }
            Set<Character> set = new HashSet<>();
            for (int middle = first[i] + 1; middle < last[i]; middle++) {
                set.add(s.charAt(middle));
            }
            result += set.size();
        }
        return result;
    }
}