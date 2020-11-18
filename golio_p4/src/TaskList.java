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

    public TaskList() {
    }

    public void addListItem(TaskItem task) {
        list.add(task);
    }

    public void removeListItem(int index) {
        list.remove(index);
    }

    public int size() {
        return list.size();
    }

    public TaskItem get(int index) {
        return list.get(index);
    }

    public String getTaskTitle(int index) {
        TaskItem task = list.get(index);
        return task.getTitle();
    }

    public String getTaskDescription(int index) {
        TaskItem task = list.get(index);
        return task.getDescription();
    }

    public Date getTaskDate(int index) {
        TaskItem task = list.get(index);
        return task.getDate();
    }

    public void setIndexCompleted(int index, boolean complete) {
        if(index > (list.size() - 1) || index < 0){
            throw new IndexOutOfBoundsException("Your input was invalid, must be integer between 0 and the size of the list - 1. Please try again.");
        }
        TaskItem task = get(index);
        if(task.isCompleted() == true){
            if(complete == true){
                throw new IllegalArgumentException("Your input was invalid, the chosen item is already complete. Please try again.");
            }
            task.setCompleted(false);
        } else {
            if(complete == false){
                throw new IllegalArgumentException("Your input was invalid, the chosen item is already not complete. Please try again.");
            }
            task.setCompleted(true);
        }
    }

    public void editTaskTitle(int index, String newTitle) {
        if(index > (list.size() - 1) || index < 0) {
            throw new IndexOutOfBoundsException("Your input was invalid, must be integer between 0 and the size of the list - 1. Please try again.");
        }

        TaskItem task = list.get(index);
        task.setTitle(newTitle);
    }

    public void editTaskDescription(int index, String newDescription) {
        if(index > (list.size() - 1) || index < 0) {
            throw new IndexOutOfBoundsException("Your input was invalid, must be integer between 0 and the size of the list - 1. Please try again.");
        }

        TaskItem task = list.get(index);
        task.setDescription(newDescription);
    }

    public void editTaskDate(int index, Date newDate) {
        if(index > (list.size() - 1) || index < 0) {
            throw new IndexOutOfBoundsException("Your input was invalid, must be integer between 0 and the size of the list - 1. Please try again.");
        }

        TaskItem task = list.get(index);
        task.setDate(newDate);

    }

    public void loadList(String filename, boolean delete) throws FileNotFoundException {

        int size = list.size();

        for(int i = 0; i < size; i++){
            list.remove(i);
        }


        File openedFile = new File(filename);
        Scanner read = new Scanner(openedFile);

        while(read.hasNextLine()) {
            boolean complete = false;
            String isComplete = read.nextLine();
            if(isComplete.equalsIgnoreCase("***")) {
                complete = true;
            } else {
                complete = false;
            }
            String title = read.nextLine();
            String description = read.nextLine();
            String date = read.nextLine();
            Date dateObject = valueOf(date);
            if(description.equals("blank")){
                description = "";
            }
            TaskItem task = new TaskItem(title, description, dateObject);
            task.setCompleted(complete);
            list.add(task);
        }

        if(delete == true) {
            try {
                Files.delete(openedFile.toPath());
            } catch (IOException e) {
            }
        }
    }

    public void saveList(String filename) throws IOException {
        File file = new File(filename);
        int size = list.size();

        if(file.createNewFile()) {
        } else {
            throw new IOException("This file already exists, please try a different file.");
        }

        FileWriter writer = new FileWriter(file.getName());

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
}
