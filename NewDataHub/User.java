package NewDataHub;

public class User {
	private String username;
	private String password;
	private String firstName;
	private String lastName;

	public User(String username, String password, String firstName, String lastName) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;

	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public void editProfile(String newFirstName, String newLastName, String newPassword) {
		firstName = newFirstName;
		lastName = newLastName;
		password = newPassword;
	}

	public String getWelcomeMessage() {
		return "Welcome, " + getFullName() + "!";
	}

	public boolean login(String enteredPassword) {
		return password.equals(enteredPassword);
	}

	public boolean isVIP() {
		return false;
	}

	class VIPUser extends User {
		// VIP users can access advanced functionalities

		public VIPUser(String username, String password, String firstName, String lastName) {
			super(username, password, firstName, lastName);
		}

		// Method to check if a user is VIP (always returns true for VIP users)
		@Override
		public boolean isVIP() {
			return true;
		}

		// Data visualization - Generate a pie chart (not implemented here, use a data
		// visualization library)

		// Bulk import social media posts from a CSV file

	}

}
