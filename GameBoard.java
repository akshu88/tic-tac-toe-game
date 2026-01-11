public class GameBoard {
    private char[] board;

    public GameBoard() {
        board = new char[9];
        for(int i = 0; i < 9; i++) {
            board[i] = (char) ('1' + i);  // INITIALISE with numbers 1-9
        }
    }

    public void display() {
        System.out.println("\nCurrent Board:");
        System.out.println(" " + board[0] + "|" + board[1] + "|" + board[2]);
        System.out.println("----------");
        System.out.println(" " + board[3] + "|" + board[4] + "|" + board[5]);
        System.out.println("----------");
        System.out.println(" " + board[6] + "|" + board[7] + "|" + board[8]);
        System.out.println();
    }
    public boolean makeMove(int pos , char player) {
        if(pos < 1 || pos > 9){
            return false;
        }
        int index = pos - 1;
        if(board[index]  == 'X' || board[index] == 'O'){
            return false;  // Position already taken
        }
        board[index] = player;
        return true;
    }

    public char[] getBoard() {
        return board;
    }

    public boolean isFull() {
        for(char cell : board){
            if(cell != 'X' && cell != 'O'){
                return false;
            }
        }
        return true;
    }
}
