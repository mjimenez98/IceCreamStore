// --------------------------------------------------------
// Assignment 4
// Written by: Miguel Jimenez 40022302
// For COMP 248 Section EE – Fall 2016
// --------------------------------------------------------
/* Stores a ShoppingCart and interacts with the customer through a set of predefined menus. 
 * The main menu displayed by IceCreamStore provides options that allow customers to print, 
 * price, or revise the ice cream orders in their cart, or to add new orders to or remove existing orders from their cart. */
// --------------------------------------------------------

public class IceCreamStore {
	
	//Array with the options for the main menu.
	private String[] mainMenu = { "Place an order", 
			  					"Delete an order",
			  					"Price the cart",
			  					"List the cart",
			  					"Proceed to checkout",
			  					"Exit this menu"
	}; 
	
	Menu menu = new Menu(mainMenu);				//Creates a new menu with the mainMenu options.
	ShoppingCart cart = new ShoppingCart();		//Creates a new ShoppingCart.
	
	private int numOrders = 0;					//Tracks the number of orders.
	
	//Creates an order using IceCreamOrder’s default constructor and places that order in the cart.
	public void placeOrder() {

		//If the cart is not full.
		if(!cart.isFull()) {
		
			IceCreamOrder newOrder = new IceCreamOrder();	//Creates new order.
			cart.add(newOrder);								//Adds the order to the cart.
			
			//Adds 1 to the number of orders if order is valid.
			if(newOrder.getQuantity() != 0) {
				
				numOrders++; 								
				menu.setTopMessage("Your shopping cart contains " + numOrders + " ice cream order(s)");
				menu.setTopPrompt("What would you like to do?");
				menu.setBottomMessage(null);
				
			}
			
			//If the cart is now full with the new order that has been created.
			if(cart.isFull()) {
				
				menu.setTopMessage("Your Shopping Cart is full with " + numOrders + 
									" ice cream orders.");
				menu.setTopPrompt("Cannot place orders! What would you like to do?");
				menu.setBottomMessage("Please select option 2, 3, 4, 5, or 6");
				
			}
		
		}
		
	}
	
	//Displays a list of all of the orders in the cart as options, prompts for and reads the option number associated with the order to be deleted, 
	//and then removes that order from the cart.
	public void deleteOrder() {
		
		//This string will be passed on to a menu, so the user selects which order to delete.
		String[] orders_inCart = new String[cart.size()+1];
		
		//Fills the new array with the toString of the orders in the cart. After that, it adds "Exit this menu" as an option.
		for(int i=0; i<1+cart.size(); i++) {
			
			if(cart.get(i) != null)
				orders_inCart[i] = cart.get(i).toString();
			
			else {
				
				orders_inCart[i] = "Exit this menu";
				break;
				
			}
		}
		
		//If shopping cart is not empty.
		if(!cart.isEmpty()) {
			
			//New menu with the orders to be deleted.
			Menu toDelete = new Menu(orders_inCart);
			
			toDelete.setTopMessage("You have selected to remove an order from your cart");
			toDelete.setTopPrompt("What would you like to do?");
			
			int selection = toDelete.getOptionNumber();		//Option selected from the menu by the user.
			
			//If the option selected is not "Exit this menu".
			if(orders_inCart[selection-1].length() == 14) {
	
				menu.setTopMessage("Your shopping cart contains " + numOrders + " ice cream order(s)");
				menu.setTopPrompt("What would you like to do?");
				menu.setBottomMessage(null);
	
			}
	
			else {
	
				cart.remove(selection);
				numOrders--;
	
				System.out.println("The order you selected was deleted\n");
				
				menu.setTopMessage("Your shopping cart contains " + numOrders + " ice cream order(s)");
	
				//If the cart is now empty.
				if(cart.isEmpty()) {
	
					menu.setTopMessage("Your Shopping Cart is empty.");
					menu.setTopPrompt("You have only two options: 1 or 6");
					menu.setBottomMessage("Please enter 1 or 6");
				}
				
			}	
		}
	}
	
	//Returns the total price of all the items in the cart.
	public double computeTotalPrice() {
		
		double total = 0;
		
		for(int i=0; i<cart.size(); i++) {
			
			if(cart.get(i) != null)
				total += cart.get(i).price();
		}
		
		return total;	
	}
	
	//Prints the total price of all the items in the cart.
	public void printTotalPrice() {
		
		//If shopping cart is not empty.
		if(!cart.isEmpty()) {
		
			System.out.println("------------------------------------=");
			System.out.println("Total price of all your orders in the cart: $" + computeTotalPrice());
			System.out.println("------------------------------------=\n");
		
		}
		
	}

	//Prints a complete list of all orders in the cart.
	public void reviewOrders() {
		
		//If shopping cart is not empty.
		if(!cart.isEmpty()) {
				
			System.out.println("Your current selections of our scrumptious ice creams");
			System.out.println("-----------------------------------------------------");
			System.out.println(cart.toString());
			System.out.println("-----------------------------------------------------\n");
			
		}
		
	}	
	
	//Calls reviewOrders() and then printTotalPrice().
	public void checkout() {
	
		if(!cart.isEmpty()) {
			
			System.out.println("Your current selections of our scrumptious ice creams");
			System.out.println("-----------------------------------------------------");
			System.out.println(cart.toString());
			System.out.println("-----------------------------------------------------");
			printTotalPrice();
			
		}
		
	}
	
	//Repeatedly displays the main menu and performs the user selected actions.
	public void run() {
		
		menu.setTopMessage("Your Shopping Cart is empty.");
		menu.setTopPrompt("You only have two options: 1 or 6");
		menu.setBottomMessage("Please enter 1 or 6");
		
		do {
		
			switch(menu.getOptionNumber()) {
			
				case 1:
					placeOrder();
					break;
				case 2:
					deleteOrder();
					break;
				case 3:
					printTotalPrice();
					break;
				case 4:
					reviewOrders();
					break;
				case 5:
					checkout();
					break;
				case 6:
					System.out.println("Cheers!");
					System.exit(0);
			
			}
		}
		while(true);
		
	}

}
