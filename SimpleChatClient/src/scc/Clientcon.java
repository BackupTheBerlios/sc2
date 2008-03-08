package scc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.UIManager;

// Referenced classes of package guiclient:
//            Fenster, Fenster_con

public class Clientcon implements Runnable {

	private Socket socket;
	private static String username;
	private BufferedReader in;
	public static PrintWriter out;
	private FensterChat frame;
	boolean packFrame;
	public int Port;

	public Clientcon(String host, int port, String titel, String uname) throws Exception {
		packFrame = false;
		Port = 22011;
		username = uname;
		socket = new Socket(host, port);
		frame = new FensterChat(this, titel, uname);

		Thread t = new Thread(this);
		t.start();

		org.eclipse.swt.widgets.Display display = org.eclipse.swt.widgets.Display.getDefault();

		while (!frame.getShell().isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	public void run() {
		try {
			UIManager.setLookAndFeel("UIManager.getSystemLookAndFeelClassName()");
		} catch (Exception exception) {
		}

		writeText("Chat Startet......\n\n");

		try {
			out = getAPrintWriter();
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			writeText("Server gefunden\n");

			out.write(String.valueOf(String.valueOf(username)).concat("\n"));
			out.flush();
			do {
				String s;
				while ((s = in.readLine()) == null) {
					Thread.sleep(1000);
				}
				writeText(String.valueOf(String.valueOf(s)).concat("\n"));

			} while (true);
		} catch (Exception e) {
			System.out.println("[ThR1] ClientCon ".concat(String.valueOf(String.valueOf(e))));
		}
	}

	public PrintWriter getAPrintWriter() {
		try {
			return new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void writeText(final String text) {

		Runnable runna = new Runnable() {
			public void run() {
				frame.textAusgabe(text);
			}
		};

		org.eclipse.swt.widgets.Display display = org.eclipse.swt.widgets.Display.getDefault();
		display.asyncExec(runna);

	}

	public static void main(String args[]) {
		new FensterVerbindung();
	}

}
