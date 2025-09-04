class Solution {
    public int findClosest(int x, int y, int z) {
        int dist1 = Math.abs(x - z);
        int dist2 = Math.abs(z - y);
        if (dist1 == dist2) {
            return 0;
        } else if (dist1 < dist2) {
            return 1;
        } else {
            return 2;
        }
    }
}