class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == word.charAt(0)) {
                    boolean isFound = dfs(board, r, c, word, 0);
                    if (isFound) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int r, int c, String word, int wordIndex) {
        // base case
        // valid
        if (word.length() == wordIndex) {
            return true;
        }
        // out of bound cases
        int rows = board.length;
        int cols = board[0].length;
        if (r < 0 || c < 0 || r >= rows || c >= cols) {
            return false;
        }
        // invalid cases
        if (board[r][c] == ' ' || board[r][c] != word.charAt(wordIndex)) {
            return false;
        }
        // mark as visited
        char ch = board[r][c];
        board[r][c] = ' ';
        if (dfs(board, r + 1, c, word, wordIndex + 1)
                || dfs(board, r - 1, c, word, wordIndex + 1)
                || dfs(board, r, c + 1, word, wordIndex + 1)
                || dfs(board, r, c - 1, word, wordIndex + 1)) {
            return true;
        }
        // backtracking
        board[r][c] = ch;
        return false;
    }
}