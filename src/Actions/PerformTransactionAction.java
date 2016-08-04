package Actions;



import Menus.PerformTransactionMenu;
import dataManager.DMComponent;

/**
 * This class get the menu for performing a buy or sell transaction 
 * @author carlosgrivera
 *
 */
public class PerformTransactionAction implements Action{

	/**
	 * This method executes the action of getting the transaction submenu 
	 */
	@Override
	public void execute(Object args) {
		// TODO Auto-generated method stub
		DMComponent dm = (DMComponent) args; 
		dm.getMenuStack().push(PerformTransactionMenu.getPerformTransactionMenu()); 
	}

}
