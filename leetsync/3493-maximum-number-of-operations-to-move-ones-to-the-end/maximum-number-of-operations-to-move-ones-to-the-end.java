class Solution {
    public int maxOperations(String s) {
        int n = s.length();
        int result = 0;
        int once = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                result += once;
                while (i < n && s.charAt(i) != '1') {
                    i++;
                }
            }
            once++;
        }
        return result;
    }
}