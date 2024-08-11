class Solution {
    public int minDays(int[][] grid) {
        if(noOfIsland(grid) != 1){
            return 0;
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    if(noOfIsland(grid) != 1){
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }
    
    private int noOfIsland(int [][]grid){
        int ans = 0;
        boolean [][]visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    ans ++;
                    dfs(visited, grid,i,j);
                }
            }
        }
        return ans;
    }
    
    private void dfs(boolean [][]visited, int [][]grid,int i, int j){
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || visited[i][j] || grid[i][j] == 0){
            return ;
        }
        visited[i][j] = true;
        dfs(visited, grid, i-1, j);
        dfs(visited, grid, i+1, j);
        dfs(visited, grid, i, j-1);
        dfs(visited, grid, i, j+1);
    }
}