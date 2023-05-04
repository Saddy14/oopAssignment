import java.util.ArrayList;

public class Main {
   public static void main(String[] args) {
      
        Deck deck1 = new Deck();
        deck1.generateDeck();
        deck1.makeDeckRandom();
        deck1.getDeck();

        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        
        ArrayList<String> leadingP1Card = player1.setLeadPlayerCard(Player.getSuitForPlayer(), Player.getRankP1());
        ArrayList<String> leadingP2Card = player2.setLeadPlayerCard(Player.getSuitForPlayer(), Player.getRankP2());
        ArrayList<String> leadingP3Card = player3.setLeadPlayerCard(Player.getSuitForPlayer(), Player.getRankP3());
        ArrayList<String> leadingP4Card = player4.setLeadPlayerCard(Player.getSuitForPlayer(), Player.getRankP4());

        ArrayList<String> center = new ArrayList<>();

        center.add(deck1.getDeck().get(0));
        deck1.setDeck(deck1.removeFromDeck(center));

        int trick = 1;
        System.out.println("Trick#"+trick);

        // Dealing Card to Player 1
        player1.dealCard(deck1.getDeck());
        System.out.println("Player1: "+player1.playerCard);
        System.out.println("Size: "+ player1.playerCard.size());
        System.out.println();
    
        deck1.setDeck(deck1.removeFromDeck(player1.playerCard));
      //   System.out.println("Deck: \n"+deck1.getDeck()+"\nSize: "+deck1.getDeckSize()+"\n");
        
        // Dealing Card to Player 2
        player2.dealCard(deck1.getDeck());
        System.out.println("Player2: "+player2.playerCard);
        System.out.println("Size: "+ player2.playerCard.size());
        System.out.println();
    
        deck1.setDeck(deck1.removeFromDeck(player2.playerCard));
      //   System.out.println("Deck: \n"+deck1.getDeck()+"\nSize: "+deck1.getDeckSize()+"\n");
    
        // Dealing Card to Player 3
        player3.dealCard(deck1.getDeck());
        System.out.println("Player3: "+player3.playerCard);
        System.out.println("Size: "+ player3.playerCard.size());
        System.out.println();
    
        deck1.setDeck(deck1.removeFromDeck(player3.playerCard));
      //   System.out.println("Deck: \n"+deck1.getDeck()+"\nSize: "+deck1.getDeckSize()+"\n");

        // Dealing Card to Player 4
        player4.dealCard(deck1.getDeck());
        System.out.println("Player4: "+player4.playerCard);
        System.out.println("Size: "+ player4.playerCard.size());
        System.out.println();
    
        deck1.setDeck(deck1.removeFromDeck(player4.playerCard));
        
        System.out.println("Center : "+center+ "\nSize: " + center.size() + "\n");

        System.out.println("Deck   : "+deck1.getDeck()+"\nSize: "+deck1.getDeckSize()+"\n");

        System.out.println("Score  : "+"Player1 = "+player1.getScore()+" | Player2 = "+player2.getScore()+" | Player3 = "+player3.getScore()
                           +" | Player4 = "+player4.getScore());


    
   }
}
