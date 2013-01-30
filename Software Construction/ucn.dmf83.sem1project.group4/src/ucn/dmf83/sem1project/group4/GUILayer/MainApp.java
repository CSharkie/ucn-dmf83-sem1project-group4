package ucn.dmf83.sem1project.group4.GUILayer;

import java.awt.Color;

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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;

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
	private Text searchProduct;
	private Text searchCustomers;
	private Text searchOrders;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_4;
	private Text text_3;

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
		tabFolder.setBounds(10, 10, 764, 541);
		
		TabItem tbtmProducts = new TabItem(tabFolder, SWT.NONE);
		tbtmProducts.setText("Products");
		
		Composite compositeProducts = new Composite(tabFolder, SWT.NONE);
		tbtmProducts.setControl(compositeProducts);
		
		List listProduct = new List(compositeProducts, SWT.BORDER);
		listProduct.setBounds(10, 37, 320, 466);
		
		searchProduct = new Text(compositeProducts, SWT.BORDER);
		searchProduct.setBounds(10, 10, 320, 21);
		
		Group displayProduct = new Group(compositeProducts, SWT.NONE);
		displayProduct.setBounds(336, 10, 410, 450);
		
		Canvas Barcodecanvas = new Canvas(displayProduct, SWT.NONE);
		Barcodecanvas.setBounds(272, 312, 128, 128);
		
		Label lblDescription = new Label(displayProduct, SWT.NONE);
		lblDescription.setBounds(10, 28, 65, 15);
		lblDescription.setText("Description:");
		
		text_4 = new Text(displayProduct, SWT.BORDER);
		text_4.setBounds(81, 25, 319, 79);
		
		Label lblDepotLocation = new Label(displayProduct, SWT.NONE);
		lblDepotLocation.setBounds(10, 113, 65, 15);
		lblDepotLocation.setText("Depot:");
		
		text_3 = new Text(displayProduct, SWT.BORDER);
		text_3.setBounds(81, 110, 185, 21);
		
		Group grpLocation = new Group(displayProduct, SWT.NONE);
		grpLocation.setText("Location");
		grpLocation.setBounds(272, 107, 128, 199);
		
		Button btnDelete = new Button(compositeProducts, SWT.NONE);
		btnDelete.setBounds(336, 466, 100, 37);
		btnDelete.setText("DELETE");
		
		Button btnSave = new Button(compositeProducts, SWT.NONE);
		btnSave.setBounds(540, 466, 100, 37);
		btnSave.setText("SAVE");
		
		Button btnAddNew = new Button(compositeProducts, SWT.NONE);
		btnAddNew.setBounds(646, 466, 100, 37);
		btnAddNew.setText("ADD AS NEW");
		
		TabItem tbtmCustomers = new TabItem(tabFolder, SWT.NONE);
		tbtmCustomers.setText("Customers");
		
		Composite compositeCustomers = new Composite(tabFolder, SWT.NONE);
		tbtmCustomers.setControl(compositeCustomers);
		
		List listCustomers = new List(compositeCustomers, SWT.BORDER);
		listCustomers.setBounds(10, 37, 320, 446);
		
		searchCustomers = new Text(compositeCustomers, SWT.BORDER);
		searchCustomers.setBounds(10, 10, 320, 21);
		
		Group infoCustomer = new Group(compositeCustomers, SWT.NONE);
		infoCustomer.setBounds(336, 10, 410, 473);
		
		TabItem tbtmOrders = new TabItem(tabFolder, SWT.NONE);
		tbtmOrders.setText("Orders");
		
		Composite compositeOrders = new Composite(tabFolder, SWT.NONE);
		tbtmOrders.setControl(compositeOrders);
		
		List listOrders = new List(compositeOrders, SWT.BORDER);
		listOrders.setBounds(10, 37, 320, 446);
		
		searchOrders = new Text(compositeOrders, SWT.BORDER);
		searchOrders.setBounds(10, 10, 320, 21);
		
		Group inforOrders = new Group(compositeOrders, SWT.NONE);
		inforOrders.setBounds(336, 10, 410, 473);
		
		TabItem tbtmRents = new TabItem(tabFolder, SWT.NONE);
		tbtmRents.setText("Rents");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmRents.setControl(composite);
		
		List list = new List(composite, SWT.BORDER);
		list.setBounds(10, 37, 320, 446);
		
		text = new Text(composite, SWT.BORDER);
		text.setBounds(10, 10, 320, 21);
		
		Group group = new Group(composite, SWT.NONE);
		group.setBounds(336, 10, 410, 473);
		
		//if(Ucontrol.getUser().isElevated() || Ucontrol.getUser().isAdmin()) {
			TabItem tbtmEmployees = new TabItem(tabFolder, SWT.NONE);
			tbtmEmployees.setText("Employees");
			
			Composite composite_2 = new Composite(tabFolder, SWT.NONE);
			tbtmEmployees.setControl(composite_2);
			
			List list_2 = new List(composite_2, SWT.BORDER);
			list_2.setBounds(10, 37, 320, 446);
			
			text_2 = new Text(composite_2, SWT.BORDER);
			text_2.setBounds(10, 10, 320, 21);
			
			Group group_2 = new Group(composite_2, SWT.NONE);
			group_2.setBounds(336, 10, 410, 473);
			
			TabItem tbtmContractors = new TabItem(tabFolder, SWT.NONE);
			tbtmContractors.setText("Contractors");
			
			TabItem tbtmOffers = new TabItem(tabFolder, SWT.NONE);
			tbtmOffers.setText("Offers");
			
			TabItem tbtmLocations = new TabItem(tabFolder, SWT.NONE);
			tbtmLocations.setText("Locations");
		//}
		//if(Ucontrol.getUser().isAdmin()) {
			TabItem tbtmAdmin = new TabItem(tabFolder, SWT.NONE);
			tbtmAdmin.setText("Administration");
			
			TabItem tbtmCurrentUser = new TabItem(tabFolder, SWT.NONE);
			tbtmCurrentUser.setText("Current User");
			
			Composite composite_1 = new Composite(tabFolder, SWT.NONE);
			tbtmCurrentUser.setControl(composite_1);
			
			List list_1 = new List(composite_1, SWT.BORDER);
			list_1.setBounds(10, 37, 320, 446);
			
			text_1 = new Text(composite_1, SWT.BORDER);
			text_1.setBounds(10, 10, 320, 21);
			
			Group group_1 = new Group(composite_1, SWT.NONE);
			group_1.setBounds(336, 10, 410, 473);
		//}
	}
}
