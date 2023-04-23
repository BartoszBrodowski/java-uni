import java.time.LocalTime;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("This program is used to organize meetings in a calendar");
        Calendar calendar = new Calendar();
        Scanner input = new Scanner(System.in);
        boolean isRunning = true;
        while(isRunning) {
            printMenu();
            int option = input.nextInt();
            switch(option) {
                case 1 -> createMeeting(calendar, input);
                case 2 -> deleteMeeting(calendar, input);
                case 3 -> getAllMeetingsInADay(calendar, input);
                case 4 -> getAllMeetingsInADayWithPriority(calendar, input);
                case 5 -> isRunning = false;
            }
        }
    }
    public static void printMenu() {
        System.out.print("Choose your option by inputting an integer: \n 1. Add new meeting \n 2. Delete a meeting \n 3. Get all meetings on a given day \n 4. Get all meetings on a given day with a given priority \n 5. Exit \n Your option: ");
    }
    public static void deleteMeeting(Calendar inputCalendar, Scanner scanner) {
        System.out.println("Provide day and index of the meeting to be deleted: ");
        System.out.print("Provide day: ");
        int day = scanner.nextInt();
        System.out.print("Provide index: ");
        int index = scanner.nextInt();
        inputCalendar.deleteMeeting(day, index);
    }
    public static void getAllMeetingsInADay(Calendar inputCalendar, Scanner scanner) {
        System.out.print("Provide day: ");
        int day = scanner.nextInt();
        for (Meeting meeting : inputCalendar.getMeetingsWithDay(day)) {
            printMeeting(meeting);
        }
    }
    public static void getAllMeetingsInADayWithPriority(Calendar inputCalendar, Scanner scanner) {
        System.out.print("Provide day: ");
        int day = scanner.nextInt();
        System.out.print("Provide priority: ");
        String priority = scanner.next();
        for (Meeting meeting : inputCalendar.getMeetingsWithDayAndPriority(day, priority)) {
            printMeetingWithoutPriority(meeting);
        }
    }
    public static void printMeeting(Meeting meeting) {
        System.out.println("\nDescription: " + meeting.getDescription());
        System.out.println("Start time: " + meeting.getStartTime());
        System.out.println("End time: " + meeting.getEndTime());
        System.out.println("Priority: " + meeting.getPriority() + "\n");
    }
    public static void printMeetingWithoutPriority(Meeting meeting) {
        System.out.println("\nDescription: " + meeting.getDescription());
        System.out.println("Start time: " + meeting.getStartTime());
        System.out.println("End time: " + meeting.getEndTime() + "\n");
    }
    public static void createMeeting(Calendar inputCalendar, Scanner scanner) {
        System.out.println("Provide day of the meeting, description, start hour and start minute of the meeting, end hour and minute and priority: ");
        System.out.print("Provide day: ");
        int day = scanner.nextInt();
        System.out.print("Provide description: ");
        String description = scanner.next();
        System.out.print("Provide start hour (Earliest time is " + Meeting.EARLIEST_TIME + "): ");
        int startHour = scanner.nextInt();
        System.out.print("Provide start minute: ");
        int startMinute = scanner.nextInt();
        System.out.print("Provide end hour: ");
        int endHour = scanner.nextInt();
        if (startHour > endHour) { System.out.println("Invalid time, meeting not added"); return; }
        System.out.print("Provide end minute: ");
        int endMinute = scanner.nextInt();
        if (startHour == endHour && startMinute > endMinute) { System.out.println("Invalid time, meeting not added"); return; }
        System.out.print("Provide priority (Low | Medium | High): ");
        String priority = scanner.next();
        inputCalendar.addMeeting(day, new Meeting(description, LocalTime.of(startHour, startMinute), LocalTime.of(endHour, endMinute), priority)); }
    }
