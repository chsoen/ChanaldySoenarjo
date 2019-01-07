import java.util.ArrayList;

public class Main {

    public static ArrayList<SalaryEmployee> getSalaryEmployees(ArrayList<Employee> list) {
        ArrayList<SalaryEmployee> temp = new ArrayList<>();
        for(Employee e: list) {
            if(e instanceof SalaryEmployee) {
                temp.add((SalaryEmployee) e);
            }
        }
        return temp;
    }

    public static ArrayList<HourlyEmployee> getHourlyEmployees(ArrayList<Employee> list) {
        ArrayList<HourlyEmployee> temp = new ArrayList<>();
        for(Employee e: list) {
            if(e instanceof HourlyEmployee) {
                temp.add((HourlyEmployee) e);
            }
        }
        return temp;
    }

    public static ArrayList<FullTimeEmployee> getFullTimeEmployees(ArrayList<Employee> list) {
        ArrayList<FullTimeEmployee> temp = new ArrayList<>();
        for(Employee e: list) {
            if(e instanceof FullTimeEmployee) {
                temp.add((FullTimeEmployee) e);
            }
        }
        return temp;
    }

    public static ArrayList<PartTimeEmployee> getPartTimeEmployees(ArrayList<Employee> list) {
        ArrayList<PartTimeEmployee> temp = new ArrayList<>();
        for(Employee e: list) {
            if(e instanceof PartTimeEmployee) {
                temp.add((PartTimeEmployee) e);
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new SalaryEmployee("Bob", 2030, 100000));
        employees.add(new FullTimeEmployee("Robby", 2030, 40, 20));
        employees.add(new PartTimeEmployee("Yob", 2030, 40, 20, true));

        for(Employee e: employees) {
            System.out.println(e);
        }

        System.out.println(getPartTimeEmployees(employees));
        System.out.println(getFullTimeEmployees(employees));
        System.out.println(getHourlyEmployees(employees));
        System.out.println(getSalaryEmployees(employees));
    }
}