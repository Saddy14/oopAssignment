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



      // Player 1 Cards
      player1.dealCard(deck);
      System.out.println();
      System.out.println("Player1: "+player1.playerCard);
      System.out.println("Deck Size: "+player1.playerCard.size()); 
      System.out.println();

      // Player 1 
      String[] suit1 = { "c", "d", "h", "s" };
      String[] rank1 = { "A", "5", "9","K" };
      ArrayList<String> leadingP1Card = player1.setLeadPlayerCard(suit1, rank1);
      System.out.println("leadingP1Card: "+ leadingP1Card);
      System.out.println("Size: "+ leadingP1Card.size());
      System.out.println();

      
      
      deck = removeFromDeck(deck, player1.playerCard); 
      System.out.println("New Deck\n"+deck);
      System.out.println("Deck Size: "+ deck.size());

      // player2        // Check to see of deck is correctly working
      player2.dealCard(deck);
      System.out.println();
      System.out.println("Player2: "+player2.playerCard);
      System.out.println("Deck Size: "+player2.playerCard.size());
      System.out.println();

      deck = removeFromDeck(deck, player2.playerCard); 
      System.out.println("New Deck\n"+deck);
      System.out.println("Deck Size: "+ deck.size());

      // player3        // Check to see of deck is correctly working
      player3.dealCard(deck);
      System.out.println();
      System.out.println("Player3: "+player3.playerCard);
      System.out.println("Deck Size: "+player3.playerCard.size());
      System.out.println();

      deck = removeFromDeck(deck, player3.playerCard); 
      System.out.println("New Deck\n"+deck);
      System.out.println("Deck Size: "+ deck.size());

      // player4        // Check to see of deck is correctly working
      player4.dealCard(deck);
      System.out.println();
      System.out.println("Player4: "+player4.playerCard);
      System.out.println("Deck Size: "+player4.playerCard.size());
      System.out.println();

      deck = removeFromDeck(deck, player4.playerCard); 
      System.out.println("New Deck\n"+deck);
      System.out.println("Deck Size: "+ deck.size());

   }



   private static ArrayList<String> removeFromDeck (ArrayList<String> deck, ArrayList<String> playerCard) {

      for(int i = 0; i < playerCard.size(); i++) {
      
         deck.remove(playerCard.get(i));
      }
      return deck;
   }
}
