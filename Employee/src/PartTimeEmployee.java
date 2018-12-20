public class PartTimeEmployee extends HourlyEmployee {
    private boolean benefits;

    public PartTimeEmployee(String name, int hireYear, double hoursPerWeek, double hourlyWage, boolean benefits) {
        super(name, hireYear, hoursPerWeek, hourlyWage);
        this.benefits = hourlyWage >= 20;
    }

    public boolean hasBenefits() {
        return benefits;
    }
}
