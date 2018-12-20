public class SalaryEmployee extends Employee {
    private int annualSalary;
    private final boolean hasBenefits;

    public SalaryEmployee(String name, int hireYear, int annualSalary, boolean hasBenefits) {
        super(name, hireYear);
        this.annualSalary = annualSalary;
        this.hasBenefits = hasBenefits;
    }

    public double monthlyPay() {
        return monthlySalary();
    }

    @Override
    public double annualSalary() {
        return annualSalary;
    }

    @Override
    public double monthlySalary() {
        return annualSalary/12.0;
    }
}
