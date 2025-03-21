class Solution {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return result;
        }
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append(".");
            }
            board.add(row.toString());
        }
        int startRow = 0;
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diagonals = new HashSet<>();
        Set<Integer> antiDiagonals = new HashSet<>();
        solveOptimised(board, startRow, cols, diagonals, antiDiagonals);
        return result;
    }

    private void solveOptimised(List<String> board, int row, Set<Integer> cols, Set<Integer> diagonals,
            Set<Integer> antiDiagonals) {
        if (row == board.size()) {
            result.add(new ArrayList<>(board));
            return;
        }
        /*
         * For a square (i, j) : Diagonally (i-j) is constant Anti diagonally (i+j) is
         * constant
         *
         * We can use this to find which square (i, j) has a risk of being attacked
         * by another queen placed already in 'diagonal', or 'anti-diagonal' or
         * 'column'
         */
        for (int col = 0; col < board.size(); col++) {
            int diagonalId = row - col;
            int antiDiagonalId = row + col;
            /*
             * If the col, or diagonal or anti_diagonal are used means one of them has a
             * Queen placed already which can attack, so look for other column
             */
            if (cols.contains(col) || antiDiagonals.contains(antiDiagonalId) || diagonals.contains(diagonalId)) {
                continue;
            }
            cols.add(col);
            diagonals.add(diagonalId);
            antiDiagonals.add(antiDiagonalId);

            StringBuilder newRow = new StringBuilder(board.get(row));
            newRow.setCharAt(col, 'Q');
            board.set(row, newRow.toString());

            solveOptimised(board, row + 1, cols, diagonals, antiDiagonals);

            cols.remove(col);
            antiDiagonals.remove(antiDiagonalId);
            diagonals.remove(diagonalId);

            newRow.setCharAt(col, '.');
            board.set(row, newRow.toString());
        }
    }
}