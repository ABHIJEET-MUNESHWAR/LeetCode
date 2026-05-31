class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currentmass = mass;
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > currentmass)
                return false;
            currentmass += asteroids[i];
        }
        return true;
    }
}