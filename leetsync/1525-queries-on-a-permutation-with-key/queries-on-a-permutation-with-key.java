class Solution {
    public int[] processQueries(int[] queries, int m) {

        int size = queries.length;
        int[] answer = new int[size];
        LinkedList<Integer> permutations = new LinkedList<>();
        for (int i = 1; i <= m; i++) {
            permutations.add(i);
        }
        for (int i = 0; i < size; i++) {
            int index = permutations.indexOf(queries[i]);
            answer[i] = index;
            permutations.addFirst(permutations.remove(index));
        }
        return answer;
    }
}