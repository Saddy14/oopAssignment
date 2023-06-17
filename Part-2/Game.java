import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;



public class Game implements Serializable{
    
    private Deck deck1;
    private ArrayList<Player> playerList;
    private ArrayList<String> deck;
    private ArrayList<String> center;
    private ArrayList<Integer> score;
    private ArrayList<String> turn;
    private SaveLoad save;


    //Main Menu
    public void mainMenu() {
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
        System.out.println("_______________________________");
        System.out.println("|To start a new game, enter n |");
        System.out.println("|To load a saved game, enter l|");
        System.out.println("|_____________________________|");
        System.out.println(" ");
        System.out.println("        New Game(n)"); //start a new game
        System.out.println("        Load Game(l)"); //load game file

        System.out.print(">");

        String game = scanner.nextLine();
  
        if (game.equals("n")) {   //New Game
            System.out.print("\033c");
            startGame();
            
        
        }
        else if (game.equals("l")) {   //Load Game
            System.out.println("Loading game file...");
            
            
        }
        else {                                  //Wrong input
            System.out.println("\033c");
            System.out.println("Please input correctly");
            System.out.println("_______________________________");
            System.out.println("|To start a new game, enter n |");
            System.out.println("|To load a saved game, enter l|");
            System.out.println("_______________________________");
            System.out.println(" ");
            mainMenu();
            
            
        }
    }

    public void startGame() {

        deck1 = new Deck();
        deck1.generateDeck();
        deck1.makeDeckRandom();
        save = new SaveLoad();
        deck = new ArrayList<>();
        center = new ArrayList<>();
        score = new ArrayList<>();
        turn = new ArrayList<>();
        int deckSize;
        int centerSize;
        

        // Adding all the player into a Arraylist
        playerList = new ArrayList<>();
        playerList.add(new Player("Player1"));
        playerList.add(new Player("Player2"));
        playerList.add(new Player("Player3"));
        playerList.add(new Player("Player4"));

        // Adding a Card to the Center
        deck1.addCardToCenter();

        // Determining the First Player..
        int startingPlayerIndex = Player.startingPlayerIndex(deck1.getCenter().get(0));

        // Add Card to Each Player
        Player.addCardToPlayer(playerList, deck1);

        
          
        Scanner scanner = new Scanner(System.in);
  
        int trick = 1;
        int tempRoundCounter = 0;
        int currentPlayerIndex = startingPlayerIndex;
        int winnerPlayer;

        // Print All stuff
        System.out.println(" _______________________________");
        System.out.println("|Game Functions:                |");
        System.out.println("| d = Draw cards                |");
        System.out.println("| s = Start a new game          |");
        System.out.println("| v = Save the game             |");
        System.out.println("| x = Exit and save the game    |");
        System.out.println("|_______________________________|");
        gameStats(playerList, currentPlayerIndex, trick);
        
        
            

        String userInput = scanner.nextLine();

        while (!userInput.equals("x")) {
  
           Player currentPlayer = playerList.get(currentPlayerIndex);
 
            if (userInput.equals("s")) {
                System.out.println("\033c");
                startGame(); // start a new game
                break;
            }

            else if (userInput.equals("d") || deck1.getDeck().isEmpty()) { // game command 'd'

                if((deck1.getDeck().isEmpty() && userInput.equals("d")) || (deck1.getDeck().isEmpty() && currentPlayer.skipPlayer(deck1.getCenter()) ) ) {

                    currentPlayerIndex = (currentPlayerIndex + 1) % playerList.size();
                    tempRoundCounter++;
                    winnerPlayer = Player.trickWinnerPlayer(deck1, userInput, currentPlayerIndex, trick);

                    if (tempRoundCounter%4 == 0 && tempRoundCounter != 0) {
                        trick++;
                        currentPlayerIndex = winnerPlayer;
                        currentPlayer = playerList.get(currentPlayerIndex);
                        currentPlayer.addScore();
                    }
                System.out.println("\033c");
                }
                else if(userInput.equals("d")) {
                    
                    deck1.dealCardFromDeck(currentPlayer); 
                    System.out.println("\033c");

                }
            }
            
            else if (userInput.equals("v")) {
                deckSize = deck1.getDeck().size();
                centerSize = deck1.getCenter().size();
                

                save.SaveLoad1(playerList);
                save.SaveLoad2(deck, deckSize);
                save.SaveLoad3(center, centerSize);
                save.SaveLoad4(score);
                save.SaveLoad5(turn);

                deck.add(deck1.getDeck().toString());
                center.add(deck1.getCenter().toString());
                turn.add(playerList.get(currentPlayerIndex).getName());
                if (turn.size() > 1){
                    turn.remove(0);
                }
                
                //System.out.println(turn);
                save.saveFile();
                System.out.println("\033c");
                System.out.println("Game Saved");
                //saveload.LoadFile();
                
            } 
            else{
            System.out.println("\033c");
            System.out.println("Please input correctly");
            
            } 
                           

            

            // gameStats(playerList, currentPlayerIndex, trick);
            // System.out.print(">");
            // userInput = scanner.nextLine();

            // Check If player has the card he played & Check Suit/Rank matches the center
            if (userInput.length() == 2 && (currentPlayer.checkPlayerhasCard(userInput) && deck1.inputCardCheck(userInput)) ) {

                // Getting the Winner Player Index after 1 trick is over 
                winnerPlayer = Player.trickWinnerPlayer(deck1, userInput, currentPlayerIndex, trick);
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
            System.out.println("\033c");    
            }
            System.out.println(" _______________________________");
            System.out.println("|Game Functions:                |");
            System.out.println("| d = Draw cards                |");
            System.out.println("| s = Start a new game          |");
            System.out.println("| v = Save the game             |");
            System.out.println("| x = Exit and save the game    |");
            System.out.println("|_______________________________|");
            gameStats(playerList, currentPlayerIndex, trick);
        

            userInput = scanner.nextLine();
            
        }

        scanner.close();

        if (userInput.equals("x")){
            deckSize = deck1.getDeck().size();
            centerSize = deck1.getCenter().size();
            
            save.SaveLoad1(playerList);
            save.SaveLoad2(deck, deckSize);
            save.SaveLoad3(center, centerSize);
            save.SaveLoad4(score);
            save.SaveLoad5(turn);    
            deck.add(deck1.getDeck().toString());
            center.add(deck1.getCenter().toString());
            turn.add(playerList.get(currentPlayerIndex).getName());
            if (turn.size() > 1){
                turn.remove(0);
            }

            //System.out.println(turn);
            save.saveFile();
            System.out.println("\033c");
            System.out.println(" ________________________");
            System.out.println("|       Game Saved       |");
            System.out.println("|Thank you for playing!!!|");
            System.out.println("|________________________|");
        }
        
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
}
