package scc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

// Referenced classes of package guiclient:
//            Switcher

public class ServerCon implements Runnable {

	private Socket socket;
	private Switcher austausch;
	private BufferedReader in;
	private PrintWriter out;
	private Thread t;
	private String s;
	private String username;
	private long eigener_index;
	private int MAX_HISTORY;
	private String history[][];
	private String vergleich[][];

	public ServerCon(Socket s, String name, Switcher sw) {
		this.s = "";
		eigener_index = 0L;
		MAX_HISTORY = 20;
		history = new String[MAX_HISTORY + 1][3];
		vergleich = new String[MAX_HISTORY + 1][3];
		socket = s;
		austausch = sw;
		t = new Thread(this, name);
		t.start();
	}

	public void run() {
		austausch.test_meth();
		init();
		try {
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			username = in.readLine();
			s = String.valueOf(String.valueOf(username)).concat(" hat den Chat betreten");
			zeile_empf(0);
			s = "";
			out.write(String.valueOf(String.valueOf((new StringBuffer("Willkommen beim Server (")).append(socket.getInetAddress()).append(")\n"))));
			out.flush();
			socket.setSoTimeout(50);
			do {
				try {
					if ((s = in.readLine()) != null)
						if (s.equals("--$&3&]eea]Q@")) {
							s = "Ein Benutzer hat den Chat verlassen!";
							zeile_empf(0);
							socket.close();
							stop();
						} else {
							zeile_empf(0);
						}
				} catch (Exception exception) {
				}
				zeile_empf(1);
			} while (true);
		} catch (Exception e) {
			System.out.println("[ThR1] ServerCon ".concat(String.valueOf(String.valueOf(e))));
		}
	}

	public void stop() {
		if (t != null) {
			t.stop();
			t = null;
		}
	}

	public void zeile_empf(int stufe) {
		long his_index = austausch.his_index;
		if (stufe != 1) {
			history = austausch.chat_history(s);
			eigener_index = Long.parseLong(history[MAX_HISTORY - 1][2]);
		}
		if (stufe == 1 && eigener_index < his_index) {
			history = austausch.get_history();
			for (int i = 1; i < MAX_HISTORY; i++)
				if (eigener_index < Long.parseLong(history[i][2])) {
					out.write(String.valueOf(String.valueOf(history[i][1])).concat("\n"));
					out.flush();
					eigener_index = his_index;
				}

		}
	}

	private void init() {
		for (int i = 1; i < MAX_HISTORY; i++) {
			vergleich[i][1] = "";
			vergleich[i][2] = "0";
			history[i][1] = "";
			history[i][2] = "0";
		}

	}

}
