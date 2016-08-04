package Actions;



import ioManagement.IOComponent;

import java.io.IOException;

import dataManager.DataHandler;
import dataManager.FileHandler;
/**
 * This method performs the action of adding a share to the program
 * @author carlosgrivera
 *
 */
public class AddSharesAction implements Action{
	
	/**
	 * This method executes the action of adding a share 
	 */
	@Override
	public void execute(Object args) {
		// TODO Auto-generated method stub
		int iAmount;
		IOComponent io = IOComponent.getComponent(); 
		
		String symbol = io.getInput("Enter the symbol of the company: ");
	
		String amount = io.getInput("Enter the amount of shares to be added: ");
		iAmount = Integer.parseInt(amount);
		if(iAmount > 0){
		DataHandler.addShareToCompany(symbol, iAmount);
		}else{
			System.out.println("Invalid input. Number of shares must be positive!");
		}
		try {
			FileHandler.writeCompanyData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
