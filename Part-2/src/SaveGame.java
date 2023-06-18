import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class SaveGame implements Serializable { 
    private Game myGame = new Game();
    private Deck deck1;
    private ArrayList<Player> playerList;
    private int startingPlayerIndex;

    private int trick = 1;
    private int tempRoundCounter = 0;
    private int currentPlayerIndex = startingPlayerIndex;
    private int winnerPlayer;
    private Player saticMethodReplace;


    SaveGame(Deck deck1, ArrayList<Player> playerList, int startingPlayerIndex, int trick, int tempRoundCounter, int currentPlayerIndex, int winnerPlayer, Player saticMethodReplace) {

        this.deck1 = deck1;
        this.playerList = playerList;
        this.startingPlayerIndex = startingPlayerIndex;
        this.trick = trick;
        this.tempRoundCounter = tempRoundCounter;
        this.currentPlayerIndex = currentPlayerIndex;
        this.winnerPlayer = winnerPlayer;
        this.saticMethodReplace = saticMethodReplace;
    }

    public void startSaving() throws IOException {

        
        myGame.setDeck1(deck1);
        myGame.setPlayerList(playerList);
        myGame.setStartingPlayerIndex(startingPlayerIndex);
        myGame.setTrick(trick);
        myGame.setTempRoundCounter(tempRoundCounter);
        myGame.setCurrentPlayerIndex(currentPlayerIndex);
        myGame.setWinnerPlayer(winnerPlayer);
        myGame.setSaticMethodReplace(saticMethodReplace);

        FileOutputStream fileout = new FileOutputStream("save.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileout);

        out.writeObject(myGame);
        out.close();
        fileout.close();
    }
}
