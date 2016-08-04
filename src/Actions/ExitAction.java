package Actions;

import dataManager.DMComponent;

/**
 * This class performs the exit action from the current menu, if the menu is the Main Menu
 * it stops the execution of the program.
 * @author carlosgrivera
 *
 */
public class ExitAction implements Action {

	/**
	 * Executes the exit action
	 */
	@Override
	public void execute(Object arg) {
		DMComponent dm = (DMComponent) arg; 
		dm.getMenuStack().pop(); 
	}

}
