package scc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

public class FensterInfo {
	private org.eclipse.swt.widgets.Shell shell = null; // @jve:decl-index=0:visual-constraint="19,7"
	Text textArea = null;

	JButton button1;
	JTextArea jTextArea1;
	JScrollPane sPannel;
	JButton logoJButton;
	BorderLayout borderLayout1;

	public FensterInfo() {
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

		getShell().setText("Info");
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

		infoText("SCC ist ein auf Java basierender\nServer - Client Chat. ");
		infoText("Dadurch ist ein Einsatz\nauf s\344mtlichen Platformen m\366glich, ");
		infoText("sofern die\nJRE (Java Runtime Enviroment) installiert ist.");
		infoText("\nDiese Applikation beschr\344nkt sich auf's\nNotwendigste ");
		infoText("um m\366glichst kompakt\nund klein zu bleiben.\n");
		infoText("SCC ist Freeware!\n");
		infoText("Die Nutzung der Software\nf\374r den privaten, nicht");
		infoText("komerziellen\nBereich ist gestattet!\n");
		infoText("Die Benutzung dieser Software geschieht\nauf eigene Gefahr!\n");
		infoText("Eine eventuell m\366gliche Haftung des\nAutors dieses Programmes ");
		infoText("f\374r etwaige\ndurch den Gebrauch dieser Software entstandene\n");
		infoText("Sch\344den wird vollkommen ausgeschlossen.\n");
	}

	void cancel() {
		getShell().dispose();
	}

	public void actionPerformed(SelectionEvent e) {
		if (e.getSource() instanceof Button)
			cancel();
	}

	void logoJButton_actionPerformed(ActionEvent actionevent) {
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
