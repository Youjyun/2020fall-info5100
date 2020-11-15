
package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private String alternateEmail;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10;
	private String companySuffix = "aeycompany.com";

	// Constructor to receive the first name and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		// call a method asking for the department which is gonna return the department
		this.department = SetDepartment();
		// call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "."
				+ companySuffix;
	}

	// Ask for the department
	@SuppressWarnings("resource")
	private String SetDepartment() {
		System.out.print("New Worker: " + firstName
				+ "\nDEPARTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter the department code: ");
		Scanner in = new Scanner(System.in);
		int depchoice = in.nextInt();
		if (depchoice == 1) {
			return "Sales";
		} else if (depchoice == 2) {
			return "dev";
		} else if (depchoice == 3) {
			return "Accounting";
		} else {
			return "";
		}
	}

	// Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}

	// set mail box capacity
	public void setMailBoxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}

	// set alternative email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}

	// change password
	public void changePassword(String password) {
		this.password = password;
	}

	public int getMailCapacity() {
		return mailboxCapacity;
	}

	public String getAlternativeEmail() {
		return alternateEmail;
	}

	public String getPassword() {
		return password;
	}

	// method to display all the info
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName + "\nDEPARTMENT: " + department + "\nCOMPANY EMAIL: "
				+ email + "\nPASSWORD: " + password + "\nMAILBOX CAPACITY: " + mailboxCapacity + " mb";

	}

}