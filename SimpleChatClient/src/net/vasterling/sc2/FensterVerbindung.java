package net.vasterling.sc2;

import net.vasterling.sc2.util.Resources;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

// Referenced classes of package guiclient:
//            ServerMain, clientcon, Fenster_helpdialog

public class FensterVerbindung {

	private org.eclipse.swt.widgets.Shell shell = null; // @jve:decl-index=0:visual-constraint="19,7"

	Button buttonStart;
	Text textPort;
	Text textHostname;
	Text textUser;
	Label labelPort;
	Label labelHostname;
	Label labelUser;
	Label labelHead;
	Button buttonExit;
	Label labelServer;
	GridLayout gridLayout1;
	GridLayout gridLayout2;
	Button checkBoxServer;

	public FensterVerbindung() {

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
		// sShell.close();

		// display.dispose();

	}

	private void shellInit() throws Exception {

		getShell().setSize(new org.eclipse.swt.graphics.Point(300, 200));

		org.eclipse.swt.layout.GridLayout gridLayout = new GridLayout();
		org.eclipse.swt.layout.GridData gridDataHead = new org.eclipse.swt.layout.GridData();
		gridDataHead.horizontalAlignment = GridData.CENTER;
		org.eclipse.swt.layout.GridData gridDataLabels = new org.eclipse.swt.layout.GridData();
		gridDataLabels.widthHint = 100;

		org.eclipse.swt.layout.GridData gridDataTextFelder = new org.eclipse.swt.layout.GridData();
		gridDataTextFelder.widthHint = 150;
		gridDataTextFelder.grabExcessHorizontalSpace = true;

		org.eclipse.swt.layout.GridData gridDataButtons = new org.eclipse.swt.layout.GridData();
		gridDataButtons.widthHint = 80;

		getShell().setText("Verbindungseinstellungen");
		getShell().setLayout(gridLayout);
		gridLayout.numColumns = 2;
		gridLayout.makeColumnsEqualWidth = false;

		initToolbar();

		labelHead = new org.eclipse.swt.widgets.Label(getShell(), SWT.NONE);
		labelHead.setText("Willkommen bei SC\u00B2");

		org.eclipse.swt.widgets.Display display = org.eclipse.swt.widgets.Display.getDefault();

		FontData fontData = new FontData("dialog", 14, SWT.BOLD);
		labelHead.setFont(new Font(display, fontData));
		gridDataHead.grabExcessHorizontalSpace = true;
		gridDataHead.horizontalSpan = 2;
		labelHead.setLayoutData(gridDataHead);

		labelServer = new Label(getShell(), SWT.NONE);
		labelServer.setText("Server: ");
		labelServer.setLayoutData(gridDataLabels);

		checkBoxServer = new Button(getShell(), SWT.CHECK);
		checkBoxServer.setToolTipText("Aktivieren, wenn dieser Rechner Server sein soll.");
		checkBoxServer.setText("Dieser Rechner ist Server");
		checkBoxServer.setLayoutData(gridDataTextFelder);
		checkBoxServer.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				serverJCB_actionPerformed(e);
			}

			public void widgetSelected(SelectionEvent e) {
				serverJCB_actionPerformed(e);
			}

		});

		labelUser = new org.eclipse.swt.widgets.Label(getShell(), SWT.NONE);
		labelUser.setText("Benutzername: ");
		labelUser.setLayoutData(gridDataLabels);

		textUser = new Text(getShell(), SWT.BORDER);
		textUser.setText("Noname");
		textUser.setLayoutData(gridDataTextFelder);

		labelHostname = new org.eclipse.swt.widgets.Label(getShell(), SWT.NONE);
		labelHostname.setText("Host name/IP:  ");
		labelHostname.setLayoutData(gridDataLabels);

		textHostname = new Text(getShell(), SWT.BORDER);
		textHostname.setToolTipText("");
		textHostname.setText("192.168.0.1");
		textHostname.setLayoutData(gridDataTextFelder);

		labelPort = new org.eclipse.swt.widgets.Label(getShell(), SWT.NONE);
		labelPort.setText("Serverport: ");
		labelPort.setLayoutData(gridDataLabels);

		textPort = new Text(getShell(), SWT.BORDER);
		textPort.setText("22011");
		textPort.setLayoutData(gridDataTextFelder);

		buttonStart = new Button(getShell(), SWT.NONE);
		buttonStart.setText("Start Chat");
		buttonStart.setLayoutData(gridDataButtons);
		buttonStart.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				actionPerformed_Start(e);
			}

			public void widgetSelected(SelectionEvent e) {
				actionPerformed_Start(e);
			}

		});

		buttonExit = new Button(getShell(), SWT.NONE);
		buttonExit.setText("exit");
		buttonExit.setLayoutData(gridDataButtons);
		buttonExit.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				actionPerformed_Exit(e);
			}

			public void widgetSelected(SelectionEvent e) {
				actionPerformed_Exit(e);
			}
		});
	}

	private void initToolbar() {

		ToolBar toolBar = new ToolBar(getShell(), SWT.FLAT | SWT.WRAP | SWT.RIGHT);

		ToolItem buttonInfo = new ToolItem(toolBar, SWT.PUSH);
		Image image = Resources.getImage(getShell().getDisplay(), "Info.gif");
		buttonInfo.setImage(image);

		buttonInfo.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				actionPerformed_info(e);
			}

			public void widgetSelected(SelectionEvent e) {
				actionPerformed_info(e);
			}
		});

		ToolItem buttonHilfe = new ToolItem(toolBar, SWT.PUSH);
		image = Resources.getImage(getShell().getDisplay(), "help.gif");
		buttonHilfe.setImage(image);

		buttonHilfe.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				actionPerformed_Help(e);
			}

			public void widgetSelected(SelectionEvent e) {
				actionPerformed_Help(e);
			}

		});
		buttonHilfe.setToolTipText("Hilfe");

	}

	public void actionPerformed_info(SelectionEvent e) {
		new FensterInfo();
	}

	void actionPerformed_Help(SelectionEvent e) {
		new FensterHilfe();
	}

	void actionPerformed_Start(SelectionEvent e) {

		String titel = "";
		String username = textUser.getText();
		String host = textHostname.getText();
		int port = Integer.parseInt(textPort.getText());
		if (checkBoxServer.getSelection()) {

			try {
				ServerMain server1 = new ServerMain(port);
				host = "127.0.0.1";
				Thread st = new Thread(server1);
				st.start();
				titel = "aChat.Server - ".concat(String.valueOf(String.valueOf(username)));
			} catch (Exception x) {
				System.out.println("[ThR] Fenster_con: ".concat(String.valueOf(String.valueOf(e))));
			}
		} else {
			titel = "aChat.Client - ".concat(String.valueOf(String.valueOf(username)));
		}
		try {
			username = String.valueOf(String.valueOf((new StringBuffer("[")).append(username).append("]")));
			getShell().dispose();
			new Clientcon(host, port, titel, username);

		} catch (Exception x) {
			// show();
			System.out.println("[ThR2] FensterCon ".concat(String.valueOf(String.valueOf(x))));
		}
	}

	void actionPerformed_Exit(SelectionEvent e) {
		System.exit(0);
	}

	void serverJCB_actionPerformed(SelectionEvent e) {
		if (checkBoxServer.getSelection()) {
			textHostname.setEditable(false);
			textHostname.setText("127.0.0.1");
		} else {
			textHostname.setEditable(true);
			textHostname.setText("192.168.0.1");
		}
	}

	public org.eclipse.swt.widgets.Shell getShell() {
		if (shell == null) {
			shell = new org.eclipse.swt.widgets.Shell();
		}
		return shell;
	}

}
