/**
 * Contains a student's first and last name, grade, and student number
 *
 * @author Chanaldy Soenarjo
 * @version 8
 */
public class Student {
    private String firstName;
    private String lastName;
    private int grade;
    private int studentNum;
    private static int nextStudentNum = 1;

    /**
     * Constructs a student instance with full name and grade
     *
     * @param firstName
     * @param lastName
     * @param grade
     */
    Student(String firstName, String lastName, int grade) {
        setFirstName(firstName);
        setLastName(lastName);
        setGrade(grade);
        setStudentNum(nextStudentNum++);
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        if (grade > 0 && grade < 13) {
            this.grade = grade;
        }
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    /**
     * Return full name and grad formatted
     *
     * @return full name and grade
     */
    public String toString() {
        return "Name: " + firstName + " " + lastName + " Grade: " + grade;
    }
}
