import java.util.HashMap;

public class Entry {
	
	//Entry Variables
	private String _firstName;
	private String _lastName;
	private long _phoneNumber;
	private String _email;
	private static int count = 0;
	private int id = 0;
	
	//Getters and Setters
	public int getId() {
		return id;
	}
	
	public String get_firstName() {
		return _firstName;
	}
	public void set_firstName(String _firstName) {
		this._firstName = _firstName;
	}
	public String get_lastName() {
		return _lastName;
	}
	public void set_lastName(String _lastName) {
		this._lastName = _lastName;
	}
	public long get_phoneNumber() {
		return _phoneNumber;
	}
	public void set_phoneNumber(long _phoneNumber) {
		this._phoneNumber = _phoneNumber;
	}
	public String get_email() {
		return _email;
	}
	public void set_email(String _email) {
		this._email = _email;
	}
	
	//Constructors
	public Entry() {
		
	}
	
	public Entry(String fName, String lName, long phnNum, String email) {
		set_firstName(fName);
		set_lastName(lName);
		set_phoneNumber(phnNum);
		set_email(email);
		id = count++;

	}
	
	//toSting Override
	public String toString() {
		return "First Name: " + get_firstName() + "\n" +
			   "Last Name: "+ get_lastName() + "\n" +
			   "Phone Number: " + get_phoneNumber() + "\n" +
			   "Email: " + get_email();
	}
	
}
