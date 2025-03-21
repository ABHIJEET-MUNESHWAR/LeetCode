class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int sizeOfSpells = spells.length;
        int[] result = new int[sizeOfSpells];
        for (int i = 0; i < sizeOfSpells; i++) {
            result[i] = eligiblePotionsUsingBinarySearch(potions, success, spells[i]);
        }
        return result;
    }

    private int eligiblePotionsUsingBinarySearch(int[] potions, long success, int spell) {
        int size = potions.length;
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long searchKey = (long)potions[mid] * spell;
            if (searchKey < success) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (size - left);
    }
}