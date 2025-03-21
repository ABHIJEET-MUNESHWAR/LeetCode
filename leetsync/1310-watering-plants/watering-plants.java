class Solution {
    public int wateringPlants(int[] plants, int capacity) {

        int totalSteps = 0;
        int size = plants.length;
        int currentCapacity = capacity;
        for (int i = 0; i < size; i++) {
            if (currentCapacity >= plants[i]) {
                currentCapacity -= plants[i];
                totalSteps++;
            } else {
                currentCapacity = capacity;
                totalSteps += (i * 2) + 1;
                currentCapacity -= plants[i];
            }
        }
        return totalSteps;
    }
}