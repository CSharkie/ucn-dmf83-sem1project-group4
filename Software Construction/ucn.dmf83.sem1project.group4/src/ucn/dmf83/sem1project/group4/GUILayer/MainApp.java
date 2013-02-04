package ucn.dmf83.sem1project.group4.GUILayer;


import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import ucn.dmf83.sem1project.group4.ControlLayer.*;
import ucn.dmf83.sem1project.group4.DomainLayer.*;

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
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MainApp {
	
	protected Shell shell;
	private TabFolder tabFolder;
	
	// Product screen
	private TabItem tbtmProducts;
	private Composite compositeProducts;
	
	private Text searchProduct;
	private Text txtProductName;
	private Text txtProductID;
	private Text txtProductDescription;
	private Text txtProductDepot;
	
	private List listProduct;
	private Group displayProduct;
	private Canvas barcodeProduct;
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		
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
	    int x = display.getPrimaryMonitor().getBounds().x + (display.getPrimaryMonitor().getBounds().width - shell.getBounds().width) / 2;
	    int y = display.getPrimaryMonitor().getBounds().y + (display.getPrimaryMonitor().getBounds().height - shell.getBounds().height) / 2;
	    
	    shell.setLocation(x, y);
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
		shell.setText("iCatalog - Welcome " + SingleUserControl.getInstance().getUser().getUserName() + "!");
		
		tabFolder = new TabFolder(shell, SWT.NONE);
		tabFolder.setBounds(10, 10, 764, 541);
		
		tbtmProducts = new TabItem(tabFolder, SWT.NONE);
		tbtmProducts.setText("Products");
		
		compositeProducts = new Composite(tabFolder, SWT.NONE);
		tbtmProducts.setControl(compositeProducts);
		
		listProduct = new List(compositeProducts, SWT.BORDER);
		listProduct.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!(listProduct.getSelectionCount() > 1)) {
					Product p = LocationControl.getInstance().getProduct(Integer.parseInt(listProduct.getSelection()[0].substring(0, 9)));
					
					displayProduct.setText(p.getID() + " - " + p.getName());
					
					txtProductName.setText(p.getName());
					txtProductID.setText(p.getID() + "");
					txtProductDescription.setText(p.getDescription());
					txtProductDescription.setText(LocationContainer.getInstance().getLocation(p).getName());
				}
			}
		});
		listProduct.setBounds(10, 37, 320, 466);
		
		searchProduct = new Text(compositeProducts, SWT.BORDER);
		searchProduct.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				listProduct.removeAll();
				for(Product p:LocationControl.getInstance().searchProducts(searchProduct.getText())) {
					listProduct.add(p.getID() + "\t" + p.getName());
				}
			}
		});
		searchProduct.setBounds(10, 10, 320, 21);
		
		displayProduct = new Group(compositeProducts, SWT.NONE);
		displayProduct.setBounds(336, 10, 410, 450);
		
		barcodeProduct = new Canvas(displayProduct, SWT.NONE);
		barcodeProduct.setBounds(10, 184, 256, 256);
		
		Label lblDescription = new Label(displayProduct, SWT.NONE);
		lblDescription.setBounds(10, 75, 65, 15);
		lblDescription.setText("Description:");
		
		txtProductDescription = new Text(displayProduct, SWT.BORDER);
		txtProductDescription.setBounds(81, 72, 319, 79);
		
		Label lblDepotLocation = new Label(displayProduct, SWT.NONE);
		lblDepotLocation.setBounds(10, 160, 65, 15);
		lblDepotLocation.setText("Depot:");
		
		txtProductDepot = new Text(displayProduct, SWT.BORDER);
		txtProductDepot.setBounds(81, 157, 319, 21);
		
		Group grpProductLocation = new Group(displayProduct, SWT.NONE);
		grpProductLocation.setText("Location");
		grpProductLocation.setBounds(272, 184, 128, 256);
		
		txtProductName = new Text(displayProduct, SWT.BORDER);
		txtProductName.setBounds(81, 21, 319, 21);
		
		txtProductID = new Text(displayProduct, SWT.BORDER);
		txtProductID.setBounds(81, 45, 185, 21);
		
		Label lblName = new Label(displayProduct, SWT.NONE);
		lblName.setBounds(10, 24, 55, 15);
		lblName.setText("Name:");
		
		Label lblId = new Label(displayProduct, SWT.NONE);
		lblId.setBounds(10, 48, 55, 15);
		lblId.setText("ID:");
		
		Button btnDeleteProduct = new Button(compositeProducts, SWT.NONE);
		btnDeleteProduct.setBounds(434, 466, 100, 37);
		btnDeleteProduct.setText("DELETE");
		
		Button btnSaveProduct = new Button(compositeProducts, SWT.NONE);
		btnSaveProduct.setBounds(540, 466, 100, 37);
		btnSaveProduct.setText("SAVE");
		
		Button btnAddNewProduct = new Button(compositeProducts, SWT.NONE);
		btnAddNewProduct.setBounds(646, 466, 100, 37);
		btnAddNewProduct.setText("ADD AS NEW");
		
		Button btnReloadProduct = new Button(compositeProducts, SWT.NONE);
		btnReloadProduct.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				listProduct.removeAll();
				searchProduct.setText("");
				for(Product p:LocationControl.getInstance().searchProducts(searchProduct.getText())) {
					listProduct.add(p.getID() + "\t" + p.getName());
				}
			}
		});
		btnReloadProduct.setText("RELOAD LIST");
		btnReloadProduct.setBounds(336, 466, 92, 37);
		
		TabItem tbtmCustomers = new TabItem(tabFolder, SWT.NONE);
		tbtmCustomers.setText("Customers");
		
		Composite compositeCustomers = new Composite(tabFolder, SWT.NONE);
		tbtmCustomers.setControl(compositeCustomers);
		
		TabItem tbtmOrders = new TabItem(tabFolder, SWT.NONE);
		tbtmOrders.setText("Orders");
		
		Composite compositeOrders = new Composite(tabFolder, SWT.NONE);
		tbtmOrders.setControl(compositeOrders);
		
		TabItem tbtmRents = new TabItem(tabFolder, SWT.NONE);
		tbtmRents.setText("Rents");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmRents.setControl(composite);
		
		//if(Ucontrol.getUser().isElevated() || Ucontrol.getUser().isAdmin()) {
			TabItem tbtmEmployees = new TabItem(tabFolder, SWT.NONE);
			tbtmEmployees.setText("Employees");
			
			Composite composite_2 = new Composite(tabFolder, SWT.NONE);
			tbtmEmployees.setControl(composite_2);
			
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
		//}
	}
}
