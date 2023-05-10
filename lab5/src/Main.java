import java.time.LocalTime;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println("This program is used to organize meetings in a calendar");
        Calendar calendar = new Calendar(12);
        Scanner input = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            printMenu();
            int option = input.nextInt();
            switch (option) {
                case 1 -> createMeeting(calendar, input);
                case 2 -> deleteMeeting(calendar, input);
                case 3 -> getAllMeetingsInADay(calendar, input);
                case 4 -> getAllMeetingsInADayWithPriority(calendar, input);
                case 5 -> getAllMeetingsInADayWithTime(calendar, input);
                case 6 -> getAllMeetingsInADayWithStartAndEndTime(calendar, input);
                case 7 -> getAllMeetingsInADayWithPriorityAndTime(calendar, input);
                case 8 -> isRunning = false;
                default -> System.out.println("Invalid option");
            }
        }
    }

    public static void printMenu() {
        System.out.print("Choose your option by inputting an integer: \n 1. Add new meeting \n 2. Delete a meeting \n 3. Get all meetings on a given day \n 4. Get all meetings on a given day with a given priority \n 5. Get all meetings on a given day after given time \n 6. Get all meetings on a given day with start and end time \n 7. Get all meetings on a given day with time and priority \n 8. Exit \n Your option: ");
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
        Predicate<Meeting> predicate = meeting -> true;
        for (Meeting meeting : inputCalendar.getMeetingsWithDayAndPredicate(day, predicate)) {
            System.out.println(meeting);
        }
    }

    public static void getAllMeetingsInADayWithPriority(Calendar inputCalendar, Scanner scanner) {
        System.out.print("Provide day: ");
        int day = scanner.nextInt();
        System.out.print("Provide priority: ");
        String priority = scanner.next();
        Predicate<Meeting> predicate = meeting -> meeting.getPriority().equals(priority);
        for (Meeting meeting : inputCalendar.getMeetingsWithDayAndPredicate(day, predicate)) {
            System.out.println(meeting);
        }
    }
    public static void getAllMeetingsInADayWithTime(Calendar inputCalendar, Scanner scanner) {
        System.out.print("Provide a day: ");
        int day = scanner.nextInt();
        System.out.println("Provide time");
        System.out.print("Hour: ");
        int hour = scanner.nextInt();
        if (hour > 24 || hour < 0) { invalidTimeInfo(); return; }
        System.out.print("Minute: ");
        int minute = scanner.nextInt();
        if (minute > 59 || minute < 0) { invalidTimeInfo(); return; }
        LocalTime inputTime = LocalTime.of(hour, minute);
        Predicate<Meeting> predicate = meeting -> meeting.getStartTime().isAfter(inputTime);
        for (Meeting meeting : inputCalendar.getMeetingsWithDayAndPredicate(day, predicate)) {
            System.out.println(meeting);
        }

    }
    public static void getAllMeetingsInADayWithStartAndEndTime(Calendar inputCalendar, Scanner scanner) {
        System.out.print("Provide a day: ");
        int day = scanner.nextInt();
        System.out.println("Provide start time");
        System.out.print("Hour: ");
        int startHour = scanner.nextInt();
        System.out.print("Minute: ");
        int startMinute = scanner.nextInt();
        System.out.println("Provide end time");
        System.out.print("Hour: ");
        int endHour = scanner.nextInt();
        System.out.print("Minute: ");
        int endMinute = scanner.nextInt();
        LocalTime startTime = LocalTime.of(startHour, startMinute);
        LocalTime endTime = LocalTime.of(endHour, endMinute);
        Predicate<Meeting> predicate = meeting -> meeting.getStartTime().isAfter(startTime) && meeting.getEndTime().isBefore(endTime);
        for (Meeting meeting : inputCalendar.getMeetingsWithDayAndPredicate(day, predicate)) {
            System.out.println(meeting);
        }
    }
    public static void getAllMeetingsInADayWithPriorityAndTime(Calendar inputCalendar, Scanner scanner) {
        System.out.print("Provide a day: ");
        int day = scanner.nextInt();
        System.out.println("Provide start time");
        System.out.print("Hour: ");
        int startHour = scanner.nextInt();
        System.out.print("Minute: ");
        int startMinute = scanner.nextInt();
        System.out.print("Provide priority: ");
        String priority = scanner.next();
        LocalTime startTime = LocalTime.of(startHour, startMinute);
        Predicate<Meeting> predicate = meeting -> meeting.getStartTime().isAfter(startTime) && meeting.getPriority().equals(priority);
        for (Meeting meeting : inputCalendar.getMeetingsWithDayAndPredicate(day, predicate)) {
            System.out.println(meeting);
        }
    }
    public static void invalidTimeInfo() {
        String invalidTimeInfo = "Invalid time, meeting not added";
        System.out.println(invalidTimeInfo);
    }

    public static void createMeeting(Calendar inputCalendar, Scanner scanner) {
        System.out.print("Provide day: ");
        int day = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Provide description: ");
        String description = scanner.nextLine();
        System.out.print("Provide start hour (Earliest time is " + Meeting.EARLIEST_TIME + "): ");
        int startHour = scanner.nextInt();
        if (startHour < Meeting.EARLIEST_TIME.getHour() || startHour > 23) { invalidTimeInfo(); return; }
        System.out.print("Provide start minute: ");
        int startMinute = scanner.nextInt();
        if (startMinute < 0 || startMinute > 59) { invalidTimeInfo(); return; }
        System.out.print("Provide end hour: ");
        int endHour = scanner.nextInt();
        if (endHour < 0 || endHour > 23 || startHour > endHour) { invalidTimeInfo(); return; }
        System.out.print("Provide end minute: ");
        int endMinute = scanner.nextInt();
        scanner.nextLine();
        if (endMinute < 0 || endMinute > 59 || startHour == endHour && startMinute >= endMinute) { invalidTimeInfo(); return; }
        System.out.print("Provide priority (Low | Medium | High): ");
        String priority = scanner.nextLine();
        inputCalendar.addMeeting(day, new Meeting(description, LocalTime.of(startHour, startMinute), LocalTime.of(endHour, endMinute), priority));
    }
}