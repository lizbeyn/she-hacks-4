import java.util.Scanner;

public class Person {
	private String username, id;
	private Schedule schedule;

	/**
	 * This is the constructor for the class. It creates a Person with a user name,
	 * an email, and a blank schedule
	 * 
	 * @param name (the name of the Person)
	 */
	public Person(String name, String email) {
		username = name;
		id = email;
		schedule = new Schedule();
	}

	/**
	 * @return the chosen name
	 */
	public String getName() {
		return username;
	}

	/**
	 * @return the automatically assigned ID's
	 */
	public String getID() {
		return id;
	}

	/**
	 * changes the user name
	 * 
	 * @param newName (the new user name)
	 */
	public void setName(String newName) {
		username = newName;
	}

	/**
	 * @return the created schedule with all the true/false
	 */
	public Schedule getSchedule() {
		return schedule;
	}

	/**
	 * prompts the user to keep choosing new times changes to "true" if the chosen
	 * day/time was "false" and vice versa"
	 */
	public void createIndSchedule() {
		boolean cont = true;

		while (cont) {
			Scanner sDay = new Scanner(System.in);
			System.out.println("Enter a # for day: ");
			int day = sDay.nextInt();

			Scanner sTime = new Scanner(System.in);
			System.out.println("Enter a # for an hour: ");
			int time = sTime.nextInt();

			schedule.changeBool(time, day);

			Scanner sQuit = new Scanner(System.in);
			System.out.println("Enter 'y' to quit. Otherwise, enter any other key: ");
			String quit = sQuit.next();
			if (quit.toLowerCase().contentEquals("yes") || quit.toLowerCase().contentEquals("y")) {
				cont = false;
			}
		}
	}
	
	public void setSchedule(Schedule newSched) {
		schedule = newSched;
	}

}
