import java.util.Scanner;

public class GameLogic {
    private GameBoard board;

    public GameLogic (GameBoard board) {
        this.board = board;
    }

    public String playGame(Scanner sc){
        char currentPlayer = 'X';

        while (true) {
            board.display();

            System.out.println("Player " + currentPlayer + "'s turn.");
            System.out.println("Enter position (1-9):");

            int pos;
            try{
                pos = sc.nextInt();
            } catch(Exception e) {
                sc.next();
                System.out.println("Invalid input! Please enter a number 1-9.");
                continue;
            }

            if(!board.makeMove(pos, currentPlayer)) {
                System.out.println("Invalid move! Position already taken or out of range. Try again.");
                continue;
            }
            if(checkWinner(currentPlayer)) {
                board.display();
                System.out.println("Player" + currentPlayer + " Wins!");
                return String.valueOf(currentPlayer);
            }
            if (board.isFull()) {
                board.display();
                System.out.println("It's a Draw!");
                return "Draw";
            }
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    private boolean checkWinner(char player) {
        char[] b = board.getBoard();
        if(b[0] == player && b[1] == player && b[2] == player) {
            return true;
        }
        if(b[3] == player && b[4] == player && b[5] == player) {
            return true;
        }
        if(b[6] == player && b[7] == player && b[8] == player) {
            return true;
        }

        if(b[0] == player && b[3] == player && b[6] == player) {
            return true;
        }
        if (b[1] == player && b[4] == player && b[7] == player) {
            return true;
        }
        if (b[2] == player && b[5] == player && b[8] == player) {
            return true;
        }

        if (b[0] == player && b[4] == player && b[8] == player) {
            return true;
        }
        if (b[2] == player && b[4] == player && b[6] == player) {
            return true;
        }
        return false;
    }
}
