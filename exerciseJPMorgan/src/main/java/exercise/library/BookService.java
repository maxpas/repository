package exercise.library;

/**
 * @author Massimo
 * A service to access the book repository.
 */
public interface BookService
{
    /**
     * Retrieve a book by its ISBN.
     * @param isbn
     * @return the retrieved book
     * @throws BookNotFoundException
     */
    public Book retrieveBook(String isbn) throws BookNotFoundException;

    /**
     * Provide a book summary
     * @param isbn
     * @return a book summary
     * @throws BookNotFoundException
     */
    public String getBookSummary(String isbn) throws BookNotFoundException;
}
