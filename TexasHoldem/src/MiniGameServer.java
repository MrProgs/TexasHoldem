import java.net.Socket;
import java.util.ArrayList;


public class MiniGameServer extends Thread {

	private Socket socket;
	private ArrayList<Player> players; 
	private Table table;
	private boolean isOpen;

    public MiniGameServer(Socket socket) {
        super("MiniGameServer");
        this.socket = socket;
        this.table = new Table();
        this.players = new ArrayList<Player>(4);
        this.isOpen = true;
    }

    public void run(){
            //Read input and process here
    }
    
    public void addPlayer(Socket clientSocket){
    	assert isOpen;
    	players.add(new Player("Player "+players.size(),
    						   1000,
    						   table,
    						   clientSocket));
    }
    
    public void removePlayer(Player p){
    	assert players.size() > 1;
    	players.remove(p);
    }
    
    public boolean isOpen(){
    	return isOpen;
    }
}
