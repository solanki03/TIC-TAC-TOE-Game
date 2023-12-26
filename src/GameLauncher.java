import java.util.Scanner;

public class GameLauncher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nWelcome to the TIC-TAC-TOE game!\n");
        System.out.println("Choose a gaming mode:\n1. User vs User \n2. User vs Computer\n");
        System.out.print("Enter your choice: ");
        int num = sc.nextInt();

        Players p1 = null, p2 = null;
        Players currentPlayer;

        try {
            switch (num) {
                case 1:
                    // User vs User
                    System.out.print("Enter name for Player 1: ");
                    String name1 = sc.next();
                    char mark1 = selectPlayerMark(sc, name1);
                    p1 = new HumanPlayer(name1, mark1);

                    System.out.print("Enter name for Player 2: ");
                    String name2 = sc.next();
                    // Automatically assign the other mark to the second player
                    char mark2;
                    if (mark1 == 'X') {
                        mark2 = 'O';
                    } else {
                        mark2 = 'X';
                    }
                    p2 = new HumanPlayer(name2, mark2);
                    break;

                case 2:
                    // User vs Computer
                    System.out.print("Enter your name: ");
                    String userName = sc.next();
                    char userMark = selectPlayerMark(sc, userName);
                    p1 = new HumanPlayer(userName, userMark);

                    char computerMark;
                    if (userMark == 'X') {
                        computerMark = 'O';
                    } else {
                        computerMark = 'X';
                    }

                    p2 = new ComputerPlayer("Computer", computerMark);
                    break;

                default:
                    System.out.println("Invalid input! Try again.");

            }
        } catch (Exception e) {
        }

        if (p1 != null && p2 != null) {
            currentPlayer = p1;
            TicTacToe.initGBoard(); // initializing the game board before starting the game

            while (true) {
                System.out.println("\n" + currentPlayer.name + "'s turn");
                currentPlayer.makeMove(); // player make a move
                TicTacToe.displayGBoard(); // display the game board

                // check the winning conditions ---
                if (TicTacToe.checkColWin() || TicTacToe.checkRowWin() || TicTacToe.checkDiagWin()) {
                    System.out.println(currentPlayer.name + " won the game!");
                    break;
                } else if (TicTacToe.checkDraw()) {
                    System.out.println("This match is a draw!");
                    break;
                } else {
                    if (currentPlayer == p1) {
                        currentPlayer = p2;
                    } else {
                        currentPlayer = p1;
                    }
                }
            }
        } else {
            System.out.println("Error occured while initializing players. Exiting the game!");
        }

    }

    // method to select player's mark
    private static char selectPlayerMark(Scanner sc, String playerName) {
        System.out.println(playerName + ", choose your mark: \n1. X \n2. O");
        System.out.print("Enter your choice: ");

        char mark;
        while (true) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    mark = 'X';
                    break;
                case 2:
                    mark = 'O';
                    break;
                default:
                    System.out.print("Invalid choice! Choose 1 for 'X' or 2 for 'O': ");
                    continue; // Go back to the beginning of the loop
            }
            break; // Exit the loop if a valid choice is made
        }

        return mark;
    }

}
