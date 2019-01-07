public class FullTimeEmployee extends HourlyEmployee{
    private boolean hasBenefits = true;

    public FullTimeEmployee(String name, int hireYear, double hoursPerWeek, double hourlyWage) {
        super(name, hireYear, hoursPerWeek, hourlyWage);
    }

    @Override
    public boolean hasBenefits() {
        return false;
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
