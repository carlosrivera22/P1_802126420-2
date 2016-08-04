import java.io.IOException;
import java.text.ParseException;
import java.util.Stack;

import Menus.MainMenu;
import Menus.Menu;
import Menus.Option;
import dataManager.DMComponent;
import dataManager.FileHandler;


public class p1_main {


		/**
		 * This is the main method, which starts to run the stocks and shareholder's project
		 * @param args main method argument 
		 */
		public static void main(String[] args) {
			try {
				FileHandler.readAllData();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DMComponent dm = new DMComponent(); 
			Stack<Menu> mStack = dm.getMenuStack();  
			mStack.push(MainMenu.getMainMenu()); 
			while(!mStack.empty()) {
				Option opt = mStack.peek().activate(); 
				opt.getAction().execute(dm); 
			} 
			
		}
}


