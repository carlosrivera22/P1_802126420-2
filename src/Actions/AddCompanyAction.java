package Actions;



import ioManagement.IOComponent;

import java.io.IOException;

import classes.Company;
import dataManager.DataHandler;
import dataManager.FileHandler;


/**
 * This class performs the action of adding a company in the program.
 * @author carlosgrivera
 *
 */
public class AddCompanyAction implements Action{
	/**
	 * This method performs the action 
	 */
	@Override
	public void execute(Object args){
		// TODO Auto-generated method stub
		IOComponent io = IOComponent.getComponent(); 
		
		int iAmount;
		float iPrice;
		String symbol;
		
		String name = io.getInput("Enter the name of the company to add: ");
		do{
		 symbol = io.getInput("Enter the symbol of the company to add: ");
		 if(!isAlpha(symbol) || symbol.length() < 3 || symbol.length() > 5){
			 System.out.println("Invalid input, try again! Symbol must be 3-5 letters");
		 }
		}while(!isAlpha(symbol) || symbol.length() < 3 || symbol.length() > 5);
		
		do{
		String amount = io.getInput("Enter the amount of shares of the company to add: ");
		 iAmount = Integer.parseInt(amount);
		 if(iAmount < 10000){
			 System.out.println("Invalid input, try again! Amount must be at least 10000");
		 }
		}while(iAmount < 10000);
		
		do{
		String price = io.getInput("Enter the price per share of the company to add: ");
		iPrice = Float.parseFloat(price);
		if(iPrice <= 0){
			System.out.println("Invalid input, try again!");
		}
		}while(iPrice <= 0);
		
		Company c = new Company(name,symbol,iAmount,iPrice);
		DataHandler.addCompany(c);
		try {
			FileHandler.writeCompanyData();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This method determines if the input provided contains only letters. 
	 * @param name the input to be tested 
	 * @return - true if it String only contains letters, false if it contains at least 
	 * one non-letter element
	 */
	public static boolean isAlpha(String name) {
	    char[] chars = name.toCharArray();
	    for (char c : chars) {

	        if(!Character.isLetter(c)) {
	            return false;
	        }
	    }
	    return true;
	}
}
