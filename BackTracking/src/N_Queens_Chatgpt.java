public class N_Queens_Chatgpt {

    // Function to print the board
    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Function to check if placing a queen is safe
    public static boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;

        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    // Backtracking function
    public static void solve(char[][] board, int row) {
        int n = board.length;
        //board.length gives the number of rows in the 2D array.
        //board[0].length would give the number of columns in the first row.

        // Base case: all queens placed
        if (row == n) {
            printBoard(board);
            return;
        }

        // Try placing a queen in each column
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';   // Place queen
                solve(board, row + 1);   // Recurse to next row
                board[row][col] = '.';   // Backtrack (remove queen)
            }
        }
    }

    public static void main(String[] args) {
        int n = 4; // Change this to solve for different N
        char[][] board = new char[n][n];

        // Initialize board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        System.out.println("Solutions for " + n + " Queens:");
        solve(board, 0);
    }
}
