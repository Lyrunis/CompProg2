public class Person
{
    private String IDNum; //should never change seq of digits
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;
    private String age;
    private String fullName;
    private String formalName;

    public Person(String iDNum, String firstName, String lastName, String title, int yOB) {
        this.IDNum = IDNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }
    // Allows the user to use the default constructor (rare scenario)//
    // public Person(){}

    public String getIDNum() {
        return IDNum;
    }

    public void setIDNum(String iDNum) {
        IDNum = iDNum;
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

    public String getFullName() {
        fullName = firstName + " " + lastName;
        return fullName;
    }

    public String getFormalName() {
        formalName = title + " " + getFullName();
        return formalName;
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

    public void setYOB(int yOB) {
        YOB = yOB;
    }
    public String getAge() {
        return age;
    }
    public String getAge(int year) {
        return age;
    }
    @Override
    public String toString() {
        return "Person [IDNum=" + IDNum + ", firstName=" + firstName + ", lastName=" + lastName + ", title=" + title
                + ", YOB=" + YOB + "]";
    }
    public String toCSV() {
        return
    }

    
}