import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args){

        ArrayList<String> folks = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        boolean done = false;

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath(),"personData.txt");
        /*a.    ID (string)
         * b. firstName
         * c. lastName
         * d. Title (mr. mrs. ms. drs)
         * e. YearOfBirth (int)
         */
        String personRec = "";
        String ID = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int YOB = 0;

        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter the ID [6 Digits]: ");
            firstName = SafeInput.getNonZeroLenString(in, "Enter the first name: ");
            lastName = SafeInput.getNonZeroLenString(in, "Enter the last name: ");
            title = SafeInput.getNonZeroLenString(in, "Enter the title [i.e: mr. mrs. dr.]");
            YOB = SafeInput.getRangedInt(in, "Enter the Year of Birth: ", 1000, 9999);

            personRec = ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;

            folks.add(personRec);

            done = SafeInput.getYNConfirm(in, "Are you done?");
        }while(!done);

        for( String p: folks)
            System.out.println(p);

        try
       {
           // Typical java pattern of inherited classes
           // we wrap a BufferedWriter around a lower level BufferedOutputStream
           OutputStream out =
                   new BufferedOutputStream(Files.newOutputStream(file, StandardOpenOption.CREATE));
           BufferedWriter writer =
                   new BufferedWriter(new OutputStreamWriter(out));
           // Finally can write the file LOL!

           for(String rec : folks)
           {
               writer.write(rec, 0, rec.length());  // stupid syntax for write rec
                            // 0 is where to start (1st char) the write
                            // rec. length() is how many chars to write (all)
               writer.newLine();  // adds the new line

           }
           writer.close(); // must close the file to seal it and flush buffer
           System.out.println("Data file written!");
       }
       catch (IOException e)
       {
           e.printStackTrace();
       }





    }
}
