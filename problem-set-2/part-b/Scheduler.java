
// Homework Question 2
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================


import java.util.*;
public class Scheduler {
	public static void main(String[] args) {
		System.out.println("Welcome to the Appointment Scheduler.");
		System.out.println("You can schedule an appointment " +
						   "at 1 or 2 pm.");
		Scanner reader = new Scanner(System.in);
		String[] appointments = new String[2];
		int appointmentsMade = 0;

		while (appointmentsMade < 2) {
			try {
				System.out.println("Enter the desired appointment time:");
				String desiredTimeStr = reader.nextLine();
				
				if (!(desiredTimeStr.equals("1") || desiredTimeStr.equals("2"))) {
					throw new InvalidTimeException();
				}

				int desiredTimeInt = Integer.valueOf(desiredTimeStr);

				if (appointments[desiredTimeInt-1] != null){
					throw new TimeInUseException();
				}

				System.out.println("Enter your name:");
				String bookerName = reader.nextLine();
				appointments[desiredTimeInt-1] = bookerName;
				appointmentsMade++;
			}

			catch (InvalidTimeException ex) {
				System.out.println("Invalid Time.");
			}
			catch (TimeInUseException ex) {
				System.out.println("Sorry, this timing is already taken.");
			}
		}

		System.out.println("\n"+appointments[0]+" has an appointment at 1pm.");
		System.out.println(appointments[1]+" has an appointment at 2pm.");
	}
}
class InvalidTimeException extends Exception{
}

class TimeInUseException extends Exception{
}

