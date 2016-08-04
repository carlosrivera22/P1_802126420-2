package Actions;



import ioManagement.IOComponent;

import java.io.IOException;

import dataManager.DataHandler;
import dataManager.FileHandler;
/**
 * This class performs the action of removing a shareholder from the program
 * @author carlosgrivera
 *
 */
public class RemoveShareholderAction implements Action{

	/**
	 * This method executes the action of removing a shareholder from the program 
	 */
	@Override
	public void execute(Object args) {
		// TODO Auto-generated method stub
		IOComponent io = IOComponent.getComponent();  
		String id = io.getInput("Enter the number ID of the shareholder to remove: ");
		int ID = Integer.parseInt(id);
		DataHandler.removeShareholder(ID);
		try {
			FileHandler.writeShareholderData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
