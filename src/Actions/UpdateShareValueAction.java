package Actions;

import ioManagement.IOComponent;

import java.io.IOException;

import dataManager.DataHandler;
import dataManager.FileHandler;

/**
 * This class performs the action of updating the value of a company's share 
 * @author carlosgrivera
 *
 */
public class UpdateShareValueAction implements Action{

	/**
	 * This method executes the action of updating the value of the share of a particular
	 * company
	 */
	@Override
	public void execute(Object args) {
		// TODO Auto-generated method stub
		float iPrice;
		IOComponent io = IOComponent.getComponent();  
		String symbol = io.getInput("Enter the symbol of the company: ");
		String price = io.getInput("Enter the price per share of the company to add: ");
		iPrice = Float.parseFloat(price);
		if(iPrice > 0){
		DataHandler.updateShareValue(symbol, iPrice);
		}else{
			System.out.println("Invalid input. Share value must be a positive number!");
		}
		try {
			FileHandler.writeCompanyData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
