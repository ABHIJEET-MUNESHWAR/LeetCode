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
        int n = equations.length;
        int[] parent = new int[27];
        int[] rank = new int[27];
        for (int i = 0; i < 27; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        for (String equation : equations) {
            int a = equation.charAt(0) - 'a';
            int b = equation.charAt(3) - 'a';
            if (equation.charAt(1) == '=') {
                union(a, b, parent, rank);
            } else {
                int parentOfA = find(a, parent);
                int parentOfB = find(b, parent);
                if (parentOfA == parentOfB) {
                    return false;
                }
            }
        }
        return true;
    }
}