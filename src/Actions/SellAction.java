package Actions;

import ioManagement.IOComponent;

import java.io.IOException;

import dataManager.DataHandler;
import dataManager.FileHandler;

/**
 * This class performs action of selling shares to a particular company
 * @author carlosgrivera
 *
 */
public class SellAction implements Action{

	/**
	 * This method executes the action of selling shares to a particular company from a specific 
	 * shareholder
	 */
	@Override
	public void execute(Object args) {
		// TODO Auto-generated method stub
				IOComponent io = IOComponent.getComponent(); 
				String id = io.getInput("Enter the user ID: ");
				String symbol = io.getInput("Enter the company symbol: ");
				String amount = io.getInput("Enter the number of shares to sell: ");
				int ID = Integer.parseInt(id);
				int iAmount = Integer.parseInt(amount);
				DataHandler.sellShare(ID, symbol, iAmount);
				try {
					FileHandler.cleanCompanyFile();
					FileHandler.cleanSharesFile();
					FileHandler.writeCompanyData();
					FileHandler.writeTransactionData();
					FileHandler.writeShareData();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	}

}
