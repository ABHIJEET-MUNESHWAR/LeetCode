class Solution {
    public void combinationBackTrack(int n, int k, int index, List<Integer> currentList,
            List<List<Integer>> resultList) {
        if (currentList.size() == k) {
            resultList.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = index; i <= n; i++) {
            currentList.add(i);
            combinationBackTrack(n, k, i + 1, currentList, resultList);
            currentList.remove(currentList.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        combinationBackTrack(n, k, 1, currentList, resultList);
        return resultList;
    }
}