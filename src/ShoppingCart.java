// --------------------------------------------------------
// Assignment 4
// Written by: Miguel Jimenez 40022302
// For COMP 248 Section EE – Fall 2016
// --------------------------------------------------------
/* The class ShoppingCart represents and stores IceCreamOrders in a cart using a regular Java array as its underlying storage. */
// --------------------------------------------------------

public class ShoppingCart {
		
	private IceCreamOrder[] cart;	//Array of orders.
	
	//Default constructor. The cart capacity has been limited to 5 IceCreamOrders.
	public ShoppingCart() {
		
		cart = new IceCreamOrder[3];
	}
	
	//Adds an order to the cart.
	public void add(IceCreamOrder order) {
		
		boolean stop = false;
		
		if(order.getVessel() != null || order.toString().length() == 14) {

			for(int i=0; i<cart.length; i++) {

				if(cart[i] == null && !stop) {

					cart[i] = order;
					stop = true;

				}
			}
		}
	}
	
	//Deletes an order to the cart.
	public void remove(int selection) {
		
		if(cart[selection-1] != null && (selection<cart.length-1 && selection>0)) {
			
			cart[selection-1] = null;
			
			for(int i=selection-1; i<cart.length-selection; i++) {
				
				cart[i] = cart[i+1];
				cart[i+1] = null;
				
			}
		}
	}		
	
	public String toString() {
		
		String print = "";
		
		for(int i=0; i<cart.length; i++) {
			
			if(cart[i] != null)
				print += cart[i].toString();
			
			if(i<cart.length-1 && cart[i+1] != null)
				print += "\n";
				
		}
		
		return print;	
	}
	
	//Determines whether this cart is empty.
	public boolean isEmpty() {
		
		if(cart[0] == null)
			return true;
		
		else
			return false;

	}
	
	//Determines whether this cart is full.
	public boolean isFull() {
		
		boolean isFull = false;
		
		for(int i=0; i<cart.length; i++) {
			
			if(cart[i] != null)
				isFull = true;
			
			else {
				
				isFull = false;
				break;
			}
				
		}
		
		return isFull;
	}

	//Returns the order placed at the supplied position in the cart. If the specified position is out of range, it ignores the request.
	public IceCreamOrder get(int selection) {
		
		if(selection == cart.length)
			return null;
		
		else
			return cart[selection];

	}
	
	//Returns the number of orders currently in the cart.
	public int size() {
		
		return cart.length;
	}
	

}
