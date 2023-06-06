package customer;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Random;

public class Methods {
	// method that writes up a invoice to a txt file called invoice.txt
	public static String getInvoice(String fullname, int orderNo, String Email, String phoneNo, String city,
			String restaurantName, String order, String specialInstructions, String location, String driver,
			String Suburb, String Restaurantphoneno, String street) {
		String invoice = fullname;
		int OrderNo = orderNo;
		// if method call to phoneNoValidator is true then phone No are valid
		// else they are not so the getInvoice method will not run
		if (phoneNoValidator(phoneNo, Restaurantphoneno)) {
			invoice = "INVOICE" + "\n" + "\n" + "Order Number: " + OrderNo + "\n" + "Customer: " + fullname + "\n"
					+ "Email: " + Email + "\n" + "Phone Number: " + phoneNo + "\n" + "Location: " + city + "\n" + "\n"
					+ "\n" + "You have ordered the following from " + restaurantName + " in " + location + ": \n" + "\n"
					+ "1 x " + order + " (R78.00)\n" + "\n" + "Special Instructions: " + specialInstructions + "\n"
					+ "\n" + "Total: R80.00" + "\n" + "\n" + driver
					+ " is nearest to the restaurant and so he will be delivering your \n" + "order to you at: " + "\n"
					+ "\n" + street + "\n" + Suburb + "\n" + "\n"
					+ "If you need to contact the restaurant, their number is " + Restaurantphoneno;
			try {
				Formatter f = new Formatter("./Invoice.txt");
				// Write the formatted invoice text to the file
				f.format("%s", invoice);
				f.close();
			} catch (FileNotFoundException c) {
				System.out.println("File Not Found!!");
			}
			return invoice;
		} else {
			String phoneNoError = "Phone number can only contain digits 0-9";
			return phoneNoError;
		}

	}

	// method that takes in 2 String parameters
	public static boolean phoneNoValidator(String phoneNo, String restaurantPhoneNo) {

		boolean isPhoneNumberValid = true;
		// checks too see if the customer phoneNo has a letter
		for (char c : phoneNo.toCharArray()) {
			if (!Character.isDigit(c)) {
				isPhoneNumberValid = false;
				break;
			}
		}
		// checks to see if the restaurant phoneNo has a letter
		if (isPhoneNumberValid) {
			for (char c : restaurantPhoneNo.toCharArray()) {
				if (!Character.isDigit(c)) {
					return false;
				}
			}
		} else {
			return false;
		}
		// if both phone Numbers has no letters
		return true;
	}
	
	public static int orderNumber() {
		Random randomNum = new Random();
		int orderNo = randomNum.nextInt(100) + 1;
		return orderNo;
	}

}
