public class Main {
    public static void main(String[] args) {
        School Windermere = new School("Secondary School", 1000, "Facta non verba");

        Windermere.addStudent(new Student("Bob", "Bobby", 8));
        Windermere.addStudent(new Student("Joe", "Hobbs", 9));
        Windermere.addStudent(new Student("Anne", "Layla", 8));
        Windermere.addStudent(new Student("Wayne", "John", 10));
        Windermere.addStudent(new Student("Alex", "Spencer", 11));
        Windermere.addStudent(new Student("Bobby", "Bob", 8));
        Windermere.addStudent(new Student("Hobbs", "Joe", 9));
        Windermere.addStudent(new Student("Layla", "Anne", 10));
        Windermere.addStudent(new Student("John", "Wayne", 11));
        Windermere.addStudent(new Student("Spencer", "Alex", 10));

        Windermere.addTeacher(new Teacher("Mav", "Johnson", "Science"));
        Windermere.addTeacher(new Teacher("Dan", "Hendrick", "Math"));
        Windermere.addTeacher(new Teacher("Pam", "Welling", "English"));

        Windermere.showStudents();
        Windermere.showTeachers();

        Windermere.removeStudent("Bob Bobby");
        Windermere.removeStudent("Joe Hobbs");

        Windermere.removeTeacher("Mav Johnson");

        Windermere.showStudents();
        Windermere.showTeachers();
    }
}
