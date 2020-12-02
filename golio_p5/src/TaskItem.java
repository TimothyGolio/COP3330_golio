import java.util.Date;

public class TaskItem {
    private String title;
    private String description;
    private Date date;
    private boolean completed = false;

    // Constructor for task item class.
    public TaskItem(String title, String description, Date date) {

        if(titleIsValid(title) == true) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("Your title was invalid, must be at least 1 character. Please try again");
        }
        
        this.description = description;
        
        try {
            this.date = date;
        } catch(IllegalArgumentException e) {
            System.out.println("Your date was invalid, must be in format MMMM-YY-DD. Please try again.");
        }
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    // Sets the task title to the given string if it is one or more characters.
    public void setTitle(String title) {

        if(titleIsValid(title) == true) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("Your title was invalid, must be at least one character. Please try again");
        }

    }

    // Sets the task description to the given string.
    public void setDescription(String description) {
        this.description = description;
    }

    // Sets the task date to the given date if it is in the correct format.
    public void setDate(Date date) {
        try {
            this.date = date;
        } catch (IllegalArgumentException e) {
            System.out.println("Your date was invalid, must be in format MMMM-YY-DD. Please try again.");
        }
    }

    // Checks if a contact title is one or more characters.
    private boolean titleIsValid(String title) {
        int x = title.length();

        if(x >= 1){
            return true;
        } else {
            return false;
        }
    }

    public boolean isCompleted() {
        return completed;
    }

    // Completes or uncompletes a given task.
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
