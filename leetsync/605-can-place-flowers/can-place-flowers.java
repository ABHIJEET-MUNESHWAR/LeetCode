class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        if (n == 0) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 0) {
                boolean isLeftEmpty = (i == 0) || (flowerbed[i - 1] == 0);
                boolean isRightEmpty = (i == length - 1) || (flowerbed[i + 1] == 0);
                if (isLeftEmpty && isRightEmpty) {
                    flowerbed[i] = 1;
                    n--;
                    if (n == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}