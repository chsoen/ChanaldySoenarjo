public class Course {
    private String courseName;
    private String block;

    public Course(String courseName, String block) {
        this.courseName = courseName;
        this.block = block;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    @Override
    public String toString() {
        return courseName;
    }
}
