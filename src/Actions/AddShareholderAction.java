package Actions;



import ioManagement.IOComponent;

import java.io.IOException;

import dataManager.DataHandler;
import dataManager.FileHandler;

/**
 * This class performs the action of adding a shareholder to the program 
 * @author carlosgrivera
 *
 */
public class AddShareholderAction implements Action{

	/**
	 * This method executes the action of adding a shareholder
	 */
	@Override
	public void execute(Object args) {
		// TODO Auto-generated method stub
		IOComponent io = IOComponent.getComponent(); 
		
		
		String name = io.getInput("Enter the name of the shareholder to add: ");
		DataHandler.addShareholder(name);
		
		try {
			FileHandler.writeShareholderData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
