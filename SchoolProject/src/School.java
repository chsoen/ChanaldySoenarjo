import java.util.ArrayList;

/**
 * A school with teachers, students, type, population, and motto
 *
 * @author Chanaldy Soenarjo
 * @version 8
 */
public class School {
    private String type;
    private int population;
    private String motto;
    private ArrayList<Teacher> teachers = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();

    /**
     * Constructs a School instance with type, motto, population, a teacher class
     * arraylist and a student class arraylist
     *
     * @param type
     * @param population
     * @param motto
     */
    School(String type, int population, String motto) {
        System.out.println("school created");
        setType(type);
        setMotto(motto);
        setPopulation(population);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (!type.isEmpty()) {
            this.type = type;
        }
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        if (population > 0) {
            this.population = population;
        }
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        if (!motto.isEmpty()) {
            this.motto = motto;
        }
    }

    /**
     * Adds teacher instance to school's teacher list
     *
     * @param x address to instance
     */
    public void addTeacher(Teacher x) {
        this.teachers.add(x);
    }

    /**
     * Adds student instance to school's teacher list
     *
     * @param x address to instance
     */
    public void addStudent(Student x) {
        this.students.add(x);
    }

    /**
     * Uses teacher's full name to remove teacher from list.
     *
     * @param name teacher's full name
     */
    public void removeTeacher(String name) {
        for (int i=0;i<this.teachers.size();i++) {
            if ((this.teachers.get(i).getFirstName() + " " + this.teachers.get(i).getLastName()).equals(name)) {
                this.teachers.remove(i);
            }
        }
    }

    /**
     * Uses student's full name to remove teacher from list.
     *
     * @param name student's full name
     */
    public void removeStudent(String name) {
        for (int i=0;i<this.students.size();i++) {
            if ((this.students.get(i).getFirstName() + " " + this.students.get(i).getLastName()).equals(name)) {
                this.students.remove(i);
            }
        }
    }

    /**
     * Prints out teachers array entries.
     */
    public void showTeachers() {
        for (int i=0;i<this.teachers.size();i++) {
            System.out.println(String.valueOf(i + 1) + " " + this.teachers.get(i));
        }
        System.out.println("\n");
    }

    /**
     * Prints out students array entries.
     */
    public void showStudents() {
        for (int i=0;i<this.students.size();i++) {
            System.out.println(String.valueOf(i + 1) + " " + this.students.get(i));
        }
        System.out.println("\n");
    }
}