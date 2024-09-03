import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 * A program to read and display person data from a selected file.
 */
public class PersonReader {

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        Scanner inFile = null;
        String line;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        
        // Set the chooser to the project src directory
        chooser.setCurrentDirectory(target.toFile());

        try {
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                target = chooser.getSelectedFile().toPath();  // Get the selected file's path

                inFile = new Scanner(target);
                
                // Print header
                System.out.printf("%-10s %-15s %-15s %-10s %-4s\n", "ID#", "Firstname", "Lastname", "Title", "YOB");
                System.out.println("=========================================================");

                while (inFile.hasNextLine()) {
                    line = inFile.nextLine();
                    // Assuming the file format is ID, firstname, lastname, title, yob
                    String[] parts = line.split(", ");
                    if (parts.length == 5) {
                        String id = parts[0];
                        String firstName = parts[1];
                        String lastName = parts[2];
                        String title = parts[3];
                        String yob = parts[4];
                        
                        // Display each person's details in a formatted way
                        System.out.printf("%-10s %-15s %-15s %-10s %-4s\n", id, firstName, lastName, title, yob);
                    }
                }

            } else {
                System.out.println("Sorry, you must select a file! Terminating!");
                System.exit(0);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found Error");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException Error");
            e.printStackTrace();
        } finally {
            if (inFile != null) {
                inFile.close();
            }
        }
    }
}