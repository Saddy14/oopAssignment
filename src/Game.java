import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    
    private Deck deck1;
    private ArrayList<Player> playerList;

    public void startGame() {

        deck1 = new Deck();
        deck1.generateDeck();
        deck1.makeDeckRandom();

        // Adding all the player object into a Arraylist
        playerList = new ArrayList<>();
        playerList.add(new Player("Player1"));
        playerList.add(new Player("Player2"));
        playerList.add(new Player("Player3"));
        playerList.add(new Player("Player4"));

        // Adding a Card to the Center
        deck1.center.add(deck1.deck.get(0));
        deck1.deck.removeAll(deck1.center);
        System.out.println("\nRemoved the center from the Deck\n" + deck1.deck + "\nSize: " + deck1.deck.size());
        System.out.println("\nCenter: " + deck1.center);

        // Determining the First Player..
        int startingPlayerIndex = Deck.startingPlayerIndex(deck1.center.get(0));
        System.out.println("\nThe First Player is: " + "Player" + (startingPlayerIndex + 1) + "\n");

        // Add Card to Each Player
        addCardToPlayer();

        Scanner scanner = new Scanner(System.in);
  
        int trick = 1;
        int tempRoundCounter = 0;
        int currentPlayerIndex = startingPlayerIndex;
        
        @SuppressWarnings("unused")
        Boolean gameIsRuning = true;
  
        while (true) {
  
           Player currentPlayer = playerList.get(currentPlayerIndex);

           if (tempRoundCounter%4 == 0 && tempRoundCounter != 0) {
            currentPlayer.addScore();
          }
           
           // Print All stuff
            gameStats(playerList, currentPlayerIndex, trick);
            String userInput = scanner.nextLine();
  
            if (userInput.equals("s")) {
                startGame();
            }

           // break out of the loop
            if (userInput.equals("x")) {
                break;
            }
            if (userInput.equals("d")) {
                deck1.dealCardFromDeck(currentPlayer);
                gameStats(playerList, currentPlayerIndex, trick);
                userInput = scanner.nextLine();
            }
            if (userInput.equals("card")) {
                // TODO method
                userInput = currentPlayer.cardPlayedbyCurrentPlayer(currentPlayer);
            }
  
           // TODO Extra Feature Don't remove yet...
            userInput = Player.checkPlayerhasCard(userInput, currentPlayer.playerCard);      
           
           // Check Suit/Rank matches the center 
            userInput = deck1.InputCardCheck(userInput);
  
           // Getting the Winner Player Index after 1 trick is over 
            int winnerPlayer = Player.trickWinnerPlayer(deck1, userInput, currentPlayerIndex, trick);
            currentPlayer.playerCard.remove(userInput);
  
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

    // Game Commands
    private void command(String userInput) {

        // if (userInput.equals("x")) {
        //     break;
        // }
        // if (userInput.equals("d")) {
        //     // TODO method
        //     deck1.dealCardFromDeck(currentPlayer);
        //     // gameStats(playerList, currentPlayerIndex, trick);
        //     // userInput = scanner.nextLine();
        // }
        // if (userInput.equals("card")) {
        //     // TODO method
        //     userInput = currentPlayer.cardPlayedbyCurrentPlayer(currentPlayer);
        // }

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

        System.out.println("Trick#" + trick);
        System.out.println("Player1: " + playerList.get(0).playerCard+"\n"+"Size: " + playerList.get(0).playerCard.size());
        System.out.println("Player2: " + playerList.get(1).playerCard+"\n"+"Size: " + playerList.get(1).playerCard.size());
        System.out.println("Player3: " + playerList.get(2).playerCard+"\n"+"Size: " + playerList.get(2).playerCard.size());
        System.out.println("Player4: " + playerList.get(3).playerCard+"\n"+"Size: " + playerList.get(3).playerCard.size());
        System.out.println("Center : " + deck1.center + "\nSize: " + deck1.center.size() + "\n");
        System.out.println("Deck   : " + deck1.deck + "\nSize: " + deck1.deck.size() + "\n");
        System.out.println("Score: " + "Player1 = " + playerList.get(0).getScore() + " | Player2 = " + playerList.get(1).getScore() +" | Player3 = " + playerList.get(2).getScore() + " | Player4 = " + playerList.get(3).getScore());
        System.out.println("Turn : " + playerList.get(currentPlayerIndex).getName());
        System.out.print(">");
    }
    
}
