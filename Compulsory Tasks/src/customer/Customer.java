package customer;
//create a customer class that initializes the values
public class Customer {
	protected String orderNo;
	protected String firstName;
	protected String lastName;
	protected String email;
	protected String phoneNo;
	protected String location;

	public Customer(String orderNo, String firstName, String lastName, String email, String phoneNo, String location) {
		this.orderNo = orderNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.location = location;
	}
	//method that concatenates the first name and second name together to get the full name
	public static String getfullName(String fname, String lname) {
		String fullName = fname + " " + lname;
		return fullName;
	}

	public String getName(String name) {
		return name;
	}

	public String getSurname(String surname) {
		return surname;
	}
}
