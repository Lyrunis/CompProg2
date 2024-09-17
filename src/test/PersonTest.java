package test;
import static org.junit.Assert.*;

import java.util.Objects;

import org.junit.Test;

import main.Person;

public class PersonTest {
    private String IDNum = "001";
    private String firstName = "Chris";
    private String lastName = "Vu";
    private String title = "Mr";
    private int YOB = 2000;

    public PersonTest(String IDNum, String firstName, String lastName, String title, int YOB) {
        this.IDNum = IDNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    public String getIDNum() {
        return IDNum;
    }

    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getFormalName() {
        return title + " " + getFullName();
    }

    public int getAge() {
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        return currentYear - YOB;
    }

    public int getAge(int year) {
        return year - YOB;
    }

    @Override
    public String toString() {
        return "Person [IDNum=" + IDNum + ", firstName=" + firstName + ", lastName=" + lastName + ", title=" + title + ", YOB=" + YOB + "]";
    }

    public String toCSV() {
        return String.format("%s,%s,%s,%s,%d", IDNum, firstName, lastName, title, YOB);
    }

    public String toJSONRecord() {
        return String.format("{\"IDNum\":\"%s\",\"firstName\":\"%s\",\"lastName\":\"%s\",\"title\":\"%s\",\"YOB\":%d}",
            IDNum, firstName, lastName, title, YOB);
    }

    public String toXMLRecord() {
        return String.format("<Person><IDNum>%s</IDNum><firstName>%s</firstName><lastName>%s</lastName><title>%s</title><YOB>%d</YOB></Person>",
            IDNum, firstName, lastName, title, YOB);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return YOB == person.getYOB() && Objects.equals(IDNum, person.getIDNum()) &&
            Objects.equals(firstName, person.getFirstName()) &&
            Objects.equals(lastName, person.getLastName()) &&
            Objects.equals(title, person.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(IDNum, firstName, lastName, title, YOB);
    }

    @Test
    public void testEquals() {
        PersonTest person1 = new PersonTest("001", "Chris", "Vu", "Mr", 2000);
        PersonTest person2 = new PersonTest("001", "Chris", "Vu", "Mr", 2000);
        assertTrue(person1.equals(person2));
    }

    @Test
    public void testGetAge() {
        PersonTest person = new PersonTest("001", "Chris", "Vu", "Mr", 2000);
        assertEquals(24, person.getAge(2024));  // Adjust the year as necessary
    }

    @Test
    public void testGetFirstName() {
        PersonTest person = new PersonTest("001", "Chris", "Vu", "Mr", 2000);
        assertEquals("Chris", person.getFirstName());
    }

    @Test
    public void testGetFormalName() {
        PersonTest person = new PersonTest("001", "Chris", "Vu", "Mr", 2000);
        assertEquals("Mr Chris Vu", person.getFormalName());
    }

    @Test
    public void testGetFullName() {
        PersonTest person = new PersonTest("001", "Chris", "Vu", "Mr", 2000);
        assertEquals("Chris Vu", person.getFullName());
    }

    @Test
    public void testGetIDNum() {
        PersonTest person = new PersonTest("001", "Chris", "Vu", "Mr", 2000);
        assertEquals("001", person.getIDNum());
    }

    @Test
    public void testToCSV() {
        PersonTest person = new PersonTest("001", "Chris", "Vu", "Mr", 2000);
        assertEquals("001,Chris,Vu,Mr,2000", person.toCSV());
    }

    @Test
    public void testToJSONRecord() {
        PersonTest person = new PersonTest("001", "Chris", "Vu", "Mr", 2000);
        assertEquals("{\"IDNum\":\"001\",\"firstName\":\"Chris\",\"lastName\":\"Vu\",\"title\":\"Mr\",\"YOB\":2000}", person.toJSONRecord());
    }

    @Test
    public void testToXMLRecord() {
        PersonTest person = new PersonTest("001", "Chris", "Vu", "Mr", 2000);
        assertEquals("<Person><IDNum>001</IDNum><firstName>Chris</firstName><lastName>Vu</lastName><title>Mr</title><YOB>2000</YOB></Person>", person.toXMLRecord());
    }
}
