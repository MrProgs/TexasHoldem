/* The dealer is the only person who can interact with the Deck that is on the
 * the table. The Dealer is the only one who can deal cards, is the only one 
 * who can take bets and handles the pot.*/

public class Dealer{
	private Deck deck;
	Table table;	//table Dealer is playing at.
	int pot;
	
	public Dealer(){
		table = new Table();
		deck = table.getDeck();
		pot = table.getPot();
	}
	
	//This will be moved to the dealer class.
	public void dealHands(){
		table.players.stream().forEach((Player) -> {
			Player.hitMe();
			Player.hitMe();
		});
	}
	
	public Card dealCard(){
		Card cd = deck.drawCard();
		return cd;
	}
}
