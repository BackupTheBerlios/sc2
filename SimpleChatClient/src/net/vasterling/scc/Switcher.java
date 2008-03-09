package net.vasterling.scc;

class Switcher {

	private int zahl;
	private int MAX_HISTORY;
	public long his_index;
	private String history[][];

	Switcher() {
		zahl = 1;
		MAX_HISTORY = 20;
		his_index = 0L;
		history = new String[MAX_HISTORY + 1][3];
	}

	public void test_meth() {
		System.out.println("Client Nummer: ".concat(String.valueOf(String.valueOf(zahl))));
		zahl = zahl + 1;
	}

	public String[][] chat_history(String s) {
		int i = 1;
		his_index = his_index + 1;
		for (i = 1; i < MAX_HISTORY; i++) {
			history[i][1] = history[i + 1][1];
			history[i][2] = history[i + 1][2];
		}

		history[MAX_HISTORY - 1][1] = s;
		history[MAX_HISTORY - 1][2] = Long.toString(his_index);
		return history;
	}

	public String[][] get_history() {
		return history;
	}

	public void init() {
		for (int i = 1; i < MAX_HISTORY; i++) {
			history[i][1] = "nix";
			history[i][2] = "0";
		}

	}
}
