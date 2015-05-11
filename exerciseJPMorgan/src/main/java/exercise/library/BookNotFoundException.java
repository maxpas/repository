package exercise.library;

/**
 * @author Massimo
 * Checked exception thrown when a book is not found in the library.
 */
public class BookNotFoundException extends Exception
{
	private static final long serialVersionUID = 519323428096177407L;

    /**
     * Parameterless constructor.
     */
    public BookNotFoundException() {
    	super("The searched book has not been found in the library");
    }

    /**
     * Constructor that accepts a message
     * @param message
     */
    public BookNotFoundException(String message)
    {
       super(message);
    }
    
    /**
     * Constructor that accepts a cause.
     * @param cause
     */
    public BookNotFoundException(Throwable cause) {
        super (cause);
    }

    /**
     * Constructor that accepts a message and a cause.
     * @param message
     * @param cause
     */
    public BookNotFoundException(String message, Throwable cause) {
        super (message, cause);
    }
}
