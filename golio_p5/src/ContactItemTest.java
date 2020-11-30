import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest {

    @Test
    public void creationFailsWithAllBlankValues() {
        assertThrows(IllegalArgumentException.class, () -> new ContactItem("", "", "", "");
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
        assertEquals("Wunsly", contact2.getFirstName());
        assertEquals("", contact2.getLastName());
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
        assertEquals("954954954954", contact3.getPhoneNumber());

        ContactItem contact4 = new ContactItem("", "", "", "HelloWorld@java.com");
        assertThrows(IllegalArgumentException.class, () -> contact4.setEmail(""));
        assertEquals("HelloWorld@java.com", contact4.getEmail());
    }

    @Test
    public void editingSucceedsWithBlankEmail() {
        ContactItem contact = new ContactItem("Margeret", "", "", "");

        contact.setFirstName("Maggie")
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

        contact.setLastName("Pop")
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

        contact.setFirstName("X Æ A-12")
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

        contact.setEmail("Goverment@gov.gov")
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
        assertEquals(str, "4#$rdagRER\nabcdefghijklmnopqrstuvwxyz1234567890 _\n000-000-0000\nEmail@Email.Email");
    }

}