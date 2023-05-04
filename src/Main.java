import java.util.ArrayList;
import java.util.Random;

public class Main {
   public static void main(String[] args) {
      
      Player player1 = new Player();
      Player player2 = new Player();
      Player player3 = new Player();
      Player player4 = new Player();

      String[] suit = { "c", "d", "h", "s" };
      String[] rank = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "X", "J", "Q", "K" };

      ArrayList<String> deck = new ArrayList<>();

      for (int i = 0; i < suit.length; i++) {

         int tempIndex = 0;

         for (int j = 0; j < rank.length; j++) {

            String temp = (suit[i] + rank[j]);
            deck.add(tempIndex, temp);
            tempIndex++;
         }
     }
      // Check to see of deck is correctly working
      System.out.println("B4 Suffle");
      System.out.println(deck);
      System.out.println("Deck Size: "+deck.size());

      // Random Deck
      Random random = new Random();

      for(int i = 0; i < deck.size(); i++) {

         int randomIndex = random.nextInt(deck.size());
         String temp = deck.get(i);
         deck.set(i, deck.get(randomIndex));
         deck.set(randomIndex, temp );
      }
      
      // Check to see of deck is correctly working
      System.out.println();
      System.out.println("After Suffle");
      System.out.println(deck);
      System.out.println("Deck Size: "+ deck.size());
      System.out.println();

      // Player 1 Cards that dertermines the 1st player
      String[] rank1 = { "A", "5", "9","K" };
      ArrayList<String> leadingP1Card = player1.setLeadPlayerCard(Player.suitForPlayer, rank1);
      System.out.println("leadingP1Card: "+ leadingP1Card);
      System.out.println("Size: "+ leadingP1Card.size());
      System.out.println();

      // Player 2 Cards that dertermines the 1st player
      String[] rank2 = { "2", "6", "X"};
      ArrayList<String> leadingP2Card = player2.setLeadPlayerCard(Player.suitForPlayer, rank2);
      System.out.println("leadingP2Card: "+ leadingP2Card);
      System.out.println("Size: "+ leadingP2Card.size());
      System.out.println();

      // Player 3 Cards that dertermines the 1st player
      String[] rank3 = { "3", "7", "j"};
      ArrayList<String> leadingP3Card = player3.setLeadPlayerCard(Player.suitForPlayer, rank3);
      System.out.println("leadingP3Card: "+ leadingP3Card);
      System.out.println("Size: "+ leadingP3Card.size());
      System.out.println();

      // Player 4 Cards that dertermines the 1st player
      String[] rank4 = { "4", "8", "Q"};
      ArrayList<String> leadingP4Card = player4.setLeadPlayerCard(Player.suitForPlayer, rank4);
      System.out.println("leadingP1Card: "+ leadingP4Card);
      System.out.println("Size: "+ leadingP4Card.size());
      System.out.println();

      // Player 1 Cards
      player1.dealCard(deck);
      System.out.println();
      System.out.println("Player1: "+player1.playerCard);
      System.out.println("Deck Size: "+player1.playerCard.size()); 
      System.out.println();
      
      deck = removeFromDeck(deck, player1.playerCard); 
      System.out.println("New Deck\n"+deck);
      System.out.println("Deck Size: "+ deck.size());

      // Player 2 Cards        
      player2.dealCard(deck);
      System.out.println();
      System.out.println("Player2: "+player2.playerCard);
      System.out.println("Deck Size: "+player2.playerCard.size());
      System.out.println();

      deck = removeFromDeck(deck, player2.playerCard); 
      System.out.println("New Deck\n"+deck);
      System.out.println("Deck Size: "+ deck.size());

      // Player 3 Cards
      player3.dealCard(deck);
      System.out.println();
      System.out.println("Player3: "+player3.playerCard);
      System.out.println("Deck Size: "+player3.playerCard.size());
      System.out.println();

      deck = removeFromDeck(deck, player3.playerCard); 
      System.out.println("New Deck\n"+deck);
      System.out.println("Deck Size: "+ deck.size());

      // Player 4 Cards
      player4.dealCard(deck);
      System.out.println();
      System.out.println("Player4: "+player4.playerCard);
      System.out.println("Deck Size: "+player4.playerCard.size());
      System.out.println();

      deck = removeFromDeck(deck, player4.playerCard); 
      System.out.println("New Deck\n"+deck);
      System.out.println("Deck Size: "+ deck.size());

   }

   // Method that remove the card from the deck after 1 Player is given 7 Cards
   private static ArrayList<String> removeFromDeck (ArrayList<String> deck, ArrayList<String> playerCard) {

      for(int i = 0; i < playerCard.size(); i++) {
      
         deck.remove(playerCard.get(i));
      }
      return deck;
   }
}
