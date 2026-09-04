class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, target, result, current, 0);
        return result;
    }

    private void solve(int[] candidates, int target, List<List<Integer>> result, List<Integer> current, int index) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                // Ignore duplicate elements
                continue;
            }
            current.add(candidates[i]);
            solve(candidates, target - candidates[i], result, current, i + 1);
            current.remove(current.size() - 1);
        }
    }
}