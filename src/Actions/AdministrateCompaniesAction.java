package Actions;



import Menus.AdministrateCompaniesMenu;
import dataManager.DMComponent;

/**
 * This class accesses the Administrate Companies Menu in the project
 * @author carlosgrivera
 *
 */
public class AdministrateCompaniesAction implements Action {
	/**
	 * This method executes the action of accessing the Administrate Companies Submenu
	 */
	@Override
	public void execute(Object args) {
		// TODO Auto-generated method stub
		DMComponent dm = (DMComponent) args; 
		dm.getMenuStack().push(AdministrateCompaniesMenu.getAdministrateCompaniesMenu()); 
	}

}
