package Menus;

import java.util.ArrayList;

import Actions.AddCompanyAction;
import Actions.AddSharesAction;
import Actions.RemoveCompanyAction;
import Actions.ShowReportAction;

/**
 * This class creates the Administrate Companies Menu
 * @author carlosgrivera
 *
 */
public class AdministrateCompaniesMenu extends Menu {
	private static AdministrateCompaniesMenu ACM = new AdministrateCompaniesMenu(); 
	private AdministrateCompaniesMenu() { 
		super(); 
		String title; 
		ArrayList<Option> options = new ArrayList<Option>();  
		title = "Administrate Companies"; 
		options.add(new Option("Add Company", new AddCompanyAction())); 
		options.add(new Option("Remove Company", new RemoveCompanyAction())); 
		options.add(new Option("Add Shares", new AddSharesAction()));
		options.add(new Option("Show Company Report", new ShowReportAction()));
		options.add(Option.EXIT); 

		super.InitializeMenu(title, options); 

	}
	
	/**
	 * This method returns the Administrate Companies Menu 
	 * @return company menu
	 */
	public static AdministrateCompaniesMenu getAdministrateCompaniesMenu() { 
		return ACM; 
	}
}
