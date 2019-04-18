package server;

import java.io.*;
import java.net.*;

public class TCPServer {
	public static void main(String[] args) throws Exception {
		String clientSentence;
		ServerSocket welcomeSocket = new ServerSocket(6789);
		while (true) {
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			clientSentence = inFromClient.readLine();
			if (clientSentence != null) {
				System.out.println("Client says: " + clientSentence);
				BufferedReader client3 = new BufferedReader(new InputStreamReader(System.in));
				String x = client3.readLine();
				outToClient.writeBytes(x+'\n');
				outToClient.flush();
			}

		}
	}

}
