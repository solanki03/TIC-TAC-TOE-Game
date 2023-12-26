import java.util.Scanner;

public class HumanPlayer extends Players {

    HumanPlayer(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    // method to make a move in the game board
    void makeMove() {
        Scanner sc = new Scanner(System.in);
        int row, col;
        do {
            System.out.print("Enter the no. of row: ");
            row = sc.nextInt();
            System.out.print("Enter the no. of column: ");
            col = sc.nextInt();

            // checkValidMove() is checking the move is valid move or not
        } while (!checkValidMove(row, col));

        // if the move is valid, the player would place its mark
        TicTacToe.putMark(row, col, mark);
    }
}
