class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        int n = candidates.length;
        combinationSumBackTrack(candidates, target, n, 0, currentList, resultList);
        return resultList;
    }

    public void combinationSumBackTrack(int[] candidates, int remainingTarget, int n, int index,
            List<Integer> currentList, List<List<Integer>> resultList) {
        if (remainingTarget == 0) {
            resultList.add(new ArrayList(currentList));
            return;
        }
        if (remainingTarget < 0 || index >= n) {
            return;
        }
        for (int j = index; j < n; j++) {
            currentList.add(candidates[j]);
            combinationSumBackTrack(candidates, remainingTarget - candidates[j], n, j, currentList, resultList);
            currentList.remove(currentList.size() - 1);
        }
    }
}