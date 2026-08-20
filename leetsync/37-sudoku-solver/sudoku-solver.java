class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean isValidSudoku(char[][] board, int row, int col, char d) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == d) {
                return false;
            }
            if (board[i][col] == d) {
                return false;
            }
        }
        int start_i = (row / 3) * 3;
        int start_j = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + start_i][j + start_j] == d) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char d = '1'; d <= '9'; d++) {
                        if (isValidSudoku(board, i, j, d)) {
                            board[i][j] = d;

                            if (solve(board)) {
                                return true;
                            }

                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}