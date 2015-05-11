package exercise.library;

public class BookServiceImpl implements BookService {
	private static final int WORDS_NUMBER = 10;
	BookRepository repository = BookRepositoryImpl.getInstance();
	
	public Book retrieveBook(String isbn) throws BookNotFoundException {
		checkIsbnSyntax(isbn);
		Book book = repository.retrieveBook(isbn);
		if (book == null) {
			throw new BookNotFoundException(String.format(Consts.ISBN_NOT_FOUND, isbn));
		}
		return book;
	}

	public String getBookSummary(String isbn) throws BookNotFoundException {
		Book book = retrieveBook(isbn);
		return new StringBuilder("[").append(book.getIsbn()).append("] ")
				.append(book.getTitle()).append(" - ")
				.append(book.getDescription(WORDS_NUMBER,false)).toString();
	}
	
	private void checkIsbnSyntax(String isbn) throws BookNotFoundException {
		if (isbn == null || isbn.length() < Consts.ISBN_PREFIX.length() || !isbn.startsWith(Consts.ISBN_PREFIX)) {
			throw new BookNotFoundException(String.format(Consts.ISBN_INVALID, Consts.ISBN_PREFIX));
		}
	}

}
