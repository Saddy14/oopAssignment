import java.util.ArrayList;
import java.util.Arrays;

public class Player {
    
    private String name;
    private static int noOfCardsEachPlayer = 7;
    private int score = 0;

    @SuppressWarnings("unused")
    private static int noOfPlayer = 4;
    // Cards for Each Player from the Deck
    ArrayList<String> playerCard = new ArrayList<>();

    public Player(String name) {
        setName(name);
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return score;
    }

    public void dealCard (ArrayList<String> deck) {
        
        for (int i = 0; i < noOfCardsEachPlayer; i++) {

            playerCard.add(deck.get(i));
        } 
    }
    
    public static int startingPlayerIndex(String center) {

        ArrayList<String> startingCardP1 = new ArrayList<>(Arrays.asList("sA", "s5", "s9", "sK", "hA", "h5", "h9", "hK", "dA", "d5", 
                                                                              "d9", "dK", "cA", "c5", "c9", "cK"));
        ArrayList<String> startingCardP2 = new ArrayList<>(Arrays.asList("s2", "s6", "sX", "h2", "h6", "hX", "d2", "d6", "dX", "c2", "c6", "cX")); 
        ArrayList<String> startingCardP3 = new ArrayList<>(Arrays.asList("s3", "s7", "sJ", "h3", "h7", "hJ", "d3", "d7", "dJ", "c3", "c7", "cJ"));
        ArrayList<String> startingCardP4 = new ArrayList<>(Arrays.asList("s4", "s8", "sQ", "h4", "h8", "hQ", "d4", "d8", "dQ", "c4", "c8", "cQ"));
         
        int playerNum = -1;
        while(true) {

            if (startingCardP1.contains(center)) {
                // System.out.print("p1");
                playerNum = 0;
                break;
            }
            else if (startingCardP2.contains(center)) {
                // System.out.print("p2");
                playerNum = 1;
                break;
            }
            else if (startingCardP3.contains(center)) {
                // System.out.print("p3");
                playerNum = 2;
                break;
            }
            else if (startingCardP4.contains(center)) {
                // System.out.print("p4");
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
}
