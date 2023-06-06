package customer;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);

		String[] prompts = { "name", "surname", "email address", "phone number", "city" };
		String[] values = new String[5];

		for (int i = 0; i < prompts.length; i++) {
			System.out.println("Enter your " + prompts[i] + ":");
			values[i] = input.nextLine();

		}

		// Access the inputs using the values array
		String name = values[0];
		String surname = values[1];
		String email = values[2];
		String phoneNo = values[3];
		String city = values[4];

		System.out.println();

		// creates a customer object
		Customer newCustomer = new Customer(Methods.orderNumber(), name, surname, email, phoneNo, city);

		String names = Customer.getfullName(newCustomer.firstName, newCustomer.lastName);
		int orderNo = newCustomer.orderNo;
		
		ArrayList<String> drivers = new ArrayList<String>();
		
		try {
			File driver = new File("./drivers.txt");
			Scanner driverScan = new Scanner(driver);

			while (driverScan.hasNextLine()) {
				String Line = driverScan.nextLine();
				drivers.add(Line);
			}
			driverScan.close();

			System.out.println();

		} catch (FileNotFoundException e) {
			System.out.println("txt File Not Found");
		}

		Scanner restaurantInput = new Scanner(System.in);

		String[] restaurantPrompts = { "Restaurant Name", "Order", "Special Instructions", "Restaurant City",
				"Restaurant Phone No", "Restaurant Street Name and No.", "Restaurant Suburb" };
		String[] restaurantValues = new String[7];

		for (int i = 0; i < restaurantPrompts.length; i++) {
			System.out.println("Enter your " + restaurantPrompts[i] + ":");
			restaurantValues[i] = restaurantInput.nextLine();
		}
		// Stores the connected information into variables
		String restaurantName = restaurantValues[0];
		String order = restaurantValues[1];
		String specialInstructions = restaurantValues[2];
		String restaurantArea = restaurantValues[3];
		String restaurantPhoneNo = restaurantValues[4];
		String restaurantStreet = restaurantValues[5];
		String restaurantSuburb = restaurantValues[6];

		System.out.println();

		String driverInfo[] = new String[drivers.size()];
		String deliveries[] = new String[drivers.size()];
		String location[] = new String[drivers.size()];
		String driversName[] = new String[drivers.size()];

		// splits the drivers into parts
		for (int i = 0; i < drivers.size(); i++) {
			driverInfo = drivers.get(i).split(",");
			deliveries[i] = driverInfo[2].trim();
			location[i] = driverInfo[1].trim();
			driversName[i] = driverInfo[0];
		}

		System.out.println();

		ArrayList<String> locationList = new ArrayList<String>();
		ArrayList<Integer> locationIndex = new ArrayList<Integer>();
		ArrayList<Integer> lowestDeliveries = new ArrayList<Integer>();

		// If location of Customer location does not match drivers
		boolean matchFound = false;
		for (int i = 0; i < location.length; i++) {
			if (location[i].equalsIgnoreCase(city)) {
				locationList.add(city);
				locationIndex.add(i);
				matchFound = true;
			}
		}

		if (!matchFound) {
			System.out.println("Sorry! Our drivers are too far away from you to be able to deliver to your location.");
		}

		System.out.println();

		for (Integer i : locationIndex) {
			int delivery = Integer.parseInt(deliveries[i]);
			lowestDeliveries.add(delivery);
		}

		System.out.println();

		// gets the Lowest Deliveries of the driver
		int lowest = lowestDeliveries.get(0);
		int indexofLowest = 0;
		for (int i = 1; i < lowestDeliveries.size(); i++) {
			if (lowestDeliveries.get(i) < lowest) {
				lowest = lowestDeliveries.get(i);
				indexofLowest = i;
			}
		}

		int num = locationIndex.get(indexofLowest);
		String driverName = driversName[num];

		for (int i = 0; i < 10; i++) {
			System.out.println();
		}

		String p = Methods.getInvoice(names, orderNo, email, phoneNo, city, restaurantName, order, specialInstructions,
				restaurantArea, driverName, restaurantSuburb, restaurantPhoneNo, restaurantStreet);

		System.out.println(p);

		input.close();
		restaurantInput.close();
	}
}