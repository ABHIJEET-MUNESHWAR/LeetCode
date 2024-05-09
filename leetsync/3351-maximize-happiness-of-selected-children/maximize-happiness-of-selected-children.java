class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long answer = 0;
        int dec = 0;
        int size = happiness.length;
        for (int i = size - 1; i >= size - k; i--) {
            answer += Math.max(0, happiness[i] - dec);
            dec++;
        }
        return answer;
    }
}