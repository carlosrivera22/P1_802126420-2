package Menus;

import Actions.Action;
import Actions.ExitAction;

/**
 * Defines the types of options that a menu contains. An object
 * of this type contains a description string (wht the menu displays
 * corresponding to that particular option) and an associated 
 * action (another object, of type Action)
 * @author carlosgrivera
 *
 */
public class Option {
	public static final Option EXIT = 
			new Option("Exit", new ExitAction()); 
	private String description; 
	private Action action; 
	
	/**
	 * Constructor for Option object 
	 * @param description describes the option to be executed
	 * @param action the action that will be executed if said option is selected
	 */
	public Option(String description, Action action) { 
		this.description = description; 
		this.action = action; 
	}

	/**
	 * This method gets the description of the action from the option object
	 * @return description of the option in the menu
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method gets the action that will be executed from said option 
	 * @return action selected by option
	 */
	public Action getAction() {
		return action;
	}

}
