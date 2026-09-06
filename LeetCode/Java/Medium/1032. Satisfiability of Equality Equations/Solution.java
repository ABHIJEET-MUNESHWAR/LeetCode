class Solution {
    public int find(int i, int[] parent) {
        if (i == parent[i]) {
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
        for (int i = 1; i < 27; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        for (String equation : equations) {
            // a==b
            if (equation.charAt(1) == '=') {
                union(equation.charAt(0) - 'a', equation.charAt(3) - 'a', parent, rank);
            }
        }
        for (String equation : equations) {
            // a==b
            if (equation.charAt(1) == '!') {
                int parentOfFirst = find(equation.charAt(0) - 'a', parent);
                int parentOfSecond = find(equation.charAt(3) - 'a', parent);
                if (parentOfFirst == parentOfSecond) {
                    return false;
                }
            }
        }
        return true;
    }
}