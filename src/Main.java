import java.util.ArrayList;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {

      Deck deck1 = new Deck();
      // Generating Deck & Shuffling the Deck
      deck1.generateDeck();
      deck1.makeDeckRandom();
      
      // Creating All 4 Player
      Player player1 = new Player("Player1");
      Player player2 = new Player("Player2");
      Player player3 = new Player("Player3");
      Player player4 = new Player("Player4");

      // Adding 1st card from the Deck to the center
      deck1.center.add(deck1.deck.get(0));
      deck1.deck.removeAll(deck1.center);
      System.out.println("Removed the center from the Deck\n" + deck1.deck + "Size: "+deck1.deck.size());

      // Determining the First Player..
      int startingPlayerIndex = Player.startingPlayerIndex(deck1.center.get(0));
      System.out.println("\nThe First Player is: " + "Player" + (startingPlayerIndex + 1) + "\n");

      // Dealing 1 Card at a time to each player from the deck
      for (int i = 0; i < Player.getNoOfCardsEachPlayer(); i++) {
         
         player1.dealCard(deck1);
         player2.dealCard(deck1);
         player3.dealCard(deck1);
         player4.dealCard(deck1);
      }

      // Adding all the player object into a Arraylist
      ArrayList<Player> playerList = new ArrayList<>();
      playerList.add(player1);
      playerList.add(player2);
      playerList.add(player3);
      playerList.add(player4);
      
      // Start the Game
      startGame(deck1, startingPlayerIndex, playerList); 

   }

   private static void startGame (Deck deck1, int startingPlayerIndex, ArrayList<Player> playerList) {

      Scanner scanner = new Scanner(System.in);

      int trick = 1;
      int tempRoundCounter = 0;

      int currentPlayerIndex = startingPlayerIndex;
      Boolean gameIsRuning = true;

      while (gameIsRuning) {

         Player currentPlayer = playerList.get(currentPlayerIndex);

         // TODO GameLogic Here
         
         // Print All stuff
         System.out.println("Trick#" + trick);
         System.out.println("Player1: " + playerList.get(0).playerCard+"\n"+"Size: " + playerList.get(0).playerCard.size());
         System.out.println("Player2: " + playerList.get(1).playerCard+"\n"+"Size: " + playerList.get(1).playerCard.size());
         System.out.println("Player3: " + playerList.get(2).playerCard+"\n"+"Size: " + playerList.get(2).playerCard.size());
         System.out.println("Player4: " + playerList.get(3).playerCard+"\n"+"Size: " + playerList.get(3).playerCard.size());
         System.out.println("Center : " + deck1.center + "\nSize: " + deck1.center.size() + "\n");
         System.out.println("Deck   : " + deck1.deck + "\nSize: " + deck1.deck.size() + "\n");
         System.out.println("Score  : " + "Player1 = " + playerList.get(0).getScore() + " | Player2 = " + playerList.get(1).getScore() +" | Player3 = " + playerList.get(2).getScore() + " | Player4 = " + playerList.get(3).getScore());
         System.out.println("Turn   : " + playerList.get(currentPlayerIndex).getName());
         System.out.print(">");
         String userInput = scanner.nextLine();

         if (userInput.equals("q")) {
            break;
         }
         // TODO Needed for Part 2
         // userInput = Player.checkPlayerhasCard(userInput, currentPlayer.playerCard);
         
         userInput = deck1.InputCardCheck(userInput);

         Player.trickWinnerPlayer(deck1, userInput, currentPlayerIndex);

         currentPlayer.playerCard.remove(userInput);
         

         currentPlayerIndex = (currentPlayerIndex + 1) % playerList.size();
         tempRoundCounter++;

         if (tempRoundCounter%4 == 0 && tempRoundCounter != 0) {
            trick++;
         }

      }

      scanner.close();
   }
}
