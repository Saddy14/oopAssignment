import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Deck {
    
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
        // System.out.println("\nAfter Suffle\n" + deck + "\nDeck Size: "+deck.size());
    }

    // Check Suit/Rank matches the center 
    public String InputCardCheck (String userInput) {

        Scanner scanner = new Scanner(System.in);

        // Needed from start of Trick#2 & so on..
        if(this.center.isEmpty()) {
            this.center.add(userInput);
        } 

        // Check Suit/Rank matches the center
        if (!(userInput.charAt(0) == (this.center.get(0).charAt(0)) || userInput.charAt(1) == (this.center.get(0).charAt(1))) ) {

            System.out.println("Suit/Rank does not match");
            System.out.print(">");
            String tempInputCardCheck = scanner.nextLine();
            userInput = InputCardCheck(tempInputCardCheck);
        }

        // Condition req. to avoid duplicate for start of Trick#2 & so on..
        if (!center.contains(userInput)) {
            this.center.add(userInput);
        }
        return userInput;        
    }

    // Method Returning the Index of the Starting Player
    public static int startingPlayerIndex(String center) {

        // Cards that determine who will be the Starting Player
        ArrayList<String> startingCardP1 = new ArrayList<>(Arrays.asList("sA", "s5", "s9", "sK", "hA", "h5", "h9", "hK", "dA", "d5", "d9", "dK", "cA", "c5", "c9", "cK"));
        ArrayList<String> startingCardP2 = new ArrayList<>(Arrays.asList("s2", "s6", "sX", "h2", "h6", "hX", "d2", "d6", "dX", "c2", "c6", "cX"));
        ArrayList<String> startingCardP3 = new ArrayList<>(Arrays.asList("s3", "s7", "sJ", "h3", "h7", "hJ", "d3", "d7", "dJ", "c3", "c7", "cJ"));
        ArrayList<String> startingCardP4 = new ArrayList<>(Arrays.asList("s4", "s8", "sQ", "h4", "h8", "hQ", "d4", "d8", "dQ", "c4", "c8", "cQ"));
    
        int playerNum = -1;
        while (true) {
    
            if (startingCardP1.contains(center)) {
                playerNum = 0;
                break;
            } 
            else if (startingCardP2.contains(center)) {
                playerNum = 1;
                break;
            } 
            else if (startingCardP3.contains(center)) {
                playerNum = 2;
                break;
            } 
            else if (startingCardP4.contains(center)) {
                playerNum = 3;
                break;
            } 
            else {
                playerNum = -1;
                break;
            }
        }
        return playerNum;
    }

    // TODO Method to Deal a card to player from their deck
    public void dealCardFromDeck(Player player) {
        
        for (int i = 0; i < deck.size(); i++) {
            
            if (deck.get(i).charAt(0) == (this.center.get(0).charAt(0)) || deck.get(i).charAt(1) == (this.center.get(0).charAt(1))) {

                player.getPlayerCard().add(deck.get(i));
                deck.remove(i);
                break;
            }
        }
    }

    // Add Card to the center from the deck
    public void addCardToCenter() {

        getCenter().add(getDeck().get(0));
        getDeck().removeAll(getCenter());
    }
}

