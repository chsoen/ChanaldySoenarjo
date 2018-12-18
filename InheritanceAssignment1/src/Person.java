public class Person {
    private String firstName;
    private String lastName;

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private String speak() {
        return "Hello World!";
    }

    @Override
    public String toString() {
        return speak();
    }

    void getFullName() {
        System.out.println(firstName + " " + lastName);
    }
}
