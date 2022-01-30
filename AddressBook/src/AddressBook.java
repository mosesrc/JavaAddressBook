import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {
	private static ArrayList<Entry> entryDatabase = new ArrayList<>();
	private static HashMap<Integer, String> emailList = new HashMap<>();
	private static int count = 0;
	private static Scanner input = new Scanner(System.in);

	// Adding Entry
	public static void addEntry() {

		// Read First Name
		System.out.print("\nFirst Name: ");
		String fName = input.next();

		// Read Last Name
		System.out.print("\nLast Name: ");
		String lName = input.next();

		// Read Phone Number
		System.out.print("\nPhone Number: ");
		long phnNum = Long.parseLong(input.next());

		// Read Email and assign it an id
		System.out.print("\nEmail Address: ");
		String email = input.next();
		count++;
		emailList.put(count, email);

		entryDatabase.add(new Entry(fName, lName, phnNum, email));
		System.out.println("\nAdded new entry!\n");
	}

	public static void removeEntry() {
		System.out.print("\nEnter an entry's email to remove: ");
		String email = input.next();
		Entry e = null;

		for (Entry item : entryDatabase) {
			if (item.get_email().contains(email)) {
				System.out.println("\nDeleted the following entry: \n");
				e = item;
				System.out.println("************\n");
				System.out.println(e);
				System.out.println("\n************\n");
				entryDatabase.remove(e);
				break;
			} 
			else if (!(item.get_email().contains(email))) {
				System.out.println("\nEntry was not found!!\n");
				break;
			}
		}
	}

	public static void Quit() {
		// Exit program
		System.out.println("\nExiting the program...");
		System.exit(0);
	}

	public static void main(String[] args) {
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
				addEntry();
				break;

			case 2:
				removeEntry();
				break;

			default:
				break;
			}
		} while (value != 6);

		if (value == 6) {
			Quit();
		}

	}
}
