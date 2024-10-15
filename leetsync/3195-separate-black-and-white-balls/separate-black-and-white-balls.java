class Solution {
    public long minimumSteps(String s) {
        int n = s.length();
        long swaps = 0l, once = 0l;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '1') {
                once++;
            } else {
                swaps += once;
            }
        }
        return swaps;
    }
}