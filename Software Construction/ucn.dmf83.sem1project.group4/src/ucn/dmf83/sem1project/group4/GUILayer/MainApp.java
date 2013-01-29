package ucn.dmf83.sem1project.group4.GUILayer;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import ucn.dmf83.sem1project.group4.ControlLayer.ContractorControl;
import ucn.dmf83.sem1project.group4.ControlLayer.CustomerControl;
import ucn.dmf83.sem1project.group4.ControlLayer.EmployeeControl;
import ucn.dmf83.sem1project.group4.ControlLayer.LocationControl;
import ucn.dmf83.sem1project.group4.ControlLayer.OfferControl;
import ucn.dmf83.sem1project.group4.ControlLayer.OrderControl;
import ucn.dmf83.sem1project.group4.ControlLayer.RentControl;
import ucn.dmf83.sem1project.group4.ControlLayer.SingleUserControl;
import ucn.dmf83.sem1project.group4.ControlLayer.SystemUserControl;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public class MainApp {
	
	private static SystemUserControl SUcontrol;
	private static CustomerControl custControl;
	private static LocationControl locControl;
	private static EmployeeControl empControl;
	private static ContractorControl contControl;
	private static OfferControl offerControl;
	private static OrderControl orderControl;
	private static RentControl rentControl;
	
	
	private static SingleUserControl Ucontrol;

	protected Shell shlIcatalogWelcome;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		
		SUcontrol = new SystemUserControl();
		Ucontrol = SingleUserControl.getInstance();
		
		try {
			MainApp window = new MainApp();
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
		shlIcatalogWelcome.open();
		shlIcatalogWelcome.layout();
		while (!shlIcatalogWelcome.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlIcatalogWelcome = new Shell();
		shlIcatalogWelcome.setMinimumSize(new Point(800, 600));
		shlIcatalogWelcome.setSize(450, 300);
		shlIcatalogWelcome.setText("iCatalog - Welcome " + Ucontrol.getUser().getUserName() + "!");
		
		TabFolder tabFolder = new TabFolder(shlIcatalogWelcome, SWT.NONE);
		tabFolder.setBounds(10, 10, 764, 521);
		
		TabItem tbtmProducts = new TabItem(tabFolder, SWT.NONE);
		tbtmProducts.setText("Products");
		
		TabItem tbtmCustomers = new TabItem(tabFolder, SWT.NONE);
		tbtmCustomers.setText("Customers");
		
		TabItem tbtmOrders = new TabItem(tabFolder, SWT.NONE);
		tbtmOrders.setText("Orders");
		
		if(Ucontrol.getUser().isElevated() || Ucontrol.getUser().isAdmin()) {
			TabItem tbtmEmployees = new TabItem(tabFolder, SWT.NONE);
			tbtmEmployees.setText("Employees");
			
			TabItem tbtmContractors = new TabItem(tabFolder, SWT.NONE);
			tbtmContractors.setText("Contractors");
			
			TabItem tbtmOffers = new TabItem(tabFolder, SWT.NONE);
			tbtmOffers.setText("Offers");
			
			TabItem tbtmLocations = new TabItem(tabFolder, SWT.NONE);
			tbtmLocations.setText("Locations");
		}
		if(Ucontrol.getUser().isAdmin()) {
			TabItem tbtmAdmin = new TabItem(tabFolder, SWT.NONE);
			tbtmAdmin.setText("Administration");
		}
		
		TabItem tbtmRents = new TabItem(tabFolder, SWT.NONE);
		tbtmRents.setText("Rents");
		
		TabItem tbtmCurrentUser = new TabItem(tabFolder, SWT.NONE);
		tbtmCurrentUser.setText("Current User");
	}
}
