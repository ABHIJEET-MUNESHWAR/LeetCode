class Solution {
    public int maxDistance(String s, int k) {
        int maxMd = 0;
        int east = 0, west = 0, south = 0, north = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case 'E':
                    east++;
                    break;

                case 'W':
                    west++;
                    break;

                case 'N':
                    north++;
                    break;

                case 'S':
                    south++;
                    break;
            }
            int currentMd = Math.abs(north - south) + Math.abs(east - west);
            int steps = i + 1;
            int wasted = steps - currentMd;
            int extra = Math.min(2 * k, wasted);
            int finalCurrentMd = currentMd + extra;
            maxMd = Math.max(maxMd, finalCurrentMd);
        }
        return maxMd;
    }
}