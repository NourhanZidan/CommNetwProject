package client;

import java.io.*;
import java.net.*;

public class TCPClient {

	public static void main(String argv[]) throws Exception {
		String sentence;
		String modifiedSentence;

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		sentence = inFromUser.readLine();
		if (sentence.equals("CONNECT")) {
			System.out.println("Connection established");
			System.out.println("Enter the message");
			while (true) {
				Socket clientSocket = new Socket("127.0.0.1", 6789);
				inFromUser = new BufferedReader(new InputStreamReader(System.in));
				DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
				BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

				sentence = inFromUser.readLine();
				if (sentence.equals("close")) {
					System.out.println("Connection terminated");
					clientSocket.close();
					return;
				} else {

					outToServer.writeBytes(sentence + '\n');
					outToServer.flush();

					modifiedSentence = inFromServer.readLine();

					System.out.println("Server says: " + modifiedSentence);
				}

			}
		}

	}
}
