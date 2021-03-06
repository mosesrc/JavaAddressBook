import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class AddressBook implements Search {
	private ArrayList<Entry> entryDatabase = new ArrayList<>();
	private HashMap<String, Entry> emailList = new HashMap<>();
	Entry entryObj;
	private Scanner input = new Scanner(System.in);
	private boolean found = true;
	
	// Adding Entry
	public void addEntry() {

		// Read First Name
		System.out.print("\nFirst Name: ");
		String fName = input.next();

		// Read Last Name
		System.out.print("\nLast Name: ");
		String lName = input.next();

		// Read Phone Number
		System.out.print("\nPhone Number: ");
		long phnNum = Long.parseLong(input.next());

		// Read Email
		System.out.print("\nEmail Address: ");
		String email = input.next();
		
		entryObj = new Entry(fName, lName, phnNum, email);
		
		entryDatabase.add(entryObj);
		assignEmailId(entryObj);
		System.out.println("\nAdded new entry!\n");
			
	}
	
	//Assign unique ID to email
			public void assignEmailId(Entry e) {
				emailList.put(e.get_email(), e);
			}

	// Remove Entry -- found(boolean global variable)
	public void removeEntry() {
		System.out.print("\nEnter an entry's email to remove: ");
		String email = input.next();
		found = false;

		for (int i = 0; i < entryDatabase.size(); i++) {
			found = entryDatabase.get(i).get_email().trim().equals(email.trim());
			if (entryDatabase.get(i).get_email().trim().equals(email.trim())) {
				System.out.println("\nDeleted the following entry: \n");
				System.out.println("************\n");
				System.out.println(entryDatabase.get(i));
				System.out.println("\n************\n");
			    emailList.remove(entryDatabase.get(i).get_email());
				entryDatabase.remove(entryDatabase.get(i));
				break;
			}
		}
		String result = found ? null : "\nEntry was not found!!\n";
		if (result != null) {
			System.out.println(result);
		}
		
	}

	// Search inner methods -- found(boolean global variable)

	public void searchFName(String value) {
		found = false;
		for (Entry item : entryDatabase) {
			if (item.get_firstName().trim().contains(value.trim())) {
				found = item.get_firstName().trim().contains(value.trim());
				System.out.println("\n************\n");
				System.out.println(item);
				System.out.println("\n************\n");
			}
			String result = found ? null : "\nNo results found!!\n";
			if (result != null) {
				System.out.println(result);
			}
		}
	}

	public void searchLName(String value) {
		found = false;
		for (Entry item : entryDatabase) {
			if (item.get_lastName().trim().contains(value.trim())) {
				found = item.get_lastName().trim().contains(value.trim());
				System.out.println("************\n");
				System.out.println(item);
				System.out.println("\n************\n");
			}
		}
		String result = found ? null : "\nNo results found!!\n";
		if (result != null) {
			System.out.println(result);
		}
	}

	public void searchPhnNum(String value) {
		found = false;
		for (Entry item : entryDatabase) {
			String phnNum = Long.toString(item.get_phoneNumber());
			if (phnNum.trim().contains(value.trim())) {
				found = phnNum.trim().contains(value.trim());
				System.out.println("************\n");
				System.out.println(item);
				System.out.println("\n************\n");
			}
		}
		
		String result = found ? null : "\nNo results found!!\n";
		if (result != null) {
			System.out.println(result);
		}
	}

	public void searchEmail(String value) {
		found = false;
		for (Entry item : entryDatabase) {
			if (item.get_email().trim().contains(value.trim())) {
				found = item.get_email().trim().contains(value.trim());
				System.out.println("************\n");
				System.out.println(item);
				System.out.println("\n************\n");
			}
		}
		String result = found ? null : "\nNo results found!!\n";
		if (result != null) {
			System.out.println(result);
		}
	}

	// Search Method
	public void searchEntry() {
		int searchInput = 0;
		String val = null;

		System.out.println("\n1) First Name");
		System.out.println("\n2) Last Name");
		System.out.println("\n3) Phone Number");
		System.out.println("\n4) Email Address");

		try {
			System.out.print("\nChoose a search type: ");
			searchInput = Integer.parseInt(input.next());
			System.out.print("\nEnter your search:");
			val = input.next();
		} catch (Exception e) {
			System.out.println("\nInvalid search option\n");
		}

		switch (searchInput) {
		case 1:
			searchFName(val);
			break;

		case 2:
			searchLName(val);
			break;

		case 3:
			searchPhnNum(val);
			break;

		case 4:
			searchEmail(val);
			break;
		}
	}

	public void printWholeBook() {
		int count = 0;
		if (entryDatabase.size() != 0) {
			for (Entry item : entryDatabase) {
				System.out.println("\n*****************\n");
				System.out.println((count + 1) + ") " + "EntryId: " + item.getId() + "\n" + item + "\n");
				System.out.println("*****************\n");
				count++;
			}
		} else if (entryDatabase.size() == 0) {
			System.out.println("\nAddress Book is empty!\n");
		}
	}

	public void deleteBook() {
		Iterator<Entry> entryIterator = entryDatabase.iterator();
		while (entryIterator.hasNext()) {
			entryIterator.next();
			entryIterator.remove();
		}
		emailList.clear();
		System.out.println("\nAddress Book Cleared!!\n");
	}

	public static void main(String[] args) {
		AddressBook bookOne = new AddressBook();
		Scanner inputCase = new Scanner(System.in);
		int value;

		do {

			System.out.println("1) Add an entry\n");
			System.out.println("2) Remove an entry\n");
			System.out.println("3) Search for a specific entry\n");
			System.out.println("4) Print Address Book\n");
			System.out.println("5) Delete Book\n");
			System.out.println("6) Quit\n");
			System.out.print("Please choose what you'd like to do with the database: ");
			value = Integer.parseInt(inputCase.next());

			switch (value) {
			case 1:
				bookOne.addEntry();
				break;

			case 2:
				bookOne.removeEntry();
				break;

			case 3:
				bookOne.searchEntry();
				break;

			case 4:
				bookOne.printWholeBook();
				break;

			case 5:
				bookOne.deleteBook();
			}
		} while (value != 6);

		if (value == 6) {
			// Exit program
			System.out.println("\nExiting the program...");
			System.exit(0);
		}

	}
}
