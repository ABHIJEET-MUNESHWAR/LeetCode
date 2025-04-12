package com.leetcode.medium.array;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   12-04-2025
    Time:   09:25 pm
    https://leetcode.com/problems/design-tic-tac-toe/description/
    348. Design Tic-Tac-Toe
    https://leetcode.ca/all/348.html
*/

import java.util.ArrayList;
import java.util.List;

public class TicTacToe {
    List<Integer> rows;
    List<Integer> cols;
    int diagonal;
    int antiDiagonal;

    public TicTacToe(int n) {
        rows = new ArrayList<>(n);
        cols = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            rows.add(0);
            cols.add(0);
        }
        diagonal = 0;
        antiDiagonal = 0;
    }

    public int move(int row, int col, int player) {
        int n = rows.size();
        int currentPlayer = player == 1 ? 1 : -1;
        rows.set(row, rows.get(row) + currentPlayer);
        cols.set(col, cols.get(col) + currentPlayer);
        if (row == col) {
            diagonal += currentPlayer;
        }
        if (col == (n - row - 1)) {
            antiDiagonal += currentPlayer;
        }
        if (Math.abs(rows.get(row)) == n
                || Math.abs(cols.get(col)) == n
                || Math.abs(diagonal) == n
                || Math.abs(antiDiagonal) == n
        ) {
            return player;
        }
        return 0;
    }
}
