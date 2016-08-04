package Menus;

import java.util.ArrayList;

import Actions.ShowReportAction;
import Actions.SplitOperationAction;
import Actions.UpdateShareValueAction;

/**
 * This class creates the Administration of Stocks submenu 
 * @author carlosgrivera
 *
 */
public class AdministrationStocksMenu extends Menu{
	private static AdministrationStocksMenu ASM = new AdministrationStocksMenu(); 
	private AdministrationStocksMenu() { 
		super(); 
		String title; 
		ArrayList<Option> options = new ArrayList<Option>();  
		title = "Administrate Stocks"; 
		options.add(new Option("Split Operation", new SplitOperationAction())); 
		options.add(new Option("Update Share Value", new UpdateShareValueAction())); 
		options.add(new Option("Show Reports", new ShowReportAction()));
		options.add(Option.EXIT); 

		super.InitializeMenu(title, options); 

	}
	
	/**
	 * This method returns the Administration of Stocks Menu
	 * @return administration of stocks menu
	 */
	public static AdministrationStocksMenu getAdministrationStocksMenu() { 
		return ASM; 
	}
}
