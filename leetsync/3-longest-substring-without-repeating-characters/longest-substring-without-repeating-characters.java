class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, maxLength = 0;
        while (j < n) {
            char ch = s.charAt(j);
            int currentLength = 0;
            if (!set.contains(ch)) {
                set.add(ch);
                j++;
                currentLength = j - i;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxLength;
    }
}