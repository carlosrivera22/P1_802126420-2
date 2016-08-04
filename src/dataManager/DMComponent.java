package dataManager;
import java.util.Stack;

import Menus.Menu;

/**
 * Data Manager component
 * 
 * @author carlosgrivera
 *
 * This class implements and object the groups together all the different 
 * operations with the data that is being managed by the system. In this
 * case, the different lists that the system manages. 
 */
public class DMComponent {
	private Stack<Menu> mStack;          // stack to manage actions in this system
	
	public DMComponent() { 
		mStack = new Stack<Menu>(); 
	} 
	
	
	/**
	 * Returns reference to the stack object used to manage different
	 * states of the system. 
	 * @return reference to the stack. 
	 */
	public Stack<Menu> getMenuStack() { 
		return mStack; 
	}
		
	
}
