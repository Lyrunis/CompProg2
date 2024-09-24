public class SalaryWorker extends Worker {
    private double annualSalary;

    // Constructor that passes 0 for hourlyPayRate, as it doesn't apply to SalaryWorker
    public SalaryWorker(String IDNum, String firstName, String lastName, String title, int YOB, double annualSalary) {
        super(IDNum, firstName, lastName, title, YOB, 0); // hourlyPayRate is 0 because SalaryWorker doesn't use it
        this.annualSalary = annualSalary;
    }

    // Override calculateWeeklyPay to return weekly salary regardless of hours worked
    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        return annualSalary / 52; // Weekly pay is fixed, based on annual salary
    }

    // Override displayWeeklyPay to show the fixed weekly salary with hours worked displayed
    @Override
    public void displayWeeklyPay(double hoursWorked) {
        double weeklyPay = calculateWeeklyPay(hoursWorked);
        System.out.printf("ID: %-4s | Name: %-10s | Clock: %.2f | Salary Pay: $%.2f (Fixed)\n", getIDNum(), getFullName(), hoursWorked, weeklyPay);
    }

    // Override toCSV to include annualSalary
    @Override
    public String toCSV() {
        return String.format("%s, %.2f", super.toCSV(), annualSalary);
    }

    // Override toXMLRecord to include annualSalary
    @Override
    public String toXMLRecord() {
        return String.format("<SalaryWorker>%s<AnnualSalary>%.2f</AnnualSalary></SalaryWorker>", super.toXMLRecord(), annualSalary);
    }

    // Override toJSONRecord to include annualSalary
    @Override
    public String toJSONRecord() {
        return String.format("{%s, \"annualSalary\": %.2f}", super.toJSONRecord().substring(1, super.toJSONRecord().length() - 1), annualSalary);
    }

    // Getter and setter for annualSalary (optional if needed)
    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    @Override
    public String toString() {
        return String.format("SalaryWorker [annualSalary=%.2f, %s]", annualSalary, super.toString());
    }
}