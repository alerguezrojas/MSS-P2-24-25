import java.io.IOException;
import java.util.Scanner;

/**
 * Entry point to test Dataset functionality using iris.csv.
 */
public class Main {
    public static void main(String[] args) {
        Dataset dataset = new Dataset();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the path to the CSV file (e.g., data/iris.csv): ");
            String inputFile = sc.nextLine();

            System.out.println("Loading dataset...");
            dataset.loadFromCSV(inputFile);
            System.out.println("Dataset successfully loaded.\n");

            System.out.println("Original dataset content:");
            dataset.print();

            // Save original min and max before any normalization
            double[] minValues = dataset.getMinValues();
            double[] maxValues = dataset.getMaxValues();

            System.out.println("\nNormalizing dataset...");
            dataset.normalizeAll();

            System.out.println("Normalized dataset content:");
            dataset.print();

            System.out.println("\nDo you want to add a new instance? (y/n)");
            if (sc.nextLine().equalsIgnoreCase("y")) {
                Instance newInstance = InstanceFactory.fromUserInput(sc);
                newInstance.normalize(minValues, maxValues); // Normalize with original min/max
                dataset.addInstance(newInstance);
                System.out.println("Instance added and normalized successfully.");
            }

            System.out.println("\nDo you want to remove an instance? (y/n)");
            if (sc.nextLine().equalsIgnoreCase("y")) {
                System.out.print("Index to remove: ");
                int idx = sc.nextInt();
                sc.nextLine();
                dataset.removeInstance(idx);
            }

            System.out.println("\nDo you want to save the dataset? (y/n)");
            if (sc.nextLine().equalsIgnoreCase("y")) {
                System.out.print("Output filename (e.g., iris_out.csv): ");
                String output = sc.nextLine();
                dataset.saveToCSV(output);
                System.out.println("Dataset saved successfully.");
            }

        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}
