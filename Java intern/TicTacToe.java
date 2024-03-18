import java.util.Scanner;

public class TicTacToe {
    private static final int BOARD_SIZE = 3;
    private static char[][] board = new char[BOARD_SIZE][BOARD_SIZE];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X';

        do {
            initializeBoard();
            printBoard();
            boolean gameWon = false;

            do {
                System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (isValidMove(row, col)) {
                    board[row][col] = currentPlayer;
                    printBoard();
                    gameWon = checkWin(row, col, currentPlayer);
                    if (!gameWon) {
                        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    }
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            } while (!gameWon && !isBoardFull());

            if (gameWon) {
                System.out.println("Player " + currentPlayer + " wins!");
            } else {
                System.out.println("It's a draw!");
            }

            System.out.println("Do you want to play again? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE && board[row][col] == '-';
    }

    private static boolean checkWin(int row, int col, char player) {
        return checkRow(row, player) || checkColumn(col, player) || checkDiagonals(player);
    }

    private static boolean checkRow(int row, char player) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[row][i] != player) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkColumn(int col, char player) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][col] != player) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkDiagonals(char player) {
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
