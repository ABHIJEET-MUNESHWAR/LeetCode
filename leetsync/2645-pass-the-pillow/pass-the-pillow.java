class Solution {
    public int passThePillow(int n, int time) {

        if (n > time) {
            return time + 1;
        } else {
            int division = time / (n-1);
            int remainder = time % (n-1);
            if (division % 2 == 0) {
                return (remainder + 1);
            } else {
                return n - remainder;
            }
        }
    }
}