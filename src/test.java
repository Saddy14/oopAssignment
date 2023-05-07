import java.util.ArrayList;
import java.util.Arrays;
// import java.util.Collections;
// import java.util.Comparator;

public class test {
    public static void main(String[] args) {
        
        ArrayList<String>  trickWinnerPlayerCard = new ArrayList<>(Arrays.asList("s1","s3","s5", "s1"));
        ArrayList<Integer> trickWinnerPlayerIndex= new ArrayList<>(Arrays.asList( 1,2,3,0  ));
        
        int winnerPlayerIndex = 0;
        
        for (int i = 0; i < trickWinnerPlayerCard.size(); i++) {
            String card = trickWinnerPlayerCard.get(i);
            card = card.substring(1);
            trickWinnerPlayerCard.set(i, card);
        }       
        System.out.println("Deck After Removing Suit: "+ trickWinnerPlayerCard); 

        
        if (trickWinnerPlayerCard.indexOf("A") != -1) { 
            System.out.println("A is in trick winner player card");
            System.out.println("Index of Card: "+ trickWinnerPlayerCard.indexOf("A"));
            winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("A"));
        }
        else if (trickWinnerPlayerCard.indexOf("K") != -1) {
            System.out.println("K is in trick winner player card");
            System.out.println("Index of Card: "+ trickWinnerPlayerCard.indexOf("K"));
            winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("K"));
        } 
        else if (trickWinnerPlayerCard.indexOf("Q") != -1) {
            System.out.println("Q is in trick winner player card");
            System.out.println("Index of Card: "+ trickWinnerPlayerCard.indexOf("Q"));
            winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("Q"));
        }
        else if (trickWinnerPlayerCard.indexOf("J") != -1) {
            System.out.println("J is in trick winner player card");
            System.out.println("Index of Card: "+ trickWinnerPlayerCard.indexOf("J"));
            winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("J"));
        }
        else if (trickWinnerPlayerCard.indexOf("X") != -1) {
            System.out.println("X is in trick winner player card");
            System.out.println("Index of Card: "+ trickWinnerPlayerCard.indexOf("X"));
            winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("X"));
        }
        else if (trickWinnerPlayerCard.indexOf("9") != -1) {
            System.out.println("9 is in trick winner player card");
            System.out.println("Index of Card: "+ trickWinnerPlayerCard.indexOf("9"));
            winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("9"));
        }
        else if (trickWinnerPlayerCard.indexOf("8") != -1) {
            System.out.println("8 is in trick winner player card");
            System.out.println("Index of Card: "+ trickWinnerPlayerCard.indexOf("8"));
            winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("8"));
        }
        else if (trickWinnerPlayerCard.indexOf("7") != -1) {
            System.out.println("7 is in trick winner player card");
            System.out.println("Index of Card: "+ trickWinnerPlayerCard.indexOf("7"));
            winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("7"));
        }
        else if (trickWinnerPlayerCard.indexOf("6") != -1) {
            System.out.println("6 is in trick winner player card");
            System.out.println("Index of Card: "+ trickWinnerPlayerCard.indexOf("6"));
            winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("6"));
        }
        else if (trickWinnerPlayerCard.indexOf("5") != -1) {
            System.out.println("5 is in trick winner player card");
            System.out.println("Index of Card: "+ trickWinnerPlayerCard.indexOf("5"));
            winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("5"));
        }
        else if (trickWinnerPlayerCard.indexOf("4") != -1) {
            System.out.println("4 is in trick winner player card");
            System.out.println("Index of Card: "+ trickWinnerPlayerCard.indexOf("4"));
            winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("4"));
        }
        else if (trickWinnerPlayerCard.indexOf("3") != -1) {
            System.out.println("3 is in trick winner player card");
            System.out.println("Index of Card: "+ trickWinnerPlayerCard.indexOf("3"));
            winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("3"));
        }
        else if (trickWinnerPlayerCard.indexOf("2") != -1) {
            System.out.println("2 is in trick winner player card");
            System.out.println("Index of Card: "+ trickWinnerPlayerCard.indexOf("2"));
            winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("2"));
        }
        else {
            System.out.println("Rank Not Found");
        }

        System.out.println(winnerPlayerIndex+ " WinnerPlayerIndex");
        System.out.println("trickWinnerPlayerCardInt: "+trickWinnerPlayerCard+"\nSize: "+trickWinnerPlayerCard.size());
        System.out.println("trickWinnerPlayer       : "+trickWinnerPlayerIndex+"\nSize: "+trickWinnerPlayerIndex.size());
        
    }
}
 