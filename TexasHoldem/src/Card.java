
public class Card {
	private Suit suit;
	private String value;
	
	public Card(Suit suit, String value){
		this.setSuit(suit);
		this.setValue(value);
	}

	private Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	private String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getCard(){
		return this.getValue() + " of " + this.getSuit();
	}
}
