import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Performance tests for the Publisher class.
 */
public class PublisherPerformanceTest {

    private static final int LARGE_NUMBER_OF_BOOKS = 1000000;

    /**
     * Tests the performance of adding a large number of books to a Publisher.
     */
    @Test
    public void testAddBooksPerformance() {
        Publisher publisher = new Publisher("P001", "Tech Books Inc.");
        Author author = new Author("A001", "John Doe");

        var startTime = System.currentTimeMillis();

        int i = 0;
        while (i < LARGE_NUMBER_OF_BOOKS) {
            Book book = new Book("ISBN" + i, "Title" + i, author, publisher);
            publisher.addBook(book);
            i++;
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Time taken to add " + LARGE_NUMBER_OF_BOOKS + " books to publisher: " + duration + " ms");

        assertEquals(LARGE_NUMBER_OF_BOOKS, publisher.getBooks().size());
    }
}
