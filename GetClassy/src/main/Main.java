public class Main {
    
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
