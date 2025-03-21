class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int size = customers.length;
        int maxUnsatisfiedCustomers = 0;
        int currentUnsatisfiedCustomers = 0;
        for (int i = 0; i < minutes; i++) {
            currentUnsatisfiedCustomers += customers[i] * grumpy[i];
        }
        maxUnsatisfiedCustomers = currentUnsatisfiedCustomers;
        int left = 0;
        int right = minutes;
        while (right < size) {
            currentUnsatisfiedCustomers += customers[right] * grumpy[right];
            currentUnsatisfiedCustomers -= customers[left] * grumpy[left];
            maxUnsatisfiedCustomers = Math.max(currentUnsatisfiedCustomers, maxUnsatisfiedCustomers);
            left++;
            right++;
        }
        int totalSatisfied = maxUnsatisfiedCustomers;
        for (int i = 0; i < size; i++) {
            if (grumpy[i] == 0) {
                totalSatisfied += customers[i];
            }
        }
        return totalSatisfied;
    }
}