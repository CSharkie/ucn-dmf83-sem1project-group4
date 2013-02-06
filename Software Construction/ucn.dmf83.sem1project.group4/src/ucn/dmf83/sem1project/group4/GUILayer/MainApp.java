package ucn.dmf83.sem1project.group4.GUILayer;

import java.text.SimpleDateFormat;
import java.util.Date;

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
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;

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
	
	private Button btnEditProduct;
	private Button btnDeleteProduct;
	private Button btnAddNewProduct;
	private Button btnReloadProduct;
	
	private List listProduct;
	private Group displayProduct;
	private Canvas barcodeProduct;
	
	
	// Customer screen
	private TabItem tbtmCustomers;
	
	private Text searchCustomer;
	private Text txtCustomerName;
	private Text txtCustomerID;
	
	private Composite compositeCustomers;
	private List listCustomers;
	private Group displayCustomer;
	private Button btnReloadCustomer;
	private Button btnSaveCustomer;
	private Button btnDeleteCustomer;
	private Button btnAddNewCustomer;
	
	
	// Employee screen
	private Text searchEmployee;
	private Text txtEmployeeDepartment;
	private Text txtEmployeeName;
	private Text txtEmployeeID;
	
	
	// Location screen
	private Text searchLocation;
	private Text txtLocationAddress;
	private Text txtLocationName;
	private Text txtLocationID;
	
	
	// Order screen
	private Text searchOrder;
	private Text txtOrderSeller;
	private Text txtOrderID;
	private Text txtOrderCustomerName;
	
	
	// Rent screen
	private Text searchRents;
	private Text txtRentsRenter;
	private Text txtRentsID;
	private Text txtRentsCustomerName;
	private Text txtRentsDevice;
	private Table table;
	private List listLocation;
	private Button btnReloadLocation;
	private Button btnDeleteLocation;
	private Button btnSaveLocation;
	private Button btnAddNewLocation;
	private Group grpProductLocation;
	private Button btnSaveProduct;
	private Spinner spinnerPDiscount;
	private Combo combo;
	private Group grpAddress;
	private Button btnEditCustomer;
	private Spinner spinnerTDiscount;
	private Group grpContactDetails;
	private Button btnOrders;
	private Button btnR;
	private Composite compositeOrders;
	private TabItem tbtmOrders;
	private List listOrders;
	private Group displayOrder;
	private Button btnCheckButton;
	private DateTime dateOrder;
	private TableColumn tblclmnName;
	private TableColumn tblclmnPrice;
	private TableColumn tblclmnNumber;
	private TableColumn tblclmnTotal;
	private Button btnAddProduct;
	private Button btnDeleteProduct_1;
	private Button btnDeleteOrder;
	private Button btnSaveOrder;
	private Button btnEditOrder;
	private Button btnAddNewOrder;
	private TabItem tbtmRents;
	private Composite composite;
	private Group displayRents;
	private List listRents;
	private DateTime startDateRent;
	private DateTime endDateRent;
	private Button btnSaveRent;
	private Button btnDeleteRent;
	private Button btnReloadRent;
	private Button btnAddNewRent;
	private TabItem tbtmEmployees;
	private Composite compositeEmployee;
	private List listEmployees;
	private Group displayEmployee;
	private Button btnReloadEmployee;
	private Button btnDeleteEmployee;
	private Button btnSaveEmployee;
	private Button btnAddNewEmployee;
	private Button btnEditEmployee;
	private TabItem tbtmContractors;
	private TabItem tbtmOffers;
	private TabItem tbtmLocations;
	private Composite compositeLocations;
	private Group displayLocation;
	private TabItem tbtmAdmin;
	private TabItem tbtmCurrentUser;
	private Composite composite_1;
	

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
		
		LocationControl.getInstance().createLocation(0, "Test Road 1, 0000 Beta Town");
		LocationControl.getInstance().getLocation(0).addProduct(new Product(0,"Test Lumber","Test Lumber, only for testers!"));
		LocationControl.getInstance().getLocation(0).addProduct(new Product(1,"Test Lumber","Test Lumber, only for testers!"));
		LocationControl.getInstance().getLocation(0).addProduct(new Product(2,"Test Lumber","Test Lumber, only for testers!"));
		LocationControl.getInstance().getLocation(0).addProduct(new Product(3,"Test Lumber","Test Lumber, only for testers!"));
		LocationControl.getInstance().getLocation(0).addProduct(new Product(4,"Test Lumber","Test Lumber, only for testers!"));
		LocationControl.getInstance().getLocation(0).addProduct(new Product(5,"Test Lumber","Test Lumber, only for testers!"));
		
		
		
		OrderControl.getInstance().createOrder(0, new Customer(), new Employee(), new Date(), false);
		
		
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
			public void widgetSelected(SelectionEvent e) { showProductDetails();}
		});
		listProduct.setBounds(10, 37, 320, 466);
		
		searchProduct = new Text(compositeProducts, SWT.BORDER);
		searchProduct.addModifyListener( new ModifyListener() { public void modifyText(ModifyEvent arg0) {searchProducts();} } );
		searchProduct.setBounds(10, 10, 299, 21);
		
		displayProduct = new Group(compositeProducts, SWT.NONE);
		displayProduct.setBounds(336, 10, 410, 450);
		
		barcodeProduct = new Canvas(displayProduct, SWT.NONE);
		barcodeProduct.setBounds(10, 184, 256, 256);
		
		Label lblDescription = new Label(displayProduct, SWT.NONE);
		lblDescription.setBounds(10, 75, 65, 15);
		lblDescription.setText("Description:");
		
		txtProductDescription = new Text(displayProduct, SWT.BORDER);
		txtProductDescription.setEditable(false);
		txtProductDescription.setBounds(81, 72, 319, 79);
		
		Label lblDepotLocation = new Label(displayProduct, SWT.NONE);
		lblDepotLocation.setBounds(10, 160, 65, 15);
		lblDepotLocation.setText("Depot:");
		
		txtProductDepot = new Text(displayProduct, SWT.BORDER);
		txtProductDepot.setEditable(false);
		txtProductDepot.setBounds(81, 157, 319, 21);
		
		grpProductLocation = new Group(displayProduct, SWT.NONE);
		grpProductLocation.setText("Location");
		grpProductLocation.setBounds(272, 184, 128, 256);
		
		txtProductName = new Text(displayProduct, SWT.BORDER);
		txtProductName.setEditable(false);
		txtProductName.setBounds(81, 21, 319, 21);
		
		txtProductID = new Text(displayProduct, SWT.BORDER);
		txtProductID.setEditable(false);
		txtProductID.setBounds(81, 45, 185, 21);
		
		Label lblName = new Label(displayProduct, SWT.NONE);
		lblName.setBounds(10, 24, 55, 15);
		lblName.setText("Name:");
		
		Label lblId = new Label(displayProduct, SWT.NONE);
		lblId.setBounds(10, 48, 55, 15);
		lblId.setText("ID:");
		
		btnDeleteProduct = new Button(compositeProducts, SWT.NONE);
		btnDeleteProduct.setEnabled(false);
		btnDeleteProduct.setBounds(346, 466, 82, 37);
		btnDeleteProduct.setText("DELETE");
		
		btnEditProduct = new Button(compositeProducts, SWT.NONE);
		btnEditProduct.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnEditProduct.setBounds(540, 466, 100, 37);
		btnEditProduct.setText("EDIT");
		
		btnAddNewProduct = new Button(compositeProducts, SWT.NONE);
		btnAddNewProduct.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAddNewProduct.setBounds(646, 466, 100, 37);
		btnAddNewProduct.setText("ADD NEW");
		
		btnReloadProduct = new Button(compositeProducts, SWT.NONE);
		btnReloadProduct.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {searchProduct.setText(""); searchProducts();}
		});
		btnReloadProduct.setText("R");
		btnReloadProduct.setBounds(309, 10, 21, 21);
		
		btnSaveProduct = new Button(compositeProducts, SWT.NONE);
		btnSaveProduct.setEnabled(false);
		btnSaveProduct.setText("SAVE");
		btnSaveProduct.setBounds(434, 466, 100, 37);
		
		tbtmCustomers = new TabItem(tabFolder, SWT.NONE);
		tbtmCustomers.setText("Customers");
		
		
		compositeCustomers = new Composite(tabFolder, SWT.NONE);
		tbtmCustomers.setControl(compositeCustomers);
		
		searchCustomer = new Text(compositeCustomers, SWT.BORDER);
		searchCustomer.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				searchCustomers();
			}
		});
		searchCustomer.setBounds(10, 10, 298, 21);
		
		listCustomers = new List(compositeCustomers, SWT.BORDER);
		listCustomers.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				showCustomerDetails();
			}
		});
		listCustomers.setBounds(10, 37, 320, 466);
		
		displayCustomer = new Group(compositeCustomers, SWT.NONE);
		displayCustomer.setBounds(336, 10, 410, 450);
		
		txtCustomerName = new Text(displayCustomer, SWT.BORDER);
		txtCustomerName.setEnabled(false);
		txtCustomerName.setBounds(144, 50, 256, 21);
		
		txtCustomerID = new Text(displayCustomer, SWT.BORDER);
		txtCustomerID.setEnabled(false);
		txtCustomerID.setBounds(144, 23, 256, 21);
		
		Label label_2 = new Label(displayCustomer, SWT.NONE);
		label_2.setText("Name:");
		label_2.setBounds(10, 53, 55, 15);
		
		Label label_3 = new Label(displayCustomer, SWT.NONE);
		label_3.setText("ID:");
		label_3.setBounds(10, 26, 55, 15);
		
		grpAddress = new Group(displayCustomer, SWT.NONE);
		grpAddress.setText("Address");
		grpAddress.setBounds(10, 134, 390, 128);
		
		combo = new Combo(displayCustomer, SWT.NONE);
		combo.setEnabled(false);
		combo.setBounds(144, 77, 256, 23);
		
		Label lblGroup = new Label(displayCustomer, SWT.NONE);
		lblGroup.setBounds(10, 80, 55, 15);
		lblGroup.setText("Group:");
		
		spinnerPDiscount = new Spinner(displayCustomer, SWT.BORDER);
		spinnerPDiscount.setEnabled(false);
		spinnerPDiscount.setBounds(144, 106, 64, 22);
		
		Label lblPersonalDiscount = new Label(displayCustomer, SWT.NONE);
		lblPersonalDiscount.setBounds(10, 109, 108, 15);
		lblPersonalDiscount.setText("Personal discount:");
		
		Label lblDiscountTotal = new Label(displayCustomer, SWT.NONE);
		lblDiscountTotal.setBounds(230, 109, 89, 15);
		lblDiscountTotal.setText("Discount total:");
		
		spinnerTDiscount = new Spinner(displayCustomer, SWT.BORDER);
		spinnerTDiscount.setEnabled(false);
		spinnerTDiscount.setBounds(336, 106, 64, 22);
		
		grpContactDetails = new Group(displayCustomer, SWT.NONE);
		grpContactDetails.setText("Contact details");
		grpContactDetails.setBounds(10, 268, 390, 128);
		
		btnOrders = new Button(displayCustomer, SWT.NONE);
		btnOrders.setBounds(292, 402, 108, 38);
		btnOrders.setText("ORDERS");
		
		btnReloadCustomer = new Button(compositeCustomers, SWT.NONE);
		btnReloadCustomer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				searchCustomer.setText("");
				searchCustomers();
			}
		});
		btnReloadCustomer.setText("R");
		btnReloadCustomer.setBounds(309, 10, 21, 21);
		
		btnAddNewCustomer = new Button(compositeCustomers, SWT.NONE);
		btnAddNewCustomer.setText("ADD NEW");
		btnAddNewCustomer.setBounds(646, 466, 100, 37);
		
		btnDeleteCustomer = new Button(compositeCustomers, SWT.NONE);
		btnDeleteCustomer.setEnabled(false);
		btnDeleteCustomer.setText("DELETE");
		btnDeleteCustomer.setBounds(336, 466, 100, 37);
		
		btnEditCustomer = new Button(compositeCustomers, SWT.NONE);
		btnEditCustomer.setBounds(548, 466, 92, 37);
		btnEditCustomer.setText("EDIT");
		
		btnSaveCustomer = new Button(compositeCustomers, SWT.NONE);
		btnSaveCustomer.setEnabled(false);
		btnSaveCustomer.setBounds(442, 466, 100, 37);
		btnSaveCustomer.setText("SAVE");
		
		tbtmOrders = new TabItem(tabFolder, SWT.NONE);
		tbtmOrders.setText("Orders");
		
		compositeOrders = new Composite(tabFolder, SWT.NONE);
		tbtmOrders.setControl(compositeOrders);
		
		searchOrder = new Text(compositeOrders, SWT.BORDER);
		searchOrder.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				searchOrders();
			}
		});
		searchOrder.setBounds(10, 10, 298, 21);
		
		btnR = new Button(compositeOrders, SWT.NONE);
		btnR.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				searchOrder.setText("");
				searchOrders();
			}
		});
		btnR.setLocation(309, 10);
		btnR.setSize(21, 21);
		btnR.setText("R");
		
		listOrders = new List(compositeOrders, SWT.BORDER);
		listOrders.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				showOrderDetails();
			}
		});
		listOrders.setBounds(10, 37, 320, 466);
		
		displayOrder = new Group(compositeOrders, SWT.NONE);
		displayOrder.setBounds(336, 10, 410, 450);
		
		Label lblSeller = new Label(displayOrder, SWT.NONE);
		lblSeller.setText("Seller:");
		lblSeller.setBounds(10, 75, 65, 15);
		
		txtOrderSeller = new Text(displayOrder, SWT.BORDER);
		txtOrderSeller.setEnabled(false);
		txtOrderSeller.setBounds(111, 72, 289, 21);
		
		txtOrderID = new Text(displayOrder, SWT.BORDER);
		txtOrderID.setEnabled(false);
		txtOrderID.setBounds(111, 21, 289, 21);
		
		txtOrderCustomerName = new Text(displayOrder, SWT.BORDER);
		txtOrderCustomerName.setEnabled(false);
		txtOrderCustomerName.setBounds(111, 48, 289, 21);
		
		Label lblId_1 = new Label(displayOrder, SWT.NONE);
		lblId_1.setText("ID:");
		lblId_1.setBounds(10, 24, 55, 15);
		
		Label lblCustomerName = new Label(displayOrder, SWT.NONE);
		lblCustomerName.setText("Customer Name:");
		lblCustomerName.setBounds(10, 48, 95, 15);
		
		Label lblDate = new Label(displayOrder, SWT.NONE);
		lblDate.setText("Date:");
		lblDate.setBounds(10, 104, 65, 15);
		
		dateOrder = new DateTime(displayOrder, SWT.BORDER);
		dateOrder.setEnabled(false);
		dateOrder.setBounds(111, 99, 128, 24);
		
		Label lblPaid = new Label(displayOrder, SWT.NONE);
		lblPaid.setText("Paid:");
		lblPaid.setBounds(248, 103, 65, 15);
		
		btnCheckButton = new Button(displayOrder, SWT.CHECK);
		btnCheckButton.setEnabled(false);
		btnCheckButton.setBounds(349, 103, 23, 16);
		
		table = new Table(displayOrder, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 125, 390, 284);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		tblclmnName = new TableColumn(table, SWT.NONE);
		tblclmnName.setResizable(false);
		tblclmnName.setWidth(194);
		tblclmnName.setText("Name");
		
		tblclmnPrice = new TableColumn(table, SWT.NONE);
		tblclmnPrice.setResizable(false);
		tblclmnPrice.setWidth(64);
		tblclmnPrice.setText("Price");
		
		tblclmnNumber = new TableColumn(table, SWT.NONE);
		tblclmnNumber.setResizable(false);
		tblclmnNumber.setWidth(64);
		tblclmnNumber.setText("Number");
		
		tblclmnTotal = new TableColumn(table, SWT.NONE);
		tblclmnTotal.setResizable(false);
		tblclmnTotal.setWidth(64);
		tblclmnTotal.setText("Total");
		
		btnAddProduct = new Button(displayOrder, SWT.NONE);
		btnAddProduct.setEnabled(false);
		btnAddProduct.setBounds(310, 415, 90, 25);
		btnAddProduct.setText("Add product");
		
		btnDeleteProduct_1 = new Button(displayOrder, SWT.NONE);
		btnDeleteProduct_1.setEnabled(false);
		btnDeleteProduct_1.setBounds(214, 415, 90, 25);
		btnDeleteProduct_1.setText("Delete product");
		
		Label lblTotalPrice = new Label(displayOrder, SWT.NONE);
		lblTotalPrice.setBounds(10, 420, 198, 15);
		lblTotalPrice.setText("Total price:");
		
		btnDeleteOrder = new Button(compositeOrders, SWT.NONE);
		btnDeleteOrder.setEnabled(false);
		btnDeleteOrder.setBounds(346, 466, 100, 37);
		btnDeleteOrder.setText("DELETE");
		
		btnSaveOrder = new Button(compositeOrders, SWT.NONE);
		btnSaveOrder.setEnabled(false);
		btnSaveOrder.setBounds(452, 466, 100, 37);
		btnSaveOrder.setText("SAVE");
		
		btnEditOrder = new Button(compositeOrders, SWT.NONE);
		btnEditOrder.setBounds(558, 466, 82, 37);
		btnEditOrder.setText("EDIT");
		
		btnAddNewOrder = new Button(compositeOrders, SWT.NONE);
		btnAddNewOrder.setBounds(646, 466, 100, 37);
		btnAddNewOrder.setText("ADD NEW");
		
		tbtmRents = new TabItem(tabFolder, SWT.NONE);
		tbtmRents.setText("Rents");
		
		composite = new Composite(tabFolder, SWT.NONE);
		tbtmRents.setControl(composite);
		  
		searchRents = new Text(composite, SWT.BORDER);
		searchRents.setBounds(10, 10, 298, 21);
		  
		listRents = new List(composite, SWT.BORDER);
		listRents.setBounds(10, 37, 320, 466);
		  
		displayRents = new Group(composite, SWT.NONE);
		displayRents.setBounds(336, 10, 410, 450);
		  
		Label lblRenter = new Label(displayRents, SWT.NONE);
		lblRenter.setText("Renter:");
		lblRenter.setBounds(10, 75, 65, 15);
		  
		txtRentsRenter = new Text(displayRents, SWT.BORDER);
		txtRentsRenter.setBounds(106, 72, 294, 21);
		  
		txtRentsID = new Text(displayRents, SWT.BORDER);
		txtRentsID.setBounds(106, 21, 294, 21);
		  
		txtRentsCustomerName = new Text(displayRents, SWT.BORDER);
		txtRentsCustomerName.setBounds(106, 45, 294, 21);
		  
		Label lblID = new Label(displayRents, SWT.NONE);
		lblID.setText("ID:");
		lblID.setBounds(10, 24, 55, 15);
		  
		Label lblCustomerName1 = new Label(displayRents, SWT.NONE);
		lblCustomerName1.setText("Customer Name:");
		lblCustomerName1.setBounds(10, 48, 90, 15);
		  
		Label lblDevice = new Label(displayRents, SWT.NONE);
		lblDevice.setText("Device:");
		lblDevice.setBounds(10, 100, 65, 15);
		  
		txtRentsDevice = new Text(displayRents, SWT.BORDER);
		txtRentsDevice.setBounds(106, 96, 294, 21);
		  
		Label lblStartDate = new Label(displayRents, SWT.NONE);
		lblStartDate.setText("Start Date:");
		lblStartDate.setBounds(10, 125, 65, 15);
		
		startDateRent = new DateTime(displayRents, SWT.BORDER);
		startDateRent.setBounds(106, 120, 80, 24);
		
		endDateRent = new DateTime(displayRents, SWT.BORDER);
		endDateRent.setBounds(320, 120, 80, 24);
		
		Label lblEndDate = new Label(displayRents, SWT.NONE);
		lblEndDate.setBounds(213, 125, 55, 15);
		lblEndDate.setText("End Date:");
		  
		btnReloadRent = new Button(composite, SWT.NONE);
		btnReloadRent.setText("R");
		btnReloadRent.setBounds(309, 10, 21, 21);
		  
		btnDeleteRent = new Button(composite, SWT.NONE);
		btnDeleteRent.setText("DELETE");
		btnDeleteRent.setBounds(336, 466, 100, 37);
		  
		btnSaveRent = new Button(composite, SWT.NONE);
		btnSaveRent.setText("SAVE");
		btnSaveRent.setBounds(442, 466, 100, 37);
		  
		btnAddNewRent = new Button(composite, SWT.NONE);
		btnAddNewRent.setText("ADD AS NEW");
		btnAddNewRent.setBounds(646, 466, 100, 37);
		
		//if(Ucontrol.getUser().isElevated() || Ucontrol.getUser().isAdmin()) {
			tbtmEmployees = new TabItem(tabFolder, SWT.NONE);
			tbtmEmployees.setText("Employees");
			
			compositeEmployee = new Composite(tabFolder, SWT.NONE);
			tbtmEmployees.setControl(compositeEmployee);
			
			searchEmployee = new Text(compositeEmployee, SWT.BORDER);
			searchEmployee.setBounds(10, 10, 298, 21);
			
			listEmployees = new List(compositeEmployee, SWT.BORDER);
			listEmployees.setBounds(10, 37, 320, 466);
			
			displayEmployee = new Group(compositeEmployee, SWT.NONE);
			displayEmployee.setBounds(336, 10, 410, 450);
			
			Label lblDepartment = new Label(displayEmployee, SWT.NONE);
			lblDepartment.setText("Department:");
			lblDepartment.setBounds(10, 75, 65, 15);
			
			txtEmployeeDepartment = new Text(displayEmployee, SWT.BORDER);
			txtEmployeeDepartment.setBounds(81, 72, 319, 21);
			
			txtEmployeeName = new Text(displayEmployee, SWT.BORDER);
			txtEmployeeName.setBounds(81, 48, 319, 21);
			
			txtEmployeeID = new Text(displayEmployee, SWT.BORDER);
			txtEmployeeID.setBounds(81, 21, 185, 21);
			
			Label label_4 = new Label(displayEmployee, SWT.NONE);
			label_4.setText("Name:");
			label_4.setBounds(10, 51, 55, 15);
			
			Label label_5 = new Label(displayEmployee, SWT.NONE);
			label_5.setText("ID:");
			label_5.setBounds(10, 24, 55, 15);
			
			btnReloadEmployee = new Button(compositeEmployee, SWT.NONE);
			btnReloadEmployee.setText("R");
			btnReloadEmployee.setBounds(309, 10, 21, 21);
			
			btnDeleteEmployee = new Button(compositeEmployee, SWT.NONE);
			btnDeleteEmployee.setText("DELETE");
			btnDeleteEmployee.setBounds(336, 466, 100, 37);
			
			btnSaveEmployee = new Button(compositeEmployee, SWT.NONE);
			btnSaveEmployee.setText("SAVE");
			btnSaveEmployee.setBounds(442, 466, 100, 37);
			
			btnAddNewEmployee = new Button(compositeEmployee, SWT.NONE);
			btnAddNewEmployee.setText("ADD AS NEW");
			btnAddNewEmployee.setBounds(646, 466, 100, 37);
			
			btnEditEmployee = new Button(compositeEmployee, SWT.NONE);
			btnEditEmployee.setBounds(548, 466, 92, 37);
			btnEditEmployee.setText("EDIT");
			
			tbtmContractors = new TabItem(tabFolder, SWT.NONE);
			tbtmContractors.setText("Contractors");
			
			tbtmOffers = new TabItem(tabFolder, SWT.NONE);
			tbtmOffers.setText("Offers");
			
			tbtmLocations = new TabItem(tabFolder, SWT.NONE);
			tbtmLocations.setText("Locations");
			
			compositeLocations = new Composite(tabFolder, SWT.NONE);
			tbtmLocations.setControl(compositeLocations);
			   
			searchLocation = new Text(compositeLocations, SWT.BORDER);
			searchLocation.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent arg0) {
					searchLocations();
				}
			});
			searchLocation.setBounds(10, 10, 299, 21);
			   
			listLocation = new List(compositeLocations, SWT.BORDER);
			listLocation.setBounds(10, 37, 320, 466);
			   
			displayLocation = new Group(compositeLocations, SWT.NONE);
			displayLocation.setBounds(336, 10, 410, 450);
			   
			txtLocationAddress = new Text(displayLocation, SWT.BORDER);
			txtLocationAddress.setBounds(81, 72, 319, 79);
			   
			txtLocationName = new Text(displayLocation, SWT.BORDER);
			txtLocationName.setBounds(81, 21, 319, 21);
			   
			txtLocationID = new Text(displayLocation, SWT.BORDER);
			txtLocationID.setBounds(81, 45, 185, 21);
			   
			Label txtName = new Label(displayLocation, SWT.NONE);
			txtName.setText("Name:");
			txtName.setBounds(10, 24, 55, 15);
			   
			Label txtID = new Label(displayLocation, SWT.NONE);
			txtID.setText("ID:");
			txtID.setBounds(10, 48, 55, 15);
			   
			Label lblAddress = new Label(displayLocation, SWT.NONE);
			lblAddress.setText("Address:");
			lblAddress.setBounds(10, 75, 65, 15);
			   
			btnReloadLocation = new Button(compositeLocations, SWT.NONE);
			btnReloadLocation.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					searchLocation.setText("");
					searchLocations();
				}
			});
			btnReloadLocation.setText("R");
			btnReloadLocation.setBounds(309, 10, 21, 21);
			   
			btnDeleteLocation = new Button(compositeLocations, SWT.NONE);
			btnDeleteLocation.setText("DELETE");
			btnDeleteLocation.setBounds(434, 466, 100, 37);
			   
			btnSaveLocation = new Button(compositeLocations, SWT.NONE);
			btnSaveLocation.setText("SAVE");
			btnSaveLocation.setBounds(540, 466, 100, 37);
			   
			btnAddNewLocation = new Button(compositeLocations, SWT.NONE);
			btnAddNewLocation.setText("ADD AS NEW");
			btnAddNewLocation.setBounds(646, 466, 100, 37);
		//}
		//if(Ucontrol.getUser().isAdmin()) {
			tbtmAdmin = new TabItem(tabFolder, SWT.NONE);
			tbtmAdmin.setText("Administration");
			
			tbtmCurrentUser = new TabItem(tabFolder, SWT.NONE);
			tbtmCurrentUser.setText("Current User");
			
			composite_1 = new Composite(tabFolder, SWT.NONE);
			tbtmCurrentUser.setControl(composite_1);
		//}
	}
	
	
	// Product screen functions
	public void showProductDetails() {
		System.out.println("MainApp - Product - List item selected: " + listProduct.getSelection()[0]);
		int ID = findNextValidInteger(listProduct.getSelection()[0]);
		System.out.println("MainApp - Product - Selected item ID: " + ID);
		Product p = LocationControl.getInstance().getProduct(ID);
		
		displayProduct.setText(p.getID() + " - " + p.getName());
		
		txtProductName.setText(p.getName() + "");
		txtProductID.setText(p.getID() + "");
		txtProductDescription.setText(p.getDescription() + "");
		txtProductDepot.setText(LocationContainer.getInstance().getLocation(p).getName() + LocationContainer.getInstance().getLocation(p).getAddress());
	}
	
	public void searchProducts() {
		listProduct.removeAll();
		for(Product p:LocationControl.getInstance().searchProducts(searchProduct.getText())) {
			listProduct.add(p.getID() + "    " + p.getName());
		}

	}
	
	public void showLocationDetails() {
		
	}
	
	public void searchLocations() {
		listLocation.removeAll();
		for(Location l:LocationControl.getInstance().searchLocations(searchLocation.getText())) {
			listLocation.add(l.getID() + "    " + l.getName() + " " + l.getAddress());
		}
	}
	
	public void showOrderDetails() {
		
	}
	
	public void searchOrders() {
		listOrders.removeAll();
		for(Order r:OrderControl.getInstance().searchOrders(searchOrder.getText())) {
			listOrders.add(r.getID() + "    " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(r.getOrderDate().getTime()));
		}
	}
	
	public void showCustomerDetails() {
		
	}
	
	public void searchCustomers() {
		
	}
	
	public void showEmployeeDetails() {
		
	}
	
	public void searchEmployees() {
		
	}
	
	
	public static int findNextValidInteger(String s) {
		// detect 1st digit after start of string
		int beginIndex=0;
		int endIndex=1;
		int length=s.length();
		while(!s.substring(beginIndex,endIndex).matches("\\d")) {
			beginIndex++;
			endIndex++;
			if(endIndex>length) {
				endIndex = 0;
				break;
			}
		}
		
		int i_startNumber= beginIndex;

		beginIndex=i_startNumber;
		endIndex=i_startNumber+1;
		while(s.substring(beginIndex,endIndex).matches("\\d")) {
			beginIndex++;
			endIndex++;
			if(endIndex>length) {
				break;
			}
		}
		int i_endNumber= beginIndex;
		// return absolute value of integer
		return Integer.valueOf(s.substring(i_startNumber, i_endNumber));
		}
	
	public void printBarcode() {
		int size = 256;
		
		BitMatrix bm = null;
		
		try {
			bm = new com.google.zxing.qrcode.QRCodeWriter().encode(txtProductID.getText(), BarcodeFormat.QR_CODE, size, size);
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
