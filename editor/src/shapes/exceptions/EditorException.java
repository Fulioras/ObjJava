package shapes.exceptions;

/**
 * Base exception class for errors related to shape editing operations.
 * <p>
 * This exception is intended to be extended by more specific exceptions
 * within the shapes editing framework.
 */
public class EditorException extends Exception {

    /**
     * Constructs a new EditorException with the specified detail message.
     *
     * @param message the detail message explaining the reason for the exception
     */
    public EditorException(String message) {
        super(message);
    }
}
