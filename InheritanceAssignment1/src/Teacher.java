public class Teacher extends Person {
    private static int id = 1;
    private int employeeId;
    private Course[] coursesTeaching = new Course[8];

    Teacher(String firstName, String lastName) {
        super(firstName, lastName);
        this.employeeId = id++;
    }

    Teacher(String firstName, String lastName, Course[] coursesTeaching) {
        super(firstName, lastName);
        this.coursesTeaching = coursesTeaching;
        this.employeeId = id++;
    }

    public void addCourse(Course course) {
        coursesTeaching[coursesTeaching.length-1] = course;
    }

    public void deleteCourse(Course course) {
        for(int i = 0; i< coursesTeaching.length; i++) {
            Course[] temp = new Course[coursesTeaching.length-1];
            if (coursesTeaching[i] != null && coursesTeaching[i].equals(course)) {
                for(int j = 0; j< coursesTeaching.length; j++) {
                    if(!coursesTeaching[i].equals(course)) temp[j] = coursesTeaching[j];
                }
                coursesTeaching = temp;
            }
        }
    }

    public void changeCourse(Course courseReplaced, Course newCourse) {
        for(int i = 0; i< coursesTeaching.length; i++) {
            if (coursesTeaching[i] != null && coursesTeaching[i].equals(courseReplaced)) {
                coursesTeaching[i] = newCourse;
                break;
            }
        }
    }

    public void getCoursesTeaching() {
        for(Course course: coursesTeaching) {
            if(course != null) System.out.println(course.toString());
        }
    }
}
