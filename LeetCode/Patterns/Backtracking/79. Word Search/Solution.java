class Solution {
    public boolean existBackTrackDfs(char[][] board, int i, int j, String word, int wordIndex, boolean[][] isVisited) {
        if (wordIndex == word.length() - 1) {
            return true;
        }
        isVisited[i][j] = true;
        int m = board.length;
        int n = board[0].length;
        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        for (int[] direction : directions) {
            int i_ = i + direction[0];
            int j_ = j + direction[1];
            if (i_ >= 0 && i_ < m && j_ >= 0 && j_ < n && board[i_][j_] == word.charAt(wordIndex + 1)) {
                if (!isVisited[i_][j_] && existBackTrackDfs(board, i_, j_, word, wordIndex + 1, isVisited)) {
                    return true;
                }
            }
        }
        isVisited[i][j] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j] && word.charAt(0) == board[i][j]
                        && existBackTrackDfs(board, i, j, word, 0, isVisited)) {
                    return true;
                }
            }
        }
        return false;
    }
}