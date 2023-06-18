import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Game implements Serializable { 
    
    private Deck deck1;
    private ArrayList<Player> playerList;
    private SaveGame gameSaver;
    private int startingPlayerIndex;
    private int trick = 1;
    

    private int tempRoundCounter = 0;
    private int currentPlayerIndex;
    private int winnerPlayer;


    private Player saticMethodReplace;
    
    public void createInstance() throws IOException {
        deck1 = new Deck();
        deck1.generateDeck();
        deck1.makeDeckRandom();
        saticMethodReplace = new Player();

        // Adding all the player into a Arraylist
        playerList = new ArrayList<>();
        playerList.add(new Player("Player1"));
        playerList.add(new Player("Player2"));
        playerList.add(new Player("Player3"));
        playerList.add(new Player("Player4"));

        // Adding a Card to the Center
        deck1.addCardToCenter();

        // Determining the First Player..
        startingPlayerIndex = saticMethodReplace.startingPlayerIndex(deck1.getCenter().get(0));
        currentPlayerIndex = startingPlayerIndex;

        // Add Card to Each Player
        Player.addCardToPlayer(playerList, deck1);

    }

    public void startGame() throws IOException {

        Scanner scanner = new Scanner(System.in);

        // Print All stuff
        gameStats(playerList, currentPlayerIndex, trick);
        String userInput = scanner.nextLine();
          
        while (!userInput.equals("x")) {
  
           Player currentPlayer = playerList.get(currentPlayerIndex);
 
            if (userInput.equals("s")) {
                createInstance();
                startGame(); // start a new game
                break;
            }

            else if (userInput.equals("d") || deck1.getDeck().isEmpty()) { // game command 'd'

                if((deck1.getDeck().isEmpty() && userInput.equals("d")) || (deck1.getDeck().isEmpty() && currentPlayer.skipPlayer(deck1.getCenter()) ) ) {

                    currentPlayerIndex = (currentPlayerIndex + 1) % playerList.size();
                    tempRoundCounter++;
                    winnerPlayer = saticMethodReplace.trickWinnerPlayer(deck1, userInput, currentPlayerIndex, trick);

                    if (tempRoundCounter%4 == 0 && tempRoundCounter != 0) {
                        trick++;
                        currentPlayerIndex = winnerPlayer;
                        currentPlayer = playerList.get(currentPlayerIndex);
                        currentPlayer.addScore();
                    }
                }
                else if(userInput.equals("d")) {
                    
                    deck1.dealCardFromDeck(currentPlayer); 
                }
            }

            // Check If player has the card he played & Check Suit/Rank matches the center
            if (userInput.length() == 2 && (currentPlayer.checkPlayerhasCard(userInput) && deck1.inputCardCheck(userInput)) ) {

                // Getting the Winner Player Index after 1 trick is over 
                winnerPlayer = saticMethodReplace.trickWinnerPlayer(deck1, userInput, currentPlayerIndex, trick);
                currentPlayer.getPlayerCard().remove(userInput);
                  
                tempRoundCounter++;
                  
                if (tempRoundCounter%4 == 0 && tempRoundCounter != 0) {

                    trick++;
                    currentPlayerIndex = winnerPlayer;
                    currentPlayer = playerList.get(currentPlayerIndex);
                    currentPlayer.addScore();
                }
                else {
                  currentPlayerIndex = (currentPlayerIndex + 1) % playerList.size();
                }

            }

            if (userInput.equals("save")) {
                
                gameSaver = new  SaveGame(deck1, playerList, startingPlayerIndex, trick, tempRoundCounter, currentPlayerIndex, winnerPlayer, saticMethodReplace);
                gameSaver.startSaving();
                break;
            }

            gameStats(playerList, currentPlayerIndex, trick);
            System.out.print(">");
            userInput = scanner.nextLine();

            
        }
        scanner.close();
    }

    
    
    // Display Game Stats
    private void gameStats(ArrayList<Player> playerList, int currentPlayerIndex, int trick) {

        System.out.println("\nTrick#" + trick);
        System.out.println("\nPlayer1: " + playerList.get(0).getPlayerCard()+"\n"+"Cards: " + playerList.get(0).getPlayerCard().size());
        System.out.println("Player2: " + playerList.get(1).getPlayerCard()+"\n"+"Cards: " + playerList.get(1).getPlayerCard().size());
        System.out.println("Player3: " + playerList.get(2).getPlayerCard()+"\n"+"Cards: " + playerList.get(2).getPlayerCard().size());
        System.out.println("Player4: " + playerList.get(3).getPlayerCard()+"\n"+"Cards: " + playerList.get(3).getPlayerCard().size());
        System.out.println("\nCenter : " + deck1.getCenter() + "\nCards: " + deck1.getCenter().size() + "\n");
        System.out.println("Deck   : " + deck1.getDeck() + "\nCards: " + deck1.getDeck().size() + "\n");
        System.out.println("Score: " + "Player1 = " + playerList.get(0).getScore() + " | Player2 = " + playerList.get(1).getScore() +" | Player3 = " + playerList.get(2).getScore() + " | Player4 = " + playerList.get(3).getScore());
        System.out.println("Turn : " + playerList.get(currentPlayerIndex).getName());
        System.out.print(">");
    }  

    //Main Menu
    public void mainMenu() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\033c");
        System.out.println(" _______  ______  ");
        System.out.println("|  ___  ||  __  | ");
        System.out.println("| |  |__|| |  | | "); 
        System.out.println("| |  ___ | |  | | ");
        System.out.println("| | |_  || |  | | ");
        System.out.println("| |   | || |  | | ");
        System.out.println("| |___| || |__| | ");
        System.out.println("|_______||______| ");
        System.out.println(" _______  ______  ______  __     __ ");
        System.out.println("|  ___  ||  __  ||  __  ||   \\  /  |");
        System.out.println("| |   | || |  | || |  | ||    \\/   |");
        System.out.println("| |___| || |  | || |  | || |\\   /| |");
        System.out.println("|  ___ < | |  | || |  | || | \\_/ | |");
        System.out.println("| |   | || |  | || |  | || |     | |");
        System.out.println("| |___| || |__| || |__| || |     | |");
        System.out.println("|_______||______||______||_|     |_|");
        System.out.println("_________________________________");
        System.out.println("|To start a new game, enter s    |");
        System.out.println("|To load a saved game, enter load|");
        System.out.println("|________________________________|");
        System.out.println(" ");
        System.out.print(">");

        String userInput = scanner.nextLine();
  
        if (userInput.equals("s")) {   //New Game
            System.out.print("\033c");
            createInstance();
            startGame();
        }
        else if (userInput.equals("load")) {   //Load Game

            LoadGame myLoadGame = new LoadGame();
            myLoadGame.startLoading();
        }
        else {                                  //Wrong input
            mainMenu();
        }
        scanner.close();
    }

    // Getters & Setters
    public Player getSaticMethodReplace() {
        return saticMethodReplace;
    }

    public void setSaticMethodReplace(Player saticMethodReplace) {
        this.saticMethodReplace = saticMethodReplace;
    }

    public int getTrick() {
        return trick;
    }

    public void setTrick(int trick) {
        this.trick = trick;
    }

    public int getTempRoundCounter() {
        return tempRoundCounter;
    }

    public void setTempRoundCounter(int tempRoundCounter) {
        this.tempRoundCounter = tempRoundCounter;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public int getWinnerPlayer() {
        return winnerPlayer;
    }

    public void setWinnerPlayer(int winnerPlayer) {
        this.winnerPlayer = winnerPlayer;
    }

    public int getStartingPlayerIndex() {
        return startingPlayerIndex;
    }

    public void setStartingPlayerIndex(int startingPlayerIndex) {
        this.startingPlayerIndex = startingPlayerIndex;
    }

    public Deck getDeck1() {
        return deck1;
    }

    public void setDeck1(Deck deck1) {
        this.deck1 = deck1;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

}
