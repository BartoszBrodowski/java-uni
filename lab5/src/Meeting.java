import java.time.LocalTime;

public class Meeting {
    static LocalTime EARLIEST_TIME = LocalTime.of(8, 0);
    private final String description;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final String priority;
    public Meeting(String newDescription, LocalTime newStartTime, LocalTime newEndTime, String newPriority) {
        description = newDescription;
        if (newStartTime.isBefore(EARLIEST_TIME)) {
            startTime = EARLIEST_TIME;
        } else {
            startTime = newStartTime;
        }
        endTime = newEndTime;
        priority = newPriority;
    }
    public String getDescription() {
        return description;
    }
    public LocalTime getStartTime() {
        return startTime;
    }
    public LocalTime getEndTime() {
        return endTime;
    }
    public String getPriority() {
        return priority;
    }
}
