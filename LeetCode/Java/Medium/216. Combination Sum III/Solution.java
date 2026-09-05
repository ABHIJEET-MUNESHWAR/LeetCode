class Solution {
    public void combinationSum3BackTrack(int k, int target, int index, List<Integer> currentList,
            List<List<Integer>> resultList) {
        if (target == 0 && currentList.size() == k) {
            resultList.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = index; i <= 9; i++) {
            currentList.add(i);
            combinationSum3BackTrack(k, target - i, i + 1, currentList, resultList);
            currentList.remove(currentList.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        combinationSum3BackTrack(k, target, 1, currentList, resultList);
        return resultList;
    }
}