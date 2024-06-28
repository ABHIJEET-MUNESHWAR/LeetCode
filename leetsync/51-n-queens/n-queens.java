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
        solve(board, 0);
        return result;
    }

    private void solve(List<String> board, int row) {
        if (row == board.size()) {
            result.add(new ArrayList<>(board));
            return;
        }
        // Place one queen at every row and check before placing
        // in every direction where there is a risk of being attacked
        // i.e., up, diagonally because we are placing queens from
        // the top row to the bottom row, so we need to check if we put a queen
        // vertically up in some row or diagonally upwards in same row
        for (int i = 0; i < board.size(); i++) {
            if (isValid(board, row, i)) {
                StringBuilder newRow = new StringBuilder(board.get(row));
                newRow.setCharAt(i, 'Q');
                board.set(row, newRow.toString());

                solve(board, row + 1);

                newRow.setCharAt(i, '.');
                board.set(row, newRow.toString());
            }
        }
    }

    private boolean isValid(List<String> board, int row, int col) {
        // Look up
        for (int i = row; i >= 0; i--) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        // Check left diagonal upwards
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        // Check right diagonal upwards
        for (int i = row, j = col; i >= 0 && j < board.size(); i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }
}