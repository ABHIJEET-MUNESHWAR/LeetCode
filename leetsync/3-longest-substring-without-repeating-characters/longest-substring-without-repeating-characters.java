class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (s == null || n == 0) {
            return 0;
        }
        int i = 0, j = 0, maxLength = 0;
        Set<Character> set = new HashSet<>();
        while (j < n) {
            char ch = s.charAt(j);
            if (!set.contains(ch)) {
                set.add(ch);
                j++;
            } else {
                set.remove(s.charAt(i++));
            }
            maxLength = Math.max(maxLength, set.size());
        }
        return maxLength;
    }
}