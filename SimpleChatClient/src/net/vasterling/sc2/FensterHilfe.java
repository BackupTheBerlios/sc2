package net.vasterling.sc2;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

public class FensterHilfe

{
	private org.eclipse.swt.widgets.Shell shell = null; // @jve:decl-index=0:visual-constraint="19,7"
	Text textArea = null;

	public FensterHilfe() {

		org.eclipse.swt.widgets.Display display = org.eclipse.swt.widgets.Display.getDefault();

		try {
			shellInit();
			// aufbauInit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		getShell().open();

		while (!getShell().isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

	}

	private void shellInit() throws Exception {

		getShell().setSize(new org.eclipse.swt.graphics.Point(550, 300));

		org.eclipse.swt.layout.GridLayout gridLayout2 = new GridLayout();
		org.eclipse.swt.layout.GridData gridDataTextArea = new org.eclipse.swt.layout.GridData();
		gridDataTextArea.horizontalSpan = 2;
		gridDataTextArea.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridDataTextArea.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridDataTextArea.grabExcessHorizontalSpace = true;
		gridDataTextArea.grabExcessVerticalSpace = true;

		org.eclipse.swt.layout.GridData gridDataSendButton = new org.eclipse.swt.layout.GridData();
		gridDataSendButton.widthHint = 70;
		org.eclipse.swt.layout.GridData gridDataTextEingabe = new org.eclipse.swt.layout.GridData();
		gridDataTextEingabe.widthHint = 200;
		gridDataTextEingabe.grabExcessHorizontalSpace = true;
		gridDataTextEingabe.horizontalAlignment = GridData.FILL;

		getShell().setText("Hilfe");
		getShell().setLayout(gridLayout2);
		gridLayout2.numColumns = 2;
		gridLayout2.makeColumnsEqualWidth = false;

		getTextArea().setEditable(false);
		getTextArea().setLayoutData(gridDataTextArea);

		Button buttonOK = new Button(getShell(), SWT.NONE);
		buttonOK.setText("OK");
		buttonOK.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				actionPerformed(e);
			}

			public void widgetSelected(SelectionEvent e) {
				actionPerformed(e);
			}

		});
		buttonOK.setLayoutData(gridDataSendButton);

		infoText("Das Fenster Vorabeinstellungen\n");
		infoText("\taChat ist eine Server - Client Applikation f\374r dessen\n");
		infoText("\tBetrieb ein Server erforderlich ist. Durch markieren des\n");
		infoText("\tKontrollk\344stchens \"Server\" gilt dieser Rechner\n");
		infoText("\tals Chatserver.\n");
		infoText("\tEs ist notwendig, dass der erste Chatteilnehmer 'Server' ist!\n\n");
		infoText("\tIm Feld Benutzername kann man seinen 'Nickname' eigeben,\n");
		infoText("\tmit dem man in aChat pr\344sent ist.\n\n");
		infoText("\tIst man selber nicht Server, so ist die Eingabe des Hostnamen\n");
		infoText("\toder der IP des Servers notwendig, um eine Verbindung\n");
		infoText("\tmit ihm aufzubauen.\n\n");
		infoText("\tIm Feld \"Serverport\" wird angegeben auf welchem Prot der\n");
		infoText("\taChat Server l\344uft. Die Standardeinstellung ist hier 22011\n");
		infoText("\tIm Problemfall kann diese auf Server- & Clientseite gleicher-\n");
		infoText("\tma\337en auf einen Wert >1024 und <32k gesetzt werden.\n\n\n");
		infoText("Das Chat Fenster\n");
		infoText("\tNachdem Server & Client verbunden sind kann der Chat\n");
		infoText("\tbereits beginnen. Zu sendender Text wird in das Textfeld\n");
		infoText("\tim unteren Bereich des Fensters eingegeben und mit \n");
		infoText("\tder [Enter] Taste bzw. einem Mausklick auf \"senden...\" best\344tigt.\n\n");
		infoText("\tWeiterhin verf\374gt das Chatfenster \374ber ein Info Fenster und\n");
		infoText("\tdieses Hilfe Fenster. Diese k\366nnen entweder \374ber den Men\374punkt\n");
		infoText("\t\"Hilfe\" oder die Icons in der Toolbar aufgerufen werden.\n\n\n");
		infoText("M\366gliche Probleme:\n");
		infoText("\tSollten mit aChat Probleme auftreten, so empfehle ich die\n");
		infoText("\tApplikation nicht per Doppelklick sondern in der Systemshell\n");
		infoText("\tmit \"java -jar aChat.jar\" zu starten. M\366gliche Fehler werden dann\n");
		infoText("\tin der Shell ausgegeben.\n\n");
		infoText("\tIn seltenen f\344llen kann ein Client, der gleichzeitig Server ist\n");
		infoText("\tkeine Verbindung aufbauen. Das Fenster Vorabeinstellungen\n");
		infoText("\terscheint daraufhin f\374r einen neuen Versuch. Hier hilft im\n");
		infoText("\tRegelfall ein Neustart des Programmes. Eine L\366sung f\374r das\n");
		infoText("\tbis weilen nur bei Linux auftretende Verbindugsproblem\n");
		infoText("\tversuche ich noch zu finden.\n");
	}

	void cancel() {
		getShell().dispose();
	}

	public void actionPerformed(SelectionEvent e) {
		if (e.getSource() instanceof Button)
			cancel();
	}

	private void infoText(String s) {
		getTextArea().append(s);
	}

	private Text getTextArea() {
		if (textArea == null) {
			textArea = new Text(getShell(), SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.BORDER);
		}

		return textArea;
	}

	public org.eclipse.swt.widgets.Shell getShell() {
		if (shell == null) {
			shell = new org.eclipse.swt.widgets.Shell();
		}
		return shell;
	}

}
