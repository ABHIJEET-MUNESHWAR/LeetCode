class Solution {

    int count = 0;

    public int countSubstrings(String s) {
        int size = s.length();
        for (int i = 0; i < size; i++) {
            isPalindromeFound(s, i, i);
            isPalindromeFound(s, i, i + 1);
        }
        return count;
    }

    private void isPalindromeFound(String s, int i, int j) {
        int size = s.length();
        while ((i >= 0) && (j < size) && (s.charAt(i) == s.charAt(j))) {
            count++;
            i--;
            j++;
        }
    }
}