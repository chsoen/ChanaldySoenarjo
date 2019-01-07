public abstract class Employee {
    private String name;
    private int hireYear;

    public Employee() {
        this.name = "John Doe";
        this.hireYear = 2019;
    }

    public Employee(String name, int hireYear) {
        this.name = name;
        this.hireYear = hireYear;
    }

    public String getName() {
        return name;
    }

    public int getHireYear() {
        return hireYear;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Started: " + hireYear;
    }

    public abstract double annualSalary();

    public abstract double monthlySalary();
}
