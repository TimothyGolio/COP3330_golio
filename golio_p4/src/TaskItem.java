import javax.naming.InvalidNameException;

public class TaskItem {
    private String title;
    private String description;
    private String duedate;

    public TaskItem(String title, String description, String duedate) throws InvalidNameException {
        if(titleIsValid(title)){
            this.title = title;
        } else {
            throw new InvalidNameException("Your title was invalid, must be at least one character. Please try again.");
        }
        this.description = description;
        this.duedate = duedate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws InvalidNameException {
        if(titleIsValid(title)){
            this.title = title;
        } else {
            throw new InvalidNameException("Your title was invalid, must be at least one character. Please try again.");
        }
    }

    private boolean titleIsValid(String title) {
        return title.length() > 0;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }
}
