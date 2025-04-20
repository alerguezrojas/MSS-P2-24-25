import java.io.*;
import java.util.*;

/**
 * Represents a dataset containing multiple instances.
 */
public class Dataset {
    private List<Instance> instances;
    private int numAttributes;

    /**
     * Constructs an empty dataset.
     */
    public Dataset() {
        this.instances = new ArrayList<>();
    }

    /**
     * Loads the dataset from a CSV file. Skips the header line.
     * @param filename the path to the CSV file
     * @throws IOException if the file cannot be read
     */
    public void loadFromCSV(String filename) throws IOException {
        instances.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            // Skip the header line
            line = reader.readLine(); // <- this line consumes the first line

            while ((line = reader.readLine()) != null) {
                Instance instance = InstanceFactory.fromCSVLine(line);
                instances.add(instance);
            }
        }
        if (!instances.isEmpty()) {
            numAttributes = instances.get(0).getAttributes().length;
        }
    }


    /**
     * Saves the dataset to a CSV file.
     * @param filename the path to the output file
     * @throws IOException if the file cannot be written
     */
    public void saveToCSV(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Instance instance : instances) {
                double[] attrs = instance.getAttributes();
                for (int i = 0; i < attrs.length; i++) {
                    writer.write(String.valueOf(attrs[i]));
                    if (i < attrs.length - 1) writer.write(",");
                }
                writer.write("," + instance.getLabel());
                writer.newLine();
            }
        }
    }

    /**
     * Prints all instances in the dataset.
     */
    public void print() {
        for (Instance instance : instances) {
            System.out.println(instance);
        }
    }

    /**
     * Adds a new instance to the dataset.
     * @param instance the instance to add
     */
    public void addInstance(Instance instance) {
        instances.add(instance);
    }

    /**
     * Removes an instance at a specific index.
     * @param index the index to remove
     */
    public void removeInstance(int index) {
        if (index >= 0 && index < instances.size()) {
            instances.remove(index);
        }
    }

    /**
     * Updates the instance at a given index.
     * @param index the index to update
     * @param newInstance the new instance
     */
    public void updateInstance(int index, Instance newInstance) {
        if (index >= 0 && index < instances.size()) {
            instances.set(index, newInstance);
        }
    }

    /**
     * Gets all instances in the dataset.
     * @return a list of instances
     */
    public List<Instance> getInstances() {
        return instances;
    }

    /**
     * Gets the minimum value for each attribute across all instances.
     * @return an array of minimums
     */
    public double[] getMinValues() {
        double[] min = Arrays.copyOf(instances.get(0).getAttributes(), numAttributes);
        for (Instance inst : instances) {
            double[] attrs = inst.getAttributes();
            for (int i = 0; i < numAttributes; i++) {
                if (attrs[i] < min[i]) min[i] = attrs[i];
            }
        }
        return min;
    }

    /**
     * Gets the maximum value for each attribute across all instances.
     * @return an array of maximums
     */
    public double[] getMaxValues() {
        double[] max = Arrays.copyOf(instances.get(0).getAttributes(), numAttributes);
        for (Instance inst : instances) {
            double[] attrs = inst.getAttributes();
            for (int i = 0; i < numAttributes; i++) {
                if (attrs[i] > max[i]) max[i] = attrs[i];
            }
        }
        return max;
    }

    /**
     * Normalizes all instances in the dataset using min-max scaling.
     */
    public void normalizeAll() {
        double[] min = getMinValues();
        double[] max = getMaxValues();
        for (Instance inst : instances) {
            inst.normalize(min, max);
        }
    }
}
