package shapes.exceptions;

/**
 * Exception thrown when a circle's radius value is invalid (e.g., non-positive).
 * <p>
 * Extends {@link EditorException} and carries the invalid radius value.
 */
public class BadRadiusValue extends EditorException {

    /** The invalid radius value that caused this exception. */
    private double radiusValue;

    /**
     * Constructs a new BadRadiusValue exception with the specified detail message
     * and the invalid radius value.
     *
     * @param message     the detail message explaining the reason for the exception
     * @param radiusValue the invalid radius value
     */
    public BadRadiusValue(String message, double radiusValue) {
        super(message);
        this.radiusValue = radiusValue;
    }

    /**
     * Returns the invalid radius value that triggered this exception.
     *
     * @return the invalid radius value
     */
    public double getRadiusValue() {
        return radiusValue;
    }
}
