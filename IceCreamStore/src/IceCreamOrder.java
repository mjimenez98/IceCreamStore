// --------------------------------------------------------
// Assignment 4
// Written by: Miguel Jimenez 40022302
// For COMP 248 Section EE – Fall 2016
// --------------------------------------------------------
/* The class IceCreamOrder represents an ice cream order. */
// --------------------------------------------------------

public class IceCreamOrder {

	private String flavor, vessel, amount;
	private double unitPrice;
	private int quantity;
	
	//flavor: Name.
	//vessel: Container (cone, cup, sundae).
	//amount: Single, double or triple scoop.
	//unitPrice: Price per unit.
	//quantity: Desired units of this ice cream.
	
	//--------------------------------------------------------------------

	//Default constructor.
	public IceCreamOrder() {

		//Initializes the options for the flavors, creates a new menu with them and receives the one selected by the user.
		String[] options_flavors = {"Avocado", "Banana", "Chocolate", "Coffee", "Hazelnut", "Lemon", "Mango", "Mocha", "Vanilla", "Exit this menu"};
		Menu menuFlavors = new Menu(options_flavors);
		
		menuFlavors.setTopMessage("Placing an order is as easy as ABC, and D.");
		menuFlavors.setTopPrompt("Step A: Select your favorite flavour");
		
		flavor = options_flavors[menuFlavors.getOptionNumber()-1];
		
		//If the user didn't select to go back.
		if(flavor.length() != 14) {

			//Initializes the options for the vessels, creates a new menu with them and receives the one selected by the user.
			String[] options_vessels = {"Cone", "Cup", "Sundae"};
			Menu menuVessels = new Menu(options_vessels);

			menuVessels.setTopPrompt("Step B: Select a vessel for your ice cream:");

			vessel = options_vessels[menuVessels.getOptionNumber()-1];


			//Initializes the options for the desired amount of ice cream, creates a new menu with them and receives the one selected by the user.
			String[] options_amount = {"Single Scoop", "Double Scoop", "Triple Scoop"};
			Menu menuAmount = new Menu(options_amount);

			menuAmount.setTopPrompt("Step C: How much ice cream?");

			amount = options_amount[menuAmount.getOptionNumber()-1];


			//Initializes the options for the quantity, creates a new menu with them and receives the one selected by the user.
			String[] options_quantity = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
			Menu menuQuantity = new Menu(options_quantity);

			menuQuantity.setTopPrompt("Step D: How many orders of your current selection?");
			menuQuantity.setBottomPrompt("Enter how many orders: ");

			quantity = menuQuantity.getOptionNumber();


			//Makes the unitPrice equal to the right price depending on the vessel and the amount selected by the user.
			if(vessel == "Cup" && amount == "Single Scoop")
				unitPrice = 2.99;
			else if(vessel == "Cup" && amount == "Double Scoop")
				unitPrice = 3.99;
			else if(vessel == "Cup" && amount == "Triple Scoop")
				unitPrice = 4.99;

			else if(vessel == "Cone" && amount == "Single Scoop")
				unitPrice = 3.49;	
			else if(vessel == "Cone" && amount == "Double Scoop")
				unitPrice = 4.49;
			else if(vessel == "Cone" && amount == "Triple Scoop")
				unitPrice = 5.49;

			else if(vessel == "Sundae" && amount == "Single Scoop")
				unitPrice = 4.25;	
			else if(vessel == "Sundae" && amount == "Double Scoop")
				unitPrice = 5.25;
			else if(vessel == "Sundae" && amount == "Triple Scoop")
				unitPrice = 6.25;
		}
		
	}

	//Initializes the instance variables with supplied values.
	public IceCreamOrder(String flavor, String vessel, String amount, double unitPrice, int quantity) {

		this.flavor = flavor;
		this.vessel = vessel;
		this.amount = amount;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	//Delegates initialization tasks to the constructor above with quantity set to 1.
	public IceCreamOrder(String flavor, String vessel, String amount, double unitPrice) {

		this.flavor = flavor;
		this.vessel = vessel;
		this.amount = amount;
		this.unitPrice = unitPrice;
		this.quantity = 1;
	}

	public void setFlavor(String flavor) {

		this.flavor = flavor;
	}

	public String getFlavor() {

		return flavor;
	}

	public void setVessel(String vessel) {

		this.vessel = vessel;
	}

	public String getVessel() {

		return vessel;
	}

	public void setAmount(String amount) {

		this.amount = amount;
	}

	public String getAmount() {

		return amount;
	}

	public void setUnitPrice(double unitPrice) {

		this.unitPrice = unitPrice;
	}

	public double getUnitPrice() {

		return unitPrice;
	}

	public void setQuantity(int quantity) {

		this.quantity = quantity;
	}

	public double getQuantity() {

		return quantity;
	}

	//Returns the price of the order.
	public double price() {

		return quantity * unitPrice;
	}

	public String toString() {

		return quantity + " order(s) of " + amount + " of " + flavor + " ice cream in a " + vessel + " for $" + price() + " = " + quantity + " x " + unitPrice;
	}

}
