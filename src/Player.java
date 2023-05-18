import java.util.ArrayList;

public class Player {

    private String name;
    private int score = 0;
    private static int tempCount = 0;
    private static final int NO_OF_CARD_EACH_PLAYER = 7;

    // Cards for Each Player from the Deck
    private ArrayList<String> playerCard = new ArrayList<>();

    // Store PlayerCard & Index to determine the Winner
    private static ArrayList<String> trickWinnerPlayerCard = new ArrayList<>();
    private static ArrayList<Integer> trickWinnerPlayerIndex = new ArrayList<>();

    // Constructer
    public Player(String name) {
        this.name = name;
    }

    // Getters
    public String getName() {
        return name;
    }
    public ArrayList<String> getPlayerCard() {
        return playerCard;
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

    // Check If player has the card he played 
    public Boolean checkPlayerhasCard(String userInput) {

        Boolean passCheck = true;

        if (!playerCard.contains(userInput)) {

            System.out.print("You do not have a " + userInput + "\n>");            
            passCheck = false;
        }
        return passCheck;
        
    }

    // TODO A Random Card Played by the player
    public String cardPlayedbyCurrentPlayer(ArrayList<String> c) {

        for (String card : playerCard) {
            
            if(c.isEmpty()) {
                c.add(card);
            }
            
            if (card.charAt(0) == (c.get(0).charAt(0)) || card.charAt(1) == (c.get(0).charAt(1)) ) {
                
                System.out.println("Card Played: " + card);
                return card;
            }
            else {
                System.out.println("Card Played: " + card);
                return card;
            }
        }
        return "";
    }

    // Method Returning the index of the Trick Winner
    public static int trickWinnerPlayer(Deck deck1, String userInput, int currentPlayerIndex, int trick) {

        int temp = 0;
        tempCount++;        

        if (deck1.getCenter().get(0).charAt(0) == userInput.charAt(0)) {

            trickWinnerPlayerIndex.add(currentPlayerIndex);
            trickWinnerPlayerCard.add(userInput);
        }

        if (tempCount % 4 == 0) {

            int winnerPlayerIndex = 0;

            // Removing the Suit only
            for (int i = 0; i < trickWinnerPlayerCard.size(); i++) {
                String card = trickWinnerPlayerCard.get(i);
                card = card.substring(1);
                trickWinnerPlayerCard.set(i, card);
            }

            // Checking with the Rank and getting the playerIndex
            if (trickWinnerPlayerCard.indexOf("A") != -1) {
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("A"));
                temp = winnerPlayerIndex;
            } 
            else if (trickWinnerPlayerCard.indexOf("K") != -1) {
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("K"));
                temp = winnerPlayerIndex;

            } 
            else if (trickWinnerPlayerCard.indexOf("Q") != -1) {
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("Q"));
                temp = winnerPlayerIndex;

            } 
            else if (trickWinnerPlayerCard.indexOf("J") != -1) {
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("J"));
                temp = winnerPlayerIndex;

            } 
            else if (trickWinnerPlayerCard.indexOf("X") != -1) {
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("X"));
                temp = winnerPlayerIndex;

            } 
            else if (trickWinnerPlayerCard.indexOf("9") != -1) {
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("9"));
                temp = winnerPlayerIndex;

            } 
            else if (trickWinnerPlayerCard.indexOf("8") != -1) {
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("8"));
                temp = winnerPlayerIndex;

            } 
            else if (trickWinnerPlayerCard.indexOf("7") != -1) {
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("7"));
                temp = winnerPlayerIndex;

            } 
            else if (trickWinnerPlayerCard.indexOf("6") != -1) {
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("6"));
                temp = winnerPlayerIndex;

            } 
            else if (trickWinnerPlayerCard.indexOf("5") != -1) {
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("5"));
                temp = winnerPlayerIndex;

            } 
            else if (trickWinnerPlayerCard.indexOf("4") != -1) {
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("4"));
                temp = winnerPlayerIndex;

            } 
            else if (trickWinnerPlayerCard.indexOf("3") != -1) {
                winnerPlayerIndex = trickWinnerPlayerIndex.get(trickWinnerPlayerCard.indexOf("3"));
                temp = winnerPlayerIndex;

            } 
            else if (trickWinnerPlayerCard.indexOf("2") != -1) {
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
