class Solution {
    int[] t = new int[51];
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Set<String> set = new HashSet<>();
        for (String word : dictionary) {
            set.add(word);
        }
        Arrays.fill(t, -1);
        return solve(0, s, set, n);
    }

    public int solve(int index, String s, Set<String> set, int n) {
        if (index >= n) {
            return 0;
        }
        if(t[index]!=-1){
            return t[index];
        }
        int result = 1 + solve(index + 1, s, set, n); // skipping the ith character
        for (int j = index; j < n; j++) {
            String current = s.substring(index, j + 1);
            if (set.contains(current)) {
                result = Math.min(result, solve(j + 1, s, set, n));
            }
        }
        return t[index]=result;
    }
}