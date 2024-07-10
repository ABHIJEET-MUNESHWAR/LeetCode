class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        double sum = 0;
        double previousDelay = 0;
        for (int[] customer : customers) {
            double customerArrivalTime = customer[0];
            double cookingDuration = customer[1];
            double cookingStartTime = Math.max(previousDelay, customerArrivalTime);
            double cookingEndTime = cookingStartTime + cookingDuration;
            double waitingTime = cookingEndTime - customerArrivalTime;
            previousDelay = cookingEndTime;
            sum += waitingTime;
        }
        return sum / n;
    }
}