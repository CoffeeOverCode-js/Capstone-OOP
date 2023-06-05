package customer;

public class Restaurant {
	protected String restaurantName;
	protected String order;
	protected String specialInstructions;
	protected String driverName;
		
	public Restaurant(String restaurantName, String order, String specialInstructions, String driverName) {
		this.restaurantName = restaurantName;
		this.order = order;
		this.specialInstructions = specialInstructions;
		this.driverName = driverName;
	}
}
