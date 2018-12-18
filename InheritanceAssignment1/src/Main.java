public class Main {
    public static void main(String[] args) {
        Student bob = new Student("Bob", "Bobby");
        bob.getFullName();
        System.out.println(bob);

        Course Programming13 = new Course("Programming 13", "3-5");
        bob.addCourse(Programming13);
        bob.getCoursesTaking();

        Course Calculus = new Course("Calculus 12", "3-1");
        bob.changeCourse(Programming13, Calculus);
        bob.getCoursesTaking();

        bob.addCourse(Programming13);
        bob.deleteCourse(Calculus);
        bob.getCoursesTaking();
    }
}
