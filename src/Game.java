import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    
    private Deck deck1;
    private ArrayList<Player> playerList;

    public void startGame() {

        deck1 = new Deck();
        deck1.generateDeck();
        deck1.makeDeckRandom();

        // Adding all the player into a Arraylist
        playerList = new ArrayList<>();
        playerList.add(new Player("Player1"));
        playerList.add(new Player("Player2"));
        playerList.add(new Player("Player3"));
        playerList.add(new Player("Player4"));

        // Adding a Card to the Center
        deck1.addCardToCenter();

        // Determining the First Player..
        int startingPlayerIndex = Deck.startingPlayerIndex(deck1.getCenter().get(0));

        // Add Card to Each Player
        Player.addCardToPlayer(playerList, deck1);

        Scanner scanner = new Scanner(System.in);
  
        int trick = 1;
        int tempRoundCounter = 0;
        int currentPlayerIndex = startingPlayerIndex;
        int winnerPlayer;

        // Print All stuff
        gameStats(playerList, currentPlayerIndex, trick);
        String userInput = scanner.nextLine();
          
        while (!userInput.equals("x")) {
  
           Player currentPlayer = playerList.get(currentPlayerIndex);
 
            if (userInput.equals("s")) {
                startGame(); // start a new game
                break;
            }

            else if (userInput.equals("d")) { // game command 'd'

                if(deck1.getDeck().isEmpty() && userInput.equals("d")) {

                    currentPlayerIndex = (currentPlayerIndex + 1) % playerList.size();
                    tempRoundCounter++;
                    winnerPlayer = Player.trickWinnerPlayer(deck1, userInput, currentPlayerIndex, trick);

                    if (tempRoundCounter%4 == 0 && tempRoundCounter != 0) {
                        trick++;
                        currentPlayerIndex = winnerPlayer;
                        currentPlayer = playerList.get(currentPlayerIndex);
                        currentPlayer.addScore();
                    }
                    gameStats(playerList, currentPlayerIndex, trick);
                }
                else {
                    
                    deck1.dealCardFromDeck(currentPlayer); 
                    gameStats(playerList, currentPlayerIndex, trick); 
                }
            }

            // Check If player has the card he played & Check Suit/Rank matches the center
            if (userInput.length() == 2 && (currentPlayer.checkPlayerhasCard(userInput) && deck1.InputCardCheck(userInput)) ) {

                // Getting the Winner Player Index after 1 trick is over 
                winnerPlayer = Player.trickWinnerPlayer(deck1, userInput, currentPlayerIndex, trick);
                currentPlayer.getPlayerCard().remove(userInput);
                  
                tempRoundCounter++;
                  
                if (tempRoundCounter%4 == 0 && tempRoundCounter != 0) {

                    trick++;
                    currentPlayerIndex = winnerPlayer;
                    currentPlayer = playerList.get(currentPlayerIndex);
                    currentPlayer.addScore();
                }
                else {
                  currentPlayerIndex = (currentPlayerIndex + 1) % playerList.size();
                }

                gameStats(playerList, currentPlayerIndex, trick);
                userInput = scanner.nextLine();
            }
            else {

                System.out.print(">");
                userInput = scanner.nextLine();
            }
        }
        scanner.close();
    }

    
    
    // Display Game Stats
    private void gameStats(ArrayList<Player> playerList, int currentPlayerIndex, int trick) {

        System.out.println("\nTrick#" + trick);
        System.out.println("\nPlayer1: " + playerList.get(0).getPlayerCard()+"\n"+"Cards: " + playerList.get(0).getPlayerCard().size());
        System.out.println("Player2: " + playerList.get(1).getPlayerCard()+"\n"+"Cards: " + playerList.get(1).getPlayerCard().size());
        System.out.println("Player3: " + playerList.get(2).getPlayerCard()+"\n"+"Cards: " + playerList.get(2).getPlayerCard().size());
        System.out.println("Player4: " + playerList.get(3).getPlayerCard()+"\n"+"Cards: " + playerList.get(3).getPlayerCard().size());
        System.out.println("\nCenter : " + deck1.getCenter() + "\nCards: " + deck1.getCenter().size() + "\n");
        System.out.println("Deck   : " + deck1.getDeck() + "\nCards: " + deck1.getDeck().size() + "\n");
        System.out.println("Score: " + "Player1 = " + playerList.get(0).getScore() + " | Player2 = " + playerList.get(1).getScore() +" | Player3 = " + playerList.get(2).getScore() + " | Player4 = " + playerList.get(3).getScore());
        System.out.println("Turn : " + playerList.get(currentPlayerIndex).getName());
        System.out.print(">");
    }  
}
