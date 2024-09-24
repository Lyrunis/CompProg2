import static org.junit.Assert.*;

import org.junit.Test;

public class WorkerTest {

    @Test
    public void testConstructor() {
        Worker worker = new Worker("001", "Chris", "Vu", "Mr", 2000, 25.00);
        assertEquals(25.00, worker.getHourlyPayRate(), 0);
    }

    @Test
    public void testCalculateWeeklyPay_NoOvertime() {
        Worker worker = new Worker("002", "Mimi", "Vu", "Ms", 1999, 20.00);
        assertEquals(800.00, worker.calculateWeeklyPay(40), 0);
    }

    @Test
    public void testCalculateWeeklyPay_WithOvertime() {
        Worker worker = new Worker("003", "Vincent", "Vu", "Mr", 2002, 15.00);
        assertEquals(825.00, worker.calculateWeeklyPay(50), 0);
    }

    @Test
    public void testToCSV() {
        Worker worker = new Worker("004", "Amie", "Dinh", "Dr", 1977, 30.00);
        assertEquals("004,Amie,Dinh,Dr,1977,30.00", worker.toCSV());
    }
}
