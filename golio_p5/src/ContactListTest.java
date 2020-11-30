import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {

    // Required Tests

    @Test
    public void addingItemsIncreasesSize() {
        ContactItem contact = new ContactItem("a", "b", "999-999-0000", "a@b.c");
        ContactList list = new ContactList();
        int initialSize = contact.size();
        list.addListItem(contact);
        assertEquals(list.size(), initialSize + 1);
        ContactItem task2 = new ContactItem("x", "y", "001-100-1010", "Java@Java.Java");
        list.addListItem(task2);
        assertEquals(list.size(), initialSize + 2);
    }

    @Test
    public void editingItemsFailsWithAllBlankValues() {
        ContactItem contact = new ContactItem("9", "", "", "");
        ContactList list = new ContactList();
        list.add(contact);
        assertThrows(IllegalArgumentException.class, () -> list.editContactFirstName(0, ""));
        assertEquals(contact.getFirstName(), "9");
    }

    @Test
    public void editingItemsFailsWithInvalidIndex() {
        ContactItem contact = new ContactItem("_", "", "", "");
        ContactList list = new ContactList();
        list.add(contact);

        assertThrows(IndexOutOfBoundsException.class, () -> list.editContactFirstName(1, "a"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.editContactLastName(1000000, "a"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.editContactPhoneNumber(-1, "012-345-6789"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.editContactPhoneNumber(-1000000, "w_...@g....wumbo"));

        assertEquals(contact.getFirstName(), "_");
        assertEquals(contact.getLastName(), "");
        assertEquals(contact.getPhoneNumber(), "");
        assertEquals(contact.getEmail(), "");
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactItem contact = new ContactItem("", "bnuckly", "", "");
        ContactList list = new ContactList();
        list.add(contact);

        list.editLastName(0, "burkly");
        assertEquals(contact.getFirstName(), "");
        assertEquals(contact.getLastName(), "burkly");
        assertEquals(contact.getPhoneNumber(), "");
        assertEquals(contact.getEmail(), "");

        list.editFirstName(0, "durkly");
        assertEquals(contact.getFirstName(), "durkly");
        assertEquals(contact.getLastName(), "burkly");
        assertEquals(contact.getPhoneNumber(), "");
        assertEquals(contact.getEmail(), "");

        list.editLastName(0, "");
        assertEquals(contact.getFirstName(), "durkly");
        assertEquals(contact.getLastName(), "");
        assertEquals(contact.getPhoneNumber(), "");
        assertEquals(contact.getEmail(), "");
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactItem contact = new ContactItem("Bug", "", "", "");
        ContactList list = new ContactList();
        list.add(contact);

        list.editFirstName(0, "Worm");
        assertEquals(contact.getFirstName(), "Worm");
        assertEquals(contact.getLastName(), "");
        assertEquals(contact.getPhoneNumber(), "");
        assertEquals(contact.getEmail(), "");

        list.editLastName(0, "Man");
        assertEquals(contact.getFirstName(), "Worm");
        assertEquals(contact.getLastName(), "Man");
        assertEquals(contact.getPhoneNumber(), "");
        assertEquals(contact.getEmail(), "");

        list.editFirstName(0, "");
        assertEquals(contact.getFirstName(), "");
        assertEquals(contact.getLastName(), "Man");
        assertEquals(contact.getPhoneNumber(), "");
        assertEquals(contact.getEmail(), "");
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactItem contact = new ContactItem(" ", "", "", "");
        ContactList list = new ContactList();
        list.add(contact);

        list.editFirstName(0, "  ");
        assertEquals(contact.getFirstName(), "  ");
        assertEquals(contact.getLastName(), "");
        assertEquals(contact.getPhoneNumber(), "");
        assertEquals(contact.getEmail(), "");

        list.editPhoneNumber(0, "000-000-0000");
        assertEquals(contact.getFirstName(), "  ");
        assertEquals(contact.getLastName(), "");
        assertEquals(contact.getPhoneNumber(), "000-000-0000");
        assertEquals(contact.getEmail(), "");

        list.editFirstName(0, "");
        assertEquals(contact.getFirstName(), "");
        assertEquals(contact.getLastName(), "");
        assertEquals(contact.getPhoneNumber(), "000-000-0000");
        assertEquals(contact.getEmail(), "");
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactItem contact = new ContactItem("- - - - ", "         ", "000-000-0000", "a@b.z");
        ContactList list = new ContactList();
        list.add(contact);

        list.editFirstName(0, "First Name");
        assertEquals("First Name", contact.getFirstName());
        assertEquals("         ", contact.getLastName());
        assertEquals("000-000-0000", contact.getPhoneNumber());
        assertEquals("a@b.z", contact.getEmail());

        list.editLastName(0, "Last Name");
        assertEquals("First Name", contact.getFirstName());
        assertEquals("Last Name", contact.getLastName());
        assertEquals("000-000-0000", contact.getPhoneNumber());
        assertEquals("a@b.z", contact.getEmail());

        list.editPhoneNumber(0, "999-999-9876");
        assertEquals("First Name", contact.getFirstName());
        assertEquals("Last Name", contact.getLastName());
        assertEquals("999-999-9876", contact.getPhoneNumber());
        assertEquals("a@b.z", contact.getEmail());

        list.editEmail(0, "Email@Email.Email");
        assertEquals("First Name", contact.getFirstName());
        assertEquals("Last Name", contact.getLastName());
        assertEquals("999-999-9876", contact.getPhoneNumber());
        assertEquals("Email@Email.Email", contact.getEmail());

    }

    @Test
    public void newListIsEmpty() {
        ContactList list = new ContactList();
        assertEquals(list.size(), 0);
        assertThrows(IndexOutOfBoundsException.class, () -> list.editContactFirstName(0, "a"));
    }

    @Test
    public void removingItemsDecreasesSize() {
        ContactList list = new ContactList();
        ContactItem contact = new ContactItem("a", "shark", "911-411-1234", "a@a.a");
        ContactItem contact2 = new ContactItem("b", "shark2", "911-411-1357", "b@b.b");
        list.add(contact);
        list.add(contact2);
        int initialSize = list.size();
        list.remove(1);
        assertEquals(list.size(), initialSize - 1);
        assertEquals(list.size(), 1);
        list.remove(0);
        assertEquals(list.size(), initialSize - 2);
        assertEquals(list.size(), 0);
    }

    @Test
    public void removingItemsFailsWithInvalidIndex() {
        ContactList list = new ContactList();
        ContactItem contact = new ContactItem("Mario", "", "800-411-6194", "Mariobros@mushroomkingdom.net");
        list.add(contact);
        assertThrows(IndexOutOfBoundsException.class, () -> list.editContactFirstName(1, "Luigi"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.editContactLastName(1000000, "Toad"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.editPhoneNumber(-1, "011-235-8132"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.editContactLastName(-1000000, "Nintendo@nintendo.com"));

        assertEquals(contact.getFirstName(), "Mario");
        assertEquals(contact.getLastName(), "");
        assertEquals(contact.getPhoneNumber(), "800-411-6194");
        assertEquals(contact.getEmail(), "Mariobros@mushroomkingdom.net");
    }

    @Test
    public void savedContactListCanBeLoaded() {
        ContactItem contact = new ContactItem("a", "ergdfrgeadrbed_", "111-111-1111", "l@o.l");
        ContactList list = new ContactList();
        list.addListItem(contact);

        try {
            list.saveList("example.txt");
        } catch (IOException e) {
        }

        list.removeListItem(0);
        assertEquals(list.size(), 0);
        assertThrows(IndexOutOfBoundsException.class, () -> list.getContactFirstName(0));

        try {
            list.loadList("example.txt", true);
        } catch (FileNotFoundException e) {
        }

        assertEquals(list.getContactFirstName(0), "a");
        assertEquals(list.getContactLastName(0), "ergdfrgeadrbed_");
        assertEquals(list.getContactPhoneNumber(0), "111-111-1111");
        assertEquals(list.getContactEmail(0), "l@o.l");
    }

    // Additional Tests

    @Test
    public void editToInvalidPhoneNumberFails() {
        ContactItem contact = new ContactItem("_", "", "", "");
        ContactItem contact2 = new ContactItem("_", "", "000-000-0000", "");
        ContactList list = new ContactList();
        list.add(contact);
        list.add(contact2);
        assertThrows(IllegalArgumentException.class, () -> list.editPhoneNumber(0, "911"));
        assertThrows(IllegalArgumentException.class, () -> list.editPhoneNumber(0, "a"));
        assertThrows(IllegalArgumentException.class, () -> list.editPhoneNumber(0, "---"));
        assertThrows(IllegalArgumentException.class, () -> list.editPhoneNumber(0, "000--0000"));
        assertThrows(IllegalArgumentException.class, () -> list.editPhoneNumber(0, "a000-000-0000"));
        assertThrows(IllegalArgumentException.class, () -> list.editPhoneNumber(0, " 000-000-0111"));
        assertThrows(IllegalArgumentException.class, () -> list.editPhoneNumber(0, "ghbreuigbhnaerjigrfdnvb8345t6782345ty__["));

        assertThrows(IllegalArgumentException.class, () -> list.editPhoneNumber(1, "911"));
        assertThrows(IllegalArgumentException.class, () -> list.editPhoneNumber(1, "a"));
        assertThrows(IllegalArgumentException.class, () -> list.editPhoneNumber(1, "---"));
        assertThrows(IllegalArgumentException.class, () -> list.editPhoneNumber(1, "000--0000"));
        assertThrows(IllegalArgumentException.class, () -> list.editPhoneNumber(1, "a000-000-0000"));
        assertThrows(IllegalArgumentException.class, () -> list.editPhoneNumber(1, " 000-000-0111"));
        assertThrows(IllegalArgumentException.class, () -> list.editPhoneNumber(1, "ghbreuigbhnaerjigrfdnvb8345t6782345ty__["));

        assertEquals(contact.getPhoneNumber(), "");
        assertEquals(contact2.getPhoneNumber(), "000-000-0000");
    }

    @Test
    public void editToInvalidEmailFails() {
        ContactItem contact = new ContactItem("_", "", "", "");
        ContactItem contact2 = new ContactItem("_", "", "", "a@b.c");
        ContactList list = new ContactList();
        list.add(contact);
        list.add(contact2);
        assertThrows(IllegalArgumentException.class, () -> list.editEmail(0, "a"));
        assertThrows(IllegalArgumentException.class, () -> list.editEmail(0, "1"));
        assertThrows(IllegalArgumentException.class, () -> list.editEmail(0, "@."));
        assertThrows(IllegalArgumentException.class, () -> list.editEmail(0, " @ . "));
        assertThrows(IllegalArgumentException.class, () -> list.editEmail(0, "1@3.6"));
        assertThrows(IllegalArgumentException.class, () -> list.editEmail(0, "Valid Email Address"));
        assertThrows(IllegalArgumentException.class, () -> list.editEmail(0, "a@@b..c"));
        assertThrows(IllegalArgumentException.class, () -> list.editEmail(0, "a@b.c."));
        assertThrows(IllegalArgumentException.class, () -> list.editEmail(0, "@a@b.c."));

        assertThrows(IllegalArgumentException.class, () -> list.editEmail(1, "a"));
        assertThrows(IllegalArgumentException.class, () -> list.editEmail(1, "1"));
        assertThrows(IllegalArgumentException.class, () -> list.editEmail(1, "@."));
        assertThrows(IllegalArgumentException.class, () -> list.editEmail(1, " @ . "));
        assertThrows(IllegalArgumentException.class, () -> list.editEmail(1, "1@3.6"));
        assertThrows(IllegalArgumentException.class, () -> list.editEmail(1, "Valid Email Address"));
        assertThrows(IllegalArgumentException.class, () -> list.editEmail(1, "a@@b..c"));
        assertThrows(IllegalArgumentException.class, () -> list.editEmail(1, "a@b.c."));
        assertThrows(IllegalArgumentException.class, () -> list.editEmail(1, "@a@b.c."));

        assertEquals(contact.getEmail(), "");
        assertEquals(contact2.getEmail(), "a@b.c");
    }
}