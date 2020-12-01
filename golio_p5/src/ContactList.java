import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;


public class ContactList {
    ArrayList<ContactItem> list = new ArrayList<ContactItem>();

    public void addListItem(ContactItem contact) {
        list.add(contact);
    }

    public void removeListItem(int index) {
        list.remove(index);
    }

    public int size() {
        return list.size();
    }

    public ContactItem get(int index) {
        return list.get(index);
    }

    public String getContactFirstName(int index) {
        ContactItem contact = list.get(index);
        return contact.getFirstName();
    }

    public String getContactLastName(int index) {
        ContactItem contact = list.get(index);
        return contact.getLastName();
    }

    public String getContactPhoneNumber(int index) {
        ContactItem contact = list.get(index);
        return contact.getPhoneNumber();
    }

    public String getContactEmail(int index) {
        ContactItem contact = list.get(index);
        return contact.getEmail();
    }

    public void editContactFirstName(int index, String newFirstName) {
        ContactItem contact;

        if(index >= 0 && index < list.size()) {
            contact = list.get(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid input. Index is out of bounds. Please try again.");
        }

        contact.setFirstName(newFirstName);
    }

    public void editContactLastName(int index, String newLastName) {
        ContactItem contact;

        if(index >= 0 && index < list.size()) {
            contact = list.get(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid input. Index is out of bounds. Please try again.");
        }

        contact.setLastName(newLastName);
    }

    public void editContactPhoneNumber(int index, String newPhoneNumber) {
        ContactItem contact;

        if(index >= 0 && index < list.size()) {
            contact = list.get(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid input. Index is out of bounds. Please try again.");
        }

        contact.setPhoneNumber(newPhoneNumber);
    }

    public void editContactEmail(int index, String newEmail) {
        ContactItem contact;

        if(index >= 0 && index < list.size()) {
            contact = list.get(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid input. Index is out of bounds. Please try again.");
        }

        contact.setPhoneNumber(newEmail);
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
            ContactItem contact = list.get(i);
            writer.write(contact.toString());
        }
        writer.close();
    }

    public void loadList(String filename, boolean delete) throws FileNotFoundException {

        int size = list.size();

        for(int i = 0; i < size; i++){
            list.remove(i);
        }


        File openedFile = new File(filename);
        Scanner read = new Scanner(openedFile);

        while(read.hasNextLine()) {
            String firstName = read.nextLine();
            String lastName = read.nextLine();
            String phoneNumber = read.nextLine();
            String email = read.nextLine();

            ContactItem contact = new ContactItem(firstName, lastName, phoneNumber, email);
            list.add(contact);
        }

        if(delete == true) {
            try {
                Files.delete(openedFile.toPath());
            } catch (IOException e) {
            }
        }
    }
}
