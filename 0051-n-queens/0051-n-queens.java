class Solution {
    public static boolean isSafe(int row, int col, char[][] board) {
        // Check horizontal
        for(int j=0; j<board.length; j++) {
            if(board[row][j] == 'Q') {
                return false;
            }
        }

        // Check vertical
        for(int i=0; i<board.length; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper left diagonal
        int r = row;
        for(int c=col; c>=0 && r>=0; c--, r--) {
            if(board[r][c] == 'Q') {
                return false;
            }
        }

        // Check upper right diagonal
        r = row;
        for(int c=col; c<board.length && r>=0; r--, c++) {
            if(board[r][c] == 'Q') {
                return false;
            }
        }

        // Check lower left diagonal
        r = row;
        for(int c=col; c>=0 && r<board.length; r++, c--) {
            if(board[r][c] == 'Q') {
                return false;
            }
        }

        // Check lower right diagonal
        r = row;
        for(int c=col; c<board.length && r<board.length; c++, r++) {
            if(board[r][c] == 'Q') {
                return false;
            }
        }

        return true;
    }

    // Function to save a valid board configuration into our results list
    public static void saveBoard(char[][] board, List<List<String>> allBoards) {
        String row = "";
        List<String> newBoard = new ArrayList<>();
        for(int i=0; i<board.length; i++) {
            row = "";
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == 'Q')
                    row += 'Q';
                else
                    row += '.';
            }
            newBoard.add(row);
        }
        allBoards.add(newBoard);
    }

    // The core backtracking recursive function
    public static void helper(char[][] board, List<List<String>> allBoards, int col) {
        // Base case: If all columns are filled, we've found a valid solution
        if(col == board.length) {
            saveBoard(board, allBoards);
            return;
        }

        // Try placing a queen in every row of the current column
        for(int row=0; row<board.length; row++) {
            if(isSafe(row, col, board)) {
                board[row][col] = 'Q'; // Place the queen
                helper(board, allBoards, col+1); // Move to the next column
                board[row][col] = '.'; // Backtrack: remove the queen and try the next row
            }
        }
    }

    // Main solver function that initializes the board
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];

        // Fill the initial empty board with dots
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        
        // Start placing from column 0
        helper(board, allBoards, 0);
        return allBoards;
    }
    
}