class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, maxLength = 0;
        while (j < n) {
            char ch = s.charAt(j);
            if (!set.contains(ch)) {
                set.add(ch);
                j++;
                maxLength = Math.max(maxLength, set.size());
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxLength;
    }
}