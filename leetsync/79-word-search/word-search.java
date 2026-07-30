class Solution {
    int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] isVisited = new boolean[m][n];
                if (board[i][j] == word.charAt(0)) {
                    if (wordSearchDFS(board, word, 0, i, j, isVisited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean wordSearchDFS(char[][] board, String word, int index, int i, int j, boolean[][] isVisited) {
        int m = board.length;
        int n = board[0].length;
        if (index == word.length() - 1) {
            return true;
        }
        isVisited[i][j] = true;
        for (int[] direction : directions) {
            int i_ = i + direction[0];
            int j_ = j + direction[1];
            if (i_ >= 0 && j_ >= 0 && i_ < m && j_ < n && !isVisited[i_][j_]
                    && board[i_][j_] == word.charAt(index + 1)) {
                if (wordSearchDFS(board, word, index + 1, i_, j_, isVisited)) {
                    return true;
                }
            }
        }
        isVisited[i][j] = false;
        return false;
    }
}