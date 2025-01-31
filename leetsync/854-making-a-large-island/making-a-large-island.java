//Approach-4 (Using DSU)
//T.C : O(m*n * alpha(m*n))
//S.C : O(m*n)
class DSU {
    private int[] parent;
    private int[] size;

    public DSU(int n) {
        parent = new int[n];
        size = new int[n];
        Arrays.fill(size, 1);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]); // Path Compression
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY)
            return;

        if (size[rootX] > size[rootY]) {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        } else {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }
    }

    public int getSize(int x) {
        return size[find(x)];
    }
}

class Solution {
    private static final int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int totalCells = n * n;
        DSU dsu = new DSU(totalCells);
        int maxArea = 0;

        // Step 1: Connect all existing 1s using DSU
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int idx = i * n + j;
                    for (int[] dir : directions) {
                        int i_ = i + dir[0], j_ = j + dir[1];
                        int idx_ = i_ * n + j_;
                        if (i_ >= 0 && i_ < n && j_ >= 0 && j_ < n && grid[i_][j_] == 1) {
                            dsu.union(idx, idx_);
                        }
                    }
                }
            }
        }

        // Step 2: Find the largest island without modification
        for (int idx = 0; idx < totalCells; idx++) {
            if (grid[idx / n][idx % n] == 1) {
                maxArea = Math.max(maxArea, dsu.getSize(idx));
            }
        }

        // Step 3: Try flipping each 0 to 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> uniqueParents = new HashSet<>();
                    for (int[] dir : directions) {
                        int i_ = i + dir[0], j_ = j + dir[1];
                        int idx_ = i_ * n + j_;
                        if (i_ >= 0 && i_ < n && j_ >= 0 && j_ < n && grid[i_][j_] == 1) {
                            uniqueParents.add(dsu.find(idx_));
                        }
                    }

                    int newSize = 1; // Flip this 0 to 1
                    for (int parent : uniqueParents) {
                        newSize += dsu.getSize(parent);
                    }
                    maxArea = Math.max(maxArea, newSize);
                }
            }
        }

        return maxArea;
    }
}