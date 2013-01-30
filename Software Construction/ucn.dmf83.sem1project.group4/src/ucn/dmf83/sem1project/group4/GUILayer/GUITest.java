package ucn.dmf83.sem1project.group4.GUILayer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import ucn.dmf83.sem1project.group4.ControlLayer.SingleUserControl;
import ucn.dmf83.sem1project.group4.ControlLayer.SystemUserControl;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class GUITest {

	private static SystemUserControl SUcontrol;
	private static SingleUserControl Ucontrol;
	
	
	protected Shell shell;
	private Text txtUName;
	private Text txtPassword;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		
		SUcontrol = new SystemUserControl();
		Ucontrol = SingleUserControl.getInstance();
		SUcontrol.flush();
		SUcontrol.addSystemUser("test", "test");
		Ucontrol.setUser(null);
		
		try {
			GUITest window = new GUITest();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
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
		shell.setSize(450, 300);
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
		
		final Label labelFinal = new Label(shell, SWT.NONE);
		labelFinal.setBounds(329, 122, 200, 15);
		
		Button btnLogin = new Button(shell, SWT.NONE);
		btnLogin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String uname = txtUName.getText();
				String password = txtPassword.getText();
				
				Ucontrol.setUser(SUcontrol.authSystemUser(uname, password));
				
				if(Ucontrol.getUser() != null) {
					shell.setVisible(false);
					shell.close();
					MainApp.main(null);
					shell.dispose();
				}
				else {
					labelFinal.setText("Login failed!");
				}
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
		

	}
}
