import java.util.ArrayList;

public class InheritanceDemo {

    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<>();

        // Create Worker instances
        workers.add(new Worker("John", "Doe", "W001", "Mr.", 1980, 25.00));
        workers.add(new Worker("Jane", "Smith", "W002", "Ms.", 1990, 30.00));
        workers.add(new Worker("Bob", "Johnson", "W003", "Mr.", 1975, 20.00));

        // Create SalaryWorker instances
        workers.add(new SalaryWorker("Alice", "Brown", "SW001", "Dr.", 1985, 80000));
        workers.add(new SalaryWorker("Tom", "White", "SW002", "Mr.", 1995, 60000));
        workers.add(new SalaryWorker("Sue", "Green", "SW003", "Ms.", 1970, 90000));

        // Simulate 3 weekly pay periods
        int[] hoursWorked = {40, 50, 40}; // Week 1, Week 2 (overtime), Week 3

        for (int week = 0; week < 3; week++) {
            System.out.printf("\nWeek %d Pay Details:\n", week + 1);
            System.out.println("========================================");
            for (Worker worker : workers) {
                worker.displayWeeklyPay(hoursWorked[week]);
            }
        }
    }
}
