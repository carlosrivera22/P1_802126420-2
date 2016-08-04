package Actions;



import ioManagement.IOComponent;
import dataManager.DataHandler;

/**
 * This class performs the action of showing a company's report
 * @author carlosgrivera
 *
 */
public class ShowReportAction implements Action{

	/**
	 * This method executes the action of showing name of the company, stock symbol, 
	 * number of shares, price per share, and the number of shares that are currently 
	 * sold to shareholders.
	 */
	@Override
	public void execute(Object args) {
		// TODO Auto-generated method stub
		IOComponent io = IOComponent.getComponent(); 
		String symbol = io.getInput("Enter the company symbol: ");
		System.out.println(DataHandler.showReportOfCompany(symbol));
	}

}
