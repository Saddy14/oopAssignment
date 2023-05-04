import java.util.ArrayList;

public class Player {
    
    public static int noOfPlayer = 4;
    public static int noOfCardsEachPlayer = 7;
    public int score = 0;
    
    public static String[] suitForPlayer = {"c", "d", "h", "s"};
    public static String[] rankP1 = { "A", "5", "9","K" };
    public static String[] rankP2 = { "2", "6", "X"};
    public static String[] rankP3 = { "3", "7", "j"};
    public static String[] rankP4 = { "4", "8", "Q"};

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
