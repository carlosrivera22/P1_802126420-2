package Menus;

import java.util.ArrayList;

import Actions.AdministrateCompaniesAction;
import Actions.AdministrateShareholdersAction;
import Actions.AdministrationStocksAction;
import Actions.PerformTransactionAction;

/**
 * This class created the main menu of the project
 * @author carlosgrivera
 *
 */
public class MainMenu extends Menu {
	private static final MainMenu MM = new MainMenu(); 
	private MainMenu() { 
		super(); 
		String title; 
		ArrayList<Option> options = new ArrayList<Option>();  
		title = "Main Menu"; 
		options.add(new Option("Administrate Companies", new AdministrateCompaniesAction())); 
		options.add(new Option("Administrate Shareholders", new AdministrateShareholdersAction())); 
		options.add(new Option("Administrate Stocks", new AdministrationStocksAction())); 
		options.add(new Option("Perform Buy/Sell Transaction", new PerformTransactionAction())); 
		options.add(Option.EXIT); 

		super.InitializeMenu(title, options); 
	}
	
	/**
	 * This method gets the main menu of the project 
	 * @return main menu of project
	 */
	public static MainMenu getMainMenu() { 
		return MM; 
	}
}
