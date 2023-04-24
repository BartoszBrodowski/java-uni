import java.time.LocalTime;

public class Meeting {
    static final LocalTime EARLIEST_TIME = LocalTime.of(8, 0);
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private String priority;
    public Meeting(String newDescription, LocalTime newStartTime, LocalTime newEndTime, String newPriority) {
        description = newDescription;
        startTime = newStartTime;
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
