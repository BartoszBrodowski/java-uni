import java.time.LocalTime;

non-sealed public class Meeting extends Event{

    private String priority;
    public Meeting(String newDescription, LocalTime newStartTime, LocalTime newEndTime, String newPriority) {
        super(newDescription, newStartTime, newEndTime);
        priority = newPriority;
    }
    public String getPriority() {
        return priority;
    }
    @Override
    public String toString() {
        return "Meeting: \n Description: " + super.getDescription() + "\n Start time: " + super.getStartTime() + "\n End time: " + super.getEndTime() + "\n Priority: " + getPriority() + "\n";
    }

}
