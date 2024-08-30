import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Performance tests for the Author class.
 */
public class AuthorPerformanceTest {

    private static final int LARGE_NUMBER_OF_BOOKS = 1000000;

    /**
     * Tests the performance of adding a large number of books to an Author.
     */
    @Test
    public void testAddBooksPerformance() {
        Author author = new Author("A001", "John Doe");
        Publisher publisher = new Publisher("P001", "Tech Books Inc.");

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < LARGE_NUMBER_OF_BOOKS; i++) {
            Book book = new Book("ISBN" + i, "Title" + i, author, publisher);
            author.addBook(book);
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Time taken to add " + LARGE_NUMBER_OF_BOOKS + " books to author: " + duration + " ms");

        assertEquals(LARGE_NUMBER_OF_BOOKS, author.getBooks().size());
    }
}
