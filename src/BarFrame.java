
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.Toolkit;

public class BarFrame extends JFrame {
	public ArrayList<Waitresses> waitress = new ArrayList<Waitresses>();
	public ArrayList<ArrayList<String>> tables = new ArrayList<ArrayList<String>>();
	public HashMap<String, Double> products = new HashMap<String, Double>();
	public ArrayList<String> chosenProducts = new ArrayList<String>();
	

	public JPanel loginScreenPanel;
	public JPanel operationPanel;
	public JPanel tablesPanel;
	public JPanel productsPanel;
	public JPanel getBillPanel;
	public JPanel whiskeyPanel;
	public JPanel vodkaPanel;
	public JPanel winePanel;
	public JPanel beerPanel;
	public JPanel nonAlcoholPanel;

	public int operation;
	public int typeOfProduct;

	public BarFrame() {
		super("Academy Bar");
		setIconImage(Toolkit.getDefaultToolkit().getImage(BarFrame.class.getResource("/Images/academy_bar_logo.png")));
		setSize(700, 650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

		Waitresses a = new Waitresses("Kuka", "1122");
		Waitresses b = new Waitresses("Koka", "a1b2");
		Waitresses c = new Waitresses("Keka", "kekata12");

		waitress.add(a);
		waitress.add(b);
		waitress.add(c);

		for (int i = 0; i <= 6; i++) {
			tables.add(new ArrayList<String>());

		}

		products.put("Jameson 50 ml", 5.0);
		products.put("Jameson 100 ml", 10.0);
		products.put("Jameson Bottle", 60.0);
		products.put("Bushmills 50 ml", 5.0);
		products.put("Bushmills 100 ml", 10.0);
		products.put("Bushmills Bottle", 60.0);
		products.put("Paddy 50 ml", 6.0);
		products.put("Paddy 100 ml", 12.0);
		products.put("Paddy Bottle", 67.0);
		products.put("Jack 50 ml", 7.0);
		products.put("Jack 100 ml", 14.0);
		products.put("Jack Bottle", 70.0);
		products.put("Finlandia 50 ml", 3.50);
		products.put("Finlandia 100 ml", 7.0);
		products.put("Finlandia Bottle", 40.0);
		products.put("Sobieski 50 ml", 4.0);
		products.put("Sobieski 100 ml", 8.0);
		products.put("Sobieski Bottle", 54.0);
		products.put("Absolut 50 ml", 4.50);
		products.put("Absolut 100 ml", 9.0);
		products.put("Absolut Bottle", 60.0);
		products.put("Smirnoff 50 ml", 4.0);
		products.put("Smirnoff 100 ml", 8.0);
		products.put("Smirnoff Bottle", 50.0);
		products.put("Sauvignon 375 ml", 9.99);
		products.put("Sauvignon 750 ml", 19.98);
		products.put("Rosé Tangra 375 ml", 9.99);
		products.put("Rosé Tangra 375 ml", 19.98);
		products.put("Rosé Gayard 375 ml", 12.99);
		products.put("Rosé Gayard 750 ml", 24.98);
		products.put("Pixels Rosé 375 ml", 11.0);
		products.put("Pixels Rosé 750 ml", 22.0);
		products.put("Kamenitza", 1.99);
		products.put("Stela Artois", 2.49);
		products.put("Staropramen", 2.49);
		products.put("Corona Extra", 3.39);
		products.put("Becks", 2.49);
		products.put("Zagorka", 1.99);
		products.put("Guiness", 2.99);
		products.put("Shumensko", 1.99);
		products.put("Coca Cola", 1.99);
		products.put("Fanta", 1.99);
		products.put("Sprite", 1.99);
		products.put("Water", 1.50);
		products.put("Orange Fresh", 2.99);
		products.put("Nestea", 2.0);
		products.put("Coffee", 1.99);
		products.put("Cappuccino", 2.99);
		products.put("Mochaccino", 2.99);
		products.put("Turkish Coffee", 1.99);
		products.put("Decaf Coffee", 1.89);
		products.put("Ice Coffee", 2.70);

		showLoginScreen("Start");
	}

	public void showLoginScreen(String fromPanel) {
		if (fromPanel.equals("Start")) {
			loginScreenPanel = new LoginScreen(this);
			loginScreenPanel.setSize(getHeight(), getWidth());
			getContentPane().add(loginScreenPanel);
		} else if (fromPanel.equals("Whiskey Panel")) {
			whiskeyPanel.setVisible(false);
			whiskeyPanel = null;
			loginScreenPanel = new LoginScreen(this);
			loginScreenPanel.setSize(getHeight(), getWidth());
			getContentPane().add(loginScreenPanel);
		} else if(fromPanel.equals("Wine Panel")) {
			winePanel.setVisible(false);
			winePanel = null;
			loginScreenPanel = new LoginScreen(this);
			loginScreenPanel.setSize(getHeight(), getWidth());
			getContentPane().add(loginScreenPanel);
		} else if(fromPanel.equals("Beer Panel")) {
			beerPanel.setVisible(false);
			beerPanel = null;
			loginScreenPanel = new LoginScreen(this);
			loginScreenPanel.setSize(getHeight(), getWidth());
			getContentPane().add(loginScreenPanel);
		} else if(fromPanel.equals("Vodka Panel")) {
			vodkaPanel.setVisible(false);
			vodkaPanel = null;
			loginScreenPanel = new LoginScreen(this);
			loginScreenPanel.setSize(getHeight(), getWidth());
			getContentPane().add(loginScreenPanel);
		}else if(fromPanel.equals("Non Alcohol Panel")) {
			nonAlcoholPanel.setVisible(false);
			nonAlcoholPanel = null;
			loginScreenPanel = new LoginScreen(this);
			loginScreenPanel.setSize(getHeight(), getWidth());
			getContentPane().add(loginScreenPanel);
		} else if(fromPanel.equals("Operation Panel")) {
			operationPanel.setVisible(false);
			operationPanel = null;
			loginScreenPanel = new LoginScreen(this);
			loginScreenPanel.setSize(getHeight(), getWidth());
			add(loginScreenPanel);
		}

	}

	public void showOperationPanel() {
		loginScreenPanel.setVisible(false);
		loginScreenPanel = null;

		operationPanel = new OperationPanel(this);
		operationPanel.setSize(getHeight(), getWidth());
		getContentPane().add(operationPanel);
	}

	public void showTablesPanel(String from) {
		if(from.equals("Operation Panel")) {
		operationPanel.setVisible(false);
		operationPanel = null;
		} else if (from.equals("Product Panel")) {
			productsPanel.setVisible(false);
			productsPanel = null;
		}
		tablesPanel = new TablesPanel(this);
		tablesPanel.setSize(getHeight(), getWidth());
		getContentPane().add(tablesPanel);

	}

//	public void showProductsPanel(int tableNumber) {
//		
//		tablesPanel.setVisible(false);
//		tablesPanel = null;
//		
//		productsPanel = new ProductsPanel(this, tableNumber);
//		productsPanel.setSize(getHeight(), getWidth());
//		add(productsPanel);
//		
//	}
	public void getBillPanel(int tableNum) {
		tablesPanel.setVisible(false);
		tablesPanel = null;

		getBillPanel = new GetBillPanel(this, tableNum);
		getBillPanel.setSize(getHeight(), getWidth());
		getContentPane().add(getBillPanel);

	}

	public void backToWelcome() {
		productsPanel.setVisible(false);
		productsPanel = null;
		loginScreenPanel = new LoginScreen(this);
		loginScreenPanel.setSize(getHeight(), getWidth());
		getContentPane().add(loginScreenPanel);

	}

	public void welcomeFromBill() {
		getBillPanel.setVisible(false);
		getBillPanel = null;

		loginScreenPanel = new LoginScreen(this);
		loginScreenPanel.setSize(getHeight(), getWidth());
		getContentPane().add(loginScreenPanel);
	}

	public void backFromTables() {
		tablesPanel.setVisible(false);
		tablesPanel = null;

		operationPanel = new OperationPanel(this);
		operationPanel.setSize(getHeight(), getWidth());
		getContentPane().add(operationPanel);
	}

	public void changeToProductPanel(int tableNum, String fromWhichPanel) {
		if (fromWhichPanel.equals("Tables Panel")) {
			tablesPanel.setVisible(false);
			tablesPanel = null;
		} else if (fromWhichPanel.equals("Whiskey Panel")) {
			whiskeyPanel.setVisible(false);
			whiskeyPanel = null;

		} else if (fromWhichPanel.equals("Beer Panel")) {
			beerPanel.setVisible(false);
			beerPanel = null;
		} else if (fromWhichPanel.equals("Vodka Panel")) {
			vodkaPanel.setVisible(false);
			vodkaPanel = null;
		} else if (fromWhichPanel.equals("Non Alcohol Panel")) {
			nonAlcoholPanel.setVisible(false);
			nonAlcoholPanel = null;
		} else if (fromWhichPanel.equals("Wine Panel")) {
			winePanel.setVisible(false);
			winePanel = null;
		}
		productsPanel = new ProductsPanel(this, tableNum);
		productsPanel.setSize(getHeight(), getWidth());
		getContentPane().add(productsPanel);
	}

	public void changeToHome(String panelName) {
		if (panelName.equals("Whiskey Panel")) {
			whiskeyPanel.setVisible(false);
			whiskeyPanel = null;
		} else if (panelName.equals("Vodka Panel")) {
			vodkaPanel.setVisible(false);
			vodkaPanel = null;
		} else if (panelName.equals("Wine Panel")) {
			winePanel.setVisible(false);
			winePanel = null;
		} else if (panelName.equals("Beer Panel")) {
			beerPanel.setVisible(false);
			beerPanel = null;
		} else if (panelName.equals("Non Alcohol Panel")) {
			nonAlcoholPanel.setVisible(false);
			nonAlcoholPanel = null;
		}
		operationPanel = new OperationPanel(this);
		operationPanel.setSize(getHeight(), getWidth());
		getContentPane().add(operationPanel);
	}

	public void showSelectedProductPanel(String productName, int tableNum) {
		productsPanel.setVisible(false);
		productsPanel = null;

		if (productName.equals("Whiskey")) {
			whiskeyPanel = new WhiskeyPanel(this, tableNum);
			whiskeyPanel.setSize(getWidth(), getHeight());
			getContentPane().add(whiskeyPanel);

		} else if (productName.equals("Vodka")) {
			vodkaPanel = new VodkaPanel(this, tableNum);
			vodkaPanel.setSize(getHeight(), getWidth());
			getContentPane().add(vodkaPanel);
		} else if (productName.equals("Wine")) {
			winePanel = new WinePanel(this, tableNum);
			winePanel.setSize(getHeight(), getWidth());
			getContentPane().add(winePanel);
		} else if (productName.equals("Beer")) {
			beerPanel = new BeerPanel(this, tableNum);
			beerPanel.setSize(getHeight(), getWidth());
			getContentPane().add(beerPanel);
		} else if (productName.equals("Non Alcohol")) {
			nonAlcoholPanel = new NonAlcoholPanel(this, tableNum);
			nonAlcoholPanel.setSize(getHeight(), getWidth());
			getContentPane().add(nonAlcoholPanel);
		}
	}
}
