class Solution {
	int find(int i, int[] parent) {
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
		if (rank[parentOfI]>rank[parentOfJ]) {
			parent[parentOfJ] = parentOfI;
		} else if (rank[parentOfI]<rank[parentOfJ]) {
			parent[parentOfI] = parentOfJ;
		} else {
			parent[parentOfI] = parentOfJ;
			rank[parentOfJ]++;
		}
	}
	public boolean detectCycle(int nodes, ArrayList<ArrayList<Integer>> adj) {
		int[] parent = new int[nodes];
		int[] rank = new int[nodes];
		for (int i = 0; i<nodes; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
		for (int u = 0; u<nodes; u++) {
			for (int v: adj.get(u)) {
				if (u<v) {
					int parentOfU = find(u, parent);
					int parentOfV = find(v, parent);
					if (parentOfU == parentOfV) {
						return true;
					}
					union(u, v, parent, rank);
				}
			}
		}
		return false;
	}
}
