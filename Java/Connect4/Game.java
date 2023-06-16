import java.util.InputMismatchException;

public class Game {
    public static char[][] board;
    public static Player[] players;
    public static int winCondition;

    // Checks for cells with players tokens and run compareCells on neighboring
    public static boolean checkWin(Player currentPlayer) {
        char testChar = currentPlayer.getToken();

        for (int row = 0; row < Game.board.length; row++) {
            for (int column = 0; column < Game.board[row].length; column++) {

                if (Game.board[row][column] == testChar) {

                    // Check for horizontal lines
                    if (compareCells(1, testChar, row, 1, column, 0)) {
                        return true;
                    // Check for vertical lines
                    } else if (compareCells(1, testChar, row, 0, column, 1)) {
                        return true;
                    // Check diagonally up and right
                    } else if (compareCells(1, testChar, row, 1, column, 1)) {
                        return true;
                    // Check diagonally up and left
                    } else if (compareCells(1, testChar, row, 1, column, -1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Compare a cell to the one next to it as defined by increment values
    // Designed to self-invoke
    public static boolean compareCells(int count, char testChar,
        int row, int rowIncrement, 
        int column, int columnIncrement) {
            try {
                if(Game.board[row+rowIncrement][column+columnIncrement]!=testChar) {
                    return false;
                }
                else {
                    count++;
                    if (Game.winCondition == count) {
                        return true;
                    }
                    else {
                        return compareCells(count, testChar, row+rowIncrement, rowIncrement, column+columnIncrement, columnIncrement);
                }
            }            
            } catch (ArrayIndexOutOfBoundsException ob) {
                return false;
            }
        }
    
    // Prints the array representing the board
    public static void drawBoard(char[][] board) {
        
        System.out.println();
        
        for (int row = board.length-1; row >= 0; row--) {
            for (int column = 0; column < board[row].length; column++) {
                System.out.print(board[row][column] + "  ");
            }
            System.out.println();
        }
        System.out.println();

        for(int column = 0; column < board[0].length; column++) {
            System.out.print(column+1 + "  ");
        }
        System.out.println();
    }

    // Replace lowest blankToken with currentPlayer's token
    public static void placeMove(int input, Player currentPlayer) {

        for(int row = 0; row < board.length; row++) {
            if(board[row][input] == Connect4.blankToken) {
                board[row][input] = currentPlayer.getToken();
                return;
            }
        }
    }

    // Receive player's input and check if valid move
    public static int selectMove(Player currentPlayer) {
        boolean moveValid = false;
        int input = 0;

        System.out.printf(currentPlayer.getName() + ", please select a column (1-%d)\n", board[0].length);        
        
        while(!moveValid) {

            try {
                input = (Connect4.in.nextInt());           
                if (input > 0 && input <= board[0].length) {
                    moveValid = spaceInColumn(input-1);

                    if (!moveValid) {
                        throw new InputMismatchException("\nRow " +input+ " is full!");
                    }
                }
            
                else {
                    throw new InputMismatchException("\n"+ input + " is not in column range!");
                }
            } catch (InputMismatchException e) {

                drawBoard(board);

                if (e.getMessage()!=null) {
                    System.out.println(e.getMessage());
                } else { 
                    System.out.println("\nNumber not detected in input!");
                }

                System.out.printf("Please enter a single digit between 1 & %d inclusive\n", board[0].length);
                Connect4.in.nextLine();
            } 
        }
        return input-1;
    }

    // Check if the current column is full of tokens
    public static boolean spaceInColumn(int column) {
        boolean spaceAvailable = false;
        if (board[board.length-1][column] == Connect4.blankToken) {
            spaceAvailable = true;
            return spaceAvailable;
        }
        return spaceAvailable;
    }
    
    public static Player play(char[][] board, Player[] players) {
        Player currentPlayer;

        // Continue playing until there are no spaces left
        for (int turn = 0; turn < (board.length * board[0].length); turn++) {

            drawBoard(board);

            currentPlayer = players[turn%(players.length)];

            // Ask the player to select a column, then place their token
            placeMove(selectMove(currentPlayer), currentPlayer);


            if(checkWin(currentPlayer)){
                return currentPlayer;
            }
        }
        return new Player();
    }
}
