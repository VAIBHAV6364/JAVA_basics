class Sudoku {
    public boolean helper(char[][] board, int row, int col){
        //base case
        //if the row is completed or full then return true
        if(row == board.length){
            return true;
        }

        int nrow = 0;
        int ncol = 0;
        //if we are not in the last column of any row then we need to increment the columns in that row one cell -> to another cell -> ......
        if(col != board.length-1){
            nrow = row;
            ncol = col + 1;
        }
        //if we are in the last column then we have to move to the next row and then start from the first column of the next row.
        else{
            nrow = row + 1;
            ncol = 0;
        }

        //to check if the cell we obtained is empty or filled
        if(board[row][col] != '.'){
            if(helper(board, nrow, ncol)){     //recursion
                return true;
            }
        }
        else  // if the cell is empty then fill appropriate number
        {
            for(int i = 1; i <= 9; i++){
                if(isSafe(board, row, col, i)){ //fill the number after it is confirmed it is safe
                    board[row][col] = (char)(i+'0');
                    if(helper(board, nrow, ncol)){ //recursive call to move forward
                        return true;
                    }
                    else{                            //backtracking
                        board[row][col] = '.';   //if found not possible to place replace with '.' , ie backtracking
                    }
                }
            }
        }
        // if there is no solution that returns true for placing a number then return false
        return false;
    }

    //The is safe function
    // it checks if the concerned number is present in the particular row
    //it checks if the concerned number is present in the particular column
    //it checks if the concerned number is present in the local grid of 3*3
    public boolean isSafe(char[][] board, int row, int col, int number){
        for(int i = 0; i < board.length; i++){
            //checking if the concerned number exists in the same row
            if(board[i][col] == (char)(number + '0')){
                return false;
            }

            //checking if the concerned number exists in the same column
            if(board[row][i] == (char)(number + '0')){
                return false;
            }

            //checking in the local grid
            int startingRow = (row/3) * 3;
            int startingColumn = (col/3) * 3;
            for(int ik = startingRow; ik < startingRow+3; ik++){
                for(int j = startingColumn; j < startingColumn+3; j++){
                    if(board[ik][j] == (char)(number + '0')){
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public void solveSudoku(char[][] board){
        helper(board, 0, 0);
    }
}


//ANOTHER CLASS CONTAINING THE MAIN FUNCTION
public class Sudoku_Solver {
    public static void main(String[] args) {
        // Example Sudoku puzzle ('.' means empty cell)
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        Sudoku solver = new Sudoku();
        solver.solveSudoku(board);

        // Print solved Sudoku
        System.out.println("Solved Sudoku:");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

