class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int n = s1.length();
        int diffCount = 0;
        int firstMismatch = 0, secondMismatch = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
                if (diffCount > 2) {
                    return false;
                } else if (diffCount == 1) {
                    firstMismatch = i;
                } else if (diffCount == 2) {
                    secondMismatch = i;
                }
            }
        }
        if (s1.charAt(firstMismatch) == s2.charAt(secondMismatch)
                && s1.charAt(secondMismatch) == s2.charAt(firstMismatch)) {
            return true;
        }
        return false;
    }
}