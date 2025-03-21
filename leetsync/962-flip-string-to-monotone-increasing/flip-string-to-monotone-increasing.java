class Solution {

    public int minFlipsMonoIncr(String s) {
        char[] chars = s.toCharArray();
        int size = s.length();
        int countOfOnce = 0;
        int flips = 0;
        for (char ch : chars) {
            if (ch == '1') {
                countOfOnce++;
            } else {
                flips = Math.min(flips + 1, countOfOnce);
            }
        }
        return flips;
    }
}