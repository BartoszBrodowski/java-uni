import java.time.LocalTime;

non-sealed public class Task extends Event {
    private String status;
    public Task(String newDescription, LocalTime newStartTime, LocalTime newEndTime, String newStatus) {
        super(newDescription, newStartTime, newEndTime);
        status = newStatus;
    }
    public String getStatus() {
        return status;
    }
    @Override
    public String toString() {
        return "Task: \n Description: " + super.getDescription() + "\n Start time: " + super.getStartTime() + "\n End time: " + super.getEndTime() + "\n Status: " + getStatus() + "\n";
    }
}
