public class HourlyEmployee extends Employee{
    private double hoursPerWeek;
    private double hourlyWage;

    public HourlyEmployee(String name, int hireYear, double hoursPerWeek, double hourlyWage) {
        super(name, hireYear);
        this.hoursPerWeek = hoursPerWeek;
        this.hourlyWage = hourlyWage;
    }

    public double monthlyPay() {
        return monthlySalary();
    }

    @Override
    public double annualSalary() {
        return hoursPerWeek*hourlyWage*52;
    }

    @Override
    public double monthlySalary() {
        return annualSalary()/12;
    }
}
