import java.util.ArrayList;

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

      @SuppressWarnings("unused")
      ArrayList<String> leadingP1Card = player1.setLeadPlayerCard(Player.getSuitForPlayer(), Player.getRankP1());

      @SuppressWarnings("unused")
      ArrayList<String> leadingP2Card = player2.setLeadPlayerCard(Player.getSuitForPlayer(), Player.getRankP2());

      @SuppressWarnings("unused")
      ArrayList<String> leadingP3Card = player3.setLeadPlayerCard(Player.getSuitForPlayer(), Player.getRankP3());
      
      @SuppressWarnings("unused")
      ArrayList<String> leadingP4Card = player4.setLeadPlayerCard(Player.getSuitForPlayer(), Player.getRankP4());

      Center center1 = new Center();

      center1.center.add(deck1.deck.get(0));
      deck1.deck.removeAll(center1.center);
      System.out.println("\n Removed the center from the Deck: "+deck1.deck);
      System.out.println();

      int trick = 1;
      System.out.println("Trick#" + trick);

      // Dealing Card to Player 1
      player1.dealCard(deck1.deck);
      System.out.println("Player1: " + player1.playerCard);
      System.out.println("Size: " + player1.playerCard.size());

      deck1.deck.removeAll(player1.playerCard);
      System.out.println("\nDeck: "+deck1.deck);

      // Dealing Card to Player 2
      player2.dealCard(deck1.deck);
      System.out.println("Player2: " + player2.playerCard);
      System.out.println("Size: " + player2.playerCard.size());

      deck1.deck.removeAll(player2.playerCard);
      System.out.println("\nDeck: "+deck1.deck);

      // Dealing Card to Player 3
      player3.dealCard(deck1.deck);
      System.out.println("Player3: " + player3.playerCard);
      System.out.println("Size: " + player3.playerCard.size());

      deck1.deck.removeAll(player3.playerCard);
      System.out.println("\nDeck: "+deck1.deck);

      // Dealing Card to Player 4
      player4.dealCard(deck1.deck);
      System.out.println("Player4: " + player4.playerCard);
      System.out.println("Size: " + player4.playerCard.size());

      deck1.deck.removeAll(player4.playerCard);
      System.out.println("\nDeck: "+deck1.deck);

      // Print All stuff
      System.out.println("Center : " + center1.center + "\nSize: " + center1.center.size() + "\n");

      System.out.println("Deck   : " + deck1.deck + "\nSize: " + deck1.deck.size() + "\n");

      System.out.println("Score  : " + "Player1 = " + player1.getScore() + " | Player2 = " + player2.getScore() +
            " | Player3 = " + player3.getScore() + " | Player4 = " + player4.getScore());

   }
}
