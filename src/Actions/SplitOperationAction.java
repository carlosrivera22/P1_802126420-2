package Actions;

import ioManagement.IOComponent;

import java.io.IOException;

import dataManager.DataHandler;
import dataManager.FileHandler;

/**
 * This class performs the split operation on a specific company
 * @author carlosgrivera
 *
 */
public class SplitOperationAction implements Action{
	
	/**
	 * This method executes the action of duplicating the number of shares 
	 * that the company has, assigns new value to each share equal to one 
	 * half of the original value
	 */
	@Override
	public void execute(Object args) {
		// TODO Auto-generated method stub
		IOComponent io = IOComponent.getComponent(); 
		String symbol = io.getInput("Enter the symbol of the company:");
		DataHandler.splitOperation(symbol);
		try {
			FileHandler.writeCompanyData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
