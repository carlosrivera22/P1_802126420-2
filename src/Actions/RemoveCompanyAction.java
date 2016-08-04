package Actions;



import ioManagement.IOComponent;

import java.io.IOException;

import dataManager.DataHandler;
import dataManager.FileHandler;


/**
 * This method performs the action of removing a company from the project.
 * @author carlosgrivera
 *
 */
public class RemoveCompanyAction implements Action{
	/**
	 * This method executes the action of removing the company from the project
	 */
	@Override
	public void execute(Object args) {
		// TODO Auto-generated method stub
		IOComponent io = IOComponent.getComponent(); 
		String symbol = io.getInput("Stock symbol of company to remove: ");
		DataHandler.removeCompany(symbol);
		try {
			FileHandler.cleanCompanyFile();
			FileHandler.writeCompanyData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
