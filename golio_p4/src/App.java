import javax.naming.InvalidNameException;
import java.util.Scanner;

public class App {

    public static void main(String[] args){
        int mainMenuResponse = 0;
        while(mainMenuResponse!= 3);
            mainMenuResponse = manageMainMenu();
        }
    }

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
                return 2
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

    private static void createList() {
        TaskList list = new TaskList();
        System.out.println("new task list has been created");
        int listMenuResponse = 0;
        while(listMenuResponse != 8) {
            listMenuResponse = manageListMenu(list);
        }
    }

    private static int manageListMenu(TaskList list) {
        printListMenu();
        Scanner scan = new Scanner(System.in);
        try {
            int mainMenuResponse = scan.nextInt();
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
                removeItem();
                return 4;
            } else if(mainMenuResponse == 5) {
                markItemAsComplete();
                return 5;
            } else if(mainMenuResponse == 6) {
                unmarkItemAsComplete();
                return 6;
            } else if(mainMenuResponse == 7) {
                saveCurrentList();
                return 7;
            } else if(mainMenuResponse == 8) {
                return 8;
            } else {
                System.out.println("Your input was invalid, must be from 1-3. Please try again.");
                return -1;
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Your input was invalid, must be an integer from 1-3. Please try again.");
            return -1;
        }
    }

    private static void viewList(TaskList list) {
        int i, size = list.size();
        System.out.println("Current Tasks");
        System.out.println("-------------");
        System.out.println("");
        for(i = 0; i < size; i++) {
            TaskItem task = list.get(i);
            System.out.println(i + ") [" + task.getDuedate() + "] " + task.getTitle() + ": " + task.getDescription());
        }
        System.out.println("");
    }

    private static void addItem(TaskList list) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Task title: ");
        String title = scan.nextLine();
        System.out.print("Task description: ");
        String description = scan.nextLine();
        System.out.print("Task due date (YYYY-MM-DD): ");
        String duedate = scan.nextLine();
        TaskItem todo = null;
        try {
            todo = new TaskItem(title, description, duedate);
        } catch (InvalidNameException e) {
            e.printStackTrace();
        }
        System.out.print("");
        list.addListItem(todo);
    }

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
        handleEditTitle(task, index);
        handleEditDescription(task, index);
        handleEditDate(task);

    }

    private static void handleEditDate(TaskItem task) {

    }

    private static void handleEditDescription(TaskItem task, int index) {
        Scanner scan = new Scanner(System.in);
        String newDescription;
        System.out.print("Enter a new description for task " + index + ": ");
        newDescription = scan.nextLine();
        task.setDescription(newDescription);
    }

    private static void handleEditTitle(TaskItem task, int index) {
        Scanner scan = new Scanner(System.in);
        String newTitle;
        while(true) {
            System.out.print("Enter a new title for task " + index + ": ");
            newTitle = scan.nextLine();
            try {
                task.setTitle(newTitle);
            } catch (InvalidNameException e) {
                e.printStackTrace();
                continue;
            }
            break;
        }

    }

    private static void removeItem() {
    }

    private static void markItemAsComplete() {
    }

    private static void unmarkItemAsComplete() {
    }

    private static void saveCurrentList() {
    }

    private static void printListMenu() {
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

    private static void printMainMenu() {
        System.out.println("Main Menu");
        System.out.println("---------");
        System.out.println("");
        System.out.println("1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit");
        System.out.println("");
    }
}
