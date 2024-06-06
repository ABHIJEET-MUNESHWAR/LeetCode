class Solution {

    public int find(int i, int[] parent) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i], parent);
    }

    public void union(int i, int j, int[] parent, int[] rank) {
        int parentOfI = find(i, parent);
        int parentOfJ = find(j, parent);
        if (parentOfI == parentOfJ) {
            return;
        }
        if (rank[parentOfI] > rank[parentOfJ]) {
            parent[parentOfJ] = parentOfI;
        } else if (rank[parentOfI] < rank[parentOfJ]) {
            parent[parentOfI] = parentOfJ;
        } else {
            parent[parentOfI] = parentOfJ;
            rank[parentOfJ]++;
        }
    }

    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[27];
        int[] rank = new int[27];
        for (int i = 1; i <= 26; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        // First do union of equal chars
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                // a == b
                union(equation.charAt(0) - 'a', equation.charAt(3) - 'a', parent, rank);
            }
        }
        // Find not equal to cases & validate
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                // a != b
                if (find(equation.charAt(0) - 'a', parent) == find(equation.charAt(3) - 'a', parent)) {
                    return false;
                }
            }
        }
        return true;
    }
}