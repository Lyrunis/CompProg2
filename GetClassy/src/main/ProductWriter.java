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

public class ProductWriter {
    public static void main(String[] args) {

        ArrayList<String> products = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        boolean done = false;

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath(), "ProductTestData.txt");

        String productRec;
        String ID;
        String name;
        String description;
        double cost;

        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter the product ID: ");
            name = SafeInput.getNonZeroLenString(in, "Enter the product name: ");
            description = SafeInput.getNonZeroLenString(in, "Enter the product description: ");
            cost = SafeInput.getRangedDouble(in, "Enter the cost: ", 0.0, Double.MAX_VALUE);

            productRec = String.format("%s, %s, %s, %.2f", ID, name, description, cost);
            products.add(productRec);

            done = SafeInput.getYNConfirm(in, "Are you done?");
        } while (!done);

        for (String p : products)
            System.out.println(p);

        // Write to file using APPEND mode
        try {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, StandardOpenOption.CREATE, StandardOpenOption.APPEND));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for (String rec : products) {
                writer.write(rec, 0, rec.length());
                writer.newLine();
            }
            writer.close();
            System.out.println("Product data writing!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
