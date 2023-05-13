import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Deck {
    
    private static String[] suit = { "c", "d", "h", "s" };
    private static String[] rank = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "X", "J", "Q", "K" };
    //Scope package level
    ArrayList<String> deck = new ArrayList<>();
    //Scope package level
    ArrayList<String> center = new ArrayList<>();


    public void generateDeck() {

        for (int i = 0; i < suit.length; i++) {
        
           for (int j = 0; j < rank.length; j++) {

               String temp = (suit[i] + rank[j]);
               deck.add(temp);
            }
        }
        // Check to see if deck is correctly working
        System.out.println("Before Suffle\n" + deck + "\nDeck Size: "+deck.size());
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
        
        // Check to see if deck is correctly working
        System.out.println("\nAfter Suffle\n" + deck + "\nDeck Size: "+deck.size());
    }

    // TODO Remove this method after testing
    public String InputCardCheck (String userInput) {

        Scanner scanner = new Scanner(System.in);
        String temp = null;

        if(this.center.isEmpty()) {

            this.center.add(userInput);
        } 

        if (userInput.charAt(0) == (this.center.get(0).charAt(0)) || userInput.charAt(1) == (this.center.get(0).charAt(1)) ) {

            System.out.println("Valid Card");
            temp = userInput;
        }
        else {
            System.out.println("Invalid Card from Deck Class");
            System.out.print(">");
            userInput = scanner.nextLine();
            temp = userInput;
        }

        if (center.get(0).equals(temp)) {
            
        }
        else {
            this.center.add(userInput);
        }
        
        return temp;        
        
    }
}

