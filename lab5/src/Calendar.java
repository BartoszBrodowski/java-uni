import java.util.ArrayList;
import java.util.function.Predicate;

public class Calendar {
    private final ArrayList<Meeting>[] meetingsList;
    public Calendar(int amountOfDays) {
        meetingsList = new ArrayList[amountOfDays];
        for (int i = 0; i < amountOfDays; i++) {
            meetingsList[i] = new ArrayList<Meeting>();
        }
    }
    public Calendar() {
      this(7);
    }
    public void addMeeting(int day, Meeting meeting) {
        meetingsList[day].add(meeting);
    }
    public void deleteMeeting(int day, int meetingIndex) {
        if (!meetingsList[day].isEmpty()) {
            meetingsList[day].remove(meetingIndex);
        }
    }
    public ArrayList<Meeting> getMeetingsWithDayAndPredicate(int day, Predicate<Meeting> predicate) {
        ArrayList<Meeting> returnList = new ArrayList<Meeting>();
        for (int i = 0; i < meetingsList[day].size(); i++) {
            if (predicate.test(meetingsList[day].get(i))) {
                returnList.add(meetingsList[day].get(i));
            }
        }
        return returnList;
    }
}
