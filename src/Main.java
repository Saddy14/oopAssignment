// import java.util.ArrayList;

public class Main {
   public static void main(String[] args) {

      Deck deck1 = new Deck();
      deck1.generateDeck();
      deck1.makeDeckRandom();
      System.out.println("\nDeck: "+ deck1.deck);
      
      Player player1 = new Player();
      Player player2 = new Player();
      Player player3 = new Player();
      Player player4 = new Player();

      // Adding 1st card from the deck to the center
      deck1.center.add(deck1.deck.get(0));
      deck1.deck.removeAll(deck1.center);
      System.out.println("\n Removed the center from the Deck: "+deck1.deck);
      System.out.println();

      // Determining the First Player..
      int startPlayer = Player.startingPlayer(deck1.center.get(0));
      System.out.println("\nThe First Player is: "+startPlayer);

      int trick = 1;
      System.out.println("Trick#" + trick);

      // Dealing Card to Player 1
      player1.dealCard(deck1.deck);
      System.out.println("Player1: " + player1.playerCard+"\n"+"Size: " + player1.playerCard.size());

      deck1.deck.removeAll(player1.playerCard);
      System.out.println("\nDeck: "+deck1.deck);

      // Dealing Card to Player 2
      player2.dealCard(deck1.deck);
      System.out.println("Player2: " + player2.playerCard+"\n"+"Size: " + player2.playerCard.size());

      deck1.deck.removeAll(player2.playerCard);
      System.out.println("\nDeck: "+deck1.deck);

      // Dealing Card to Player 3
      player3.dealCard(deck1.deck);
      System.out.println("Player3: " + player3.playerCard+"\n"+"Size: " + player3.playerCard.size());

      deck1.deck.removeAll(player3.playerCard);
      System.out.println("\nDeck: "+deck1.deck);

      // Dealing Card to Player 4
      player4.dealCard(deck1.deck);
      System.out.println("Player4: " + player4.playerCard+"\n"+"Size: " + player4.playerCard.size());

      deck1.deck.removeAll(player4.playerCard);
      System.out.println("\nDeck: "+deck1.deck);

      // Print All stuff
      System.out.println("Center : " + deck1.center + "\nSize: " + deck1.center.size() + "\n");

      System.out.println("Deck   : " + deck1.deck + "\nSize: " + deck1.deck.size() + "\n");

      System.out.println("Score  : " + "Player1 = " + player1.getScore() + " | Player2 = " + player2.getScore() +
            " | Player3 = " + player3.getScore() + " | Player4 = " + player4.getScore());

   }
}
