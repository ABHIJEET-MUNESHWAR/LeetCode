class Solution {
    public int findMinArrowShots(int[][] points) {
        int arrowsCount = 1;
        int size = points.length;
        if (size == 1) {
            return 1;
        }
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int commonEndPoint = points[0][1];
        for (int i = 1; i < size; i++) {
            int currentStart = points[i][0];
            int currentEnd = points[i][1];
            if (commonEndPoint < currentStart) {
                commonEndPoint = currentEnd;
                arrowsCount++;
            }
        }
        return arrowsCount;
    }
}