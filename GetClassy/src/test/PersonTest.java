import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {
    @Test
    public void testEquals() {
        Person person1 = new Person("001", "Chris", "Vu", "Mr", 2000);
        Person person2 = new Person("001", "Chris", "Vu", "Mr", 2000);
        assertTrue(person1.equals(person2));
    }

    @Test
    public void testGetAge() {
        Person person = new Person("001", "Chris", "Vu", "Mr", 2000);
        assertEquals(24, person.getAge(2024));  // Adjust the year as necessary
    }

    @Test
    public void testGetFirstName() {
        Person person = new Person("001", "Chris", "Vu", "Mr", 2000);
        assertEquals("Chris", person.getFirstName());
    }

    @Test
    public void testGetFormalName() {
        Person person = new Person("001", "Chris", "Vu", "Mr", 2000);
        assertEquals("Mr Chris Vu", person.getFormalName());
    }

    @Test
    public void testGetFullName() {
        Person person = new Person("001", "Chris", "Vu", "Mr", 2000);
        assertEquals("Chris Vu", person.getFullName());
    }

    @Test
    public void testGetIDNum() {
        Person person = new Person("001", "Chris", "Vu", "Mr", 2000);
        assertEquals("001", person.getIDNum());
    }

    @Test
    public void testToCSV() {
        Person person = new Person("001", "Chris", "Vu", "Mr", 2000);
        assertEquals("001,Chris,Vu,Mr,2000", person.toCSV());
    }

    @Test
    public void testToJSONRecord() {
        Person person = new Person("001", "Chris", "Vu", "Mr", 2000);
        assertEquals("{\"IDNum\":\"001\",\"firstName\":\"Chris\",\"lastName\":\"Vu\",\"title\":\"Mr\",\"YOB\":2000}", person.toJSONRecord());
    }

    @Test
    public void testToXMLRecord() {
        Person person = new Person("001", "Chris", "Vu", "Mr", 2000);
        assertEquals("<Person><IDNum>001</IDNum><firstName>Chris</firstName><lastName>Vu</lastName><title>Mr</title><YOB>2000</YOB></Person>", person.toXMLRecord());
    }
}
