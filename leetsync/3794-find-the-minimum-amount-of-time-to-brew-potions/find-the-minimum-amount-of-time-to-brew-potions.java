class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long[] finishTime = new long[n]; // finishTime[i] = when wizard i finishes current potion

        for (int j = 0; j < m; ++j) {
            finishTime[0] += (long) mana[j] * skill[0];

            for (int i = 1; i < n; ++i) {
                finishTime[i] = Math.max(finishTime[i], finishTime[i - 1]) + (long) mana[j] * skill[i];
            }

            for (int i = n - 1; i > 0; --i) {
                finishTime[i - 1] = finishTime[i] - (long) mana[j] * skill[i];
            }
        }

        return finishTime[n - 1];
    
    }
}