class Solution {
    public int minSwaps(String s) {        
        int n = s.length();
        int extraClose = 0;
        int maxExtraClose = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ']') {
                extraClose++;
            } else {
                extraClose--;
            }
            maxExtraClose = Math.max(maxExtraClose, extraClose);
        }
        int result = (maxExtraClose + 1) / 2;
        return result;
    }
}