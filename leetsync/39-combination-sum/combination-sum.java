class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        combinationSumBackTrack(candidates, candidates.length, target, 0, currentList, resultList);
        return resultList;
    }

    public void combinationSumBackTrack(int[] candidates, int n, int remainingTarget, int index,
            List<Integer> currentList, List<List<Integer>> resultList) {
        if (remainingTarget == 0) {
            resultList.add(new ArrayList<>(currentList));
            return;
        }
        if (remainingTarget < 0 || index > n) {
            return;
        }
        for (int i = index; i < n; i++) {
            currentList.add(candidates[i]);
            combinationSumBackTrack(candidates, n, remainingTarget - candidates[i], i, currentList, resultList);
            currentList.remove(currentList.size() - 1);
        }
    }
}