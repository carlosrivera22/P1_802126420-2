package Actions;


import Menus.AdministrateShareholdersMenu;
import dataManager.DMComponent;

/**
 * This class gets the Administrate Shareholders submenu 
 * @author carlosgrivera
 *
 */
public class AdministrateShareholdersAction implements Action {
	/**
	 * This method executes the action to access the Administrate Shareholders submenu
	 */
	@Override
	public void execute(Object args) {
		// TODO Auto-generated method stub
				DMComponent dm = (DMComponent) args; 
				dm.getMenuStack().push(AdministrateShareholdersMenu.getAdministrateShareHoldersMenu()); 
	}

}
