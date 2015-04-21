import java.util.Random;
import java.util.Stack;

/* This class functions as the Deck for a game of Blackjack. Only the Dealer has
 * access to the deck. Players get cards from the Deck through the Dealer.
 * */
public class Deck {
	private int numCards;
	protected Stack<Card> deck;
	protected Stack<Card> discardPile;
	
	public Deck(){
		deck = new Stack<Card>();
		discardPile = new Stack<Card>();
		setNumCards(52);
		stackDeck();
		shuffleDeck();
	}
	
	private void stackDeck(){
		Suit currentSuit = Suit.DIAMONDS;
		String val;
		for(int i = 0; i < 4; i++){
			switch(i){
			case 0:
				currentSuit = Suit.DIAMONDS;
				break;
			case 1:
				currentSuit = Suit.HEARTS;
				break;
			case 2:
				currentSuit = Suit.CLUBS;
				break;
			case 3:
				currentSuit = Suit.SPADES;
				break;
			}
			for(int j = 1; j < 14; j++){
				switch (j){
				case 1:
					val = "Ace";
					break;
				case 11:
					val = "Jack";
					break;
				case 12:
					val = "Queen";
					break;
				case 13:
					val = "King";
					break;
				default:
					val = Integer.toString(j);
				}
				assert (deck != null);
				deck.push(new Card(currentSuit, val));
			}
		}
	}
	
	public void shuffleDeck(){
		Random rndr = new Random();
		for(int i = deck.size() - 1; i > 0; i--){
			int index = rndr.nextInt(i+1);
			//Simple swap
			Card cd = deck.get(index);
			deck.set(index, deck.get(i));
			deck.set(i, cd);
		}
	}
	
	public void reshuffle(){
		while(!discardPile.isEmpty()){
			deck.push(discardPile.pop());
		}
	}

	public int getNumCards() {
		return numCards;
	}

	public void setNumCards(int numCards) {
		this.numCards = numCards;
	}
	
	public Card drawCard(){
		Card cd = deck.pop();
		discardPile.push(cd);
		return cd;
	}
	
}
