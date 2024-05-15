class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        int size = s.length();
        Set<Character> set = new HashSet<>();
        int maxLength = 0, i = 0, j = 0;
        while (j < size) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxLength = Math.max(maxLength, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return maxLength;
    }
}