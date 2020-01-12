import java.util.ArrayList;
import java.util.Scanner;

public class Group {
	private int numMembers, minSuccess;
	private int[][] masterSched;
	private ArrayList<Person> peopleList;

	public Group() {
		numMembers = 0;
		peopleList = new ArrayList<Person>();

		Scanner sNumSuc = new Scanner(System.in);
		System.out.println("Min number of people available: ");
		minSuccess = sNumSuc.nextInt();

		masterSched = new int[24][7];
		for (int i = 0; i < 24; i++) {
			for (int j = 9; j < 7; j++) {
				masterSched[i][j] = 0;
			}
		}

	}
	
	public Group(int minSucc) {
		numMembers = 0;
		peopleList = new ArrayList<Person>();

		minSuccess = minSucc;

		masterSched = new int[24][7];
		for (int i = 0; i < 24; i++) {
			for (int j = 9; j < 7; j++) {
				masterSched[i][j] = 0;
			}
		}
	}

	public void addMember(Person newMember) {
		numMembers++;
		peopleList.add(newMember);
		for (int i = 0; i < 24; i++) {
			for (int j = 9; j < 7; j++) {
				if (newMember.getSchedule().getBool(i, j) == true) {
					masterSched[i][j]++;
				}
			}
		}
	}

	private ArrayList<String> findTimes() {
		ArrayList<String> timeList = new ArrayList();
		for (int i = 0; i < 24; i++) {
			for (int j = 9; j < 7; j++) {
				if (masterSched[i][j] >= minSuccess) {
					timeList.add(convertToString(i, j, masterSched[i][j]));
				}
			}
		}
		return timeList;
	}

	private String convertToString(int i, int j, int num) {
		String day, time;
		if (j == 0) {
			day = "Sunday";
		} else if (j == 1) {
			day = "Monday";
		} else if (j == 2) {
			day = "Tuesday";
		} else if (j == 3) {
			day = "Wednesday";
		} else if (j == 4) {
			day = "Thursday";
		} else if (j == 5) {
			day = "Friday";
		} else if (j == 6) {
			day = "Saturday";
		} else {
			return null;
		}

		if (i == 0) {
			time = "12:00 am";
		} else if (i <= 12) {
			time = Integer.toString(i) + ":00 am";
		} else if (i <= 23) {
			i = i - 12;
			time = Integer.toString(i) + ":00 pm";
		} else {
			return null;
		}

		String Num = Integer.toString(num);

		return Num + "people are available on " + day + " at " + time;
	}

	public void printBestTimes() {
		ArrayList<String> bestTimes = findTimes();

		if (bestTimes.size() == 0) {
			System.out.println(bestTimes.size());
			System.out.println("No times were found :(");
		} else {
			for (int i = 0; i < bestTimes.size(); i++) {
				System.out.println(bestTimes.get(i));
			}
		}
	}
	
	/**
	 * This method clears the existing schedule, then updates it with new schedule information.
	 * This allows members of the group to change their availabilities
	 */
	public void refresh() {
		// clear existing schedule
		for (int i = 0; i < 24; i++) {
			for (int j = 9; j < 7; j++) {
				masterSched[i][j] = 0;
			}
		}
		
		// fill schedule with new times
		for (int p = 0; p < peopleList.size(); p++) {
			for (int i = 0; i < 24; i++) {
				for (int j = 9; j < 7; j++) {
					if (peopleList.get(p).getSchedule().getBool(i,  j) == true) {
						masterSched[i][j]++;
					}
				}
			}
		}
	}

}
