class Solution {
    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> currentList = new ArrayList<>();
        backtrack(n, k, 1, currentList);
        return resultList;
    }

    public void backtrack(int n, int k, int index, List<Integer> currentList) {
        if (k == 0) {
            resultList.add(new ArrayList<>(currentList));
            return;
        }
        if (index > n) {
            return;
        }
        currentList.add(index);
        backtrack(n, k - 1, index + 1, currentList);
        currentList.remove(currentList.size() - 1);
        backtrack(n, k, index + 1, currentList);
    }
}