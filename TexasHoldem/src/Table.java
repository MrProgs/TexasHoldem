import java.util.ArrayList;

/* This class is the main game. It is the interaction between the Dealer, who 
 * has access to the deck and the size of the pot, and the Players.
 * The table holds the pot, the Players, and the Dealer, along with all the
 * cards that have currently been dealt. It also holds the amounts of all the
 * bets the players have made.
 * */
public class Table {
	private Deck deck;
	Dealer dealer;		//Component that runs the game.
	ArrayList<Player> players;
	private int pot;			//total amount of money currently being bet by players
	
	public Table(){
		setDeck(new Deck());
		players = new ArrayList<Player>();
		setPot(0);
	}
	
	public void addToPot(int money){
		this.setPot(this.getPot() + money);
	}
	
	public void joinGame(Player p){
		players.add(p);
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public int getPot() {
		return pot;
	}

	public void setPot(int pot) {
		this.pot = pot;
	}
	
}
