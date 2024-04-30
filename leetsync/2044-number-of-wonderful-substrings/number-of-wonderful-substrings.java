class Solution {
    public long wonderfulSubstrings(String word) {
        long answer = 0;
        int size = word.length();
        int[] counts = new int[1024];
        int mask = 0;
        counts[0] = 1;
        for (int i = 0; i < size; i++) {
            mask = mask ^ (1 << ((int) (word.charAt(i) - 'a')));
            answer += counts[mask];
            for (int j = 0; j < 10; j++) {
                int newMask = mask ^ (1 << j);
                answer += counts[newMask];
            }
            counts[mask]++;
        }
        return answer;
    }
}