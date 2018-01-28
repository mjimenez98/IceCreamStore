// --------------------------------------------------------
// Assignment 4
// Written by: Miguel Jimenez 40022302
// For COMP 248 Section EE – Fall 2016
// --------------------------------------------------------
/* The class Menu models menus used in text-based menu-driven programs,
 * where the user is presented with a list of options to choose from. */
// --------------------------------------------------------

import java.util.Scanner;

public class Menu {

	private String topMessage, topPrompt, bottomMessage, bottomPrompt;
	private String[] menu;
	Scanner reader = new Scanner(System.in);
	
	//topMessage: Introduces the user to the menu.
	//topPrompt: Tells the user what to do.
	//bottomMessage: Displays a message after the menu has been shown.
	//bottomPrompt: Tells the user the options he or she has.
	
	//menu[]: Holds all the options for the menu.
	
	//----------------------------------------------------------------------//

	//No argument constructor.
	public Menu() {

		topMessage = null;
		topPrompt = null;
		bottomMessage = null;
		bottomPrompt = null;
	}

	//One argument constructor. Takes an array of strings.
	public Menu(String[] menu) {

		this.menu = menu;

		topMessage = null;
		topPrompt = "Choose an option:";
		bottomMessage = null;
		bottomPrompt = "Enter an option number: ";
	}

	//Displays the menu and then inputs an integer number from the keyboard. Returns the number.
	public int getOptionNumber() {

		String options = ""; //Will hold the options to be printed.

		//If the menu is not empty.
		if(length() != 0) {
			
			//Prepares the options and saves them in the string "options".
			for(int i=0; i<menu.length; i++) {
				
				if(menu[i] != null)
					options += ("     (" + (i+1) + ") " + menu[i] + "\n");
			
			}
			
		}

		//Prints the menu.
		System.out.print(getTopMessage() + getTopPrompt() + options + getBottomMessage() + getBottomPrompt());
		
		//Receives the option selected by the user.
		int n = reader.nextInt();

		//If the option list is empty, it returns the number entered.
		if(isEmpty())
			return n;
		
		//If the option is valid, the number entered will be returned.
		else if(n >= 1 && n <= length()) {
			
			System.out.println();
			return n;
		}

		//The method repeatedly displays the menu and then inputs a number until a valid option number is entered. After a valid option number has been entered, the method returns that number.
		else {

			do {

				System.out.print("\n" + getTopMessage() + getTopPrompt() + options + getBottomMessage() + getBottomPrompt());
				n = reader.nextInt();

			}
			while(n > length() || n < 1);

			return n;
		}

	}
	
	//Returns zero if the option list in this menu is null; otherwise, it returns the length of the option list in this menu.
	public int length() {

		if(menu == null)
			return 0;

		else	
			return menu.length;
	}
	
	//Determines whether the option list in this menu is null or empty.
	public boolean isEmpty() {

		return (menu == null || menu.length == 0);
	}
	
	public void setBottomMessage(String bottomMessage) {

		this.bottomMessage = bottomMessage;
	}
	
	public String getBottomMessage() {

		if(bottomMessage == null)
			return "";

		else
			return bottomMessage + "\n";
	}
	
	public void setBottomPrompt(String bottomPrompt) {

		this.bottomPrompt = bottomPrompt;
	}
	
	public String getBottomPrompt() {

		if(bottomPrompt == null)
			return "?->  ";

		else
			return "?->  " + bottomPrompt;
	}
	
	public void setTopMessage(String topMessage) {

		this.topMessage = topMessage;
	}
	
	public String getTopMessage() {

		if(topMessage == null)
			return "";

		else
			return topMessage + "\n";
	}
	
	public void setTopPrompt(String topPrompt) {

		this.topPrompt = topPrompt;
	}
	
	public String getTopPrompt() {

		if(topPrompt == null)
			return "";

		else
			return topPrompt + "\n";
	}
	
	public String toString() {

		String printOptions = "";
		for(int i=0; i<menu.length; i++)
			printOptions += ("     (" + (i+1) + ") " + menu[i] + "\n");

		return getTopMessage() + getTopPrompt() + printOptions + getBottomMessage() + getBottomPrompt();
	}

}
