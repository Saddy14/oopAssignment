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
        System.out.println("leadingP1Card: "+leadingP1Card);
        System.out.println("Size: "+leadingP1Card.size());
        // 
        ArrayList<String> leadingP2Card = player2.setLeadPlayerCard(Player.getSuitForPlayer(), Player.getRankP2());
        System.out.println("leadingP2Card: "+leadingP2Card);
        System.out.println("Size: "+leadingP2Card.size());
        // 
        ArrayList<String> leadingP3Card = player3.setLeadPlayerCard(Player.getSuitForPlayer(), Player.getRankP3());
        System.out.println("leadingP3Card: "+leadingP3Card);
        System.out.println("Size: "+leadingP3Card.size());
        // 
        ArrayList<String> leadingP4Card = player4.setLeadPlayerCard(Player.getSuitForPlayer(), Player.getRankP4());
        System.out.println("leadingP4Card: "+leadingP4Card);
        System.out.println("Size: "+leadingP4Card.size());
        System.out.println();

        // Dealing Card to Player 1
        player1.dealCard(deck1.getDeck());
        System.out.println("Player1: "+player1.playerCard);
        System.out.println("Size: "+ player1.playerCard.size());
        System.out.println();
    
        deck1.setDeck(deck1.removeFromDeck(player1.playerCard));
        System.out.println("Deck: \n"+deck1.getDeck()+"\nSize: "+deck1.getDeckSize()+"\n");
        
        // Dealing Card to Player 2
        player2.dealCard(deck1.getDeck());
        System.out.println("Player2: "+player2.playerCard);
        System.out.println("Size: "+ player2.playerCard.size());
        System.out.println();
    
        deck1.setDeck(deck1.removeFromDeck(player2.playerCard));
        System.out.println("Deck: \n"+deck1.getDeck()+"\nSize: "+deck1.getDeckSize()+"\n");
    
        // Dealing Card to Player 3
        player3.dealCard(deck1.getDeck());
        System.out.println("Player3: "+player3.playerCard);
        System.out.println("Size: "+ player3.playerCard.size());
        System.out.println();
    
        deck1.setDeck(deck1.removeFromDeck(player3.playerCard));
        System.out.println("Deck: \n"+deck1.getDeck()+"\nSize: "+deck1.getDeckSize()+"\n");

        // Dealing Card to Player 4
        player4.dealCard(deck1.getDeck());
        System.out.println("Player4: "+player4.playerCard);
        System.out.println("Size: "+ player4.playerCard.size());
        System.out.println();
    
        deck1.setDeck(deck1.removeFromDeck(player4.playerCard));
        System.out.println("Deck: \n"+deck1.getDeck()+"\nSize: "+deck1.getDeckSize()+"\n");

    
   }
}
