import java.util.Arrays;

public class Schedule {
	private boolean[][] schedule;
	
	public Schedule() {
		schedule = new boolean[24][7];
		
		for (int i = 0; i < 24; i++) {
			for (int j = 0; j < 7; j++) {
				schedule[i][j] = false;
			}
		}	
	}
	
	public void changeBool(int time, int day) {
		if (schedule[time][day] == false) {
			schedule[time][day]= true;
		} else if (schedule[time][day] == true) {
			schedule[time][day] = false;
		}
	}
	
	public boolean[][] getSchedule(){
		return schedule;
	}
	
	public boolean getBool(int time, int day) {
		return schedule[time][day];
	}
	
	public void printSchedule() { // prints the schedule
		System.out.println();
		System.out.println(Arrays.deepToString(schedule).replace("], ", "]\n"));
	}

}
