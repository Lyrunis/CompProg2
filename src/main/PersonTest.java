package main;
import java.time.LocalDate;

public class PersonTest{
    private String IDNum; // should never change seq of digits
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;
    private String age;
    private String fullName;
    private String formalName;

    public PersonTest(String IDNum, String firstName, String lastName, String title, int YOB) {
        this.IDNum = IDNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
        this.fullName = getFullName();
        this.formalName = getFormalName();
        this.age = getAge();
    }

    // Default constructor (if needed)
    //public Person() {}

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
        fullName = firstName + " " + lastName;
        return fullName;
    }

    public String getFormalName() {
        formalName = title + " " + getFullName();
        return formalName;
    }

    public String getAge() {
        int currentYear = LocalDate.now().getYear();
        int age = currentYear - YOB;
        return String.valueOf(age);
    }

    public String getAge(int year) {
        int age = year - YOB;
        return String.valueOf(age);
    }

    @Override
    public String toString() {
        return "Person [IDNum=" + IDNum + ", firstName=" + firstName + ", lastName=" + lastName + ", title=" + title
                + ", YOB=" + YOB + "]";
    }

    public String toCSV() {
        return IDNum + "," + firstName + "," + lastName + "," + title + "," + YOB;
    }

    public String toJSONRecord() {
        String DQ = "\""; // double quote char
    
        return "{" +
                DQ + "IDNum" + DQ + ":" + DQ + this.IDNum + DQ + "," +
                DQ + "firstName" + DQ + ":" + DQ + this.firstName + DQ + "," +
                DQ + "lastName" + DQ + ":" + DQ + this.lastName + DQ + "," +
                DQ + "title" + DQ + ":" + DQ + this.title + DQ + "," +
                DQ + "age" + DQ + ":" + DQ + getAge() + DQ + "," +
                DQ + "YOB" + DQ + ":" + this.YOB +
                "}";
    }
    
    public String toXMLRecord() {
        return "<Person>\n" +
                "\t<IDNum>" + IDNum + "</IDNum>\n" +
                "\t<FirstName>" + firstName + "</FirstName>\n" +
                "\t<LastName>" + lastName + "</LastName>\n" +
                "\t<Title>" + title + "</Title>\n" +
                "\t<YOB>" + YOB + "</YOB>\n" +
                "</Person>";
    }
    public static void main(String[] args) {
        // Create a Person object
        Person person = new Person("123", "John", "Doe", "Mr.", 1985);

        // Display the Person object
        System.out.println("Person Details:");
        System.out.println(person);

        // Display CSV, JSON, and XML formats
        System.out.println("\nCSV Format:");
        System.out.println(person.toCSV());

        System.out.println("\nJSON Format:");
        System.out.println(person.toJSONRecord());

        System.out.println("\nXML Format:");
        System.out.println(person.toXMLRecord());
    }
}
