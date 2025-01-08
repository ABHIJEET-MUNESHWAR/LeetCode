class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];
        int cumValue = 0, cumValueSum = 0;
        // Find moves for all left balls to index i
        for (int i = 0; i < n; i++) {
            answer[i] = cumValueSum;
            cumValue += boxes.charAt(i) == '0' ? 0 : 1;
            cumValueSum += cumValue;
        }
        cumValue = 0;
        cumValueSum = 0;
        // Find moves for all right balls to index i
        for(int i=n-1; i>=0; i--){
            answer[i]+=cumValueSum;
            cumValue+=boxes.charAt(i)=='0'?0:1;
            cumValueSum+=cumValue;
        }
        return answer;
    }
}