package exercise.library;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BookServiceTest {
	BookService service;

	@Before
	public void setUp() throws Exception {
		service = new BookServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
		service = null;
	}

	@Test
	public void testRetrieveBookWithInvalidIsbn() {
		try {
			service.retrieveBook("INVALID-TEXT");
			fail("BookNotFoundException was expected but did not occurr.");
		} catch (BookNotFoundException e) {
			assertEquals("Expected exception occurred", String.format(Consts.ISBN_INVALID, Consts.ISBN_PREFIX), e.getMessage());
		}
	}

	@Test
	public void testRetrieveBookWithNotExistingIsbn() {
		try {
			service.retrieveBook("ISBN-777");
			fail("BookNotFoundException was expected but did not occurr.");
		} catch (BookNotFoundException e) {
			assertEquals("Expected exception occurred", String.format(Consts.ISBN_NOT_FOUND, "ISBN-777"), e.getMessage());
		}
	}

	@Test
	public void testRetrieveBookWithExistingIsbn() {
		try {
			Book book = service.retrieveBook("ISBN-001");
			assertEquals("Book was succesfully found", "Harry Potter and the Deathly Hallows", book.getTitle());
		} catch (BookNotFoundException e) {
			fail("BookNotFoundException was not expected but occurred.");
		}
	}

	@Test
	public void testGetBookSummaryWithInvalidIsbn() {
		try {
			service.getBookSummary("INVALID-TEXT");
			fail("BookNotFoundException was expected but did not occurr.");
		} catch (BookNotFoundException e) {
			assertEquals("Expected exception occurred", String.format(Consts.ISBN_INVALID, Consts.ISBN_PREFIX), e.getMessage());
		}
	}

	@Test
	public void testGetBookSummaryWithNotExistingIsbn() {
		try {
			service.getBookSummary("ISBN-777");
			fail("BookNotFoundException was expected but did not occurr.");
		} catch (BookNotFoundException e) {
			assertEquals("Expected exception occurred", String.format(Consts.ISBN_NOT_FOUND, "ISBN-777"), e.getMessage());
		}
	}

	@Test
	public void testGetBookSummaryWithExistingIsbn001() {
		try {
			String summary = service.getBookSummary("ISBN-001");
			assertEquals("Book summary matches", "[ISBN-001] Harry Potter and the Deathly Hallows - Sorcery and Magic.", summary);
		} catch (BookNotFoundException e) {
			fail("BookNotFoundException was not expected but occurred.");
		}
	}

	@Test
	public void testGetBookSummaryWithExistingIsbn002() {
		try {
			String summary = service.getBookSummary("ISBN-002");
			assertEquals("Book summary matches", "[ISBN-002] The Player of Games - Jernau Morat Gurgeh. The Player of Games. Master of every...", summary);
		} catch (BookNotFoundException e) {
			fail("BookNotFoundException was not expected but occurred.");
		}
	}

	@Test
	public void testGetBookSummaryWithExistingIsbn003() {
		try {
			String summary = service.getBookSummary("ISBN-003");
			assertEquals("Book summary matches", "[ISBN-003] Genius: Richard Feynman and Modern Physics - A brilliant interweaving of Richard Feynman's colourful life and a...", summary);
		} catch (BookNotFoundException e) {
			fail("BookNotFoundException was not expected but occurred.");
		}
	}

}
