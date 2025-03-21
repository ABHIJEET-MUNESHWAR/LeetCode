class Solution {
    public int numSteps(String s) {
        int steps = 0;
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > 1) {
            int lsb = sb.length() - 1;
            if (sb.charAt(lsb) == '0') {
                sb.deleteCharAt(lsb);
            } else {
                while (lsb >= 0 && sb.charAt(lsb) == '1') {
                    sb.setCharAt(lsb--, '0');
                }
                if (lsb > 0) {
                    sb.setCharAt(lsb, '1');
                } else {
                    sb.insert(0, '1');
                }
            }
            steps++;
        }
        return steps;
    }
}