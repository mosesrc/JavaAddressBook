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
		this._email = id + _email;
	}
	
	//Constructors
	public Entry(String fName, String lName, long phnNum, String email) {
		set_firstName(fName);
		set_lastName(lName);
		set_phoneNumber(phnNum);
		set_email(email);
		id = count++;
		
		//call assign email
//		assignEmailId();
	}
	
	//toSting Override
	public String toString() {
		return get_firstName() + " " + get_lastName() + "\n" 
				+ get_phoneNumber() + "\n" + get_email();
	}
	
	//Methods ----->
	
//	//Assign unique ID to email
//	public void assignEmailId() {
//		HashMap<Integer, String> emailList = new HashMap<>();
//		emailList.put(getId(),get_email());
//	}
	
	
	
}