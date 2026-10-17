class Solution {
    public int solve(List<List<Integer>> triangle, int row, int col){
        int n = triangle.size();
        if(row==n-1){
            return triangle.get(row).get(col);
        }
        int minPath = triangle.get(row).get(col)+Math.min(solve(triangle, row +1, col), solve(triangle, row+1, col+1));
        return minPath;
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        return solve(triangle, 0,0);
    }
}