import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class SaveLoad implements Serializable {

    ArrayList<Player> playerList;
    ArrayList<String> deck = new ArrayList<>();
    ArrayList<String> center = new ArrayList<>();
    ArrayList<Integer> score = new ArrayList<>();
    ArrayList<String> turn = new ArrayList<>();
    int deckSize;
    int centerSize;
    Deck deck1;  
    Game game;  

    void SaveLoad1(ArrayList<Player> p) {
        this.playerList = p;  
    }

    void SaveLoad2(ArrayList<String> d, int d2){
        this.deck = d;
        this.deckSize = d2;
    }

    void SaveLoad3 (ArrayList<String> c, int c2){
        this.center = c;
        this.centerSize = c2;
    }

    void SaveLoad4(ArrayList<Integer> s) {
        this.score = s;
    }

    void SaveLoad5(ArrayList<String> t) {
        this.turn = t;
    }

    void saveFile() {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();

        list3.add(turn.toString());

        int lastDeck = deck.size() - 1;
        int lastCenter = center.size() - 1;
        int lastTurn = list3.size() - 1;
   
        //changing ArrayList<Player> into ArrayList<String>
        for (int i = 0; i < playerList.size(); i++) {
            list.add(playerList.get(i).getPlayerCard().toString());
            list2.add(playerList.get(i).getScore());
        }

        try {
            FileOutputStream fileOut = new FileOutputStream("SaveLoad.txt");
            ObjectOutputStream output = new ObjectOutputStream(fileOut); 

            //Saving every player's current deck

            for (int k=0; k < list.size(); k++) {
                output.writeObject(list.get(k) + "\n");  
            }
                    
            //Saving the curent Deck and number of cards in the Deck
            
            output.writeObject(deck.get(lastDeck) + "\n");            
            output.writeObject(deckSize + "\n");

            //Saving the current card and number of cards at the center
            output.writeObject(center.get(lastCenter) + "\n");
            output.writeObject(centerSize + "\n");

            
            //Saving the current player's score
            for (int l = 0; l < list2.size(); l++){
                output.writeObject(list2.get(l)+ "\n");
            }


            //Saving who's turn it is
            
            output.writeObject(list3.get(lastTurn) + "\n");
            

            output.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something not right");
        }
    }

        
     

    
    public void LoadFile(){
        try{
            FileInputStream fileIn = new FileInputStream("SaveLoad.txt");
            ObjectInputStream input = new ObjectInputStream(fileIn);
            

            input.close();
            fileIn.close();     
        } catch (IOException e) {
                e.printStackTrace(); // Handle the exception appropriately
                System.out.println("Something went wrong while loading the file.");
        }             
    }

}
