/*
 * 0 | 1 | 2
 * ----------
 * 3 | 4 | 5
 * ----------
 * 6 | 7 | 8
 * 
 * 
 * 4  3 = (1, 1)
 * 6  3 = (2, 0)
 * 7  3 = (2, 1)
 * 
 * Rules for games:
 * Game will be played with two player
 * Who will win at last we will print it
 * o - we will be used for player1
 * x - we will be used for player2
 * 
 */


import java.util.Scanner;

public class TicTacToe {
    
    private String[][] board = new String[3][3];
    private int[][] win_positions = new int[][]{
        {0, 1, 2},
        {3, 4, 5},
        {6, 7, 8},
        {0, 3, 6},
        {1, 4, 7},
        {2, 5, 8},
        {0, 4, 8},
        {2, 4, 6}
    };

    public boolean isGameOver()  { 
        
        return false;
    }
    public void printWinner(String winnerName) {
        System.out.printf("Congras! %s win the match\n", winnerName);
        board = new String[3][3];
    }
    public void updateBoard() {}
    public void printBoard()  {
        for (int i = 0; i < board.length; i++) {
            System.out.printf(" x | x | x ");
        }
        System.out.println("\n-------------");
    }

    
    public static void main(String[] args) {
        TicTacToe ins = new TicTacToe();
        Scanner sc = new Scanner(System.in);
        int inp;

        while (!ins.isGameOver()) {
            System.out.println("Enter the input(q for quit): ");
            inp = sc.nextInt();
        }
        sc.close();
    }
}