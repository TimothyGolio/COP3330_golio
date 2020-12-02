import javax.naming.InvalidNameException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ContactApp {
    // Creates main menu for Contact App.
    public static void mainContactAppMenu() {
        int mainMenuResponse = 0;

        while(mainMenuResponse != 3) {
            mainMenuResponse = manageMainMenu();
        }
    }

    // Manages the user input from the main menu.
    private static int manageMainMenu() {
        TaskApp.printMainMenu();
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
        } catch (Exception e) {
            System.out.println("Your input was invalid, must be an integer from 1-3. Please try again.");
            return -1;
        }
    }

    // Creates a new, empty list.
    private static void createList() {
        ContactList list = new ContactList();
        System.out.println("new contact list has been created");
        System.out.println("");
        createListMenu(list);
    }

    // Loads a list from a text file inputted by the user.
    private static void loadList() {
        Scanner scan = new Scanner(System.in);
        ContactList list = new ContactList();

        while(true) {
            System.out.print("Enter the file name to load: ");

            try {
                String filename = scan.nextLine();

                if(filename.equalsIgnoreCase("quit")){
                    break;
                }

                list.loadList(filename, false);
                System.out.println("contact list has been loaded");
                createListMenu(list);
                break;
            } catch (FileNotFoundException e) {
                System.out.println("There was a problem loading your file. Please try again or type \"Quit\" to return to the main menu.");
            } catch (Exception e2) {
                System.out.println("There was a problem. Please try again or type \"Quit\" to return to the main menu.");
            }
        }
    }

    // Creates the list menu.
    private static void createListMenu(ContactList list) {
        int listMenuResponse = 0;

        while(listMenuResponse != 6){
            listMenuResponse = manageListMenu(list);
        }
    }

    // Manages the user input from the list menu.
    private static int manageListMenu(ContactList list) {
        printListMenu();
        int mainMenuResponse;
        Scanner scan = new Scanner(System.in);

        try {
            mainMenuResponse = scan.nextInt();
        } catch (IllegalArgumentException e) {
            System.out.println("Your input was invalid, must be an integer from 1-6. Please try again.");
            return -1;
        } catch (Exception e2) {
            System.out.println("Your input was invalid, must be from 1-6. Please try again.");
            return -1;
        }

        if (mainMenuResponse == 1) {
            viewList(list);
            return 1;
        } else if (mainMenuResponse == 2) {
            addItem(list);
            return 2;
        } else if (mainMenuResponse == 3) {
            editItem(list);
            return 3;
        } else if (mainMenuResponse == 4) {
            removeItem(list);
            return 4;
        } else if (mainMenuResponse == 5) {
            saveCurrentList(list);
            return 5;
        } else if (mainMenuResponse == 6) {
            return 6;
        } else {
            System.out.println("Your input was invalid, must be from 1-6. Please try again.");
            return -1;
        }
    }

    // Prints the current list.
    private static void viewList(ContactList list) {
        int i, size = list.size();

        System.out.println("Current Contacts");
        System.out.println("-------------");
        System.out.println("");

        for(i = 0; i < size; i++) {
            System.out.println(i + ") Name: " + list.getContactFirstName(i) + " " + list.getContactLastName(i));
            System.out.println("Phone: " + list.getContactPhoneNumber(i));
            System.out.println("Email: " + list.getContactEmail(i));
        }
        System.out.println("");
    }

    // Takes user input and creates a contact list with the input. Prompts the user again if there is an error in their input.
    private static void addItem(ContactList list) {
        Scanner scan = new Scanner(System.in);
        ContactItem newContact = new ContactItem("a", "b", "000-000-0000", "a@b.c");

        while(true) {
            try {
                System.out.print("First Name: ");
                String firstName = scan.nextLine();
                newContact.setFirstName(firstName);
                System.out.print("Last Name: ");
                String lastName = scan.nextLine();
                newContact.setLastName(lastName);
                System.out.print("Phone number (xxx-xxx-xxxx): ");
                String phoneNumber = scan.nextLine();
                newContact.setPhoneNumber(phoneNumber);
                System.out.print("Email address (x@y.z): ");
                String email = scan.nextLine();
                newContact.setEmail(email);
                list.addListItem(newContact);
                break;
            } catch (Exception e) {
                System.out.println("Your input was invalid. Please try again");
            }
        }
    }

    // Takes user input for which contact they want to edit.
    private static void editItem(ContactList list) {
        if(list.size() > 0) {
            Scanner scan = new Scanner(System.in);
            viewList(list);
            int index;

            while (true) {
                System.out.print("Which contact will you edit? ");
                try {
                    index = scan.nextInt();
                } catch (IllegalArgumentException e1) {
                    System.out.println("Your input was invalid, must be an integer. Please try again.");
                    continue;
                } catch (IndexOutOfBoundsException e2) {
                    System.out.println("Your input was invalid, must be an integer from 0 - " + (list.size() - 1) + ". Please try again.");
                    continue;
                }

                break;
            }

            while (true) {
                try {
                    handleEditFirstName(list, index);
                    handleEditLastName(list, index);
                    handleEditPhoneNumber(list, index);
                    handleEditEmail(list, index);
                    break;
                } catch (Exception e) {
                    System.out.println("Your input was invalid, at least one value must not be blank. Please try again.");
                }
            }
        } else {
            System.out.println("Your input was invalid, cannot edit an empty list. Please try again.");
        }
    }

    // Takes user input on how to edit the first name and edits that contacts first name value.
    private static void handleEditFirstName(ContactList list, int index) {
        Scanner scan = new Scanner(System.in);

        while(true) {
            try {
                System.out.print("Enter a new first name for contact " + index + ": ");
                list.editContactFirstName(index, scan.nextLine());
                break;
            } catch(Exception e) {
                System.out.println("Your input was invalid, at least one value must not be blank. Please try again.");
            }
        }
    }

    // Takes user input on how to edit the last name and edits that contacts last name value.
    private static void handleEditLastName(ContactList list, int index) {
        Scanner scan = new Scanner(System.in);

        while(true) {
            try {
                System.out.print("Enter a new last name for contact " + index + ": ");
                list.editContactLastName(index, scan.nextLine());
                break;
            } catch(Exception e) {
                System.out.print("Your input was invalid, at least one value must not be blank. Please try again.");
            }
        }
    }

    // Takes user input on how to edit the phone number and edits that contacts phone number value.
    private static void handleEditPhoneNumber(ContactList list, int index) {
        Scanner scan = new Scanner(System.in);

        while(true) {
            try {
                System.out.print("Enter a new phone number (xxx-xxx-xxxx) for contact " + index + ": ");
                list.editContactPhoneNumber(index, scan.nextLine());
                break;
            } catch(Exception e) {
                System.out.print("Your input was invalid, must be of format xxx-xxx-xxxx. Please try again.");
            }
        }
    }

    // Takes user input on how to edit the email and edits that contacts email value.
    private static void handleEditEmail(ContactList list, int index) throws InvalidNameException {
        Scanner scan = new Scanner(System.in);

        String firstName = list.getContactFirstName(index);
        String lastName = list.getContactLastName(index);
        String phoneNumber = list.getContactPhoneNumber(index);

        while(true) {
            try {
                System.out.print("Enter a new email address (x@y.z) for contact " + index + ": ");
                String email = scan.nextLine();

                if(email.equals("") && firstName.equals("") && lastName.equals("") && phoneNumber.equals("")) {
                    throw new InvalidNameException("Your input was invalid, at least one value must not be blank. Please try again.");
                }

                list.editContactEmail(index, email);
                break;
            } catch(IllegalArgumentException e) {
                System.out.println("Your input was invalid, email must be of format a@b.c. Please try again.");
            }
        }
    }

    // Takes user input on which task to remove and removes it.
    private static void removeItem(ContactList list) {
        if(list.size() > 0) {
            viewList(list);
            Scanner scan = new Scanner(System.in);

            while (true) {
                System.out.print("Which contact will you remove? ");

                try {
                    int index = scan.nextInt();
                    list.removeListItem(index);
                    break;
                } catch (Exception e) {
                    System.out.println("Your input was invalid, must be integer from 0-" + (list.size() - 1) + ". Please try again.");
                }
            }
        } else {
            System.out.println("Your input was invalid, cannot edit an empty list. Please try again.");
        }
    }

    // Saves the current list to a text file inputted by the user.
    private static void saveCurrentList(ContactList list) {
        Scanner scan = new Scanner(System.in);

        while(true) {
            System.out.print("Enter the file name to save as: ");

            try {
                String filename = scan.nextLine();
                list.saveList(filename);
                System.out.println("task list has been saved");
                break;
            } catch(IOException e) {
                System.out.println("Your input was invalid. Please try again.");
                continue;
            } catch(Exception e2) {
                System.out.println("Your input was invalid. Please try again.");
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
        System.out.println("5) save the current list");
        System.out.println("6) quit to the main menu");
        System.out.println("");
    }
}

