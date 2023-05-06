import java.util.ArrayList;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {

      Deck deck1 = new Deck();
      deck1.generateDeck();
      deck1.makeDeckRandom();
      
      Player player1 = new Player("Player1");
      Player player2 = new Player("Player2");
      Player player3 = new Player("Player3");
      Player player4 = new Player("Player4");

      // Adding 1st card from the deck to the center
      deck1.center.add(deck1.deck.get(0));
      deck1.deck.removeAll(deck1.center);
      System.out.println("\n Removed the center from the Deck: "+deck1.deck);
      System.out.println();

      // Determining the First Player..
      int startingPlayerIndex = Player.startingPlayerIndex(deck1.center.get(0));
      System.out.println("\nThe First Player is: "+ "Player"+(startingPlayerIndex + 1));

      // Dealing Card to Player 1
      player1.dealCard(deck1.deck);
      deck1.deck.removeAll(player1.playerCard);

      // Dealing Card to Player 2
      player2.dealCard(deck1.deck);
      deck1.deck.removeAll(player2.playerCard);

      // Dealing Card to Player 3
      player3.dealCard(deck1.deck);
      deck1.deck.removeAll(player3.playerCard);

      // Dealing Card to Player 4
      player4.dealCard(deck1.deck);
      deck1.deck.removeAll(player4.playerCard);

      // Start the Game
      startGame(deck1, startingPlayerIndex, player1, player2, player3, player4);
      

   }

   private static void startGame (Deck deck1, int startingPlayerIndex, Player player1, Player player2, Player player3, Player player4) {

      Scanner scanner = new Scanner(System.in);

      int trick = 1;
      int tempRoundCounter = 0;

      ArrayList<Player> playerList = new ArrayList<>();
      playerList.add(player1);
      playerList.add(player2);
      playerList.add(player3);
      playerList.add(player4);

      int currentPlayerIndex = startingPlayerIndex;
      Boolean gameIsRuning = true;

      while (gameIsRuning) {

         Player currentPlayer = playerList.get(currentPlayerIndex);

         // TODO
         // GameLogic Here
         
         // Print All stuff
         System.out.println("Trick#" + trick);
         System.out.println("Player1: " + player1.playerCard+"\n"+"Size: " + player1.playerCard.size());
         System.out.println("Player2: " + player2.playerCard+"\n"+"Size: " + player2.playerCard.size());
         System.out.println("Player3: " + player3.playerCard+"\n"+"Size: " + player3.playerCard.size());
         System.out.println("Player4: " + player4.playerCard+"\n"+"Size: " + player4.playerCard.size());
         System.out.println("Center : " + deck1.center + "\nSize: " + deck1.center.size() + "\n");
         System.out.println("Deck   : " + deck1.deck + "\nSize: " + deck1.deck.size() + "\n");
         System.out.println("Score  : " + "Player1 = " + player1.getScore() + " | Player2 = " + player2.getScore() +" | Player3 = " + player3.getScore() + " | Player4 = " + player4.getScore());
         System.out.println("Turn   : " + playerList.get(currentPlayerIndex).getName());
         System.out.print(">");
         String userInput = scanner.nextLine();

         if (userInput.equals("q")) {
            break;
         }

         userInput = Player.checkPlayerhasCard(userInput, currentPlayer.playerCard);
         // if (!currentPlayer.playerCard.contains(userInput)) {

         //    System.out.println("You do not have a " + userInput + " card");
         //    System.out.print(">");
         //    userInput = scanner.nextLine();
         // }
         // else {
         //    System.out.println("You have a " + userInput + " card");
         // }
         
         userInput = deck1.InputCardCheck(userInput);

         // if ((userInput.charAt(0) != deck1.center.get(0).charAt(0)) && (userInput.charAt(1) != deck1.center.get(0).charAt(1))) {

         //    System.out.println("Invalid Card from Main Function");
         //    System.out.print(">");
         //    userInput = scanner.nextLine();

         // }
         // else {
         //    System.out.println("Valid Card from Main Function");
         //    deck1.center.add(userInput);
         // }
            

         currentPlayer.playerCard.remove(userInput);
         
   
         currentPlayerIndex = (currentPlayerIndex + 1) % playerList.size();
         tempRoundCounter++;

         if (tempRoundCounter%4 == 0) {
            trick++;
         }

      }

      scanner.close();
   }
}
