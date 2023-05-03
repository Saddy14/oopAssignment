import java.util.ArrayList;
import java.util.Random;

public class Main {
   public static void main(String[] args) {

      String[] suit = { "c", "d", "h", "s" };
      String[] rank = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "X", "J", "Q", "K" };

      ArrayList<String> deck = new ArrayList<>();

      for (int i = 0; i < suit.length; i++) {

         for (int j = 0; j < rank.length; j++) {
             deck.add(rank[j] + suit[i]);
         }
     }
      // Check to see of deck is correctly working
      System.out.println(deck);
      System.out.println("Deck Size: "+deck.size());

      // Random Deck
      Random random = new Random();

      for(int i = 0; i < 52; i++) {

         int randomIndex = random.nextInt(52);
         deck.set(i, deck.get(randomIndex));
      }
      
      // Check to see of deck is correctly working
      System.out.println();
      System.out.println(deck);
      System.out.println("Deck Size: "+ deck.size());

   }



   
}
