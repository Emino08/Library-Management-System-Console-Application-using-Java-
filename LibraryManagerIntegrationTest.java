import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for the LibraryManager class.
 */
public class LibraryManagerIntegrationTest {

    private LibraryManager libraryManager;
    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();
        UserInterface userInterface = new UserInterface();
        libraryManager = new LibraryManager();  // Assuming constructor injection
    }

    @Test
    public void testAddAndSearchBook() {
        // Simulate adding a book
        String isbn = "1234";
        String title = "Java Programming";
        String authorName = "John Doe";
        String publisherName = "Tech Books Inc.";

        Book book = new Book(isbn, title, new Author("0099",authorName), new Publisher("0044",publisherName));

        libraryManager.addBook();

        // Search for the book by ISBN
        Book book1 = library.searchBook(isbn);
        assertNotNull(book1);
        assertEquals(isbn, book1.getIsbn());
        assertEquals(title, book1.getTitle());
        assertEquals(authorName, book1.getAuthor().getName());
        assertEquals(publisherName, book1.getPublisher().getName());
    }

    @Test
    public void testAddAndRemoveBook() {
        // Simulate adding a book
        String isbn = "1234";
        String title = "Java Programming";
        String authorName = "John Doe";
        String publisherName = "Tech Books Inc.";

        Book book = new Book(isbn, title, new Author("0099",authorName), new Publisher("0044",publisherName));

        libraryManager.addBook();

//        libraryManager.addBook(isbn, title, authorName, publisherName);

        // Remove the book
        libraryManager.removeBook();

        // Search for the book by ISBN
        Book book1 = library.searchBook(isbn);
        assertNull(book1);
    }

    @Test
    public void testAddAndSearchPatron() {
        // Simulate adding a patron
        String patronId = "P001";
        String patronName = "Alice";


        libraryManager.addPatron();

        // Search for the patron by ID
        Patron patron = library.searchPatron(patronId);
        assertNotNull(patron);
        assertEquals(patronId, patron.getId());
        assertEquals(patronName, patron.getName());
    }

    @Test
    public void testAddAndRemovePatron() {
        // Simulate adding a patron
        String patronId = "P001";
        String patronName = "Alice";

        libraryManager.addPatron();

        // Remove the patron
        libraryManager.removePatron();

        // Search for the patron by ID
        Patron patron = library.searchPatron(patronId);
        assertNull(patron);
    }

    @Test
    public void testBorrowAndReturnBook() {
        // Simulate adding a book
        String isbn = "1234";
        String title = "Java Programming";
        String authorName = "John Doe";
        String publisherName = "Tech Books Inc.";

        Book book = new Book(isbn, title, new Author("0099",authorName), new Publisher("0044",publisherName));
        libraryManager.addBook();

        // Simulate adding a patron
        String patronId = "P001";
        String patronName = "Alice";
        libraryManager.addPatron();

        // Borrow the book
        libraryManager.borrowBook();

        // Check that the book is no longer available
        Book book1 = library.searchBook(isbn);
        assertNotNull(book1);
        assertFalse(book1.isAvailable());

        // Check that the patron has borrowed the book1
        Patron patron = library.searchPatron(patronId);
        assertNotNull(patron);
        assertTrue(patron.getBorrowedBooks().contains(book1));

        // Return the book1
        libraryManager.returnBook();

        // Check that the book1 is available again
        assertTrue(book1.isAvailable());

        // Check that the patron no longer has the book1
        assertFalse(patron.getBorrowedBooks().contains(book));
    }

    @Test
    public void testGenerateReport() {
        // Simulate adding some books and patrons

        libraryManager.addBook();
        libraryManager.addBook();
        libraryManager.addPatron();
        libraryManager.addPatron();

        // Generate the report
        String report = libraryManager.generateReport();

        // Verify the report contains expected data
        assertTrue(report.contains("Total Books: 2"));
        assertTrue(report.contains("Total Patrons: 2"));
        assertTrue(report.contains("Available Books: 2"));
        assertTrue(report.contains("Borrowed Books: 0"));
    }

    @Test
    public void testSearchBookByTitle() {
        // Simulate adding some books
        libraryManager.addBook();
        libraryManager.addBook();

        // Search for books by title
        List<Book> books = libraryManager.searchBook();

        // Verify the correct book is found
        assertEquals(1, books.size());
        assertEquals("1234", books.get(0).getIsbn());
    }

    @Test
    public void testSortAndSearchBook() {
        // Simulate adding some books with different titles
        libraryManager.addBook();
        libraryManager.addBook();
        libraryManager.addBook();

        // Sort and search for a book by exact title
        Book book = libraryManager.sortAndSearchBook();

        // Verify the correct book is found
        assertNotNull(book);
        assertEquals("5678", book.getIsbn());
        assertEquals("Data Structures", book.getTitle());
    }
}
