package ucn.dmf83.sem1project.group4.GUILayer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import ucn.dmf83.sem1project.group4.ControlLayer.SingleUserControl;
import ucn.dmf83.sem1project.group4.ControlLayer.SystemUserControl;

public class LoginScreen {
	
	private SystemUserControl SUcontrol;
	
	
	protected Shell shell;
	private Text txtUName;
	private Text txtPassword;
	private Label labelFinal;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		try {
			LoginScreen window = new LoginScreen();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		SUcontrol = new SystemUserControl();
		Display display = Display.getDefault();
		createContents();
		shell.open();
	    int x = display.getPrimaryMonitor().getBounds().x + (display.getPrimaryMonitor().getBounds().width - shell.getBounds().width) / 2;
	    int y = display.getPrimaryMonitor().getBounds().y + (display.getPrimaryMonitor().getBounds().height - shell.getBounds().height) / 2;
	    
	    shell.setLocation(x, y);
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setMinimumSize(new Point(800, 600));
		shell.setSize(800, 600);

		shell.setText("iCatalog - Log In");
		
		txtUName = new Text(shell, SWT.BORDER);
		txtUName.setBounds(329, 165, 200, 21);
		
		txtPassword = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		txtPassword.setBounds(329, 192, 200, 21);
		
		Label lblUsername = new Label(shell, SWT.NONE);
		lblUsername.setBounds(232, 168, 55, 15);
		lblUsername.setText("Username:");
		
		Label lblPassword = new Label(shell, SWT.NONE);
		lblPassword.setBounds(232, 195, 55, 15);
		lblPassword.setText("Password:");
		
		labelFinal = new Label(shell, SWT.NONE);
		labelFinal.setBounds(329, 122, 200, 15);
		
		Button btnLogin = new Button(shell, SWT.NONE);
		btnLogin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				authUser();
			}
		});
		btnLogin.setBounds(232, 239, 91, 50);
		btnLogin.setText("Log in");
		
		Button btnSupport = new Button(shell, SWT.NONE);
		btnSupport.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String uname = txtUName.getText();
				String password = txtPassword.getText();
				
				SUcontrol.addSystemUser(uname, password);
			}
		});
		btnSupport.setBounds(329, 239, 200, 50);
		btnSupport.setText("Register user with data above");
		
		final Button btnElevatedRights = new Button(shell, SWT.CHECK);
		btnElevatedRights.setBounds(560, 239, 93, 16);
		btnElevatedRights.setText("Elevated rights");
		
		final Button btnAdminMode = new Button(shell, SWT.CHECK);
		btnAdminMode.setBounds(560, 261, 93, 16);
		btnAdminMode.setText("Admin Mode");
		
		btnElevatedRights.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				SUcontrol.updateSystemUserRights(btnElevatedRights.getSelection(), btnAdminMode.getSelection());
				SingleUserControl.getInstance().setUser(SUcontrol.getSystemUser());
			}
		});

		btnAdminMode.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				SUcontrol.updateSystemUserRights(btnElevatedRights.getSelection(), btnAdminMode.getSelection());
				SingleUserControl.getInstance().setUser(SUcontrol.getSystemUser());
			}
		});

	}
	
	
	public void authUser() {
		String uname = txtUName.getText();
		String password = txtPassword.getText();
		
		SingleUserControl.getInstance().setUser(SUcontrol.authSystemUser(uname, password));
		
		if(SingleUserControl.getInstance().getUser() != null) {
			shell.setVisible(false);
			shell.close();
			MainApp.main(null);
			shell.dispose();
		}
		else {
			labelFinal.setText("Login failed!");
		}
	}
}
