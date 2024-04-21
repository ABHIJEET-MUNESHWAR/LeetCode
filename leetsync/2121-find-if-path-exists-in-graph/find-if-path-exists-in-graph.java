class DisjointSetUnion {

  private int[] parent;
  private int n;

  public DisjointSetUnion(int n) {
    this.n = n;
    this.parent = new int[n];
    for (int i = 0; i < n; i++) {
      this.parent[i] = i;
    }
  }

  public int find(int u) {
    int x = u;
    while (x != this.parent[x]) {
      x = this.parent[x];
    }
    this.parent[u] = x;
    return x;
  }

  public void union(int u, int v) {
    if (u != v) {
      int x = find(u);
      int y = find(v);
      parent[x] = y;
    }
  }

  public boolean areConnected(int u, int v) {
    return find(u) == find(v);
  }
}
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        DisjointSetUnion disjointSetUnion = new DisjointSetUnion(n);
        for (int[] edge : edges) {
            disjointSetUnion.union(edge[0], edge[1]);
        }
        return disjointSetUnion.areConnected(source, destination);        
    }
}