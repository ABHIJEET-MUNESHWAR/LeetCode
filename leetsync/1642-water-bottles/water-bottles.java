class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalFullBottles = 0;
        int totalEmptyBottles = numBottles;
        int totalBottlesDrank = numBottles;
        while (totalEmptyBottles >= numExchange) {
            totalFullBottles = totalEmptyBottles / numExchange;
            totalEmptyBottles = totalEmptyBottles % numExchange + totalFullBottles;
            totalBottlesDrank += totalFullBottles;
        }
        return totalBottlesDrank;
    }
}