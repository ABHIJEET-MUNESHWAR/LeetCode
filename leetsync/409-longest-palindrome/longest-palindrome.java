class Solution {
    public int longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
          return 0;
        }
        HashSet<Character> hashSet = new HashSet<>();
        int size = s.length();
        int count = 0;
        for (int i = 0; i < size; i++) {
          char ch = s.charAt(i);
          if (hashSet.contains(ch)) {
            hashSet.remove(ch);
            count++;
          } else {
            hashSet.add(ch);
          }
        }
        if (hashSet.isEmpty()) {
          return count * 2;
        } else {
          return count * 2 + 1;
        }        
    }
}