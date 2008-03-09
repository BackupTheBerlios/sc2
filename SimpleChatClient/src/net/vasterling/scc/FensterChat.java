package net.vasterling.scc;

import java.io.PrintWriter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolTip;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;

// Referenced classes of package guiclient:
//            Fenster_Infodialog, Fenster_helpdialog, clientcon

public class FensterChat {

	private org.eclipse.swt.widgets.Shell shell = null; // @jve:decl-index=0:visual-constraint="19,7"
	ToolBar toolBar;
	Button sendenButton;
	Text textToSend;
	Text chatArea;
	private String username = null;
	private Clientcon clientConnection = null;
	private Tray tray = null;
	private TrayItem trayItem = null;

	public FensterChat(Clientcon clientCon, String titel, String uname) {

		setUsername(uname);
		clientConnection = clientCon;

		try {
			shellInit(titel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		initTray();
		getShell().open();

	}

	private void shellInit(String titel) throws Exception {

		getShell().setSize(new org.eclipse.swt.graphics.Point(393, 279));

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

		getShell().setText("Chatfenster");
		getShell().setLayout(gridLayout2);
		gridLayout2.numColumns = 2;
		gridLayout2.makeColumnsEqualWidth = false;

		getShell().setText(titel);

		initToolbar();

		chatArea = new Text(getShell(), SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.BORDER);
		// chatArea.setEditable(false);
		chatArea.setLayoutData(gridDataTextArea);

		sendenButton = new Button(getShell(), SWT.NONE);
		sendenButton.setToolTipText("Hier draufdr\374cken um zu senden!");
		sendenButton.setText("senden...");
		// sendenButton.setHorizontalAlignment(2);
		sendenButton.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				actionPerformed_Senden(e);
			}

			public void widgetSelected(SelectionEvent e) {
				actionPerformed_Senden(e);
			}

		});
		sendenButton.setLayoutData(gridDataSendButton);

		textToSend = new Text(getShell(), SWT.BORDER);

		textToSend.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				actionPerformed_Senden(e);
			}

			public void widgetSelected(SelectionEvent e) {
				actionPerformed_Senden(e);
			}

		});
		textToSend.setLayoutData(gridDataTextEingabe);

		initMenu();

	}

	private void initToolbar() {

		toolBar = new ToolBar(getShell(), SWT.FLAT | SWT.WRAP | SWT.RIGHT);

		ToolItem buttonInfo = new ToolItem(toolBar, SWT.PUSH);
		Image image = new Image(getShell().getDisplay(), FensterChat.class.getResourceAsStream("Info.gif"));
		buttonInfo.setImage(image);

		buttonInfo.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				actionPerformed_Info(e);
			}

			public void widgetSelected(SelectionEvent e) {
				actionPerformed_Info(e);
			}

		});

		ToolItem buttonHilfe = new ToolItem(toolBar, SWT.PUSH);
		image = new Image(getShell().getDisplay(), FensterChat.class.getResourceAsStream("help.gif"));
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

	private void initMenu() {

		Menu menuBar = new Menu(getShell(), SWT.BAR);
		MenuItem fileMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
		fileMenuHeader.setText("&File");

		Menu menuFile = new Menu(getShell(), SWT.DROP_DOWN);
		fileMenuHeader.setMenu(menuFile);

		MenuItem menuItemFileExit = new MenuItem(menuFile, SWT.PUSH);
		menuItemFileExit.setText("Beenden");

		menuItemFileExit.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				actionPerformed_Exit(e);
			}

			public void widgetSelected(SelectionEvent e) {
				actionPerformed_Exit(e);
			}
		});

		MenuItem infoMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
		infoMenuHeader.setText("&Hilfe");

		Menu menuHelp = new Menu(getShell(), SWT.DROP_DOWN);
		infoMenuHeader.setMenu(menuHelp);

		MenuItem menuItemHelpHelp = new MenuItem(menuHelp, SWT.PUSH);
		menuItemHelpHelp.setText("Hilfe");
		menuItemHelpHelp.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				actionPerformed_Help(e);
			}

			public void widgetSelected(SelectionEvent e) {
				actionPerformed_Help(e);
			}
		});

		MenuItem menuItemHelpAbout = new MenuItem(menuHelp, SWT.PUSH);
		menuItemHelpAbout.setText("Info");
		menuItemHelpAbout.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				actionPerformed_Info(e);
			}

			public void widgetSelected(SelectionEvent e) {
				actionPerformed_Info(e);
			}

		});

		getShell().setMenuBar(menuBar);
	}

	public void actionPerformed_Exit(SelectionEvent e) {
		Clientcon.out.write("--$&3&]eea]Q@\n");
		Clientcon.out.flush();
		System.exit(0);
	}

	public void actionPerformed_Help(SelectionEvent e) {
		new FensterInfo();
	}

	void actionPerformed_Info(SelectionEvent e) {
		new FensterHilfe();
	}

	public void textAusgabe(String s) {
		// chatArea.setCaretPosition(chatArea.getDocument().getLength());
		chatArea.append(s);

		// ToolTip tip = new ToolTip(sShell, SWT.BALLOON | SWT.ICON_INFORMATION);
		// tip.setMessage("Balloon Message Goes Here!");
		// tip.setText("Balloon Title goes here.");
		// tip.setLocation(100,100);

		makeTooltip(s);

		// getTrayItem().getToolTip().setVisible(true);

		// getTrayItem().setToolTip(tip);
		// tip.setVisible(true);

	}

	void actionPerformed_Senden(SelectionEvent e) {
		String tf_text = textToSend.getText();
		PrintWriter aPrintWriter = clientConnection.getAPrintWriter();
		aPrintWriter.write(String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(getUsername())))).append(" ").append(tf_text).append(
				"\n"))));
		aPrintWriter.flush();
		textAusgabe(String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(getUsername())))).append(" ").append(tf_text).append("\n"))));
		textToSend.setText("");
	}

	private void setUsername(String username) {
		this.username = username;
	}

	private String getUsername() {
		return username;
	}

	private void initTray() {

		Image image = new Image(getShell().getDisplay(), FensterChat.class.getResourceAsStream("Info.gif"));
		tray = getShell().getDisplay().getSystemTray();
		if (tray != null) {
			trayItem = new TrayItem(tray, SWT.NONE);
			trayItem.setImage(image);

			final Menu menu = new Menu(getShell(), SWT.POP_UP);
			MenuItem menuItem = new MenuItem(menu, SWT.PUSH);
			menuItem.setText("Button A");

			trayItem.addListener(SWT.MenuDetect, new Listener() {
				public void handleEvent(Event event) {
					menu.setVisible(true);
				}
			});

			menuItem.addSelectionListener(new SelectionListener() {

				public void widgetDefaultSelected(SelectionEvent e) {
					getShell().forceActive();
					System.out.println("TEST1");

				}

				public void widgetSelected(SelectionEvent e) {
					getShell().forceActive();
					System.out.println("TEST2");

				}
			});

		}
	}

	private Tray getTray() {
		if (tray == null) {
			initTray();
		}
		return tray;
	}

	private TrayItem getTrayItem() {
		if (trayItem == null) {
			initTray();
		}
		return trayItem;
	}

	private void makeTooltip(String s) {

		Shell shell = getShell();
		
		final ToolTip tip = new ToolTip(shell, SWT.BALLOON | SWT.ICON_INFORMATION);
		
		tip.setMessage(s);

		getTrayItem().setToolTip(tip);
		
		tip.setVisible(true);
		
	}

	public org.eclipse.swt.widgets.Shell getShell() {
		if (shell == null) {
			shell = new org.eclipse.swt.widgets.Shell();
		}
		return shell;
	}

}
