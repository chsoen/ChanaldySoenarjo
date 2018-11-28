/**
 * A teacher's first and last name, and subject.
 *
 * @author Chanaldy Soenarjo
 * @version 8
 */
public class Teacher {
    private String firstName;
    private String lastName;
    private String subject;

    /**
     * Constructs a teacher instance with full name and subject
     *
     * @param firstName
     * @param lastName
     * @param subject
     */
    Teacher(String firstName, String lastName, String subject) {
        setFirstName(firstName);
        setLastName(lastName);
        setSubject(subject);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (!firstName.isEmpty()) {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (!lastName.isEmpty()) {
            this.lastName = lastName;
        }
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        if (!subject.isEmpty()) {
            this.subject = subject;
        }
    }

    /**
     * Returns a string formatting full name and subject
     *
     * @return full name and subject
     */
    public String toString() {
        return "Name: " + firstName + " " + lastName + " Subject: " + subject;
    }
}
