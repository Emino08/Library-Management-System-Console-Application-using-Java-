import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Performance tests for the Patron class.
 */
public class PatronPerformanceTest {

    private static final int LARGE_NUMBER_OF_OPERATIONS = 10000;

    /**
     * Tests the performance of borrowing and returning books by a Patron.
     */
    @Test
    public void testBorrowAndReturnBooksPerformance() {
        Patron patron = new Patron("P001", "Alice");
        Author author = new Author("A001", "John Doe");
        Publisher publisher = new Publisher("P001", "Tech Books Inc.");
        Book book = new Book("1234", "Java Programming", author, publisher);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < LARGE_NUMBER_OF_OPERATIONS; i++) {
            patron.borrowBook(book);
            patron.returnBook(book);
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Time taken to borrow and return a book " + LARGE_NUMBER_OF_OPERATIONS + " times: " + duration + " ms");

        assertTrue(patron.getBorrowedBooks().isEmpty());
        assertTrue(book.isAvailable());
    }
}
