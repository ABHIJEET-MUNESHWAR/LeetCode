class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int size = piles.length;
        int low = 1;
        int high = piles[size - 1];
        while (low < high) {
            int mid = (low + high) / 2;
            if (canEatAllBanana(piles, mid, h)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canEatAllBanana(int[] piles, int mid, int h) {
        int totalHours = 0;
        for (int pile : piles) {
            totalHours += pile / mid;
            if (pile % mid != 0) {
                totalHours++;
            }
        }
        return totalHours <= h;
    }
}