package Actions;

import ioManagement.IOComponent;

import java.io.IOException;

import dataManager.DataHandler;
import dataManager.FileHandler;

/**
 * This class performs the action of buying shares from a company
 * @author carlosgrivera
 *
 */
public class BuyAction implements Action{
	/**
	 * This method executes the action of buying shares from a company
	 */
	@Override
	public void execute(Object args) {
		// TODO Auto-generated method stub
		IOComponent io = IOComponent.getComponent(); 
		
		String id = io.getInput("Enter the user ID: ");
		String symbol = io.getInput("Enter the company symbol: ");
		String amount = io.getInput("Enter the number of shares to buy: ");
		int ID = Integer.parseInt(id);
		int iAmount = Integer.parseInt(amount);
		
		DataHandler.buyShares(ID, symbol, iAmount);
		try {
			FileHandler.cleanCompanyFile();
			FileHandler.writeCompanyData();
			FileHandler.writeTransactionData();
			FileHandler.writeShareData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
