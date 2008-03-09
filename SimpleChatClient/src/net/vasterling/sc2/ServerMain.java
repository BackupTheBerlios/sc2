package net.vasterling.sc2;

import java.net.ServerSocket;
import java.net.Socket;

// Referenced classes of package guiclient:
//            Switcher, ServerCon

public class ServerMain implements Runnable {

	String serverIP;
	int port;

	public ServerMain(int por) {
		port = 22011;
		port = por;
	}

	public void run() {
		Socket s = null;
		int client_count = 0;
		System.out.println("Server l\344uft!");
		try {
			ServerSocket server = new ServerSocket(port);
			Switcher sw = new Switcher();
			sw.init();
			serverIP = String.valueOf(serverIP) + String.valueOf(server.getInetAddress());
			do {
				client_count++;
				s = server.accept();
				System.out.println("Client versucht zu verbinden...");
				System.out.println("Kan\344le \366ffnen....");
				ServerCon doIt = new ServerCon(s, "Client_Thread".concat(String.valueOf(String.valueOf(client_count))), sw);
			} while (true);
		} catch (Exception e) {
			System.out.println("[ThR] ServerMain ".concat(String.valueOf(String.valueOf(e))));
		}
		System.exit(1);
	}

}
