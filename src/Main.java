public class Main {
    
    public static void main(String[] args)
    {
        Person sally = new Person("00000008", "Sally", "Williams", "Mrs.", 2005);
        System.out.println(sally);

        sally.setLastName("Smith");
        System.out.println(sally.getFullName());
        System.out.println(sally.getFormalName());
    }
}
