class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int size = profits.length;
        int[][] projects = new int[size][2];
        for (int i = 0; i < size; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }
        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0])); // Sort based on capital value
        int i = 0;
        PriorityQueue<Integer> maximiseCapital = new PriorityQueue<>(Collections.reverseOrder());
        while (k-- > 0) {
            while (i < size && projects[i][0] <= w) {
                maximiseCapital.add(projects[i][1]);
                i++;
            }
            if (maximiseCapital.isEmpty()) {
                break;
            }
            w += maximiseCapital.poll();
        }
        return w;
    }
}