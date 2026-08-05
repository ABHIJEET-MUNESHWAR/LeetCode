class Solution {
    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> currentList = new ArrayList<>();
        int n = candidates.length;
        Arrays.sort(candidates);
        backTrack(candidates, target, n, 0, currentList);
        return resultList;
    }

    public void backTrack(int[] candidates, int target, int n, int index, List<Integer> currentList) {
        if (target == 0) {
            resultList.add(new ArrayList<>(currentList));
            return;
        }
        if (target < 0 || index == n) {
            return;
        }
        for (int i = index; i < n; i++) {
            currentList.add(candidates[i]);
            backTrack(candidates, target - candidates[i], n, i, currentList);
            currentList.remove(currentList.size() - 1);
        }
    }
}