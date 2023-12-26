public abstract class Players {
    String name;
    char mark;

    abstract void makeMove();

    // checkValidMove() is checking the move is valid move or not
    // the condition is: the player would get chance until it gives a valid move
    boolean checkValidMove(int row, int col) {

        // check the given move is in the boundary of the array or not
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
            // if the index on game board is empty, only then the player can make a move
            if (TicTacToe.gameBoard[row][col] == ' ') {
                return true;
            }
        }
        System.out.println("Invalid input! Please make a valid move!");
        return false;
    }
}
