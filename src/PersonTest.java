import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class PersonTest {

    private Person person1;
    private Person person2;
    private Person person3;

    @BeforeEach
    public void setUp() {
        // Initialize some Person objects for testing
        person1 = new Person("12345", "John", "Doe", "Mr.", 1990);
        person2 = new Person("12345", "John", "Doe", "Mr.", 1990);
        person3 = new Person("67890", "Jane", "Smith", "Ms.", 1985);
    }

    @Test
    public void testConstructor() {
        assertEquals("12345", person1.getIDNum());
        assertEquals("John", person1.getFirstName());
        assertEquals("Doe", person1.getLastName());
        assertEquals("Mr.", person1.getTitle());
        assertEquals(1990, person1.getYOB());
    }

    @Test
    public void testGetFullName() {
        assertEquals("John Doe", person1.getFullName());
    }

    @Test
    public void testGetFormalName() {
        assertEquals("Mr. John Doe", person1.getFormalName());
    }

    @Test
    public void testGetAge() {
        int currentYear = java.time.Year.now().getValue();
        assertEquals(String.valueOf(currentYear - 1990), person1.getAge());
    }

    @Test
    public void testGetAgeWithYear() {
        assertEquals("30", person1.getAge(2020)); // Test for a specific year
    }

    @Test
    public void testToString() {
        assertEquals("Person [IDNum=12345, firstName=John, lastName=Doe, title=Mr., YOB=1990]", person1.toString());
    }

    @Test
    public void testToCSV() {
        assertEquals("12345,John,Doe,Mr.,1990", person1.toCSV());
    }

    @Test
    public void testToJSONRecord() {
        assertEquals("{\"IDNum\":\"12345\", \"firstName\":\"John\", \"lastName\":\"Doe\", \"title\":\"Mr.\", \"YOB\":1990}", person1.toJSONRecord());
    }

    @Test
    public void testToXMLRecord() {
        assertEquals("<Person><IDNum>12345</IDNum><firstName>John</firstName><lastName>Doe</lastName><title>Mr.</title><YOB>1990</YOB></Person>", person1.toXMLRecord());
    }

    @Test
    public void testEquals() {
        assertTrue(person1.equals(person2)); // Should be true, same IDNum
        assertFalse(person1.equals(person3)); // Should be false, different IDNum
    }

    @Test
    public void testHashCode() {
        assertEquals(person1.hashCode(), person2.hashCode()); // Same IDNum, same hash code
        assertNotEquals(person1.hashCode(), person3.hashCode()); // Different IDNum, different hash code
    }
}
