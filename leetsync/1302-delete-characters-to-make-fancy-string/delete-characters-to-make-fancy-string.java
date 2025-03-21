class Solution {
    public String makeFancyString(String s) {
        char prev = s.charAt(0);
        int freq = 1;
        StringBuilder result = new StringBuilder();
        result.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == prev) {
                freq++;
            } else {
                prev = s.charAt(i);
                freq = 1;
            }
            if (freq < 3) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}