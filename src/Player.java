import java.util.ArrayList;

public class Player {
    
    static int noOfPlayer = 4;
    static int noOfCardsEachPlayer = 7;
    int score = 0;
    ArrayList<String> playerCard = new ArrayList<>();

    void dealCard (ArrayList<String> deck ) {
        
        for (int i = 0; i < noOfCardsEachPlayer; i++) {

            playerCard.add(deck.get(i));
            
        } 

    }
}
