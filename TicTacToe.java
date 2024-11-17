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

    private String[] playersIcon = new String[]{"o", "x"};
    int currentPlayer = 0; // 0 for first player and 1 for second player
    
    private String[][] board = new String[][]{
        {"1", "2", "3"},
        {"4", "5", "6"},
        {"7", "8", "9"}
    };
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

    public void updateCurrentPlayer() {
        if (currentPlayer == 0) {
            currentPlayer = 1;
        } else {
            currentPlayer = 0;
        }
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isGameOver()  { 
        
        return false;
    }
    public void printWinner() {
        String winnerName = null;
        System.out.printf("Congras! %s win the match\n", winnerName);
        board = new String[3][3];
    }
    public void updateBoard(int playerId, int position) {
        int x, y;
        position = position-1;

        // first player or second player decided by playerId
        x = Math.floorDiv(position, 3);
        y = position % 3;
        board[x][y] = playersIcon[playerId];
        
    }
    public void printBoard()  {
        for (int i = 0; i < board.length; i++) {
            System.out.printf(" %s | %s | %s ", board[i][0], board[i][1], board[i][2]);
            System.out.println("\n-------------");
        }
        
    }

    public void printRules() {
        System.out.println("***********Welcome to the Tic Tac Toe game*******");
        System.out.println("o - for player 1");
        System.out.println("x - for player 2");
        System.out.println("1 | 2 | 3");
        System.out.println("---------");
        System.out.println("4 | 5 | 6");
        System.out.println("---------");
        System.out.println("7 | 8 | 9");
        System.out.println("Enter any number from 1 to 9 for input.");
        System.out.println("Enter 0 for quit.");
        System.out.println("\n");
    }

    
    public static void main(String[] args) {
        TicTacToe ins = new TicTacToe();
        Scanner sc = new Scanner(System.in);
        int inp;
        
        // printing rules for players
        ins.printRules();


        while (!ins.isGameOver()) {
            ins.printBoard();
            System.out.printf("Enter input for player%d(0 for quit): ", ins.getCurrentPlayer()+1);
            inp = sc.nextInt();

            if (inp == 0) {
                // TODO: print a outro
                System.exit(0);
            } else {
                ins.updateBoard(ins.getCurrentPlayer(), inp);
                ins.updateCurrentPlayer();
            }

        }

        // game over so printing the winner
        ins.printWinner();

        sc.close();
    }
}