public class Task {

    private int taskId;
    private String title;
    private String priority;
    private String status;
    private String dueDate;

    public Task(int taskId,
                String title,
                String priority,
                String status,
                String dueDate) {

        this.taskId = taskId;
        this.title = title;
        this.priority = priority;
        this.status = status;
        this.dueDate = dueDate;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTitle() {
        return title;
    }

    public String getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    public String getDueDate() {
        return dueDate;
    }
    public void setStatus(String status) {
    this.status = status;
}

public void setPriority(String priority) {
    this.priority = priority;
}
}