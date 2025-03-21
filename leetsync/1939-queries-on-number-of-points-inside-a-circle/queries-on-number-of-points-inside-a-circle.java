class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {

        int[] res = new int[queries.length];
        int i = 0;
        for (int[] query : queries) {
            int pts = 0;
            for (int[] point : points) {
                if ((point[0] - query[0]) * (point[0] - query[0])
                        + (point[1] - query[1]) * (point[1] - query[1]) <= query[2] * query[2]) {
                    pts++;
                }
            }
            res[i++] = pts;
        }
        return res;
    }
}