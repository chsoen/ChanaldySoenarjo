public class Student extends Person {
    private static int id = 1;
    private int studentId;
    private Course[] coursesTaking = new Course[8];

    Student(String firstName, String lastName) {
        super(firstName, lastName);
        this.studentId = id++;
    }

    Student(String firstName, String lastName, Course[] coursesTaking) {
        super(firstName, lastName);
        this.coursesTaking = coursesTaking;
        this.studentId = id++;
    }

    public void addCourse(Course course) {
        coursesTaking[coursesTaking.length-1] = course;
    }

    public void deleteCourse(Course course) {
        for(int i=0;i<coursesTaking.length;i++) {
            Course[] temp = new Course[coursesTaking.length-1];
            if (coursesTaking[i] != null && coursesTaking[i].equals(course)) {
                for(int j=0;j<coursesTaking.length;j++) {
                    if(!coursesTaking[i].equals(course)) temp[j] = coursesTaking[j];
                }
                coursesTaking = temp;
            }
        }
    }

    public void changeCourse(Course courseReplaced, Course newCourse) {
        for(int i=0;i<coursesTaking.length;i++) {
            if (coursesTaking[i] != null && coursesTaking[i].equals(courseReplaced)) {
                coursesTaking[i] = newCourse;
                break;
            }
        }
    }

    public void getCoursesTaking() {
        for(Course course: coursesTaking) {
            if(course != null) System.out.println(course.toString());
        }
    }
}
