import java.util.regex.Pattern;

public class ContactItem {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public ContactItem(String firstName, String lastName, String phoneNumber, String email) {

        if(firstName.equals("") && lastName.equals("") && phoneNumber.equals("") && email.equals("")) {
            throw new IllegalArgumentException("Invalid input. At least one value in the contact must not be blank. Please try again.");
        } else if(phoneNumberIsValid(phoneNumber) == false) {
            throw new IllegalArgumentException("Invalid input. Phone number must be in format xxx-xxx-xxxx. Please try again.");
        } else if(emailIsValid(email) == false) {
            throw new IllegalArgumentException("Invalid input. Email must be in format a@b.c. Please try again.");
        } else {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        if(firstName.equals("") && lastName.equals("") && phoneNumber.equals("") && email.equals("")) {
            throw new IllegalArgumentException("Invalid input. At least one value in the contact must not be blank. Please try again.");
        } else {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if(lastName.equals("") && firstName.equals("") && phoneNumber.equals("") && email.equals("")) {
            throw new IllegalArgumentException("Invalid input. At least one value in the contact must not be blank. Please try again.");
        } else {
            this.lastName = lastName;
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber.equals("") && firstName.equals("") && lastName.equals("") && email.equals("")) {
            throw new IllegalArgumentException("Invalid input. At least one value in the contact must not be blank. Please try again.");
        } else if (ContactItem.phoneNumberIsValid(phoneNumber) == false){
            throw new IllegalArgumentException("Invalid input. Phone number must be in format xxx-xxx-xxxx. Please try again.");
        } else {
            this.phoneNumber = phoneNumber;
        }
    }

    public void setEmail(String email) {
        if(email.equals("") && firstName.equals("") && lastName.equals("") && phoneNumber.equals("")) {
            throw new IllegalArgumentException("Invalid input. At least one value in the contact must not be blank. Please try again.");
        } else if (ContactItem.emailIsValid(email) == false){
            throw new IllegalArgumentException("Invalid input. Email must be of format a@b.c. Please try again.");
        } else {
            this.email = email;
        }
    }

    public static boolean phoneNumberIsValid(String phoneNumber) {
        String phoneNumberRegex = "(?:\\d{3}-){2}\\d{4}$";
        Pattern pattern = Pattern.compile(phoneNumberRegex);

        if(pattern.matcher(phoneNumber).matches() || phoneNumber.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean emailIsValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{1,7}$";
        Pattern pattern = Pattern.compile(emailRegex);

        if(pattern.matcher(email).matches() || email.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return firstName + "\n" + lastName + "\n" + phoneNumber + "\n" + email + "\n";
    }

}
