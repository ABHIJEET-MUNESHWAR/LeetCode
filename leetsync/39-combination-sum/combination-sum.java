class Solution {
    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> currentList = new ArrayList<>();
        combinationSum(candidates, target, candidates.length, currentList, 0);
        return resultList;
    }

    public void combinationSum(int[] candidates, int remainingTarget, int n, List<Integer> currentList, int index) {
        if (remainingTarget == 0) {
            resultList.add(new ArrayList<>(currentList));
            return;
        }
        if (index >= n || remainingTarget < 0) {
            return;
        }
        for (int i = index; i < n; i++) {
            currentList.add(candidates[i]);
            combinationSum(candidates, remainingTarget - candidates[i], n, currentList, i);
            currentList.remove(currentList.size() - 1);
        }
    }
}