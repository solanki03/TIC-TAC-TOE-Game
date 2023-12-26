public class TicTacToe {
    static char[][] gameBoard = new char[3][3];

    // initialize the board/array with space
    static void initGBoard() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = ' ';
            }
        }
    }

    // Display the game boardstatic
    static void displayGBoard() {
        System.out.println("-------------");
        for (int i = 0; i < gameBoard.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.print(gameBoard[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Display the mark ---- 'X' and 'O'
    static void putMark(int row, int col, char mark) {
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
            gameBoard[row][col] = mark;
        } else {
            System.out.println("Invalid input!");
        }
    }

    // Conditions to win the game ---

    // Column-wise winning condition
    static boolean checkColWin() {
        for (int j = 0; j <= 2; j++) {
            if (gameBoard[0][j] != ' ' && gameBoard[0][j] == gameBoard[1][j] && gameBoard[1][j] == gameBoard[2][j]) {
                return true;
            }
        }
        return false;
    }

    // Row-wise winning condition
    static boolean checkRowWin() {
        for (int i = 0; i <= 2; i++) {
            if (gameBoard[i][0] != ' ' && gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][1] == gameBoard[i][2]) {
                return true;
            }
        }
        return false;
    }

    // Diagonal winning condition
    static boolean checkDiagWin() {
        if (gameBoard[0][0] != ' ' && gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2]
                || gameBoard[0][2] != ' ' && gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0]) {
            return true;
        } else {
            return false;
        }

    }

    // Check the Draw condition
    static boolean checkDraw() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (gameBoard[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
