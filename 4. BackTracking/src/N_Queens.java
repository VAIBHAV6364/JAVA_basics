import java.util.*;

public class N_Queens {

    // (Your existing isSafe, saveBoard, helper, and solveNQueens methods go here)

    public boolean isSafe(int row, int col, char[][] board) {
        // horizontal
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }
        // vertical
        for (int i = 0; i < board[0].length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // upper left
        int r = row;
        for (int c = col; c >= 0 && r >= 0; c--, r--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        // upper right
        r = row;
        for (int c = col; c < board.length && r >= 0; r--, c++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        // lower left
        r = row;
        for (int c = col; c >= 0 && r < board.length; r++, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        // lower right
        r = row;
        for (int c = col; c < board.length && r < board.length; c++, r++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public void saveBoard(char[][] board, List<List<String>> allBoards) {
        List<String> newBoard = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q') {
                    row.append('Q');
                } else {
                    row.append('.');
                }
            }
            newBoard.add(row.toString());
        }
        allBoards.add(newBoard);
    }

    public void helper(char[][] board, List<List<String>> allBoards, int col) {
        if (col == board.length) {
            saveBoard(board, allBoards);
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                helper(board, allBoards, col + 1);
                board[row][col] = '.'; // Backtrack: remove the queen
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];
        // Initialize the board with empty cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        helper(board, allBoards, 0);
        return allBoards;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the board size (n): ");
        int n = scanner.nextInt();

        N_Queens solver = new N_Queens();
        List<List<String>> solutions = solver.solveNQueens(n);

        if (solutions.isEmpty()) {
            System.out.println("No solutions found for N = " + n);
        } else {
            System.out.println("Found " + solutions.size() + " solutions for N = " + n + ":");
            for (int i = 0; i < solutions.size(); i++) {
                System.out.println("Solution " + (i + 1) + ":");
                List<String> board = solutions.get(i);
                for (String row : board) {
                    System.out.println(row);
                }
                System.out.println(); // Add a blank line between solutions
            }
        }
        scanner.close();
    }
}
