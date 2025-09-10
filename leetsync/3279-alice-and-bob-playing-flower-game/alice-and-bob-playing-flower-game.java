class Solution {
    public long flowerGame(int n, int m) {
        long oddN = (n + 1) / 2;// ceil(n/2)
        long evenN = (n) / 2;// floor(n/2)
        long oddM = (m + 1) / 2;// ceil(m/2)
        long evenM = m / 2;// floor(m/2)
        return oddN * evenM + evenN * oddM;
    }
}