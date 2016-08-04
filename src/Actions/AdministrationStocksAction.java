package Actions;



import Menus.AdministrationStocksMenu;
import dataManager.DMComponent;

/**
 * This class performs the action of getting the Administration of Stocks menu
 * @author carlosgrivera
 *
 */
public class AdministrationStocksAction implements Action {

	/**
	 * This method executes the action of getting the Administration of Stocks menu
	 */
	@Override
	public void execute(Object args) {
		// TODO Auto-generated method stub
		DMComponent dm = (DMComponent) args; 
		dm.getMenuStack().push(AdministrationStocksMenu.getAdministrationStocksMenu()); 
		
	}

}
