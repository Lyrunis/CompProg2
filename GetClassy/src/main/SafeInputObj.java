package main;
import java.util.Scanner;

public class SafeInputObj {
    private Scanner pipe;  // Class-level scanner instance

    // Default constructor that initializes the scanner to System.in
    public SafeInputObj() {
        this.pipe = new Scanner(System.in);
    }

    // Constructor that accepts a custom Scanner
    public SafeInputObj(Scanner scanner) {
        this.pipe = scanner;
    }

    /**
     * Get a String which contains at least one character.
     * @param prompt Prompt for the user.
     * @return A String response that is not zero length.
     */
    public String getNonZeroLenString(String prompt) {
        String retString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0); // Until we have some characters

        return retString;
    }

    /**
     * Get an int value within a specified numeric range.
     * @param prompt Input prompt message (should not include range info).
     * @param low Low end of inclusive range.
     * @param high High end of inclusive range.
     * @return int value within the inclusive range.
     */
    public int getRangedInt(String prompt, int low, int high) {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("\nNumber is out of range [" + low + "-" + high + "]: " + retVal);
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter an int: " + trash);
            }
        } while (!done);

        return retVal;
    }

    // Other methods follow the same conversion pattern
    // Example: Get an int with no constraints

    public int getInt(String prompt) {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter an int: " + trash);
            }
        } while (!done);

        return retVal;
    }

    // Repeat conversion for all other methods from SafeInput

    public double getRangedDouble(String prompt, double low, double high) {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("\nNumber is out of range [" + low + "-" + high + "]: " + retVal);
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a double: " + trash);
            }
        } while (!done);

        return retVal;
    }

    // Follow similar pattern for remaining methods

    public boolean getYNConfirm(String prompt) {
        boolean retVal = true;
        String response = "";
        boolean gotAVal = false;

        do {
            System.out.print("\n" + prompt + " [Y/N] ");
            response = pipe.nextLine();
            if (response.equalsIgnoreCase("Y")) {
                gotAVal = true;
                retVal = true;
            } else if (response.equalsIgnoreCase("N")) {
                gotAVal = true;
                retVal = false;
            } else {
                System.out.println("You must answer [Y/N]! " + response);
            }

        } while (!gotAVal);

        return retVal;
    }

    public String getRegExString(String prompt, String regExPattern) {
        String response = "";
        boolean gotAVal = false;

        do {
            System.out.print("\n" + prompt + ": ");
            response = pipe.nextLine();
            if (response.matches(regExPattern)) {
                gotAVal = true;
            } else {
                System.out.println("\n" + response + " must match the pattern " + regExPattern);
                System.out.println("Try again!");
            }

        } while (!gotAVal);

        return response;
    }
}