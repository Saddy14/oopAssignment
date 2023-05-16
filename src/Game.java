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
        addCardToPlayer();

        Scanner scanner = new Scanner(System.in);
  
        int trick = 1;
        int tempRoundCounter = 0;
        int currentPlayerIndex = startingPlayerIndex;
          
        while (true) {
  
           Player currentPlayer = playerList.get(currentPlayerIndex);

           if (tempRoundCounter%4 == 0 && tempRoundCounter != 0) {
                currentPlayer.addScore();
            }
           
            // Print All stuff
            gameStats(playerList, currentPlayerIndex, trick);
            String userInput = scanner.nextLine();
  
            if (userInput.equals("s")) {
                startGame(); // start a new game
            }

            else if (userInput.equals("x")) {
                break; // break out of the loop
            }

            else if (userInput.equals("d")) {
                deck1.dealCardFromDeck(currentPlayer);
                gameStats(playerList, currentPlayerIndex, trick);
                userInput = scanner.nextLine();
            }

            else if (userInput.equals("card")) {
                // TODO method
                userInput = currentPlayer.cardPlayedbyCurrentPlayer();
            }
  
            // Check If player has the card he played
            userInput = Player.checkPlayerhasCard(userInput, currentPlayer.getPlayerCard());      
           
            // Check Suit/Rank matches the center 
            userInput = deck1.InputCardCheck(userInput);
  
            // Getting the Winner Player Index after 1 trick is over 
            int winnerPlayer = Player.trickWinnerPlayer(deck1, userInput, currentPlayerIndex, trick);
            currentPlayer.getPlayerCard().remove(userInput);
  
            tempRoundCounter++;
  
            if (tempRoundCounter%4 == 0 && tempRoundCounter != 0) {
              trick++;
              currentPlayerIndex = winnerPlayer;
            }
            else {
              currentPlayerIndex = (currentPlayerIndex + 1) % playerList.size();
            }
        }
        scanner.close();
    }

    // Add Cards to player
    private void addCardToPlayer() {

        // Dealing 1 Card at a time to each player from the deck
        for (int i = 0; i < Player.getNoOfCardsEachPlayer(); i++) {

            playerList.get(0).dealCard(deck1);
            playerList.get(1).dealCard(deck1);
            playerList.get(2).dealCard(deck1);
            playerList.get(3).dealCard(deck1);
        }
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
