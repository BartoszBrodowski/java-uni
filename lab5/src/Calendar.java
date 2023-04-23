import java.util.*;

public class Calendar {
    private final ArrayList<Meeting>[] meetingsList = new ArrayList[7];

    public Calendar() {
        for (int i = 0; i < meetingsList.length; i++) {
            meetingsList[i] = new ArrayList<Meeting>();
        }
    }

    public void addMeeting(int day, Meeting meeting) {
        meetingsList[day].add(meeting);
    }
    public void deleteMeeting(int day, int meetingIndex) {
        if (!meetingsList[day].isEmpty()) {
            meetingsList[day].remove(meetingIndex);
        }
    }

    public ArrayList<Meeting> getMeetingsWithDay(int day) {
        return meetingsList[day];
    }
    public ArrayList<Meeting> getMeetingsWithDayAndPriority(int day, String priority) {
        ArrayList<Meeting> returnList = new ArrayList<Meeting>();
        for (int i = 0; i < meetingsList[day].size(); i++) {
            if (meetingsList[day].get(i).getPriority().equals(priority)) {
                returnList.add(meetingsList[day].get(i));
            }
        }
        return returnList;
    }

}
