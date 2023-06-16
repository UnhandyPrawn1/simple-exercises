import java.util.Scanner;

public class Connect4 {
    public static final char blankToken = '_';
    public static final boolean fastTrack = true;
    static Scanner in = new Scanner(System.in);
  
    // Fill board array with blankToken
    public static char[][] fillBoard(char[][] board, char token) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                board[row][column] = token;
            }
        }

        return board;
    }
    
    // Uses input to populate players array
    public static Player[] createPlayers(Player[] players) {
        String playerName;
        char playerToken;

        for(int index = 0; index < players.length; index++) {
            System.out.printf("Player %d, please enter your name: \n", index+1);
            playerName = in.nextLine();

            System.out.printf("Pleased to meet you, %s!\n", playerName);
            System.out.printf("Please enter a letter to represent your moves: \n");

            playerToken = in.nextLine().charAt(0);

            players[index] = new Player(playerName, playerToken);
            
            System.out.printf("Player %d %s using token %c successfully created!\n\n", 
                index+1, players[index].getName(), players[index].getToken());
        }
        return players;
    }

    // Override for debugging; not used in final game
    public static Player[] createPlayers() {
        System.err.println("FastTrack used");
        if(fastTrack) {
            Game.players[0] = new Player("One", 'A');
            Game.players[1] = new Player("Two", 'B');
        }
        return Game.players;

    }

    // Print winners name to screen
    public static void declareWinner(Player winner) {
        Game.drawBoard(Game.board);

        if(winner.getName().equals("Draw")) {
            System.out.println("Game is a draw!");
        } else {
            System.out.println(winner.getName() + " has won!!");
        }
    }
  
    // User to confirm reset or quit
    public static boolean playAgain() {
        String response;

        while (true) {
            System.out.println("Play again? (y/n)");
            in.nextLine();
            response = in.nextLine();
            switch (response.toLowerCase()) {
                case "y":
                case "yes":
                    return true;
                case "n":
                case "no":
                    return false;
                default:
                    System.out.println("Input not understood, please type 'y' to replay or 'n' to exit\n");
                    break;
            }
        }
    }

    
    public static void main(String[] args) {
        boolean playAgain = true;

        // Create array of players w/ user input
        // Fast-track
        Game.players = new Player[2];
        createPlayers(Game.players);

        do {
            //TODO: Let user define board size & winCondition
            Game.winCondition = 4;

            // Create game board w/ blank tokens
            Game.board = new char[6][7];
            fillBoard(Game.board, blankToken);


            // Play game, which returns winner
            Player winner = Game.play(Game.board, Game.players);

            // Print winner's name
            declareWinner(winner);

            // Ask for rematch
            playAgain = playAgain();
        } while (playAgain);
        }
    }