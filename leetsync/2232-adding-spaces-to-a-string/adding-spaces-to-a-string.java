class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int m = s.length();
        int n = spaces.length;
        int j = 0;
        for (int i = 0; i < m; i++) {
            if (j < n && i == spaces[j]) {
                sb.append(" ");
                j++;
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}