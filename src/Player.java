import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Player {

    private String name;
    private int score = 0;
    
    private static final int NO_OF_CARD_EACH_PLAYER = 7;
    @SuppressWarnings("unused")
    private static final int NO_OF_PLAYER = 4;

    // Cards for Each Player from the Deck
    ArrayList<String> playerCard = new ArrayList<>();

    static ArrayList<String> trickWinnerPlayerCard = new ArrayList<>();
    static ArrayList<Integer> trickWinnerPlayerIndex = new ArrayList<>();

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

    public static int getNoOfCardsEachPlayer() {
        return NO_OF_CARD_EACH_PLAYER;
    }

    public void dealCard(Deck deck1) {

        for (int i = 0; i < 1; i++) {
                
            playerCard.add(deck1.deck.get(i));
            deck1.deck.removeAll(playerCard);
        }
    }


    public static int startingPlayerIndex(String center) {

        // Cards that determine who will be the Starting Player
        ArrayList<String> startingCardP1 = new ArrayList<>(Arrays.asList("sA", "s5", "s9", "sK", "hA", "h5", "h9", "hK", "dA", "d5", "d9", "dK", "cA", "c5", "c9", "cK"));
        ArrayList<String> startingCardP2 = new ArrayList<>(Arrays.asList("s2", "s6", "sX", "h2", "h6", "hX", "d2", "d6", "dX", "c2", "c6", "cX"));
        ArrayList<String> startingCardP3 = new ArrayList<>(Arrays.asList("s3", "s7", "sJ", "h3", "h7", "hJ", "d3", "d7", "dJ", "c3", "c7", "cJ"));
        ArrayList<String> startingCardP4 = new ArrayList<>(Arrays.asList("s4", "s8", "sQ", "h4", "h8", "hQ", "d4", "d8", "dQ", "c4", "c8", "cQ"));

        int playerNum = -1;
        while (true) {

            if (startingCardP1.contains(center)) {
                // System.out.print("p1");
                playerNum = 0;
                break;
            } else if (startingCardP2.contains(center)) {
                // System.out.print("p2");
                playerNum = 1;
                break;
            } else if (startingCardP3.contains(center)) {
                // System.out.print("p3");
                playerNum = 2;
                break;
            } else if (startingCardP4.contains(center)) {
                // System.out.print("p4");
                playerNum = 3;
                break;
            } else {
                playerNum = -1;
                break;
            }
        }
        return playerNum;
    }

    // TODO Remove this method after testing
    public static String checkPlayerhasCard(String userInput, ArrayList<String> playerCard) {

        Scanner scanner = new Scanner(System.in);
        String temp = null;

        if (playerCard.contains(userInput)) {

            System.out.println("You have a " + userInput + " card");
            temp = userInput;
        }

        else {

            System.out.println("You do not have a " + userInput + " card");
            System.out.print(">");
            temp = scanner.nextLine();
        }
        return temp;

    }

    public static void trickWinnerPlayer(Deck deck1, String userInput, int currentPlayerIndex) {

        if (deck1.center.get(0).charAt(0) == userInput.charAt(0)) {

            trickWinnerPlayerIndex.add(currentPlayerIndex);
            trickWinnerPlayerCard.add(userInput);

            System.out.println(trickWinnerPlayerIndex);
            System.out.println(trickWinnerPlayerCard);
        }

        if (trickWinnerPlayerCard.size() == 4) {

            int winnerPlayerIndex = 0;

            for (int i = 0; i < trickWinnerPlayerCard.size(); i++) {
                String card = trickWinnerPlayerCard.get(i);
                card = card.substring(1);
                trickWinnerPlayerCard.set(i, card);
            }

            System.out.println("Deck After Removing Suit: " + trickWinnerPlayerCard);

            if (trickWinnerPlayerCard.indexOf("A") != -1) {
                System.out.println("A is in trick winner player card");
                System.out.println("Index of Card: " + trickWinnerPlayerCard.indexOf("A"));
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("A"));
            } 
            else if (trickWinnerPlayerCard.indexOf("K") != -1) {
                System.out.println("K is in trick winner player card");
                System.out.println("Index of Card: " + trickWinnerPlayerCard.indexOf("K"));
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("K"));
            } 
            else if (trickWinnerPlayerCard.indexOf("Q") != -1) {
                System.out.println("Q is in trick winner player card");
                System.out.println("Index of Card: " + trickWinnerPlayerCard.indexOf("Q"));
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("Q"));
            } 
            else if (trickWinnerPlayerCard.indexOf("J") != -1) {
                System.out.println("J is in trick winner player card");
                System.out.println("Index of Card: " + trickWinnerPlayerCard.indexOf("J"));
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("J"));
            } 
            else if (trickWinnerPlayerCard.indexOf("X") != -1) {
                System.out.println("X is in trick winner player card");
                System.out.println("Index of Card: " + trickWinnerPlayerCard.indexOf("X"));
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("X"));
            } 
            else if (trickWinnerPlayerCard.indexOf("9") != -1) {
                System.out.println("9 is in trick winner player card");
                System.out.println("Index of Card: " + trickWinnerPlayerCard.indexOf("9"));
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("9"));
            } 
            else if (trickWinnerPlayerCard.indexOf("8") != -1) {
                System.out.println("8 is in trick winner player card");
                System.out.println("Index of Card: " + trickWinnerPlayerCard.indexOf("8"));
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("8"));
            } 
            else if (trickWinnerPlayerCard.indexOf("7") != -1) {
                System.out.println("7 is in trick winner player card");
                System.out.println("Index of Card: " + trickWinnerPlayerCard.indexOf("7"));
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("7"));
            } 
            else if (trickWinnerPlayerCard.indexOf("6") != -1) {
                System.out.println("6 is in trick winner player card");
                System.out.println("Index of Card: " + trickWinnerPlayerCard.indexOf("6"));
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("6"));
            } 
            else if (trickWinnerPlayerCard.indexOf("5") != -1) {
                System.out.println("5 is in trick winner player card");
                System.out.println("Index of Card: " + trickWinnerPlayerCard.indexOf("5"));
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("5"));
            } 
            else if (trickWinnerPlayerCard.indexOf("4") != -1) {
                System.out.println("4 is in trick winner player card");
                System.out.println("Index of Card: " + trickWinnerPlayerCard.indexOf("4"));
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("4"));
            } 
            else if (trickWinnerPlayerCard.indexOf("3") != -1) {
                System.out.println("3 is in trick winner player card");
                System.out.println("Index of Card: " + trickWinnerPlayerCard.indexOf("3"));
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("3"));
            } 
            else if (trickWinnerPlayerCard.indexOf("2") != -1) {
                System.out.println("2 is in trick winner player card");
                System.out.println("Index of Card: " + trickWinnerPlayerCard.indexOf("2"));
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("2"));
            } 
            else {
                System.out.println("Rank Not Found");
            }

            System.out.println(winnerPlayerIndex + " WinnerPlayerIndex");
            System.out.println("trickWinnerPlayerCardInt: " + trickWinnerPlayerCard + "\nSize: " + trickWinnerPlayerCard.size());
            System.out.println("trickWinnerPlayer       : " + trickWinnerPlayerIndex + "\nSize: " + trickWinnerPlayerIndex.size());

            trickWinnerPlayerIndex.removeAll(trickWinnerPlayerIndex);
            trickWinnerPlayerCard.removeAll(trickWinnerPlayerCard);
            deck1.center.removeAll(deck1.center);
        }
        


    }
}
