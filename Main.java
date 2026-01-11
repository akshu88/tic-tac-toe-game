import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;
        int X = 0 , Y = 0, draws = 0;

        System.out.println("WELCOME TO TIC-TAC-TOE!!");
        System.out.println("Player 1: X");
        System.out.println("Player 2: O\n");

        while(playAgain){
            GameBoard board = new GameBoard();
            GameLogic game = new GameLogic(board);

            String result = game.playGame(sc);
            
            if(result.equals("X")){
                X++;
            } 
            else if(result.equals("O")){
                Y++;
            }
            else{
                draws++;
            }
            System.out.println("\n Play again? (y/n):");
            String response = sc.next();
            playAgain = response.equalsIgnoreCase("y"); 
        }
        System.out.println("\n Thanks for playing!");
        System.out.println("Final Scores:");
        System.out.println("Games Played:" + (X + Y + draws));
        System.out.println("X Wins:" + X);
        System.out.println("Y wins:" + Y);
        System.out.println("Draws:" + draws);

        sc.close();
    }
}