public class FullTimeEmployee extends HourlyEmployee{
    private final boolean hasBenefits;

    public FullTimeEmployee(String name, int hireYear, double hoursPerWeek, double hourlyWage, boolean hasBenefits) {
        super(name, hireYear, hoursPerWeek, hourlyWage);
        this.hasBenefits = hasBenefits;
    }
}
