import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import static java.sql.Date.valueOf;

public class TaskList {
    private ArrayList<TaskItem> list = new ArrayList<TaskItem>();

    // Adds the given task item to the list.
    public void addListItem(TaskItem task) {
        list.add(task);
    }

    // Removes the task item at the given index.
    public void removeListItem(int index) {
        list.remove(index);
    }

    // Returns the size of the list.
    public int size() {
        return list.size();
    }

    // Returns the task item at a specific index.
    public TaskItem get(int index) {
        return list.get(index);
    }

    // Returns the title of the task item at a specific index.
    public String getTaskTitle(int index) {
        TaskItem task = list.get(index);
        return task.getTitle();
    }

    // Returns the description of the task item at a specific index.
    public String getTaskDescription(int index) {
        TaskItem task = list.get(index);
        return task.getDescription();
    }

    // Returns the date of the task item at a specific index.
    public Date getTaskDate(int index) {
        TaskItem task = list.get(index);
        return task.getDate();
    }

    // Sets the task item at the given index to complete or uncomplete.
    public void setIndexCompleted(int index, boolean complete) {
        if(index > (list.size() - 1) || index < 0) {
            throw new IndexOutOfBoundsException("Your input was invalid, must be integer between 0 and the size of the list - 1. Please try again.");
        }

        TaskItem task = get(index);

        if(task.isCompleted() == true) {

            if(complete == true) {
                throw new IllegalArgumentException("Your input was invalid, the chosen item is already complete. Please try again.");
            }

            task.setCompleted(false);
        } else {

            if(complete == false) {
                throw new IllegalArgumentException("Your input was invalid, the chosen item is already not complete. Please try again.");
            }

            task.setCompleted(true);
        }
    }

    // Edits the title of the task item at a specific index.
    public void editTaskTitle(int index, String newTitle) {
        if(index > (list.size() - 1) || index < 0) {
            throw new IndexOutOfBoundsException("Your input was invalid, must be integer between 0 and the size of the list - 1. Please try again.");
        }

        TaskItem task = list.get(index);
        task.setTitle(newTitle);
    }

    // Edits the description of the task item at a specific index.
    public void editTaskDescription(int index, String newDescription) {
        if(index > (list.size() - 1) || index < 0) {
            throw new IndexOutOfBoundsException("Your input was invalid, must be integer between 0 and the size of the list - 1. Please try again.");
        }

        TaskItem task = list.get(index);
        task.setDescription(newDescription);
    }

    // Edits the date of the task item at a specific index.
    public void editTaskDate(int index, Date newDate) {
        if(index > (list.size() - 1) || index < 0) {
            throw new IndexOutOfBoundsException("Your input was invalid, must be integer between 0 and the size of the list - 1. Please try again.");
        }

        TaskItem task = list.get(index);
        task.setDate(newDate);
    }

    // Saves the list to a file with the given file name.
    public void saveList(String filename) throws IOException {
        File file = new File(filename);
        int size = list.size();

        if(file.createNewFile()) {
        } else {
            throw new IOException("This file already exists, please try a different file.");
        }

        FileWriter writer = new FileWriter(file.getName());
        writer.write("Task List\n");

        for(int i = 0; i < size; i++) {
            TaskItem task = list.get(i);
            String description = task.getDescription();

            if(description.equals("")) {
                description = "blank";
            }

            Date date = task.getDate();
            String dateString = date.toString();

            if(task.isCompleted()){
                writer.write("***\n");
            } else {
                writer.write("*\n");
            }

            writer.write(task.getTitle() + "\n");
            writer.write(description + "\n");
            writer.write(dateString + "\n");
        }
        writer.close();
    }

    // loads the list in the file at the given file name
    public void loadList(String filename, boolean delete) throws FileNotFoundException {
        list.clear();
        File openedFile = new File(filename);
        Scanner read = new Scanner(openedFile);
        String isTaskList = read.nextLine();

        if(isTaskList.equals("Task List")) {

            while (read.hasNextLine()) {
                boolean complete = false;
                String isComplete = read.nextLine();

                if (isComplete.equalsIgnoreCase("***")) {
                    complete = true;
                } else {
                    complete = false;
                }

                String title = read.nextLine();
                String description = read.nextLine();
                String date = read.nextLine();
                Date dateObject = valueOf(date);

                if (description.equals("blank")) {
                    description = "";
                }

                TaskItem task = new TaskItem(title, description, dateObject);
                task.setCompleted(complete);
                list.add(task);
            }

            if (delete == true) {
                try {
                    Files.delete(openedFile.toPath());
                } catch (IOException e) {
                }
            }
        } else {
            throw new IllegalArgumentException("Invalid input, File is not a task list. Please try again");
        }
    }
}
