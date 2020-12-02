import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;


public class ContactList {
    ArrayList<ContactItem> list = new ArrayList<ContactItem>();

    // Adds the given contact item to the list.
    public void addListItem(ContactItem contact) {
        list.add(contact);
    }

    // Removes the contact item at the given index.
    public void removeListItem(int index) {
        list.remove(index);
    }

    // Returns the size of the list.
    public int size() {
        return list.size();
    }

    // Returns the contact item at a specific index.
    public ContactItem get(int index) {
        return list.get(index);
    }

    // Returns the first name of the contact item at a specific index.
    public String getContactFirstName(int index) {
        ContactItem contact = list.get(index);
        return contact.getFirstName();
    }

    // Returns the last name of the contact item at a specific index.
    public String getContactLastName(int index) {
        ContactItem contact = list.get(index);
        return contact.getLastName();
    }

    // Returns the phone number of the contact item at a specific index.
    public String getContactPhoneNumber(int index) {
        ContactItem contact = list.get(index);
        return contact.getPhoneNumber();
    }

    // Returns the email of the contact item at a specific index.
    public String getContactEmail(int index) {
        ContactItem contact = list.get(index);
        return contact.getEmail();
    }

    // Edits the first name of the contact item at a specific index.
    public void editContactFirstName(int index, String newFirstName) {
        ContactItem contact;

        if(index >= 0 && index < list.size()) {
            contact = list.get(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid input. Index is out of bounds. Please try again.");
        }

        contact.setFirstName(newFirstName);
    }

    // Edits the last name of the contact item at a specific index.
    public void editContactLastName(int index, String newLastName) {
        ContactItem contact;

        if(index >= 0 && index < list.size()) {
            contact = list.get(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid input. Index is out of bounds. Please try again.");
        }

        contact.setLastName(newLastName);
    }

    // Edits the phone number of the contact item at a specific index.
    public void editContactPhoneNumber(int index, String newPhoneNumber) {
        ContactItem contact;

        if(index >= 0 && index < list.size()) {
            contact = list.get(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid input. Index is out of bounds. Please try again.");
        }

        contact.setPhoneNumber(newPhoneNumber);
    }

    // Edits the email of the contact item at a specific index.
    public void editContactEmail(int index, String newEmail) {
        ContactItem contact;

        if(index >= 0 && index < list.size()) {
            contact = list.get(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid input. Index is out of bounds. Please try again.");
        }

        contact.setEmail(newEmail);
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
        writer.write("Contact List\n");

        for(int i = 0; i < size; i++) {
            ContactItem contact = list.get(i);
            writer.write(contact.toString());
        }

        writer.close();
    }

    // loads the list in the file at the given file name
    public void loadList(String filename, boolean delete) throws FileNotFoundException {
        list.clear();
        File openedFile = new File(filename);
        Scanner read = new Scanner(openedFile);
        String isContactList = read.nextLine();

        if(isContactList.equals("Contact List")) {

            while (read.hasNextLine()) {
                String firstName = read.nextLine();
                String lastName = read.nextLine();
                String phoneNumber = read.nextLine();
                String email = read.nextLine();

                ContactItem contact = new ContactItem(firstName, lastName, phoneNumber, email);
                list.add(contact);
            }

            if (delete == true) {
                try {
                    Files.delete(openedFile.toPath());
                } catch (IOException e) {
                }
            }
        } else {
            throw new IllegalArgumentException("Invalid input, File is not a contact list. Please try again");
        }
    }
}
