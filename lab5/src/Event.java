import java.time.LocalTime;

abstract sealed public class Event permits Meeting, Task {
    static final LocalTime EARLIEST_TIME = LocalTime.of(8, 0);
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;

    public Event(String newDescription, LocalTime newStartTime, LocalTime newEndTime) {
        description = newDescription;
        startTime = newStartTime;
        endTime = newEndTime;
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
}
