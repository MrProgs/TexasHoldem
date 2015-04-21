import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class GameServer {

	private static ArrayList<MiniGameServer> games = new ArrayList<MiniGameServer>();
	
	public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;

        boolean listeningSocket = true;
        try {
            serverSocket = new ServerSocket(2343);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 2343");
        }

        while(listeningSocket){
            Socket clientSocket = serverSocket.accept();
            searchForGame(clientSocket);
        }
        serverSocket.close();       
    }
	
	private static boolean searchForGame(Socket clientSocket){
		if(games.isEmpty()){
			makeNewGame(clientSocket);
		}
		for(MiniGameServer game : games){
			if(game.isOpen()){
				game.addPlayer(clientSocket);
				return true;
			}
		}
		makeNewGame(clientSocket);
		return true;
	}
	
	private static void makeNewGame(Socket clientSocket){
		MiniGameServer mini = new MiniGameServer(clientSocket);
        mini.start();
	}

}
