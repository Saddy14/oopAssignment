import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class LoadGame implements Serializable {

   

    public void startLoading() throws IOException, ClassNotFoundException {

        Game myGame = null;
        FileInputStream fileIn = new FileInputStream("save.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        myGame = (Game) in.readObject();
        in.close();
        fileIn.close();

        myGame.setDeck1(myGame.getDeck1());
        myGame.setPlayerList(myGame.getPlayerList());
        myGame.setStartingPlayerIndex(myGame.getStartingPlayerIndex());
        myGame.setTrick(myGame.getTrick());
        myGame.setTempRoundCounter(myGame.getTempRoundCounter());
        myGame.setCurrentPlayerIndex(myGame.getCurrentPlayerIndex());
        myGame.setWinnerPlayer(myGame.getWinnerPlayer());
        myGame.setSaticMethodReplace(myGame.getSaticMethodReplace());
        myGame.startGame();

    }
}
