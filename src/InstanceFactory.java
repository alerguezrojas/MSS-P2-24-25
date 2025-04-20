import java.util.Scanner;

/**
 * Utility class to create instances from CSV or manual input.
 */
public class InstanceFactory {

    /**
     * Creates an instance from a line of CSV input.
     * @param line a comma-separated line representing an instance
     * @return a new Instance object
     */
    public static Instance fromCSVLine(String line) {
        String[] tokens = line.split(",");
        int len = tokens.length;
        double[] attributes = new double[len - 1];
        for (int i = 0; i < len - 1; i++) {
            attributes[i] = Double.parseDouble(tokens[i]);
        }
        String label = tokens[len - 1];
        return new Instance(attributes, label);
    }

    /**
     * Creates an instance by reading input from the user.
     * @param sc a Scanner object
     * @return a new Instance object
     */
    public static Instance fromUserInput(Scanner sc) {
        System.out.print("Number of attributes: ");
        int n = Integer.parseInt(sc.nextLine()); // Read as String and parse, to avoid conflicts

        double[] attributes = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Attribute " + (i + 1) + ": ");
            attributes[i] = Double.parseDouble(sc.nextLine()); // Likewise, read the entire line and parse it.
        }

        System.out.print("Label: ");
        String label = sc.nextLine();

        return new Instance(attributes, label);
    }

}
