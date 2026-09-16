class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int size = 0;
        for (int i = n - 1; i >= 0; i--) {
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