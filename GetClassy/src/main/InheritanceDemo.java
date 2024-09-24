import java.util.ArrayList;

public class InheritanceDemo {

    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<>();

        // Create Worker instances
        workers.add(new Worker("001", "Chris", "Vu", "Mr.", 2000, 25.00));
        workers.add(new Worker("002", "Mimi", "Vu", "Ms.", 1999, 20.00));
        workers.add(new Worker("003", "Vincent", "Vu", "Mr.", 2002, 17.00));

        // Create SalaryWorker instances
        workers.add(new SalaryWorker("004", "Amie", "Dinh", "Dr.", 1977, 80000));
        workers.add(new SalaryWorker("005", "Johnie", "Vu", "Mr.", 1976, 60000));
        workers.add(new SalaryWorker("006", "Thuy", "Dinh", "Ms.", 1970, 50000));

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
