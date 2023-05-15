import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class Player {

    private String name;
    private int score = 0;
    private static int tempCount = 0;
    private static final int NO_OF_CARD_EACH_PLAYER = 7;
    
    @SuppressWarnings("unused")
    private static final int NO_OF_PLAYER = 4;

    // Cards for Each Player from the Deck
    private ArrayList<String> playerCard = new ArrayList<>();

    public ArrayList<String> getPlayerCard() {
        return playerCard;
    }

    // Store PlayerCard & Index to determine the Winner
    private static ArrayList<String> trickWinnerPlayerCard = new ArrayList<>();
    private static ArrayList<Integer> trickWinnerPlayerIndex = new ArrayList<>();

    // 
    public Player(String name) {
        setName(name);
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    // Getters
    public String getName() {
        return name;
    }
    
    public int getScore() {
        return score;
    }
        
    public static int getNoOfCardsEachPlayer() {
        return NO_OF_CARD_EACH_PLAYER;
    }
    
    // TODO Adding score to the Winning Player
    public void addScore() {

        for (String card : playerCard) {
            
            char rank = card.charAt(1);
            switch (rank) {
                case 'A':
                    this.score += 1;
                    break;
                case '2':
                    this.score += 2;
                    break;
                case '3':
                    this.score += 3;
                    break;
                case '4':
                    this.score += 4;
                    break;
                case '5':
                    this.score += 5;
                    break;
                case '6':
                    this.score += 6;
                    break;
                case '7':
                    this.score += 7;
                    break;
                case '8':
                    this.score += 8;
                    break;
                case '9':
                    this.score += 9;
                    break;
                case 'X':
                    this.score += 10;
                    break;
                case 'J','Q','K':
                    this.score += 10;
                    break;
            
                default:
                    this.score += 0;
                    break;
            }
        }
        
    }

    // Deal 1 Card to a Player
    public void dealCard(Deck deck1) {

        for (int i = 0; i < 1; i++) {
                
            playerCard.add(deck1.getDeck().get(i));
            deck1.getDeck().removeAll(playerCard);
        }
    }

    // TODO Extra Feature Don't remove yet... Method to Check If player has the card he played 
    public static String checkPlayerhasCard(String userInput, ArrayList<String> playerCard) {

        Scanner scanner = new Scanner(System.in);
        String temp = null;

        if (!playerCard.contains(userInput)) {

            System.out.println("You do not have a " + userInput + " card");
            System.out.print(">");
            temp = scanner.nextLine();
            userInput = checkPlayerhasCard(temp, playerCard);
        }
        
        return userInput;

    }

    // TODO A Random Card Played by the player
    public String cardPlayedbyCurrentPlayer(Player player) {

        Random random = new Random();
        int r = random.nextInt(playerCard.size());
        String card = playerCard.get(r);
        System.out.println(r);
        return card;

    }

    // Method Returning the index of the Trick Winner
    public static int trickWinnerPlayer(Deck deck1, String userInput, int currentPlayerIndex, int trick) {

        int temp = 0;
        tempCount++;        

        if (deck1.getCenter().get(0).charAt(0) == userInput.charAt(0)) {

            trickWinnerPlayerIndex.add(currentPlayerIndex);
            trickWinnerPlayerCard.add(userInput);

            System.out.println(trickWinnerPlayerIndex);
            System.out.println(trickWinnerPlayerCard +"\n");
            System.out.println("TempArry"+tempCount);
        }

        if (tempCount % 4 == 0) {

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
                temp = winnerPlayerIndex;
            } 
            else if (trickWinnerPlayerCard.indexOf("K") != -1) {
                System.out.println("K is in trick winner player card");
                System.out.println("Index of Card: " + trickWinnerPlayerCard.indexOf("K"));
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("K"));
                temp = winnerPlayerIndex;

            } 
            else if (trickWinnerPlayerCard.indexOf("Q") != -1) {
                System.out.println("Q is in trick winner player card");
                System.out.println("Index of Card: " + trickWinnerPlayerCard.indexOf("Q"));
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("Q"));
                temp = winnerPlayerIndex;

            } 
            else if (trickWinnerPlayerCard.indexOf("J") != -1) {
                System.out.println("J is in trick winner player card");
                System.out.println("Index of Card: " + trickWinnerPlayerCard.indexOf("J"));
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("J"));
                temp = winnerPlayerIndex;

            } 
            else if (trickWinnerPlayerCard.indexOf("X") != -1) {
                System.out.println("X is in trick winner player card");
                System.out.println("Index of Card: " + trickWinnerPlayerCard.indexOf("X"));
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("X"));
                temp = winnerPlayerIndex;

            } 
            else if (trickWinnerPlayerCard.indexOf("9") != -1) {
                System.out.println("9 is in trick winner player card");
                System.out.println("Index of Card: " + trickWinnerPlayerCard.indexOf("9"));
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("9"));
                temp = winnerPlayerIndex;

            } 
            else if (trickWinnerPlayerCard.indexOf("8") != -1) {
                System.out.println("8 is in trick winner player card");
                System.out.println("Index of Card: " + trickWinnerPlayerCard.indexOf("8"));
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("8"));
                temp = winnerPlayerIndex;

            } 
            else if (trickWinnerPlayerCard.indexOf("7") != -1) {
                System.out.println("7 is in trick winner player card");
                System.out.println("Index of Card: " + trickWinnerPlayerCard.indexOf("7"));
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("7"));
                temp = winnerPlayerIndex;

            } 
            else if (trickWinnerPlayerCard.indexOf("6") != -1) {
                System.out.println("6 is in trick winner player card");
                System.out.println("Index of Card: " + trickWinnerPlayerCard.indexOf("6"));
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("6"));
                temp = winnerPlayerIndex;

            } 
            else if (trickWinnerPlayerCard.indexOf("5") != -1) {
                System.out.println("5 is in trick winner player card");
                System.out.println("Index of Card: " + trickWinnerPlayerCard.indexOf("5"));
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("5"));
                temp = winnerPlayerIndex;

            } 
            else if (trickWinnerPlayerCard.indexOf("4") != -1) {
                System.out.println("4 is in trick winner player card");
                System.out.println("Index of Card: " + trickWinnerPlayerCard.indexOf("4"));
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("4"));
                temp = winnerPlayerIndex;

            } 
            else if (trickWinnerPlayerCard.indexOf("3") != -1) {
                System.out.println("3 is in trick winner player card");
                System.out.println("Index of Card: " + trickWinnerPlayerCard.indexOf("3"));
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("3"));
                temp = winnerPlayerIndex;

            } 
            else if (trickWinnerPlayerCard.indexOf("2") != -1) {
                System.out.println("2 is in trick winner player card");
                System.out.println("Index of Card: " + trickWinnerPlayerCard.indexOf("2"));
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("2"));
                temp = winnerPlayerIndex;

            } 
            else {
                System.out.println("Rank Not Found");
            }

            System.out.println("\n*** Player"+(winnerPlayerIndex+1) + " wins Trick#" + trick + " ***\n");

            trickWinnerPlayerIndex.removeAll(trickWinnerPlayerIndex);
            trickWinnerPlayerCard.removeAll(trickWinnerPlayerCard);
            deck1.getCenter().removeAll(deck1.getCenter());
        }
        return temp;
    }
}
