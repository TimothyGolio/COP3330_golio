import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import static java.sql.Date.valueOf;

public class App {
    public static void main(String[] args) {
        int mainMenuResponse = 0;
        while(mainMenuResponse != 3) {
            mainMenuResponse = manageMainMenu();
        }
    }

    // Manages the user input from the main menu.
    private static int manageMainMenu() {
        printMainMenu();
        Scanner scan = new Scanner(System.in);

        try {
            int mainMenuResponse = scan.nextInt();

            if(mainMenuResponse == 1) {
                createList();
                return 1;
            } else if(mainMenuResponse == 2) {
                loadList();
                return 2;
            } else if(mainMenuResponse == 3) {
                return 3;
            } else {
                System.out.println("Your input was invalid, must be from 1-3. Please try again.");
                return -1;
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Your input was invalid, must be an integer from 1-3. Please try again.");
            return -1;
        }
    }

    // Creates the list menu.
    private static void createListMenu(TaskList list) {
        int listMenuResponse = 0;
        while(listMenuResponse != 8){
            listMenuResponse = manageListMenu(list);
        }
    }

    // Creates a new, empty list.
    private static void createList() {
        TaskList list = new TaskList();
        System.out.println("new task list has been created");
        System.out.println("");
        int listMenuResponse = 0;
        while(listMenuResponse != 8) {
            listMenuResponse = manageListMenu(list);
        }
    }

    // Manages the user input from the list menu.
    private static int manageListMenu(TaskList list) {
        printListMenu();
        int mainMenuResponse = 0;
        Scanner scan = new Scanner(System.in);

        try {
            mainMenuResponse = scan.nextInt();
        } catch (IllegalArgumentException e) {
            System.out.println("Your input was invalid, must be an integer from 1-8. Please try again.");
            return -1;
        } catch (Exception e2) {
            System.out.println("Your input was invalid, must be an integer from 1-8. Please try again.");
            return -1;
        }

        if(mainMenuResponse == 1) {
            viewList(list);
            return 1;
        } else if(mainMenuResponse == 2) {
            addItem(list);
            return 2;
        } else if(mainMenuResponse == 3) {
            editItem(list);
            return 3;
        } else if(mainMenuResponse == 4) {
            removeItem(list);
            return 4;
        } else if(mainMenuResponse == 5) {
            markItemAsComplete(list);
            return 5;
        } else if(mainMenuResponse == 6) {
            unmarkItemAsComplete(list);
            return 6;
        } else if(mainMenuResponse == 7) {
            saveCurrentList(list);
            return 7;
        } else if(mainMenuResponse == 8) {
            return 8;
        } else {
            System.out.println("Your input was invalid, must be from 1-8. Please try again.");
            return -1;
        }
    }

    // Prints the current list.
    private static void viewList(TaskList list) {
        int i, size = list.size();
        System.out.println("Current Tasks");
        System.out.println("-------------");
        System.out.println("");
        for(i = 0; i < size; i++) {
            TaskItem task = list.get(i);
            if(task.isCompleted()) {
                System.out.print("*** ");
            }
            System.out.print(i + ") [" + list.getTaskDate(i) + "] " + list.getTaskTitle(i));
            String description = list.getTaskDescription(i);
            if(description.equals("")){
                System.out.println("");
            }
            else{
                System.out.println(": " + description);
            }
        }
        System.out.println("");
    }

    // Takes user input and creates a task list with the input. Prompts the user again if there is an error in their input.
    private static void addItem(TaskList list) {
        Date objectDate = new Date();
        String title;
        Scanner scan = new Scanner(System.in);

        while(true) {
            try {
                System.out.print("Task title: ");
                title = scan.nextLine();
                if(!(title.length() > 0)) {
                    throw new IllegalArgumentException("Your input was invalid, must be at least one character. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Your input was invalid, must be at least one character. Please try again.");
                continue;
            }
            break;
        }

        System.out.print("Task description: ");
        String description = scan.nextLine();

        while(true) {
            try {
                System.out.print("Task due date (YYYY-MM-DD): ");
                String date = scan.nextLine();
                objectDate = valueOf(date);
            } catch(IllegalArgumentException e) {
                System.out.println("Your input was invalid, must be in format YYYY-MM-DD. Please try again.");
                continue;
            }
            break;
        }

        TaskItem todo = new TaskItem(title, description, objectDate);
        list.addListItem(todo);
    }

    // Takes user input for which task they want to edit.
    private static void editItem(TaskList list) {
        viewList(list);
        TaskItem task;
        int index;

        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.print("Which task will you edit? ");
            try {
                index = scan.nextInt();
                task = list.get(index);
            } catch (IllegalArgumentException e1) {
                System.out.println("Your input was invalid, must be an integer from 0 to the list size. Please try again.");
                continue;
            } catch (IndexOutOfBoundsException e2) {
                System.out.println("Your input was invalid, must be an integer from 0 to the list size. Please try again.");
                continue;
            }
            break;
        }
        handleEditTitle(list, index);
        handleEditDescription(list, index);
        handleEditDate(list, index);
    }

    // Takes user input on how to edit the date and edits that tasks date value.
    private static void handleEditDate(TaskList list, int index) {
        Scanner scan = new Scanner(System.in);
        String newDate;

        while(true) {
            System.out.print("Enter a new task due date (YYYY-MM-DD) for task " + index + ": ");
            newDate = scan.nextLine();
            try {
                Date objectDate = valueOf(newDate);
                list.editTaskDate(index, objectDate);
            } catch(IllegalArgumentException e) {
                System.out.println("Your input was invalid, must be in format YYYY-MM-DD. Please try again.");
                continue;
            }
            break;
        }

    }

    // Takes user input on how to edit the description and edits that tasks description value.
    private static void handleEditDescription(TaskList list, int index) {
        Scanner scan = new Scanner(System.in);
        String newDescription;
        System.out.print("Enter a new description for task " + index + ": ");
        newDescription = scan.nextLine();
        list.editTaskDescription(index, newDescription);
    }

    // Takes user input on how to edit the title and edits that tasks title value.
    private static void handleEditTitle(TaskList list, int index) {
        Scanner scan = new Scanner(System.in);
        String newTitle;
        while(true) {
            System.out.print("Enter a new title for task " + index + ": ");
            newTitle = scan.nextLine();
            try {
                list.editTaskTitle(index, newTitle);
            } catch (Exception e) {
                System.out.println("Your input was invalid, most be at least one character. Please try again.");
                continue;
            }
            break;
        }

    }

    // Takes user input on which task to remove and removes it.
    private static void removeItem(TaskList list) {
        viewList(list);
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.print("Which task will you remove? ");
            try {
                int index = scan.nextInt();
                list.removeListItem(index);
            } catch(IllegalArgumentException e1) {
                System.out.println("Your input was invalid, must be integer between 0 and the size of the list - 1. Please try again.");
                continue;
            }
            break;
        }
    }

    // Prints the list of tasks that are completed.
    private static void viewCompletedList(TaskList list) {
        int i, size = list.size();
        System.out.println("Completed Tasks");
        System.out.println("-------------");
        System.out.println("");
        for(i = 0; i < size; i++) {
            TaskItem task = list.get(i);
            if(task.isCompleted()) {
                System.out.print(i + ") [" + list.getTaskDate(i) + "] " + list.getTaskTitle(i));
                String description = list.getTaskDescription(i);
                if(description.equals("")){
                    System.out.println("");
                }
                else{
                    System.out.println(": " + description);
                }
            }
        }
    }

    // Marks the inputted task as complete.
    private static void markItemAsComplete(TaskList list) {
        Scanner scan = new Scanner(System.in);

        while(true) {

            try {
                viewUncompletedList(list);
                System.out.print("Which task will you mark as completed? ");
                int index = scan.nextInt();
                list.setIndexCompleted(index, true);
                break;
            } catch(IndexOutOfBoundsException e1) {
                System.out.println("Your input was invalid, value must be from 0 to the size of the list - 1. Please try again.");
                System.out.println("");
                break;
            } catch(IllegalArgumentException e2) {
                System.out.println("Your input was invalid, item is already complete. Please try again.");
                System.out.println("");
                break;
            }

        }

    }

    // Prints out the list of tasks that are not completed.
    private static void viewUncompletedList(TaskList list) {
        int i, size = list.size();
        System.out.println("Uncompleted Tasks");
        System.out.println("-------------");
        System.out.println("");
        for(i = 0; i < size; i++) {
            TaskItem task = list.get(i);
            if(!task.isCompleted()) {
                System.out.print(i + ") [" + list.getTaskDate(i) + "] " + list.getTaskTitle(i));
                String description = list.getTaskDescription(i);
                if(description.equals("")){
                    System.out.println("");
                }
                else{
                    System.out.println(": " + description);
                }
            }
        }
        System.out.println("");
    }

    // Unmarks the inputted task as complete.
    private static void unmarkItemAsComplete(TaskList list) {
        Scanner scan = new Scanner(System.in);
        viewCompletedList(list);
        while(true) {
            try {
                System.out.print("Which task will you unmark as completed? ");
                int index = scan.nextInt();
                System.out.println("");
                list.setIndexCompleted(index, false);

                break;
            } catch(IndexOutOfBoundsException e1) {
                System.out.println("Your input was invalid, value must be from 0 to the size of the list - 1. Please try again.");
                System.out.println("");
                break;
            }catch(Exception e2) {
                System.out.println("Your input was invalid, item is incomplete. Please try again.");
                System.out.println("");
                break;
            }
        }
    }

    // Saves the current list to a text file inputted by the user.
    private static void saveCurrentList(TaskList list) {
        Scanner scan = new Scanner(System.in);

        while(true) {
            System.out.print("Enter the file name to save as: ");
            try {
                String filename = scan.nextLine();
                list.saveList(filename);
                System.out.println("task list has been saved");
                break;

            } catch(IOException e2) {
                System.out.println("Your input was invalid. Please try again.");
                continue;
            } catch(Exception e3) {
                System.out.println("Your input was invalid. Please try again.");
                continue;
            }
        }
    }

    // Loads a list from a text file inputted by the user.
    private static void loadList() {
        Scanner scan = new Scanner(System.in);
        TaskList list = new TaskList();

        while(true) {
            System.out.println("Enter the file name to load: ");
            try {
                String filename = scan.nextLine();
                if(filename.equalsIgnoreCase("quit")){
                    break;
                }
                list.loadList(filename, false);
                System.out.println("task list has been loaded");
                createListMenu(list);
                break;
            } catch (FileNotFoundException e) {
                System.out.println("There was a problem loading your file. Please try again or type \"Quit\" to return to the main menu.");
                continue;
            } catch (Exception e) {
                System.out.println("There was a problem loading your file. Please try again or type \"Quit\" to return to the main menu.");
                continue;
            }
        }
    }

    // Prints the list menu.
    private static void printListMenu() {
        System.out.println("");
        System.out.println("List Operation Menu");
        System.out.println("---------");
        System.out.println("");
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) mark an item as completed");
        System.out.println("6) unmark an item as completed");
        System.out.println("7) save the current list");
        System.out.println("8) quit to the main menu");
        System.out.println("");
    }

    // Prints the main menu.
    private static void printMainMenu() {
        System.out.println("");
        System.out.println("Main Menu");
        System.out.println("---------");
        System.out.println("");
        System.out.println("1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit");
        System.out.println("");
    }
}
