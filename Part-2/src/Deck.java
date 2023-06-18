import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Deck implements Serializable { 
    
    // Arrays for suit & rank
    private static String[] suit = { "c", "d", "h", "s" };
    private static String[] rank = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "X", "J", "Q", "K" };
    // ArrayList where the deck & center is stored
    private ArrayList<String> deck = new ArrayList<>();
    private ArrayList<String> center = new ArrayList<>();

    // Getters
    public ArrayList<String> getDeck() {
        return deck;
    }

    public ArrayList<String> getCenter() {
        return center;
    }

    // Generate Deck
    public void generateDeck() {

        for (int i = 0; i < suit.length; i++) {
        
           for (int j = 0; j < rank.length; j++) { 

               String temp = (suit[i] + rank[j]);
               deck.add(temp);
            }
        }
        // Check to see if deck is correctly working
        // System.out.println("Before Suffle\n" + deck + "\nDeck Size: "+deck.size());
    }

    // Shuffling the Deck
    public void makeDeckRandom() {

        Collections.shuffle(deck);

        // Check to see if deck is correctly working
        System.out.println("\nAfter Suffle\n" + deck + "\nDeck Size: "+deck.size());
    }

    // Check Suit/Rank matches the center 
    public Boolean inputCardCheck (String userInput) {

        Boolean passCheck = true;

        // Needed from start of Trick#2 & so on..
        if(this.center.isEmpty()) {
            this.center.add(userInput);
        } 

        // Check Suit/Rank matches the center
        if (!(userInput.charAt(0) == (this.center.get(0).charAt(0)) || userInput.charAt(1) == (this.center.get(0).charAt(1))) ) {

            System.out.println("Suit/Rank does not match");
            
            passCheck = false;
        }
        else if (!center.contains(userInput)) {
            this.center.add(userInput);
        }
        
        return passCheck;        
    }

    // Deal a card to player from their deck
    public void dealCardFromDeck(Player player) {
        
        while (true) {
            
            if (deck.isEmpty()){
                break;
            }
            if (deck.get(0).charAt(0) == (this.center.get(0).charAt(0)) || deck.get(0).charAt(1) == (this.center.get(0).charAt(1))) {

                player.getPlayerCard().add(deck.get(0));
                System.out.println("You drew: " + deck.get(0));
                deck.remove(0);
                break;
            }
            else {
                player.getPlayerCard().add(deck.get(0));
                System.out.println("You drew: " + deck.get(0));
                deck.remove(0);
                if(deck.isEmpty()) {
                    break;
                }
            }
        }
    }

    // Add Card to the center from the deck
    public void addCardToCenter() {

        getCenter().add(getDeck().get(0));
        getDeck().removeAll(getCenter());
    }
}

