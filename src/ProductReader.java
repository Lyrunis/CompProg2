import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 * A program to read and display product data from a selected file.
 */
public class ProductReader {

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
                System.out.printf("%-6s %-15s %-25s %-10s\n", "ID#", "Name", "Description", "Cost");
                System.out.println("============================================");

                while (inFile.hasNextLine()) {
                    line = inFile.nextLine();
                    // Assuming the file format is ID, name, description, cost
                    String[] parts = line.split(", ");
                    if (parts.length == 4) {
                        String id = parts[0];
                        String name = parts[1];
                        String description = parts[2];
                        String cost = parts[3];

                        // Display each product's details in a formatted way
                        System.out.printf("%-6s %-15s %-25s $%s\n", id, name, description, cost);
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
