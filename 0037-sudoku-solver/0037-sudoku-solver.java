class Solution {
    
    // Function to check if placing a number is safe
    public boolean isSafe(char[][] board, int row, int col, int number) {
        // Check the column and the row
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == (char) (number + '0')) {
                return false;
            }
            if (board[row][i] == (char) (number + '0')) {
                return false;
            }
        }
        
        // Check the 3x3 grid
        int startingRow = (row / 3) * 3;
        int startingCol = (col / 3) * 3;
        
        for (int i = startingRow; i < startingRow + 3; i++) {
            for (int j = startingCol; j < startingCol + 3; j++) {
                if (board[i][j] == (char) (number + '0')) {
                    return false;
                }
            }
        }
        
        return true; // Safe to place the number
    }
    
    // Recursive helper function for Backtracking
    public boolean helper(char[][] board, int row, int col) {
        // Base Condition: If we reach the end of the board
        if (row == board.length) {
            return true;
        }
        
        // Variables for the next cell
        int nrow = 0;
        int ncol = 0;
        
        // If we are not at the last column, move right. Otherwise, move to the next row.
        if (col != board.length - 1) {
            nrow = row;
            ncol = col + 1;
        } else {
            nrow = row + 1;
            ncol = 0;
        }
        
        // If the cell is already filled, move to the next cell
        if (board[row][col] != '.') {
            if (helper(board, nrow, ncol)) {
                return true;
            }
        } else {
            // If the cell is empty, try placing numbers from 1 to 9
            for (int i = 1; i <= 9; i++) {
                if (isSafe(board, row, col, i)) {
                    board[row][col] = (char) (i + '0'); // Place the number
                    
                    if (helper(board, nrow, ncol)) { // Recursive call
                        return true;
                    }
                    
                    board[row][col] = '.'; // Backtrack: Remove the number if it doesn't lead to a solution
                }
            }
        }
        
        return false; // Return false if no number from 1 to 9 can be placed
    }

    // Main function to initiate the solver
    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }
}