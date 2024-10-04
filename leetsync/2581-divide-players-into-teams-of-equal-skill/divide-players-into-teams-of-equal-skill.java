class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        Arrays.sort(skill);
        int i = 0;
        int j = n - 1;
        int s = skill[i] + skill[j];
        long chemistry = 0l;
        while (i < j) {
            int currentSkill = skill[i] + skill[j];
            if (currentSkill != s) {
                return -1;
            }
            chemistry += (long) skill[i] * (long) skill[j];
            i++;
            j--;
        }
        return chemistry;
    }
}