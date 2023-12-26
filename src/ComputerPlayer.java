import java.util.Random;

public class ComputerPlayer extends Players{

    ComputerPlayer(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    // method to make a move in the game board
    void makeMove() {
        int row, col;
        do {
            Random r = new Random();
            row = r.nextInt(3);
            col = r.nextInt(3);

            // checkValidMove() is checking the move is valid move or not
        } while (!checkValidMove(row, col));

        // if the move is valid, the player would place its mark
        TicTacToe.putMark(row, col, mark);
    }
}
