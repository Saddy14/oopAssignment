import java.util.ArrayList;
import java.util.Random;

public class Deck {
    
    public static String[] suit = { "c", "d", "h", "s" };
    public static String[] rank = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "X", "J", "Q", "K" };
    public ArrayList<String> deck = new ArrayList<>();

    public void generateDeck() {

        for (int i = 0; i < suit.length; i++) {
    
           int tempIndex = 0;
    
           for (int j = 0; j < rank.length; j++) {

               String temp = (suit[i] + rank[j]);
               deck.add(tempIndex, temp);
               tempIndex++;
            }
        }
        // Check to see of deck is correctly working
        System.out.println("Before Suffle");
        System.out.println(deck);
        System.out.println("Deck Size: "+deck.size());
    }

    public void makeDeckRandom() {

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
    }

}
