import java.util.ArrayList;

public class Player {
    
    static int noOfPlayer = 4;
    static int noOfCardsEachPlayer = 7;
    int score = 0;
    static String[] suitForPlayer = {"c", "d", "h", "s"};

    // ArrayList for Each Player from the Deck
    ArrayList<String> playerCard = new ArrayList<>();

    // ArrayList for Each Player that determines the first player
    ArrayList<String> leadingPlayerCard = new ArrayList<>();



    public void dealCard (ArrayList<String> deck) {
        
        for (int i = 0; i < noOfCardsEachPlayer; i++) {

            playerCard.add(deck.get(i));
            
        } 

    }

    public ArrayList<String> setLeadPlayerCard(String[] suit, String[] rank) {

        ArrayList<String> leadPlayerCard = new ArrayList<>();

        for (int i = 0; i < suit.length; i++) {

            int tempIndex = 0;

            for (int j = 0; j < rank.length; j++) {

                String temp = (suit[i] + rank[j]);
                leadPlayerCard.add(tempIndex, temp);
                tempIndex++;
            }
        }
        return leadPlayerCard;
    }
}
