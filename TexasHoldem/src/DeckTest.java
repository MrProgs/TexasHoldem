import java.util.ArrayList;

public class DeckTest {

	public static void main(String args[]){
		Deck deck = new Deck();
		
		ArrayList<Card> hand = new ArrayList<Card>(2);
		hand.add(deck.drawCard());
		hand.add(deck.drawCard());
		
		for(int i = 0; i < 2; i++){
			System.out.println(hand.get(i).getCard());
		}
		
		deck.shuffleDeck();
		hand.set(0, deck.drawCard());
		hand.set(1, deck.drawCard());
		
		for(int i = 0; i < 2; i++){
			System.out.println(hand.get(i).getCard());
		}
	}
}
