package Menus;

import java.util.ArrayList;

import Actions.BuyAction;
import Actions.SellAction;

/**
 * This class creates the perform transaction menu 
 * @author carlosgrivera
 *
 */
public class PerformTransactionMenu extends Menu {
	private static PerformTransactionMenu PTM = new PerformTransactionMenu(); 
	private PerformTransactionMenu() { 
		super(); 
		String title; 
		ArrayList<Option> options = new ArrayList<Option>();  
		title = "Perform Transaction"; 
		options.add(new Option("Buy", new BuyAction())); 
		options.add(new Option("Sell", new SellAction())); 
		options.add(Option.EXIT); 

		super.InitializeMenu(title, options); 

	}
	
	/**
	 * This method returns the perform transaction submenu 
	 * @return perform transaction submenu
	 */
	public static PerformTransactionMenu getPerformTransactionMenu() { 
		return PTM; 
	}
}

