class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        int n = s.length();
        if (n < 3) {
            return s;
        }
        result.append(s.charAt(0)).append(s.charAt(1));
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1) && s.charAt(i - 1) == s.charAt(i - 2)) {
                //
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}