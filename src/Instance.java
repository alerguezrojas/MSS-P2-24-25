import java.util.Arrays;

/**
 * Represents a single data instance with numerical attributes and a label.
 */
public class Instance {
    private double[] attributes;
    private String label;

    /**
     * Constructs an instance with attributes and a label.
     * @param attributes numerical values describing the instance
     * @param label the class label of the instance
     */
    public Instance(double[] attributes, String label) {
        this.attributes = attributes;
        this.label = label;
    }

    /**
     * Gets the attribute values.
     * @return an array of attribute values
     */
    public double[] getAttributes() {
        return attributes;
    }

    /**
     * Gets the class label.
     * @return the label of the instance
     */
    public String getLabel() {
        return label;
    }

    /**
     * Normalizes the attributes using min-max normalization.
     * @param min array of minimum values per attribute
     * @param max array of maximum values per attribute
     */
    public void normalize(double[] min, double[] max) {
        for (int i = 0; i < attributes.length; i++) {
            if (max[i] - min[i] != 0) {
                attributes[i] = (attributes[i] - min[i]) / (max[i] - min[i]);
            } else {
                attributes[i] = 0.0;
            }
        }
    }

    /**
     * Returns a string representation of the instance.
     */
    @Override
    public String toString() {
        return Arrays.toString(attributes) + " => " + label;
    }
}
