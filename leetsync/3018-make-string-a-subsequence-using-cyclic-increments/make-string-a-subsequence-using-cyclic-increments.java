class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if ((str1.charAt(i) == str2.charAt(j))
                    || ((str1.charAt(i) + 1) == str2.charAt(j))
                    || ((str1.charAt(i) - 25) == str2.charAt(j))) {
                j++;
            }
            i++;
        }
        return j == n;
    }
}