import java.util.ArrayList;
import java.util.Random;

public class Main {
   public static void main(String[] args) {

      String[] suit = { "c", "d", "h", "s" };
      String[] rank = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "X", "J", "Q", "K" };

      ArrayList<String> deck = new ArrayList<>();

      for (int i = 0; i < suit.length; i++) {

         int tempIndex = 0;

         for (int j = 0; j < rank.length; j++) {

            String temp = (rank[j] + suit[i]);
            deck.add(tempIndex, temp);
            tempIndex++;
         }
     }
      // Check to see of deck is correctly working
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
      System.out.println(deck);
      System.out.println("Deck Size: "+ deck.size());

   }



   
}
