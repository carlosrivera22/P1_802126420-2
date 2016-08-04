package Menus;

import java.util.ArrayList;

import Actions.AddShareholderAction;
import Actions.RemoveShareholderAction;
import Actions.ShowPortfolioAction;

/**
 * This class creates the Administrate Shareholders submenu 
 * @author carlosgrivera
 *
 */
public class AdministrateShareholdersMenu extends Menu{
	private static AdministrateShareholdersMenu ASM = new AdministrateShareholdersMenu(); 
	private AdministrateShareholdersMenu() { 
		super(); 
		String title; 
		ArrayList<Option> options = new ArrayList<Option>();  
		title = "Administrate Shareholders"; 
		options.add(new Option("Add Shareholder", new AddShareholderAction())); 
		options.add(new Option("Remove Shareholder", new RemoveShareholderAction())); 
		options.add(new Option("Show Shareholder Portfolio", new ShowPortfolioAction())); 
		options.add(Option.EXIT); 

		super.InitializeMenu(title, options); 

	}
	/**
	 * 	This method returns the Administrate Shareholders Menu 
	 * @return shareholders menu
	 */
	public static AdministrateShareholdersMenu getAdministrateShareHoldersMenu() { 
		return ASM; 
	}
}
