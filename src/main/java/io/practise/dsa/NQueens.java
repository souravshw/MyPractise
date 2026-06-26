package io.practise.dsa;

import java.util.*;

public class NQueens {

    // Backtracking - O(n!)
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        backtrack(0, board, res);
        return res;
    }

    private void backtrack(int row, char[][] board, List<List<String>> res) {
        if (row == board.length) {
            List<String> list = new ArrayList<>();
            for (char[] r : board) list.add(new String(r));
            res.add(list);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(row + 1, board, res);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q') return false;
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
            if (board[i][j] == 'Q') return false;
        return true;
    }

    public static void main(String[] args) {
        NQueens solver = new NQueens();
        int n = 4;

        System.out.println("--- N-Queens Demonstration ---");
        List<List<String>> solutions = solver.solveNQueens(n);
        System.out.println("Number of solutions for 4-Queens: " + solutions.size());
        System.out.println("Example Solution:");
        for (String row : solutions.get(0)) {
            System.out.println(row);
        }
    }
}
