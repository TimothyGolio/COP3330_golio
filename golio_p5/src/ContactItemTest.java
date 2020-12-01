import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest {

    // Required Tests

    @Test
    public void creationFailsWithAllBlankValues() {
        assertThrows(IllegalArgumentException.class, () -> new ContactItem("", "", "", ""));
    }

    @Test
    public void creationSucceedsWithBlankEmail() {
        ContactItem contact = new ContactItem("Dun", "Wunsly", "911-911-9111", "");
        assertEquals("Dun", contact.getFirstName());
        assertEquals("Wunsly", contact.getLastName());
        assertEquals("911-911-9111", contact.getPhoneNumber());
        assertEquals("", contact.getEmail());
    }

    @Test
    public void creationSucceedsWithBlankFirstName() {
        ContactItem contact = new ContactItem("", "Wunsly", "911-911-9111", "ImDum@yahoo.com");
        assertEquals("", contact.getFirstName());
        assertEquals("Wunsly", contact.getLastName());
        assertEquals("911-911-9111", contact.getPhoneNumber());
        assertEquals("ImDum@yahoo.com", contact.getEmail());
    }

    @Test
    public void creationSucceedsWithBlankLastName() {
        ContactItem contact = new ContactItem("Dun", "", "911-911-9111", "ImDum@yahoo.com");
        assertEquals("Dun", contact.getFirstName());
        assertEquals("", contact.getLastName());
        assertEquals("911-911-9111", contact.getPhoneNumber());
        assertEquals("ImDum@yahoo.com", contact.getEmail());
    }

    @Test
    public void creationSucceedsWithBlankPhone() {
        ContactItem contact = new ContactItem("Dun", "Wunsly", "", "ImDum@yahoo.com");
        assertEquals("Dun", contact.getFirstName());
        assertEquals("Wunsly", contact.getLastName());
        assertEquals("", contact.getPhoneNumber());
        assertEquals("ImDum@yahoo.com", contact.getEmail());
    }

    @Test
    public void creationSucceedsWithNonBlankValues() {
        ContactItem contact = new ContactItem("Dun", "", "", "");
        assertEquals("Dun", contact.getFirstName());
        assertEquals("", contact.getLastName());
        assertEquals("", contact.getPhoneNumber());
        assertEquals("", contact.getEmail());

        ContactItem contact2 = new ContactItem("", "Wunsly", "", "");
        assertEquals("", contact2.getFirstName());
        assertEquals("Wunsly", contact2.getLastName());
        assertEquals("", contact2.getPhoneNumber());
        assertEquals("", contact2.getEmail());

        ContactItem contact3 = new ContactItem("", "", "911-911-9111", "");
        assertEquals("", contact3.getFirstName());
        assertEquals("", contact3.getLastName());
        assertEquals("911-911-9111", contact3.getPhoneNumber());
        assertEquals("", contact3.getEmail());

        ContactItem contact4 = new ContactItem("", "", "", "ImDum@yahoo.com");
        assertEquals("", contact4.getFirstName());
        assertEquals("", contact4.getLastName());
        assertEquals("", contact4.getPhoneNumber());
        assertEquals("ImDum@yahoo.com", contact4.getEmail());

        ContactItem contact5 = new ContactItem("Dun", "Wunsly", "911-911-9111", "ImDum@yahoo.com");
        assertEquals("Dun", contact5.getFirstName());
        assertEquals("Wunsly", contact5.getLastName());
        assertEquals("911-911-9111", contact5.getPhoneNumber());
        assertEquals("ImDum@yahoo.com", contact5.getEmail());
    }

    @Test
    public void editingFailsWithAllBlankValues() {
        ContactItem contact = new ContactItem("Richard", "", "", "");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(""));
        assertEquals("Richard", contact.getFirstName());

        ContactItem contact2 = new ContactItem("", "Urkel", "", "");
        assertThrows(IllegalArgumentException.class, () -> contact2.setLastName(""));
        assertEquals("Urkel", contact2.getLastName());

        ContactItem contact3 = new ContactItem("", "", "954-954-9549", "");
        assertThrows(IllegalArgumentException.class, () -> contact3.setPhoneNumber(""));
        assertEquals("954-954-9549", contact3.getPhoneNumber());

        ContactItem contact4 = new ContactItem("", "", "", "HelloWorld@java.com");
        assertThrows(IllegalArgumentException.class, () -> contact4.setEmail(""));
        assertEquals("HelloWorld@java.com", contact4.getEmail());
    }

    @Test
    public void editingSucceedsWithBlankEmail() {
        ContactItem contact = new ContactItem("Margeret", "", "", "");

        contact.setFirstName("Maggie");
        assertEquals("Maggie", contact.getFirstName());
        assertEquals("", contact.getLastName());
        assertEquals("", contact.getPhoneNumber());
        assertEquals("", contact.getEmail());

        contact.setEmail("ImMaggie@earthlink.net");
        assertEquals("Maggie", contact.getFirstName());
        assertEquals("", contact.getLastName());
        assertEquals("", contact.getPhoneNumber());
        assertEquals("ImMaggie@earthlink.net", contact.getEmail());

        contact.setFirstName("");
        assertEquals("", contact.getFirstName());
        assertEquals("", contact.getLastName());
        assertEquals("", contact.getPhoneNumber());
        assertEquals("ImMaggie@earthlink.net", contact.getEmail());
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactItem contact = new ContactItem("", "Poppins", "", "");

        contact.setLastName("Pop");
        assertEquals("", contact.getFirstName());
        assertEquals("Pop", contact.getLastName());
        assertEquals("", contact.getPhoneNumber());
        assertEquals("", contact.getEmail());

        contact.setFirstName("Mary");
        assertEquals("Mary", contact.getFirstName());
        assertEquals("Pop", contact.getLastName());
        assertEquals("", contact.getPhoneNumber());
        assertEquals("", contact.getEmail());

        contact.setLastName("");
        assertEquals("Mary", contact.getFirstName());
        assertEquals("", contact.getLastName());
        assertEquals("", contact.getPhoneNumber());
        assertEquals("", contact.getEmail());
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactItem contact = new ContactItem("Normal Name", "", "", "");

        contact.setFirstName("X Æ A-12");
        assertEquals("X Æ A-12", contact.getFirstName());
        assertEquals("", contact.getLastName());
        assertEquals("", contact.getPhoneNumber());
        assertEquals("", contact.getEmail());

        contact.setLastName("Musk");
        assertEquals("X Æ A-12", contact.getFirstName());
        assertEquals("Musk", contact.getLastName());
        assertEquals("", contact.getPhoneNumber());
        assertEquals("", contact.getEmail());

        contact.setFirstName("");
        assertEquals("", contact.getFirstName());
        assertEquals("Musk", contact.getLastName());
        assertEquals("", contact.getPhoneNumber());
        assertEquals("", contact.getEmail());
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactItem contact = new ContactItem("", "", "", "Emergency@gov.com");

        contact.setEmail("Goverment@gov.gov");
        assertEquals("", contact.getFirstName());
        assertEquals("", contact.getLastName());
        assertEquals("", contact.getPhoneNumber());
        assertEquals("Goverment@gov.gov", contact.getEmail());

        contact.setPhoneNumber("911-000-0000");
        assertEquals("", contact.getFirstName());
        assertEquals("", contact.getLastName());
        assertEquals("911-000-0000", contact.getPhoneNumber());
        assertEquals("Goverment@gov.gov", contact.getEmail());

        contact.setEmail("");
        assertEquals("", contact.getFirstName());
        assertEquals("", contact.getLastName());
        assertEquals("911-000-0000", contact.getPhoneNumber());
        assertEquals("", contact.getEmail());
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactItem contact = new ContactItem("4#$rdagRER", "abcdefghijklmnopqrstuvwxyz1234567890 _", "000-000-0000", "Email@Email.Email");

        contact.setFirstName("Email");
        assertEquals("Email", contact.getFirstName());
        assertEquals("abcdefghijklmnopqrstuvwxyz1234567890 _", contact.getLastName());
        assertEquals("000-000-0000", contact.getPhoneNumber());
        assertEquals("Email@Email.Email", contact.getEmail());

        contact.setLastName("Email");
        assertEquals("Email", contact.getFirstName());
        assertEquals("Email", contact.getLastName());
        assertEquals("000-000-0000", contact.getPhoneNumber());
        assertEquals("Email@Email.Email", contact.getEmail());

        contact.setPhoneNumber("111-111-1111");
        assertEquals("Email", contact.getFirstName());
        assertEquals("Email", contact.getLastName());
        assertEquals("111-111-1111", contact.getPhoneNumber());
        assertEquals("Email@Email.Email", contact.getEmail());

        contact.setEmail("a@a.a");
        assertEquals("Email", contact.getFirstName());
        assertEquals("Email", contact.getLastName());
        assertEquals("111-111-1111", contact.getPhoneNumber());
        assertEquals("a@a.a", contact.getEmail());
    }

    @Test
    public void testToString() {
        ContactItem contact = new ContactItem("4#$rdagRER", "abcdefghijklmnopqrstuvwxyz1234567890 _", "000-000-0000", "Email@Email.Email");
        String str = contact.toString();
        assertEquals(str, "4#$rdagRER\nabcdefghijklmnopqrstuvwxyz1234567890 _\n000-000-0000\nEmail@Email.Email\n");
    }

    // Additional Tests

    @Test
    public void creationFailsWithInvalidPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> new ContactItem("", "", "911", ""));
        assertThrows(IllegalArgumentException.class, () -> new ContactItem("", "", "a", ""));
        assertThrows(IllegalArgumentException.class, () -> new ContactItem("", "", "---", ""));
        assertThrows(IllegalArgumentException.class, () -> new ContactItem("", "", "000--0000", ""));
        assertThrows(IllegalArgumentException.class, () -> new ContactItem("", "", "a000-000-0000", ""));
        assertThrows(IllegalArgumentException.class, () -> new ContactItem("", "", " 000-000-0111", ""));
        assertThrows(IllegalArgumentException.class, () -> new ContactItem("", "", "ghbreuigbhnaerjigrfdnvb8345t6782345ty__[", ""));
    }

    @Test
    public void creationFailsWithInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> new ContactItem("", "", "", "a"));
        assertThrows(IllegalArgumentException.class, () -> new ContactItem("", "", "", "1"));
        assertThrows(IllegalArgumentException.class, () -> new ContactItem("", "", "", "@."));
        assertThrows(IllegalArgumentException.class, () -> new ContactItem("", "", "", " @ . "));
        assertThrows(IllegalArgumentException.class, () -> new ContactItem("", "", "", "1@3.6"));
        assertThrows(IllegalArgumentException.class, () -> new ContactItem("", "", "", "Valid Email Address"));
        assertThrows(IllegalArgumentException.class, () -> new ContactItem("", "", "", "a@@b..c"));
        assertThrows(IllegalArgumentException.class, () -> new ContactItem("", "", "", "a@b.c."));
        assertThrows(IllegalArgumentException.class, () -> new ContactItem("", "", "", "@a@b.c."));
    }

    @Test
    public void editFailsWithInvalidPhoneNumber() {
        ContactItem contact = new ContactItem("_", "", "", "");
        ContactItem contact2 = new ContactItem("_", "", "000-000-0000", "");

        assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber("911"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber("a"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber("---"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber("000--0000"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber("a000-000-0000"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber(" 000-000-0111"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber("ghbreuigbhnaerjigrfdnvb8345t6782345ty__["));

        assertThrows(IllegalArgumentException.class, () -> contact2.setPhoneNumber("911"));
        assertThrows(IllegalArgumentException.class, () -> contact2.setPhoneNumber("a"));
        assertThrows(IllegalArgumentException.class, () -> contact2.setPhoneNumber("---"));
        assertThrows(IllegalArgumentException.class, () -> contact2.setPhoneNumber("000--0000"));
        assertThrows(IllegalArgumentException.class, () -> contact2.setPhoneNumber("a000-000-0000"));
        assertThrows(IllegalArgumentException.class, () -> contact2.setPhoneNumber(" 000-000-0111"));
        assertThrows(IllegalArgumentException.class, () -> contact2.setPhoneNumber("ghbreuigbhnaerjigrfdnvb8345t6782345ty__["));

        assertEquals(contact.getPhoneNumber(), "");
        assertEquals(contact2.getPhoneNumber(), "000-000-0000");
    }

    @Test
    public void editFailsWithInvalidEmail() {
        ContactItem contact = new ContactItem("_", "", "", "");
        ContactItem contact2 = new ContactItem("_", "", "", "a@b.c");

        assertThrows(IllegalArgumentException.class, () -> contact.setEmail("a"));
        assertThrows(IllegalArgumentException.class, () -> contact.setEmail("1"));
        assertThrows(IllegalArgumentException.class, () -> contact.setEmail("@."));
        assertThrows(IllegalArgumentException.class, () -> contact.setEmail(" @ . "));
        assertThrows(IllegalArgumentException.class, () -> contact.setEmail("1@3.6"));
        assertThrows(IllegalArgumentException.class, () -> contact.setEmail("Valid Email Address"));
        assertThrows(IllegalArgumentException.class, () -> contact.setEmail("a@@b..c"));
        assertThrows(IllegalArgumentException.class, () -> contact.setEmail("a@b.c."));
        assertThrows(IllegalArgumentException.class, () -> contact.setEmail("@a@b.c."));

        assertThrows(IllegalArgumentException.class, () -> contact2.setEmail("a"));
        assertThrows(IllegalArgumentException.class, () -> contact2.setEmail("1"));
        assertThrows(IllegalArgumentException.class, () -> contact2.setEmail("@."));
        assertThrows(IllegalArgumentException.class, () -> contact2.setEmail(" @ . "));
        assertThrows(IllegalArgumentException.class, () -> contact2.setEmail("1@3.6"));
        assertThrows(IllegalArgumentException.class, () -> contact2.setEmail("Valid Email Address"));
        assertThrows(IllegalArgumentException.class, () -> contact2.setEmail("a@@b..c"));
        assertThrows(IllegalArgumentException.class, () -> contact2.setEmail("a@b.c."));
        assertThrows(IllegalArgumentException.class, () -> contact2.setEmail("@a@b.c."));

        assertEquals(contact.getEmail(), "");
        assertEquals(contact2.getEmail(), "a@b.c");
    }

}