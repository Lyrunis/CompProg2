public class Worker extends Person {
    private double hourlyPayRate;

    // Constructor that calls the superclass constructor (Person)
    public Worker(String IDNum, String firstName, String lastName, String title, int YOB, double hourlyPayRate) {
        super(IDNum, firstName, lastName, title, YOB);
        this.hourlyPayRate = hourlyPayRate;
    }

    // Method to calculate weekly pay
    public double calculateWeeklyPay(double hoursWorked) {
        if (hoursWorked <= 40) {
            return hoursWorked * hourlyPayRate;
        } else {
            double overtimeHours = hoursWorked - 40;
            return (40 * hourlyPayRate) + (overtimeHours * hourlyPayRate * 1.5);
        }
    }

    // Display weekly pay breakdown
    public void displayWeeklyPay(double hoursWorked) {
        double regularPay = Math.min(40, hoursWorked) * hourlyPayRate;
        double overtimePay = (hoursWorked > 40) ? (hoursWorked - 40) * hourlyPayRate * 1.5 : 0;
        double totalPay = regularPay + overtimePay;

        System.out.printf("Worker: %s | Regular Hours: %.2f, Regular Pay: $%.2f | Overtime Pay: $%.2f | Total Pay: $%.2f\n",
                getFullName(), Math.min(40, hoursWorked), regularPay, overtimePay, totalPay);
    }

    // Overriding toCSV to include hourlyPayRate
    @Override
    public String toCSV() {
        return String.format("%s, %.2f", super.toCSV(), hourlyPayRate);
    }

    // Overriding toJSONRecord to include hourlyPayRate
    @Override
    public String toJSONRecord() {
        return String.format("{%s, \"hourlyPayRate\": %.2f}", super.toJSONRecord().substring(1, super.toJSONRecord().length() - 1), hourlyPayRate);
    }

    // Overriding toXMLRecord to include hourlyPayRate
    @Override
    public String toXMLRecord() {
        return String.format("<Worker>%s<HourlyPayRate>%.2f</HourlyPayRate></Worker>", super.toXMLRecord(), hourlyPayRate);
    }

    // Getters and setters for hourlyPayRate (if needed)
    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    public void setHourlyPayRate(double hourlyPayRate) {
        this.hourlyPayRate = hourlyPayRate;
    }

    @Override
    public String toString() {
        return String.format("Worker [hourlyPayRate=%.2f, %s]", hourlyPayRate, super.toString());
    }
}
