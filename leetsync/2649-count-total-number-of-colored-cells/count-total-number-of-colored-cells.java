class Solution {
    public long coloredCells(int n) {
        int time = 1;
        long cells = 1;
        while (time <= n) {
            cells += (4 * (time - 1));
            time++;
        }
        return cells;
    }
}