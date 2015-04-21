import java.net.Socket;
import java.util.ArrayList;

//may make Player extend Thread.
public class Player {

	ArrayList<Card> hand;
	int handTotal;
	String name;
	int money;
	int bet;
	Table table;
	Dealer dealer;
	Socket clientSocket;
	
	public Player(String name, int money, Table tb, Socket clientSocket){
		this.name = name;
		this.money = money;
		this.handTotal = 0;
		this.hand = new ArrayList<Card>();
		this.clientSocket = clientSocket;
	}
	
	public Card hitMe(){
		Card cd = dealer.dealCard();
		hand.add(cd);
		return cd;
	}
	
	public int placeBet(int amount){
		if(amount > money)
			System.out.println("You don't have the necessary funds. Bet again.");
		money -= amount;
		bet = amount;
		return money;
	}
}
