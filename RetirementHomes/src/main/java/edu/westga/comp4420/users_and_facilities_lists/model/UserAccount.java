package edu.westga.comp4420.users_and_facilities_lists.model;

/**
 * Stores the user accounts that are made.
 *
 * @author	Comp 4420
 * @version Spring 2025
 */
public final class UserAccount {   

	private final String firstName;
	private final String lastName;
	private final String email;
	
	/**
	 * Create and initialize a new user account with the provided information.
	 * 
	 * @precondition firstName != null &&
	 *				 !firstName.isEmpty() &&
	 *				 !lastName != null &&
	 * 				 !lastName.isEmpty() &&
	 * 				 !email != null &&
	 * 				 !email.isEmpty()
	 * @postcondition getFirstName() == firstName &&
	 * 				  getLastName() == lastName &&
	 * 				  getEmail() == email
	 * 
	 * @param firstName first name of the user
	 * @param lastName last name of the user
	 * @param email email of the user
	 */
	public UserAccount(String firstName, String lastName, String email) {
		if (firstName == null) {
			throw new IllegalArgumentException("Must provide a name, but first name was null.");
		}
		if (firstName.isEmpty()) {
			throw new IllegalArgumentException("Must provide a name with at least one character.");
		}
		if (lastName == null) {
			throw new IllegalArgumentException("Must provide a name, but last name was null.");
		}
		if (lastName.isEmpty()) {
			throw new IllegalArgumentException("Must provide a name with at least one character");
		}
		if (email == null) {
			throw new IllegalArgumentException("Must provide a name, but email was null.");
		}
		if (email.isEmpty()) {
			throw new IllegalArgumentException("Must provide a valid email");
		}
		if (!email.contains("@")) {
			throw new IllegalArgumentException("Email must contain @");
		}
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	/**
	 * Return the first name for the user.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the first name for the new user
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	/**
	 * Return the last name of the user
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the last name of the user
	 */
	public String getLastName() {
		return this.lastName;
	}
	
	/**
	 * Return the email of the user
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the email of the user
	 */
	public String getEmail() {
		return this.email;
	}
	
	@Override
	public String toString() {
		return "Name: " + this.firstName + " " + this.lastName + "/" + this.email;
	}
}