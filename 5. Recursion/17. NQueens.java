// -----Back Tracking-----
// Leetcode-51: N-Queens
// Level-Hard

// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

// Input: n = 4
// Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above


class Solution {
    public void generate(char[][] board, int row, List<List<String>> res) {
        // once the rows are finished then convert each row into string and add into res
        if(row == board.length) {
            List<String> list = new ArrayList<>();
            for(int i = 0; i < board.length; i++) {
                list.add(new String(board[i]));
            }
            res.add(list);
            return;
        }
        for(int col = 0; col < board[row].length; col++) {
            // Check each place weather it is safe or not, if safe then place queen and call fun again
            if(isSafe(board, row, col)) {
                board[row][col] = 'Q';
                generate(board, row+1, res);
                board[row][col] = '.';
            }
        }
    }
    public boolean isSafe(char[][] board, int row, int col) {
        // Check vertically until curr row
        for(int i = 0; i < row; i++) {
            if(board[i][col] == 'Q') return false;
        }
        // Check Left diagonal
        int minLeft = Math.min(row, col);
        for(int i = 1; i <= minLeft; i++) {
            if(board[row-i][col-i] == 'Q') return false;
        }
        // Check Right diagonal
        int minRight = Math.min(row, board.length - 1 - col);
        for(int i = 1; i <= minRight; i++) {
            if(board[row-i][col+i] == 'Q') return false;
        }
        return true;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        // First generate 2D array board with all '.'s
        char[][] board = new char[n][n];
        for(int i =0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        generate(board, 0, res);
        return res;
    }
}