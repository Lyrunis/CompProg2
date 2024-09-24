import static org.junit.Assert.*;

import org.junit.Test;

public class SalaryWorkerTest {

    @Test
    public void testConstructor() {
        SalaryWorker salaryWorker = new SalaryWorker("001", "Johnie", "Vu", "Mr", 1976, 60000.00);
        assertEquals(60000.00, salaryWorker.getAnnualSalary(), 0);
    }

    @Test
    public void testCalculateWeeklyPay() {
        SalaryWorker salaryWorker = new SalaryWorker("002", "Thuy", "Dinh", "Ms", 1970, 52000.00);
        assertEquals(1000.00, salaryWorker.calculateWeeklyPay(40), 0.01);
    }

    @Test
    public void testToCSV() {
        SalaryWorker salaryWorker = new SalaryWorker("003", "Chris", "Vu", "Mr", 2000, 75000.00);
        assertEquals("003,Chris,Vu,Mr,2000,75000.00", salaryWorker.toCSV());
    }
}
