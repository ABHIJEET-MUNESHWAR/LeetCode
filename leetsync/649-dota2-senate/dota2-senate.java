class Solution {
    public String predictPartyVictory(String senate) {

        char[] chars = senate.toCharArray();
        int r = 0, d = 0;
        int n = chars.length;
        for (char ch : chars) {
            if (ch == 'R') {
                r++;
            } else {
                d++;
            }
        }
        int startIndex = 0;
        while (r > 0 && d > 0) {
            while (chars[startIndex] == ' ') {
                startIndex = (startIndex + 1) % n;
            }
            char ban = 'R';
            if (chars[startIndex] == 'R') {
                ban = 'D';
                d--;
            } else {
                r--;
            }
            int nextIndex = (startIndex + 1) % n;
            while (chars[nextIndex] != ban) {
                nextIndex = (nextIndex + 1) % n;
            }
            chars[nextIndex] = ' ';
            startIndex = (startIndex + 1) % n;
        }
        return r > 0 ? "Radiant" : "Dire";
    }
}