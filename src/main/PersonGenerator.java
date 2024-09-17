package main;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A program to generate and save person data to a file.
 */
public class PersonGenerator {
    public static void main(String[] args) {

        ArrayList<Person> persons = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        boolean done = false;

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath(), "personData.txt");

        do {
            String firstName = SafeInput.getNonZeroLenString(in, "Enter the first name: ");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter the last name: ");
            String ID = SafeInput.getNonZeroLenString(in, "Enter the ID: ");
            String title = SafeInput.getNonZeroLenString(in, "Enter the title: ");
            int YOB = SafeInput.getRangedInt(in, "Enter the year of birth: ", 1940, 2010);

            Person person = new Person(firstName, lastName, ID, title, YOB);
            persons.add(person);

            done = SafeInput.getYNConfirm(in, "Are you done?");
        } while (!done);

        for (Person p : persons) {
            System.out.println(p);
        }

        try {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, StandardOpenOption.CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for (Person person : persons) {
                writer.write(person.toCSV());
                writer.newLine();
            }
            writer.close();
            System.out.println("Person data file written!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
