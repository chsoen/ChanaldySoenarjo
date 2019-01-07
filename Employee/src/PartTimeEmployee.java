public class PartTimeEmployee extends HourlyEmployee {
    private boolean hasBenefits = true;

    public PartTimeEmployee(String name, int hireYear, double hoursPerWeek, double hourlyWage, boolean hasBenefits) {
        super(name, hireYear, hoursPerWeek, hourlyWage);
    }

    public boolean hasBenefits() {
        return hasBenefits;
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
