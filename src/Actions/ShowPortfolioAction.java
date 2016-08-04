package Actions;



import ioManagement.IOComponent;
import dataManager.DataHandler;

/**
 * This class performs the action of showing the shareholder's 
 * portfolio
 * @author carlosgrivera
 *
 */
public class ShowPortfolioAction implements Action{

	/**
	 * This method executes the action of showing the shareholder name, 
	 * company stocks and shares owned
	 */
	@Override
	public void execute(Object args) {
		// TODO Auto-generated method stub
		IOComponent io = IOComponent.getComponent();  
		String id = io.getInput("Enter the id of the shareholder: ");
		int ID = Integer.parseInt(id);
		System.out.println(DataHandler.showShareholderPortfolio(ID));
		
	}

}
