class Solution {
    public int lengthOfLastWord(String s) {
        int size = 0;
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
          if (s.charAt(i) != ' ') {
            size++;
          } else {
            if (size > 0) {
              return size;
            }
          }
        }
        return size;      
    }
}